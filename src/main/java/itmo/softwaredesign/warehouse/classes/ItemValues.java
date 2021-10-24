package itmo.softwaredesign.warehouse.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemValues {
    UUID id;
    Integer amount;
}
