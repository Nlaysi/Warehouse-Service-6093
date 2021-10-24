package itmo.softwaredesign.warehouse.services;

import itmo.softwaredesign.warehouse.classes.ItemValues;
import itmo.softwaredesign.warehouse.classes.ResponseMessage;
import itmo.softwaredesign.warehouse.entities.CatalogItem;
import itmo.softwaredesign.warehouse.entities.WarehouseItem;
import itmo.softwaredesign.warehouse.repositories.CatalogItemRepository;
import itmo.softwaredesign.warehouse.repositories.WarehouseItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WarehouseService {

    private final WarehouseItemRepository warehouseRepository;
    private final CatalogItemRepository catalogRepository;

    private boolean ValidationError(){
        return false;
    }

    public ResponseEntity<String> income(ItemValues values){
        if(!catalogRepository.existsById(values.getId()) || values.getAmount() < 1)
            return new ResponseEntity<>( ResponseMessage.BAD_REQUEST.TEXT(), HttpStatus.BAD_REQUEST);
        else {
            WarehouseItem item = warehouseRepository.findWarehouseItemById(values.getId());
            item.setAmount(item.getAmount() + values.getAmount());
            warehouseRepository.save(item);
            return new ResponseEntity<>( ResponseMessage.OK_UPDATED.TEXT(), HttpStatus.OK);
        }
    }

    public ResponseEntity<String> outcome(ItemValues values){
        if(!catalogRepository.existsById(values.getId()) || values.getAmount() < 1)
            return new ResponseEntity<>( ResponseMessage.BAD_REQUEST.TEXT(), HttpStatus.BAD_REQUEST);
        else {
            WarehouseItem item = warehouseRepository.findWarehouseItemById(values.getId());

            if(item.getAmount() >= values.getAmount())
                item.setAmount(item.getAmount() - values.getAmount());
            else
                return new ResponseEntity<>( ResponseMessage.BAD_QUANTITY.TEXT(), HttpStatus.BAD_REQUEST);

            warehouseRepository.save(item);
            return new ResponseEntity<>( ResponseMessage.OK_UPDATED.TEXT(), HttpStatus.OK);
        }
    }

    public ResponseEntity<String> book(ItemValues values){
        if(!catalogRepository.existsById(values.getId()) || values.getAmount() < 1)
            return new ResponseEntity<>( ResponseMessage.BAD_REQUEST.TEXT(), HttpStatus.BAD_REQUEST);
        else {
            WarehouseItem item = warehouseRepository.findWarehouseItemById(values.getId());

            if(item.getAmount() - item.getBooked() >= values.getAmount())
                item.setBooked(item.getBooked() + values.getAmount());
            else
                return new ResponseEntity<>( ResponseMessage.BAD_QUANTITY.TEXT(), HttpStatus.BAD_REQUEST);

            warehouseRepository.save(item);
            return new ResponseEntity<>( ResponseMessage.OK_UPDATED.TEXT(), HttpStatus.OK);
        }
    }

    public ResponseEntity<String> unbook(ItemValues values){
        if(!catalogRepository.existsById(values.getId()) || values.getAmount() < 1)
            return new ResponseEntity<>( ResponseMessage.BAD_REQUEST.TEXT(), HttpStatus.BAD_REQUEST);
        else {
            WarehouseItem item = warehouseRepository.findWarehouseItemById(values.getId());

            if(item.getBooked() >= values.getAmount())
                item.setBooked(item.getBooked() - values.getAmount());
            else
                return new ResponseEntity<>( ResponseMessage.BAD_QUANTITY.TEXT(), HttpStatus.BAD_REQUEST);

            warehouseRepository.save(item);
            return new ResponseEntity<>( ResponseMessage.OK_UPDATED.TEXT(), HttpStatus.OK);
        }
    }

    public ResponseEntity<String> addItem(CatalogItem item){
        if(ValidationError())
            return new ResponseEntity<>( ResponseMessage.BAD_REQUEST.TEXT(), HttpStatus.BAD_REQUEST);

        CatalogItem catalogItem = catalogRepository.save(item);
        WarehouseItem warehouseItem = new WarehouseItem(catalogItem, 0, 0);
        System.out.println(catalogItem.getId().toString());
        warehouseRepository.save(warehouseItem);

        return new ResponseEntity<>( ResponseMessage.OK_CREATED.TEXT(), HttpStatus.OK);
    }

    public ResponseEntity<List<CatalogItem>> getItemsList() {

        List<CatalogItem> list = catalogRepository.findAll();

        return new ResponseEntity<>( list, HttpStatus.OK);
    }

    public ResponseEntity<CatalogItem> getItem(UUID id) {
        return new ResponseEntity<>( catalogRepository.findCatalogItemById(id), HttpStatus.OK);
    }

    public ResponseEntity<WarehouseItem> getItemQuantity(UUID id) {
        return new ResponseEntity<>( warehouseRepository.findWarehouseItemById(id), HttpStatus.OK);
    }
}
