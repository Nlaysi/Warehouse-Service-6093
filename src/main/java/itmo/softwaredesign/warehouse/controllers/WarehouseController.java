package itmo.softwaredesign.warehouse.controllers;

import itmo.softwaredesign.warehouse.classes.ItemValues;
import itmo.softwaredesign.warehouse.entities.CatalogItem;
import itmo.softwaredesign.warehouse.entities.WarehouseItem;
import itmo.softwaredesign.warehouse.services.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/warehouse")
public class WarehouseController {

    private final WarehouseService service;

    @PostMapping(value = "/income", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> income(@RequestBody ItemValues values){
        return service.income(values);
    }

    @PostMapping(value = "/outcome", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> outcome(@RequestBody ItemValues values){
        return service.outcome(values);
    }

    @PostMapping(value = "/book", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> book(@RequestBody ItemValues values){
        return service.book(values);
    }

    @PostMapping(value = "/unbook", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> unbook(@RequestBody ItemValues values){
        return service.unbook(values);
    }

    @PostMapping(value = "/addItem", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addItem(@RequestBody CatalogItem item){
        return service.addItem(item);
    }

    @GetMapping(value = "/getItems")
    public ResponseEntity<List<CatalogItem>> getItemsList(){
        System.out.println();
        return service.getItemsList();
    }

    @GetMapping(value = "/getItem")
    public ResponseEntity<CatalogItem> getItem(@RequestParam("id") UUID id){
        return service.getItem(id);
    }

    @GetMapping(value = "/getItemQuantity")
    public ResponseEntity<WarehouseItem> getItemQuantity(@RequestParam("id") UUID id){
        return service.getItemQuantity(id);
    }
}
