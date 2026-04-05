import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameLoader loader = new GameLoader();
        Scanner scanner = new Scanner(System.in); // Προσθήκη Scanner για την Εβδ. 4

        try {
            List<Room> rooms = loader.loadRooms("src/main/resources/world.json");
            Player player = new Player();
            player.setCurrentRoom(rooms.get(0));

            // Week 4: λογική εντολών (go, look, inventory, exit) στον CommandParser
            CommandParser parser = new CommandParser();

            System.out.println("--- Progress Update: Week 4 Interaction ---");

            // Game Loop
            boolean running = true;
            while (running) {
                System.out.println("\n" + player.getCurrentRoom().description);
                // Αυτό τυπώνει τις διαθέσιμες εξόδους αυτόματα από το Map του Κώστα
                System.out.println("Έξοδοι: " + player.getCurrentRoom().exits.keySet());
                System.out.println("Έξτρα εντολές: look, inventory, exit");
                System.out.print("Που θα πας:");
                String input = scanner.nextLine().toLowerCase();
                System.out.print("\n");

                CommandParser.ProcessResult result = parser.process(input, player, rooms);
                if (result == CommandParser.ProcessResult.EXIT) {
                    running = false;
                }
            }
        } catch (Exception e) {
            System.out.println("Σφάλμα: " + e.getMessage());
        }
    }
}
