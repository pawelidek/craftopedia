package com.javadevwannabes.craftopedia.repository;

import com.javadevwannabes.craftopedia.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {

}
