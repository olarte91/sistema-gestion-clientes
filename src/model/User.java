package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static Integer userId = 0;
    private String userName;
    private String password;
    private List<UserLog> userLogs = new ArrayList<>();

    public User(String userName, String password){
        userId ++;
        this.userName = userName;
        this.password = password;
    }

    public User(){

    }

    public Integer getId(){
        return userId;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public List<UserLog> getUserLogs(){
        return userLogs;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUserLog(UserLog userLog){
        userLogs.add(userLog);
    }

}
