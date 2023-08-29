package model;

import lombok.*;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Builder
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(appliesTo = "reviews")
public class Review {
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
