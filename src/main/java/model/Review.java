package model;

import lombok.*;

@Builder
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    int id;
    int productId;
    String timestamp;
    String user;
    int rating;
    String comment;
}
