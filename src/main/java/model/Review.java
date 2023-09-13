package model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;


@Builder
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @jakarta.persistence.Id
    @Column(name = "id")
    @Id // TODO: check if it okay I took this @Id from Jakarta of mb another lib should be used
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "product_id")
    int productId;

    @Column(name = "timestamp")
    String timestamp;

    @Column(name = "user_name")
    String userName;

    @Column(name = "rating")
    int rating;

    @Column(name = "comment")
    String comment;
}
