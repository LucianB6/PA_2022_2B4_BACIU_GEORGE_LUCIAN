package Entity;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "continents")
@NamedQueries({
        @NamedQuery(name = "Continent.findAll",
                query = "select e from continents e order by e.name"),
})

public class ContinentsEntity{

    private int id;
    private String name;

    public ContinentsEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public ContinentsEntity(){}
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, precision = 0)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
