package models;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    int rating;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "title")
    String title;

    @Column(name = "price")
    int  price;

    @Column(name = "description")
    String description;

    @Column(name = "categories")
    String categories;

    public Product(String title, long id) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }
}
