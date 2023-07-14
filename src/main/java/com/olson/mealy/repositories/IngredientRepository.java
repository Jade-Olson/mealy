package com.olson.mealy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olson.mealy.models.Ingredient;
import com.olson.mealy.models.User;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	List<Ingredient> findAll();
	List<Ingredient> findAllByUser(User user);
}
