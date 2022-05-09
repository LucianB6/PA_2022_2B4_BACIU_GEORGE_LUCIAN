public class Continents {

    private String name;

    public Continents(){}

    public Continents(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Continents{ ");
        sb.append("name=").append(name);
        sb.append("}");
        return sb.toString();
    }
}
