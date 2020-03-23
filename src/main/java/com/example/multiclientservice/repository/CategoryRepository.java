package com.example.multiclientservice.repository;

import com.example.multiclientservice.repository.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
