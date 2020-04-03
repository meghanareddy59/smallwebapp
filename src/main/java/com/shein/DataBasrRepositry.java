package com.shein;

import java.sql.*;

public class DataBasrRepositry {
    Statement stmt;

    public Statement connection() throws ClassNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sheindb", "meghana", "9177733205");
            stmt = con.createStatement();
            return stmt;
        } catch (SQLException e) {
            System.out.println("connection is not established");
            return null;
        }

    }

    public DataBasrRepositry() {
        try {
            stmt = connection();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int addDetails(String email, String password) throws SQLException {
        System.out.println(email);

        String query ="insert into userData(email,password) values('"+email+"','"+password+"')";
        int result=stmt.executeUpdate(query);


        System.out.println(query);
        return result;

    }

    public int check(String email, String password) throws SQLException, ClassNotFoundException, SQLException {


        String query = "select * from userData where email='" + email + "' AND password='" + password + "'";
        int result ;

        ResultSet rs = stmt.executeQuery(query);
        if(rs.next())

            result=1;

        else
            result =0;

return result;
    }
    public ResultSet getUserData() throws SQLException, ClassNotFoundException, SQLException {
        try {
            String query = "select * from userData order by email";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


