import java.util.ArrayList;
import java.util.List;

public class Intersection {
    private String name;
    private int intersection;
    private List<Intersection> intersections = new ArrayList<>();

    public Intersection(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public String toString(){
        return this.getName();
    }
}
