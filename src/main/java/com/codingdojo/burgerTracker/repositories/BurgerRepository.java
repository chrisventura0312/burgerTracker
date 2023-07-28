package com.codingdojo.burgerTracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.burgerTracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {
    List<Burger> findAll();

    // this method finds burgers by id
}
