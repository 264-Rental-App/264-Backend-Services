package edu.rentals.backend.controllers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import edu.rentals.backend.entities.Store;
import edu.rentals.backend.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class StoreController {
    @Autowired
    private StoreRepository storeRepository;

    @PostMapping("/stores")
    public Store createStore(@RequestBody Store s) {
        return storeRepository.save(s);
    }

    @GetMapping("/stores")
    public Store getStore(@RequestHeader("Authorization") String token) throws FirebaseAuthException {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
        String uid = decodedToken.getUid();
        return storeRepository.findOneByOwnerId(uid);
    }

    @GetMapping(path = "/search/stores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findStoresByLatLong(@RequestParam(name = "lat", required = true) float lat,
                                                 @RequestParam(name = "long", required = true) float lon) {
        if (lat != 0 && lon != 0) {
            List<Store> stores = storeRepository.findAll();
            double d = 30;

            stores.sort(new Comparator<Store>() {
                @Override
                public int compare(Store o1, Store o2) {
                    return Double.compare(o1.findByLatLong(lat, lon, d), o2.findByLatLong(lat, lon, d));
                }
            });
            Map<String, List<Store>> result = new HashMap<>();
            result.put("stores", stores);

            return ResponseEntity.ok(result);

        } else {
            try {
                throw new Exception("Please enter valid latitude and longitude");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/stores/{id}")
    public ResponseEntity<?> getByID(@PathVariable Long id) {
        Store store = storeRepository.findById(id).get();
        Map<String, Store> result = new HashMap<>();
        result.put("store", store);

        return ResponseEntity.ok(result);
    }

    @PatchMapping("/stores/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Store s) {
        Store store = null;
        try {
            store = storeRepository.findById(id).get();
            if (s.getCategory() != null) {
                store.setCategory(s.getCategory());
            }
            if (s.getLat() != null) {
                store.setLat(s.getLat());
            }
            if (s.getLon() != null) {
                store.setLon(s.getLon());
            }
            if (s.getCategory() != null) {
                store.setCategory(s.getCategory());
            }
            if (s.getOwnerId() != null) {
                store.setOwnerId(s.getOwnerId());
            }
            if (s.getCommonAddress() != null) {
                store.setCommonAddress(s.getCommonAddress());
            }
            if (s.getName() != null) {
                store.setName(s.getName());
            }

            storeRepository.save(store);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(storeRepository.getOne(id), HttpStatus.OK);
    }

    @DeleteMapping("/stores/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable Long id) throws Exception {
        return storeRepository.findById(id).map(store -> {
            storeRepository.delete(store);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new Exception("Store not found"));
    }

}