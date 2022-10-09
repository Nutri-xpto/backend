package com.example.demo.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.demo.dto.HealthCheckDTO;

public class HealthService {

    final static String CONECTION_STRING = "jdbc:postgresql://db:5432/DEV";

    public static HealthCheckDTO isConnected(){
        String message = "Unnable to connect with database.";
        boolean isConnected = false;

        try {
            Connection con  = DriverManager.getConnection(CONECTION_STRING + "?currentSchema=DEV&user=compose-postgres&password=compose-postgres");
            if(con != null && ! con.isClosed()){
                isConnected = true;
                message =  "Successfully connected.";
            }
        }catch( SQLException e ) {
            message =  e.getMessage();
        }

        // Send to datadog 
        return new HealthCheckDTO(isConnected, message);
    }
}
