package com.shein;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignupServlet extends HttpServlet {
    DataBasrRepositry db = new DataBasrRepositry();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("emailId");

        String password = req.getParameter("passwordId");


        try {
           int result= db. addDetails(email,password);
           if(result==1)resp.getWriter().write("Success");
           else
               resp.getWriter().write("failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }

