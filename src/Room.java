import java.util.Map;
import java.util.List;

public class Room {
    public String id;
    public String description; // Η περιγραφή του χώρου
    public Map<String, String> exits; // Πού οδηγεί κάθε κατεύθυνση (π.χ. "north" -> "hallway")
    public List<String> items; // Λίστα με τα IDs των αντικειμένων που υπάρχουν εδώ
}