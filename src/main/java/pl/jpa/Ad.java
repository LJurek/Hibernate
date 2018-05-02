package pl.jpa;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jsoup.select.Elements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
public class Ad {

    @Id @GeneratedValue
    Integer id;

    @Column @Getter @Setter
    String title;
    @Column @Getter @Setter
    String city;
    @Column @Getter @Setter
    String price;
    @Column @Getter @Setter
    String content;

    public Ad(String title, String city, String price, String content) {
        this.title = title;
        this.city = city;
        this.price = price;
        this.content = content;
    }

    public Ad() {
    }
}