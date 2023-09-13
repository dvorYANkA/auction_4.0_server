package model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;



@Builder
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    int rating;

    @jakarta.persistence.Id
    @Column(name = "id")
    @Id // TODO: check if it okay I took this @Id from Jakarta of mb another lib should be used
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

    public Long getId() {
        return id;
    }
}
