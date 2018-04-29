import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue()
    int Id;

    String imie;

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    String nazwisko;

    @ManyToMany
    private List<Apartment> apartments = new ArrayList<>();

    public List<Apartment> getApartments() {
        return apartments;
    }

    public int getId() {
        return Id;
    }

    public Person(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Person(){

    }

    public void addApartment (Apartment apartment){
        apartments.add(apartment);
    }
}
