import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<String> words = new ArrayList<>();
    public void addWord(Player player, String word) {
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }
    @Override
    public String toString() {

        return words.toString();
    }
}