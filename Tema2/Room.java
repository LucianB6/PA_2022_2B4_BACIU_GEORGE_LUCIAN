public abstract class Room {
    protected String name;

    public Room(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Room other)) {
            return false;
        }
        return name.equals(other.name);
    }
    public String toString() {
        return name;
    }

}

