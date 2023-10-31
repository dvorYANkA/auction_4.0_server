package auction.com.server.models;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {

    @Column(name = "id")
    @Id
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

    public Review(int id) {
        this.id = id;
    }
}
