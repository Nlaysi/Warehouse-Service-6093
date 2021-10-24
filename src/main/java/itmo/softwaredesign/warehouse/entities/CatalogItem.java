package itmo.softwaredesign.warehouse.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatalogItem {
    @Id
    @GeneratedValue
    private UUID id;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private WarehouseItem warehouseItem;

    private String title;
    private String description;
    private Integer price = 100;
}
