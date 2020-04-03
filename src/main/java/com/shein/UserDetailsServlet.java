package com.shein;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@WebServlet(name = "userDetailsServlet",urlPatterns = "/userDetails")
public class UserDetailsServlet extends HttpServlet {
    ResultSet rs ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter print = resp.getWriter();
        DataBasrRepositry db = new DataBasrRepositry();



        try {
            rs = db.getUserData();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("empty");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("empty");
        }




            ArrayList<UserDetails> UsersList = new ArrayList<>();


        try {
            while(rs.next()) {

        UserDetails userdetails = new UserDetails();
        UserDetails ud = userdetails.getUsers(rs);

        UsersList.add(ud);

    }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        GsonBuilder builder = new GsonBuilder();
                builder.setPrettyPrinting();
                Gson gson = builder.create();



            print.write(gson.toJson(UsersList));


        }

    }

