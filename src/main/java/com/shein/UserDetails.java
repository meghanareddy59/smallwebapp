package com.shein;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetails {
    private String email;
    private String password;
    private String image;


    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getImage() {
        return image;
    }





    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
    public UserDetails getUsers(ResultSet res)
    {
        UserDetails userdetails=new UserDetails();
        try {

            userdetails.setEmail(res.getString("email"));
            userdetails.setPassword(res.getString("password"));
            userdetails.setImage(res.getString("image"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userdetails;
    }

    }

