public class Event {
    public String name;

    public Event(String name) {
        this.name = name;
    }
    public Event() {
    }
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Event other)) {
            return false;
        }
        return name.equals(other.name);
    }
}