package edu.rentals.backend.rental;

import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.*;


@RestController
public class RentalController {
    @Autowired
    private RentalApiService rentalapiservice;

    @PostMapping(value = "/rental", consumes = "application/json", produces = "application/json")
    public Rental createStore(@RequestBody Rental r){
        Rental rental = rentalapiservice.save(r);
        return rental;

    }

    @GetMapping("/rental/{invoiceId}")
    public Map<String, ResponseRental> getByID(@PathVariable Long invoiceId){

        ResponseRental response = new ResponseRental();

        Rental rental = rentalapiservice.findByinvoiceId(invoiceId);

        List<EquipmentInfo> equipmentInfos = new ArrayList<>();

        for (Equipment equipment : rental.getEquipment()) {
            String id  = equipment.getEquipmentId().toString();
            String uri = "http://localhost:8080/equipment/" + id;

            RestTemplate restTemplate = new RestTemplate();
            JsonObject eJson = restTemplate.getForObject(uri, JsonObject.class);
            String equipmentname = eJson.getAsJsonObject("equipment").get("name").toString();

            EquipmentInfo e  = new EquipmentInfo();

            e.setId(equipment.getEquipmentId());
            e.setName(equipmentname);
            e.setQuantity(equipment.getQuantity());

            equipmentInfos.add(e);

        }

        response.setEquipment(equipmentInfos);

        final String uri = "http://localhost:8080/invoices";

        RestTemplate restTemplate = new RestTemplate();
        JsonObject invoices = restTemplate.getForObject(uri, JsonObject.class);

        JsonArray invoices_array = (JsonArray) invoices.get("invoices");

        invoices_array.forEach(x -> {
            if (x.isJsonObject()){
                if (x.getAsJsonObject().get("id").toString().equals(invoiceId)){
                    JsonObject result = x.getAsJsonObject();
                    response.setId(invoiceId);
                    response.setTranscationDate(Timestamp.valueOf(result.get("transactionDate").getAsString()));
                    response.setStoreId(result.get("storeId").getAsLong());
                    response.setStoreName(result.get("storeName").getAsString());
                }
            }
        });

        response.setRentalStartDate(rental.getRentalTime());
        response.setDueDate(rental.getReturnTime());

        Map<String, ResponseRental> final_response = new HashMap<>();

        final_response.put("invoice", response);

        return final_response;
    }

}
