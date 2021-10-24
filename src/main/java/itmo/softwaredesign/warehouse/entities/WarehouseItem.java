package itmo.softwaredesign.warehouse.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WarehouseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonManagedReference
    private UUID id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private CatalogItem item;

    private Integer amount;
    private Integer booked;

    public WarehouseItem(CatalogItem item, Integer amount, Integer booked) {
        this.item = item;
        this.amount = amount;
        this.booked = booked;
    }
}
