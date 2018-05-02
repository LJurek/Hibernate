package pl.jpa;

import lombok.Cleanup;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

public class launcherJPA {
    @lombok.SneakyThrows
    public static void main(String[] args) {
            @Cleanup EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA1");
            @Cleanup EntityManager em = emf.createEntityManager();

            Document document = Jsoup.connect("https://sprzedajemy.pl/nieruchomosci/mieszkania").get();
            Elements els = document.select(".details");
            em.getTransaction().begin();
            for (Element e: els) {
                String title = e.select(".title").text();
                String city = e.select(".city").text();
                String price = e.select(".price").text();
                String txt = els.text();
                em.persist(new Ad(title, city, price, txt));
            }
            em.getTransaction().commit();

            em.find(Person.class, 1);

            List<Ad> ads = em.createQuery("SELECT a FROM Ad a", Ad.class).getResultList();
            for (Ad a: ads) {
                System.out.println(a);
            }
    }
}