package com.shein;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class LoginServlet  extends HttpServlet {
    DataBasrRepositry db = new DataBasrRepositry();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        String password = req.getParameter("password");

        DataBasrRepositry db = new DataBasrRepositry();
        try {

            int re = db.check(email, password);

            if (re == 1) resp.getWriter().write("Success");
            else
                resp.getWriter().write("failed");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
