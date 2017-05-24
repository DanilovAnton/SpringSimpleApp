package com.onlyhorde.springsimpleapp.repository;

import com.onlyhorde.springsimpleapp.model.Meal;
import com.onlyhorde.springsimpleapp.utility.MealsUtil;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

import java.util.concurrent.atomic.AtomicInteger;

public class InMemMealRepository implements MealRepository{
    private Map<Integer, Meal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.mealList.forEach(this::save);
    }

    @Override
    public Meal save(Meal meal) {
        if (meal.isNew()){
            meal.setId(counter.incrementAndGet());
        }
        repository.put(meal.getId(), meal);
        return meal;
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<Meal> getAll() {
        return repository.values();
    }
}
