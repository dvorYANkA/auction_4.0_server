package model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
    @Id // TODO: check if it okay I took this @Id from Jakarta of mb another lib should be used
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int productId;
    String timestamp;
    String user;
    int rating;
    String comment;
}
