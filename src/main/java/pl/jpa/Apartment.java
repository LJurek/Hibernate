package pl.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Apartment {
    @javax.persistence.Id
    @GeneratedValue
    int Id;
    String miasto;
    String ulica;
    String nr;

    public int getId() {
        return Id;
    }
    @ManyToMany
    private List<Person> owners = new ArrayList<>();

    public List<Person> getOwners() {
        return owners;
    }


    public String getMiasto() {
        return miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public String getNr() {
        return nr;
    }

    public Apartment(String miasto, String ulica, String nr) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr = nr;
    }

    public Apartment() {
    }
    public void addOwners(Person person) {
        owners.add(person);
    }

}