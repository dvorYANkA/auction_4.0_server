package model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    int rating;

    @Id // TODO: check if it okay I took this @Id from Jakarta of mb another lib should be used
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    int  price;

    String description;

    String categories;
}
