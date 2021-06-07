package com.ehsan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.ehsan.Sensor.getBuilder;

public class RepositoryPostgreSQL implements IRepositoryPostgreSQL{


    /// Calling userBuilder in RepositoryPostgreSQL class.
    public RepositoryPostgreSQL(){
        Sensor.getBuilder();
    }

    /// Connecting to postgreSQL - database.
    @Override
    public Connection connect() {
        String DB_URL= "jdbc:postgresql://localhost:5432/SystemOfCooling";
        String USER = "postgres";
        String PASSWORD = "ZAhra0101";

        Connection conn = null;

        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            if( conn != null){
                System.out.println("Successfully connected to database!!!");
            }else{
                System.out.println("Do not connect to database!!!");
            }
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return conn;
    }
}
