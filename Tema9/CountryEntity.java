package Entity;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "countries")
@NamedQueries({
        @NamedQuery(name = "Countries.findAll",
                query = "select e from Countries e order by e.name"),
})

public class CountryEntity implements Serializable {

    private int id;
    private String name;

    public CountryEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
    @Column(name = "id")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "name")

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}