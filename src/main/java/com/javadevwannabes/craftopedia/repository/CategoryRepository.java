package com.javadevwannabes.craftopedia.repository;

import com.javadevwannabes.craftopedia.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
