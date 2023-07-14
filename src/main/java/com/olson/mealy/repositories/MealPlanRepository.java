package com.olson.mealy.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.olson.mealy.models.MealPlan;
import com.olson.mealy.models.User;

@Repository
public interface MealPlanRepository extends CrudRepository<MealPlan, Long>{
	List<MealPlan> findAll();
	Optional<MealPlan> findByDate(LocalDate date);
	List<MealPlan> findAllByUser(User user);
}
