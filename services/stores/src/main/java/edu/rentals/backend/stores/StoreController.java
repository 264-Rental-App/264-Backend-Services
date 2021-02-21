package edu.rentals.backend.stores;

import edu.rentals.backend.stores.Store;
import org.springframework.beans.factory.annotation.Autowired;
import edu.rentals.backend.stores.StoreApiService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/stores")
public class StoreController {
    @Autowired
    private StoreApiService storeapiservice;

    @PostMapping("/new_store")
    public Store createStore(@RequestBody Store s){
        Store store = storeapiservice.save(s);
        return store;
    }

    @PostMapping("/get_all")
    public Page<Store> listStore(Pageable pageable){
        return storeapiservice.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Store getByID(@PathVariable Long id){
        Store store = storeapiservice.getOne(id);
        return store;
    }

    @DeleteMapping("/update_stores")
    public ResponseEntity<?> deleteStore (@PathVariable Long id) throws Exception {
        return storeapiservice.findById(id).map(store -> {
            storeapiservice.delete(store);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new Exception("Store not found"));
    }

}
