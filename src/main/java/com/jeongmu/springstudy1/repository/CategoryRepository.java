package com.jeongmu.springstudy1.repository;

import com.jeongmu.springstudy1.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByTypeAndId(String type, Long id);



}
