package com.onlyhorde.springsimpleapp.utility;

import com.onlyhorde.springsimpleapp.model.Meal;
import com.onlyhorde.springsimpleapp.model.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

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
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<MealWithExceed>  getFilteredWithExceeded(List<Meal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<MealWithExceed> list = new ArrayList<>();

        Map<LocalDate, Integer> caloriesSumByDate = new HashMap<>();
        for (Meal item : mealList) {
            caloriesSumByDate.merge(item.getDate(), item.getCalories(), (a, b) -> Integer.sum(a, b));
        }


        return null;
    }
}
