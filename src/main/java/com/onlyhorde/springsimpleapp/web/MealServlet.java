package com.onlyhorde.springsimpleapp.web;

import com.onlyhorde.springsimpleapp.model.MealWithExceed;
import com.onlyhorde.springsimpleapp.utility.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class MealServlet extends HttpServlet {

    MealsUtil mealsUtil = new MealsUtil();
    List<MealWithExceed> l = mealsUtil.createList();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        request.setAttribute("meals", l);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
