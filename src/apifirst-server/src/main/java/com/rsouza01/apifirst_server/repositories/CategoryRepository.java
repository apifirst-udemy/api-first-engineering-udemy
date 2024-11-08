package com.rsouza01.apifirst_server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsouza01.apifirst_server.domain.Category;

import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Optional<Category> findByCategoryCode(String categoryCode);
}
