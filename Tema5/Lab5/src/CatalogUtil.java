import java.io.*;
import java.awt.Desktop;

public class CatalogUtil {

    public static void save (Catalog catalog)  throws IOException {
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
            oos.writeObject(catalog);
        }
    }
    public static Catalog load (String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Catalog catalog = (Catalog)ois.readObject();
        return catalog;
    }

    public static void view (Item item ) {
        try {
            File file = new File(item.getLocation());
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}