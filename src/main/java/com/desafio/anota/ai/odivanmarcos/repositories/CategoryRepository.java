package com.desafio.anota.ai.odivanmarcos.repositories;

import com.desafio.anota.ai.odivanmarcos.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
