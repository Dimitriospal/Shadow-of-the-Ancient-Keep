import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // ΑΥΤΟ ΕΙΝΑΙ ΤΟ ΚΛΕΙΔΙ
public class Room {
    public String id;
    public String description;
    public Map<String, String> exits;

    // Βεβαιώσου ότι το όνομα είναι ακριβώς "items" (πεζά) όπως στο JSON
    public List<Item> items;

    public Item findItem(String itemName) {
        if (items != null) {
            for (Item item : items) {
                if (item.id.equalsIgnoreCase(itemName)) {
                    return item;
                }
            }
        }
        return null;
    }
}
