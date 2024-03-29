package com.desafio.anota.ai.odivanmarcos.domain.products;

import com.desafio.anota.ai.odivanmarcos.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String title;
    private String description;
    private String ownerId;
    private Integer price;
    private Category category;

    public Product(ProductDto dto){
        this.title = dto.title();
        this.description = dto.description();
        this.ownerId = dto.ownerId();
        this.price = dto.price();
    }
}
