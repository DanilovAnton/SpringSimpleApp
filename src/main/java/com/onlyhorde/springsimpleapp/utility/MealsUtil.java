package com.onlyhorde.springsimpleapp.utility;

import com.onlyhorde.springsimpleapp.model.Meal;
import com.onlyhorde.springsimpleapp.model.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class MealsUtil {
    public static void main(String[] args) {
        List<Meal> mealList = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);

        mealList.forEach(meal -> System.out.println(meal.getDateTime() + " " +
                                                    meal.getDescription() + " " +
                                                    meal.getCalories()));
    }

    public static List<MealWithExceed>  getFilteredWithExceeded(List<Meal> mealList, final LocalTime startTime, final LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate, Integer> caloriesSumByDate = mealList.stream()
                .collect(Collectors.groupingBy( m -> m.getDate(), Collectors.summingInt( Meal::getCalories )));

        return mealList.stream().
                filter(p -> p.getTime().compareTo(startTime) >= 0 && p.getTime().compareTo(endTime) <= 0)
                .map(p -> new MealWithExceed(p.getDateTime(), p.getDescription(), p.getCalories(),
                        caloriesSumByDate.get(p.getDate()) >= caloriesPerDay))
                .collect(Collectors.toList());
    }
}
