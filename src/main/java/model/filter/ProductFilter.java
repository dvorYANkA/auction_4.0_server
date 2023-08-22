package model.filter;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class ProductFilter {
    //TODO: jsonProps???
    String title;
    Integer price;
    String category;
}
