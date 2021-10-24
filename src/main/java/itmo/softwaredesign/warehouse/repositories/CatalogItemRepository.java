package itmo.softwaredesign.warehouse.repositories;

import itmo.softwaredesign.warehouse.entities.CatalogItem;
import itmo.softwaredesign.warehouse.entities.WarehouseItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CatalogItemRepository extends JpaRepository<CatalogItem, UUID> {
    List<CatalogItem> findAll();
    boolean existsById(UUID id);
    CatalogItem findCatalogItemById(UUID id);
}
