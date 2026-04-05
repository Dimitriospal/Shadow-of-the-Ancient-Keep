import java.util.List;

public class CommandParser {

    public enum ProcessResult {
        EXIT,
        CONTINUE
    }

    public ProcessResult process(String rawInput, Player player, List<Room> rooms) {
        String input = rawInput.trim().toLowerCase();

        if (input.equals("exit")) {
            return ProcessResult.EXIT;
        }
        if (input.equals("look")) {
            look(player);
            return ProcessResult.CONTINUE;
        }
        if (input.equals("inventory")) {
            inventory(player);
            return ProcessResult.CONTINUE;
        }
        if (input.startsWith("go ")) {
            String direction = input.substring(3).trim(); // Εντολή go
            go(direction, player, rooms);
            return ProcessResult.CONTINUE;
        }

        System.out.println("Δεν καταλαβαίνω την εντολή. Δοκίμασε: go <κατεύθυνση>, look, inventory, exit.");
        return ProcessResult.CONTINUE;
    }

    /** Όταν ο παίκτης πληκτρολογεί look — περιγραφή τρέχοντος δωματίου + σάρωση items. */
    public void look(Player player) {
        Room room = player.getCurrentRoom();
        System.out.println(room.description);
        if (room.items != null && !room.items.isEmpty()) {
            System.out.print("Στο χώρο βλέπεις: ");
            for (int i = 0; i < room.items.size(); i++) {
                // Παίρνουμε το .id από το Item object
                System.out.print(room.items.get(i).id);
                if (i < room.items.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }

    /** Εντολή inventory — λίστα αντικειμένων παίκτη (ξεκινάει άδεια). */
    public void inventory(Player player) {
        List<Item> inv = player.getInventory();
        if (inv.isEmpty()) {
            System.out.println("Το inventory σου είναι άδειο.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inv.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Item it = inv.get(i);
            sb.append(it.id != null ? it.id : "?");
        }
        System.out.println("Έχεις μαζί σου: [" + sb + "]");
    }

    private void go(String direction, Player player, List<Room> rooms) {
        // Έλεγχος αν υπάρχει η κατεύθυνση στο JSON
        if (player.getCurrentRoom().exits.containsKey(direction)) {
            String nextRoomId = player.getCurrentRoom().exits.get(direction);

            // Ενημέρωση τοποθεσίας παίκτη
            for (Room r : rooms) {
                if (r.id.equals(nextRoomId)) {
                    player.setCurrentRoom(r);
                    System.out.println("Μετακινήθηκες προς: " + direction);
                    break;
                }
            }
        } else {
            System.out.println("Σφάλμα: Δεν υπάρχει έξοδος στα " + direction + "!");
        }
    }
}
