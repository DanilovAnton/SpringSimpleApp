package com.onlyhorde.springsimpleapp.utility;

import com.onlyhorde.springsimpleapp.model.Meal;
import com.onlyhorde.springsimpleapp.model.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MealsUtil {
    public static final int DEFAULT_CALORIES = 2000;
    AtomicInteger atomicInteger = new AtomicInteger(1);
    private List<Meal> mealList = Arrays.asList(
            new Meal(atomicInteger.getAndIncrement(), LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
            new Meal(atomicInteger.getAndIncrement(), LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
            new Meal(atomicInteger.getAndIncrement(), LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
            new Meal(atomicInteger.getAndIncrement(), LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
            new Meal(atomicInteger.getAndIncrement(), LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
            new Meal(atomicInteger.getAndIncrement(), LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 490)
    );

    public List<MealWithExceed> createList(){
        return getWithExceeded(this.mealList);
    }



    public List<MealWithExceed>  getWithExceeded(List<Meal> mealList){

        Map<LocalDate, Integer> caloriesSumByDate = checkMeals(mealList);

        return mealList.stream()
                .map(p -> new MealWithExceed(p.getId(), p.getDateTime(), p.getDescription(), p.getCalories(),
                        caloriesSumByDate.get(p.getDate()) >= DEFAULT_CALORIES))
                .collect(Collectors.toList());
    }
    
    public List<MealWithExceed>  getFilteredWithExceeded(List<Meal> mealList, final LocalTime startTime, final LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate, Integer> caloriesSumByDate = checkMeals(mealList);

        return mealList.stream().
                filter(p -> p.getTime().compareTo(startTime) >= 0 && p.getTime().compareTo(endTime) <= 0)
                .map(p -> new MealWithExceed(p.getId(), p.getDateTime(), p.getDescription(), p.getCalories(),
                        caloriesSumByDate.get(p.getDate()) >= caloriesPerDay))
                .collect(Collectors.toList());
    }

    private Map<LocalDate, Integer> checkMeals (List<Meal> mealList){
        return mealList.stream()
                .collect(Collectors.groupingBy( m -> m.getDate(), Collectors.summingInt( Meal::getCalories )));
    }
}
