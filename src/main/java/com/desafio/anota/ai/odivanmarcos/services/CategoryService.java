package com.desafio.anota.ai.odivanmarcos.services;

import com.desafio.anota.ai.odivanmarcos.domain.category.Category;
import com.desafio.anota.ai.odivanmarcos.domain.category.CategoryDto;
import com.desafio.anota.ai.odivanmarcos.domain.category.exceptions.CategoryNotFoundException;
import com.desafio.anota.ai.odivanmarcos.repositories.CategoryRepository;
import com.desafio.anota.ai.odivanmarcos.services.interfaces.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    @Override
    public Category insert(CategoryDto dto) {
        Category category = new Category(dto);
        this.repository.save(category);
        return category;
    }

    @Override
    public Optional<Category> getById(String id){
        return this.repository.findById(id);
    }

    @Override
    public List<Category> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Category update(String id, CategoryDto dto) {
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);

        if(!dto.title().isEmpty()) category.setTitle(dto.title());
        if(!dto.description().isEmpty()) category.setDescription(dto.description());

        this.repository.save(category);

        return category;
    }

    @Override
    public void delete(String id) {
        Category category = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        this.repository.delete(category);
    }
}