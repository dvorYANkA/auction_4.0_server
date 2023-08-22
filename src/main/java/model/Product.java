package model;

import lombok.*;

@Builder
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    int rating;
    int id;
    String title;
    int  price;
    String description;
    String[] categories;
}
