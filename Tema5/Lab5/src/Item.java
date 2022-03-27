import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Item implements Serializable {
    private String id;
    private String name;
    private String location; // calea catre document

    public Item(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    private Map<String , Object> tags = new HashMap<>();

    public void addTag (String key , Object obj){
        tags.put(key , obj);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTaguri() {
        return tags;
    }

    public void setTaguri(Map<String, Object> taguri) {
        this.tags = taguri;
    }

    @Override
    public String toString() {
        return "\n Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}' + "\n";
    }
}

