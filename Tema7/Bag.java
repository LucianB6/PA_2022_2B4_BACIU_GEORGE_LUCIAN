import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {
    private final List<Tile> letters= new ArrayList<Tile>();

    public List<Tile> getLetters() {
        return letters;
    }

    public Bag() {
        for (char c = 'a'; c < 'z'; c++) {
            Random random = new Random();
            Tile tiles = new Tile(c, random.nextInt(10) + 1);
            letters.add(tiles);
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) {
                break;
            }
            int j = random.nextInt(letters.size());
            extracted.add(letters.get(j));
        }
        return extracted;
    }
}