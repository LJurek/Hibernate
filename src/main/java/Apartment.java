import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Apartment {
    @Id
    @GeneratedValue
    int Id;
    String miasto;
    String ulica;
    String nr;

    public int getId() {
        return Id;
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
}
