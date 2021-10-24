package itmo.softwaredesign.warehouse.repositories;

import itmo.softwaredesign.warehouse.entities.WarehouseItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarehouseItemRepository extends JpaRepository<WarehouseItem, UUID> {
    @Override
    boolean existsById(UUID uuid);
    WarehouseItem findWarehouseItemById(UUID uuid);
}
