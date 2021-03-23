package com.jeongmu.springstudy1.repository;

import com.jeongmu.springstudy1.Springstudy1ApplicationTests;
import com.jeongmu.springstudy1.model.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryRepositoryTest extends Springstudy1ApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){

        String type = "COMPUTER";

        String title = "컴퓨터";

        LocalDateTime createdAt = LocalDateTime.now();

        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assertions.assertNotNull(newCategory);
        Assertions.assertEquals(newCategory.getType(), type);
        Assertions.assertEquals(newCategory.getTitle(), title);



    }

    @Test
    public void read(){

        Optional<Category> optionalCategory = categoryRepository.findByTypeAndId("COMPUTER", 1L);


        // select * from category where type = "computer"

        optionalCategory.ifPresent(category -> {
            System.out.println(category.getId());
            System.out.println(category.getTitle());
            System.out.println(category.getType());

        });
    }

}