package com.desafio.anota.ai.odivanmarcos.services.interfaces;

import com.desafio.anota.ai.odivanmarcos.domain.category.Category;
import com.desafio.anota.ai.odivanmarcos.domain.category.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    public Category insert(CategoryDto dto);
    public Optional<Category> getById(String id);
    public List<Category> getAll();
    public Category update(String id, CategoryDto dto);
    public void delete(String id);
}
