package com.desafio.anota.ai.odivanmarcos.services;

import com.desafio.anota.ai.odivanmarcos.domain.category.Category;
import com.desafio.anota.ai.odivanmarcos.domain.category.exceptions.CategoryNotFoundException;
import com.desafio.anota.ai.odivanmarcos.domain.products.Product;
import com.desafio.anota.ai.odivanmarcos.domain.products.ProductDto;
import com.desafio.anota.ai.odivanmarcos.domain.products.exceptions.ProductNotFoundException;
import com.desafio.anota.ai.odivanmarcos.repositories.ProductRepository;
import com.desafio.anota.ai.odivanmarcos.services.interfaces.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private ProductRepository repository;
    private CategoryService categoryService;

    public ProductService(ProductRepository repository, CategoryService categoryService){
        this.repository = repository;
        this.categoryService = categoryService;
    }

    @Override
    public Product insert(ProductDto dto) {
        Category category = this.categoryService.getById(dto.categoryId()).orElseThrow(CategoryNotFoundException::new);
        Product product = new Product(dto);
        product.setCategory(category);
        this.repository.save(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Product update(String id, ProductDto dto) {
        Product product = this.repository.findById(id).orElseThrow(ProductNotFoundException::new);
        this.categoryService.getById(dto.categoryId()).ifPresent(product::setCategory);
        if(!dto.title().isEmpty() || dto.title() != null) product.setTitle(dto.title());
        if(!dto.description().isEmpty() || dto.description() != null) product.setDescription(dto.description());
        if((dto.price() != null)) product.setPrice(dto.price());
        this.repository.save(product);
        return product;
    }

    @Override
    public void delete(String id) {
        Product product = this.repository.findById(id).orElseThrow(ProductNotFoundException::new);
        this.repository.delete(product);
    }
}