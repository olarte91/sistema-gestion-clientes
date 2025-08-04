package model;

import java.util.List;

public class User {

    private static Integer contador = 1;
    private Integer id;
    private String userName;
    private String fullName;
    private String password;
    private List<UserAction> userAction;

    public User(String userName, String fullName, String password) {
        this.id = contador;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        contador ++;
    }

    public void addUserAction(UserAction userAction){
        this.userAction.add(userAction);
    }

    @Override
    public String toString(){
        return "Id user: " + id + "\n" +
        "user name: " + userName + "\n" +
        "full name: " + fullName;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }

}
