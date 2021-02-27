package edu.rentals.backend.stores;

import com.sipios.springsearch.anotation.SearchSpec;
import edu.rentals.backend.stores.Store;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import edu.rentals.backend.stores.StoreApiService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class StoreController {
    @Autowired
    private StoreApiService storeapiservice;

    @PostMapping("/stores")
    public Store createStore(@RequestBody Store s){
        Store store = storeapiservice.save(s);
        return store;
    }

//    @PostMapping("/get_all")
//    public Page<Store> listStore(Pageable pageable){
//        return storeapiservice.findAll(pageable);
//    }

//    @GetMapping("/stores")
//    public ResponseEntity<List<Store>> searchForStore(@SearchSpec Specification<Store> stores){
//        return new ResponseEntity<>(storeapiservice.findAll(Specification.where(stores)), HttpStatus.OK);
//    }

    @GetMapping("/search/stores")
    public ResponseEntity<?> findStoresBylatlon(@RequestParam(name = "lat", required = true) float lat, @RequestParam(name = "long", required = true) float lon, Pageable pageable){
        if (lat != 0 && lon != 0){
            	List<Store> stores = storeapiservice.findAll();
                double d = 30;

            Collections.sort(stores, new Comparator<Store>() {
                @Override
                public int compare(Store o1, Store o2) {
                    return Double.compare(o1.findbylatlon(lat, lon, d), o2.findbylatlon(lat, lon, d));
                }
            });
                Map<String, List<Store>> result = new HashMap<>();
                result.put("stores", stores);

            	return ResponseEntity.ok(result);
            
        }else{
            try {
                throw new Exception("Please enter valid latitude and longitude");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    @GetMapping("/stores/{id}")
    public ResponseEntity<?> getByID(@PathVariable Long id){
        Store store = storeapiservice.findById(id).get();
        Map<String, Store> result = new HashMap<>();
        result.put("store", store);

        return ResponseEntity.ok(result);
    }

    @PatchMapping("/stores/{id}")
    public ResponseEntity<Store> updateStore (@PathVariable Long id, @RequestBody Store s){
        Store store = null;
        try{
            store = storeapiservice.findById(id).get();
            if (store != null){
                store.setId(s.getId());
                store.setCategory(s.getCategory());
                store.setCommonAddress(s.getCommonAddress());
                store.setLat(s.getLat());
                store.setLon(s.getLon());
                store.setName(s.getName());
                storeapiservice.save(store);
            }
            else{
                throw new Exception("StoreNotFoundException");
            }
        }catch (Exception e){

        }
        return new ResponseEntity<>(storeapiservice.getOne(id), HttpStatus.OK);
    }

    @DeleteMapping("/stores/{id}")
    public ResponseEntity<?> deleteStore (@PathVariable Long id) throws Exception {
        return storeapiservice.findById(id).map(store -> {
            storeapiservice.delete(store);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new Exception("Store not found"));
    }

}
