package com.onlyhorde.springsimpleapp;

import com.onlyhorde.springsimpleapp.utility.MealsUtil;

public class Main {
    public static void main(String[] args) {
        MealsUtil mealsUtil = new MealsUtil();
        mealsUtil.createList().stream().forEach(p -> System.out.println(p.getCalories()));
    }
}
