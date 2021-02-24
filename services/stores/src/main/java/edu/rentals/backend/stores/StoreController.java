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

import java.util.ArrayList;
import java.util.List;


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
    public Page<Store> findStoresBylatlon(@RequestParam(name = "lat", required = true) float lat, @RequestParam(name = "long", required = true) float lon, @RequestParam(name = "dist", required = true) double dist, Pageable pageable){
        if (lat != 0 && lon != 0){
            	Page<Store> stores = storeapiservice.findAll(pageable);
            	List<Store> store_list = new ArrayList<>();
            	
            	stores.forEach(s -> {if (s.findbylatlon(lat, lon, dist) != null) {store_list.add(s);}});
            	Page<Store> result = new PageImpl(store_list);
            	return result;
            
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
    public Store getByID(@PathVariable Long id){
        Store store = storeapiservice.findById(id).get();
        return store;
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
