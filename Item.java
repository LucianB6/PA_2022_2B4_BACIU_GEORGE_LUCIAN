package Homework;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private final ItemType type;
    private static Integer number = 0;
    private String id;
    private String name;
    private String location;

    public Item(String name, String location, ItemType type) {
        this.type = type;
        this.id = String.valueOf(number);
        number++;
        this.name = name;
        this.location = location;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public ItemType getType() {
        return type;
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

    @Override
    public String toString() {

        return id + " : " + name + " : " + type + " : " + location + "\n";
    }
}

