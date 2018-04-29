import org.hibernate.Session;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateLauncher {
    public static void main(String[] args) {
        org.hibernate.cfg.Configuration c = new Configuration()
                .configure("./hibernate.cfg.xml");
        Session session = c.buildSessionFactory().openSession();
        session.getSessionFactory().openSession();

        session.beginTransaction();
        Person p = new Person("Mateusz", "Jurek");
        session.save(p);
        Apartment apartment = (new Apartment("Opoczno", "Inowłodzka","12"));
        p.addApartment(apartment);
        session.save(apartment);
        session.getTransaction().commit();


        List<Person> result = session.createQuery("select p from Person p", Person.class).getResultList();
        System.out.println(result);
        for (Person p1 : result){
            System.out.print(p1.getImie() + ", ");
            System.out.print(p1.getNazwisko() + ", ");
            System.out.print(p1.getId() + " \n");

            List<Apartment> Aresults = p1.getApartments();
            for (Apartment a1 : Aresults){
                System.out.print(a1.getMiasto() + ", ");
                System.out.print(a1.getUlica() + ", ");
                System.out.print(a1.getNr() + " \n");
            }
        }



        //List<> peopleapartm = session.createQuery("select p,a from Person p join person_apartment pa on p.Id = pa.Person_Id join Apartment a on pa.apartments_Id = a.Id");
        session.close();
        session.getSessionFactory().close();


    }

}
