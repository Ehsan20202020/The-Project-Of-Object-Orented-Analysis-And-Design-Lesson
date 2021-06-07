package com.ehsan;

public class Sensor implements IObservable{
    private User user;

    /// Getting UserBuilder and use in every class.
    public static User getBuilder(){
        User user1 = new User.UserBuilder().build();
        return user1;
    }

    /// To display temperature.
    private int MeasureTemperature(){
        int max = 40;
        int min =10;
        int range = max - min +1;
        Temperature = (int) (Math.random()* range)+min;
        return Temperature;
    }

    static int Temperature;


    /// Dependency Inversion - Using advertising function.
    @Override
    public void advertising() {
        MeasureTemperature();
    }

    public void advertising2(){
    }
}






















    /*
    /// Getting UserBuilder and use in every class.
    public static User getBuilder(){
       User userbuild = new User.UserBuilder("", "").build();
        return userbuild;
    }

     */



   /*   DOROST ASSSSSSSSSSSSSSYTTTTTTT
    public Sensor(){
        this.user = getUser().build();
    }
     public Sensor(){
        this.user = getUser().build();
    }

     */