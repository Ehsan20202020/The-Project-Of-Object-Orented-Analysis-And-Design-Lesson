package com.ehsan;

public class User implements IObserver {
    private final String UserName;
    private final String Password;

    public String getUserName() {
        return this.UserName;
    }

    public String getPassword() {
        return this.Password;
    }

    private User(UserBuilder builder) {
        this.UserName = builder.UserName;
        this.Password = builder.Password;
    }


    public static void Turn_on() {
        System.out.println("The cooler turned on");
    }

    public static void Turn_off() {
        System.out.println("The cooler Turned off");
    }

    /// Observer Pattern - by using Update function
    /// Sending the situation to all observers
    @Override
    public void Update(boolean Message) {
        if (Message == true) {
            Turn_on();
        }
        else {
            Turn_off();
        }
    }

    /// Builder Design Pattern - By adding inner class.
    /// Inner class to use Builder.
    public static class UserBuilder {
        private final String UserName;
        private final String Password;


        public UserBuilder() {
            this.UserName = build().UserName;
            this.Password = build().Password;
        }

        /// Builder Design pattern.
        /// return the finally constructed User object
        public User build() {
            return new User(this);
        }
    }
}






