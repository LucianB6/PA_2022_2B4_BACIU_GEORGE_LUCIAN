import com.github.javafaker.Name;

import java.util.ArrayList;
import java.util.List;

public class Street implements Comparable<Street>{
    private List<Intersection> preference = new ArrayList<>();
    private String name;
    private int length;

    public Street(String name, int length){
        this.name = name;
        this.length = length;
    }

    public Street(String name) {
        this.name = name;
    }

    public String getName(){

        return name;
    }
    public void setName(String name){

        this.name = name;
    }
    public int getLength(){
        return length;
    }
    public void setLength(int length){

        this.length = length;
    }

    @Override
    public int compareTo(Street o) {
        return o.getName().compareTo(this.getName());
    }
    public String toString(){
        return this.getName();
    }
}
