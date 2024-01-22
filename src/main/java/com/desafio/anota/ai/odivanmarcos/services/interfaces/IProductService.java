package com.desafio.anota.ai.odivanmarcos.services.interfaces;

import com.desafio.anota.ai.odivanmarcos.domain.products.Product;
import com.desafio.anota.ai.odivanmarcos.domain.products.ProductDto;

import java.util.List;

public interface IProductService {
    public Product insert(ProductDto dto);
    public List<Product> getAll();
    public Product update(String id,ProductDto dto);
    public void delete(String id);
}
