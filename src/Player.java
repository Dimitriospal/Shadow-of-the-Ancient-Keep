import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private List<Item> inventory;

    public Player() {
        this.inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() { return currentRoom; }
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }
    public void addItem(Item item) { this.inventory.add(item); }
    public List<Item> getInventory() {
        return inventory;
    }
}