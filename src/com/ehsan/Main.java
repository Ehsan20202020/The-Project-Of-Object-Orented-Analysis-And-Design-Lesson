package com.ehsan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;




public class Main {
    static String UserName;
    static String Password;

    static Scanner Entering = new Scanner(System.in);
    static int Selection;
    static Connection conn;


    /// This object for calling the sensor method.
    static IObservable I_observer = new Sensor();

    /// This object for calling the Actuator methods.
    static IObservable I_observable = new Actuator();



    public static void main(String[] args) throws SQLException {


        /// Creating new object to use RepositoryPostgreSQL.
        RepositoryPostgreSQL RE_postgre_SQL = new RepositoryPostgreSQL();

        conn = RE_postgre_SQL.connect();
        do {
            System.out.print("Welcome, Enter your user name please...");
            UserName= Entering.next();

            System.out.print("Enter your password...");
            Password = Entering.next();

            if(CheckUser(UserName, Password)== true){
                System.out.println("Successfully login");
            }else{
                System.out.println("Your username or password is wrong!!!");
                System.out.println("Try again...");
            }
        }while(CheckUser(UserName, Password) == false);

        /// Calling the Menu function.
        MenuAnd_option();

    }

    /// It is for checking the username and password
    // which the user entered is it correct or no.
    public static boolean CheckUser(String USERname, String PASSword) throws SQLException {
        Statement st_men = null;
        st_men = conn.createStatement();

        String sql = "SELECT \"UserName\", \"Password\" FROM \"Users\"";
        ResultSet rs = st_men.executeQuery(sql);

        while(rs.next()){
            String user_name = rs.getString("UserName");
            String password = rs.getString("Password");

            if((user_name).equals(USERname) && (password).equals(PASSword))
                return true;
        }
        rs.close();
        return false;
    }


    public static void MenuAnd_option(){

        System.out.println("**************************************************");
        System.out.println("Select one option to do..."+"\n" +
                "1-) Display the Temperature."+"\n" +
                "2-) Turn on the cooler." + "\n" +
                "3-) Turn off the cooler." + "\n" +
                "4-) Log out.");
        System.out.println("***************************************************");
        Selection= Entering.nextInt();

        switch(Selection){
            case 1:
                /// Calling by Observer object.
                I_observer.advertising();
                System.out.println("The temperature of your device is: " + Sensor.Temperature + "℃.");
                MenuAnd_option();
                break;

            case 2:
                /// Calling by Observable object.
                I_observable.advertising();
                MenuAnd_option();
                break;

            case 3:
                /// Calling by Observable object.
                I_observable.advertising2();
                MenuAnd_option();
                break;
            case 4:
                System.out.println("Log out from device!!!");
                System.exit(0);
                break;
        }
    }

}




















//// static IObservable sensor = new Sensor();     /////// ASli ast //////////


/////////static IObservable get_actuator = new Actuator();  ///////// ASLIIIIIII


