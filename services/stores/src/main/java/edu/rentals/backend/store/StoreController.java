package edu.rentals.backend.store;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/stores", produces = MediaType.APPLICATION_JSON_VALUE)
    public Store getInvoiceByUser(@RequestHeader("Authorization") String token)
            throws FirebaseAuthException {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        String uid = decodedToken.getUid();

        return storeapiservice.findByownerId(uid);
    }

    @PatchMapping("/stores/{id}")
    public ResponseEntity<Store> updateStore (@PathVariable Long id, @RequestBody Store s){
        Store store = null;
        try{
            store = storeapiservice.findById(id).get();
            if (store != null){
                if (s.getCategory() != null){
                    store.setCategory(s.getCategory());
                }
                if (s.getLat() != null){
                    store.setLat(s.getLat());
                }
                if (s.getLon() != null){
                    store.setLon(s.getLon());
                }
                if (s.getCategory() != null){
                    store.setCategory(s.getCategory());
                }
                if (s.getOwnerId() != null){
                    store.setOwnerId(s.getOwnerId());
                }
                if(s.getCommonAddress() != null){
                    store.setCommonAddress(s.getCommonAddress());
                }
                if (s.getName() != null) {
                    store.setName(s.getName());
                }

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
