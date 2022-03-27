import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private String path;

    private List<Item> items = new ArrayList<>();
    public String getPath() {

        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public void add(Item item) {

        items.add(item);
    }
    public Item findById(String Id){
        for(Item item : items){
            if (item.getId().equals(item)){
                return item;
            }
        }
        return null;
    }
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public List<Item> getItems() {

        return items;
    }

    public void setItems(List<Item> items) {

        this.items = items;
    }

    @Override
    public String toString() {
        return "\n Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", \n items=" + items +
                '}' + "\n";
    }
}
