package com.javadevwannabes.craftopedia.repository;

import com.javadevwannabes.craftopedia.domain.Beer;
import com.javadevwannabes.craftopedia.domain.Style;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<Style, Long> {

}
