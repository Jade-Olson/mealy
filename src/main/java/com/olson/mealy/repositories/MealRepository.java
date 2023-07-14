package com.olson.mealy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olson.mealy.models.Meal;
import com.olson.mealy.models.User;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
	List<Meal> findAll();
	List<Meal> findAllByUser(User user);
}
