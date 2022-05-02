public class Countries {
    private int id;
    private String name;

    public Countries(){}

    public Countries(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Countries{ ");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append("}");
        return sb.toString();
    }
}
