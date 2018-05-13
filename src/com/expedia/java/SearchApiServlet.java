package com.expedia.java;

import Controller.SearchController;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "SearchApiServlet",urlPatterns = {"/Master"})
public class SearchApiServlet extends HttpServlet {

    SearchController controller = new SearchController();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> params = request.getParameterMap();

        PrintWriter pw = response.getWriter();

        JsonArray result = (JsonArray) controller.doSearch(params);
        pw.println(result.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        pw.println("Weloome");

    }
}
