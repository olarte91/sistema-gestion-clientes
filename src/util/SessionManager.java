package util;

import model.User;

public class SessionManager {

    private static SessionManager instance;
    private User currentUser;

    private SessionManager () {}

    public static SessionManager getIsntance(){
        if(instance == null){
            instance = new SessionManager();
        }

        return instance;
    }

    public void loginUser(User user){
        this.currentUser = user;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void logoutUser(){
        this.currentUser = null;
    }

}
