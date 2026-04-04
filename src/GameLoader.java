import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class GameLoader {
    public List<Room> loadRooms(String filePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        /* Διαβάζει το αρχείο και το μετατρέπει αυτόματα σε λίστα από Rooms */
        Room[] roomsArray = mapper.readValue(new File(filePath), Room[].class);
        return Arrays.asList(roomsArray);
    }
}