import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HibernateLauncher {
    public static void main(String[] args) {
        org.hibernate.cfg.Configuration c = new Configuration()
                .configure("./hibernate.cfg.xml");
        Session session = c.buildSessionFactory().openSession();
        session.getSessionFactory().openSession();

        session.beginTransaction();
        Person p1 = new Person("Sergiusz", "Kreton");
        session.save(p1);
        Person p2 = new Person("Euzebio", "Drewno");
        session.save(p2);
        Apartment a = (new Apartment("Końskie", "Moscickiego","35"));
       // Apartment a2 = (new Apartment("Wawa", "Radomska","98"));
        //p1.addApartment(a);
       // p1.addApartment(a2);
        a.addOwners(p1);
        a.addOwners(p2);
        session.save(a);
       // session.save(p1);
        session.getTransaction().commit();


        List<Person> result = session.createQuery("select p from Person p", Person.class).getResultList();
        System.out.println(result);
        for (Person pe1 : result){
            System.out.print(pe1.getImie() + ", ");
            System.out.print(pe1.getNazwisko() + ", ");
            System.out.print(pe1.getId() + " \n");

            List<Apartment> Aresults = pe1.getApartments();
            for (Apartment ap1 : Aresults){
                System.out.print(ap1.getMiasto() + ", ");
                System.out.print(ap1.getUlica() + ", ");
                System.out.print(ap1.getNr() + " \n");
            }
        }
        session.close();
        session.getSessionFactory().close();


    }

}
