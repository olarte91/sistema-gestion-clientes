package model;

import util.UserType;

public class User {

    private static Integer userId = 1;
    private Integer id;
    private String name;
    private String username;
    private String password;
    private Boolean isAccountBlocked = false;
    private UserLog[] userLogs = new UserLog[100];
    private int logCounter = 0;
    private UserType userType;
    public boolean canCreateUser = false;
    public boolean canEditUser = false;
    public boolean canDeleteUser = false;

    public User(String username, String name, String password, UserType type){
        this.id = userId ++;
        this.username = username;
        this.name = name;
        this.password = password;

        if(type == UserType.ADMIN){
            canCreateUser();
            canEditUser();
            canDeleteUser();
            this.userType = type;
        }else{
            canEditUser();
            this.userType = type;
        }
       
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(){
    }

    public Integer getId(){
        return id;
    }

    public String getUserName(){
        return username;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public UserLog[] getUserLogs(){
        return userLogs;
    }

    public void setUserName(String userName){
        this.username = userName;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void addUserLog(UserLog userLog){
        
        userLogs[logCounter] = userLog;

        logCounter += 1;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType type){
        this.userType = type;
    }

    //Permisos de usuario

    public void canCreateUser(){
        canCreateUser = !canCreateUser;
    }

    public void canEditUser(){
        canEditUser = !canEditUser;
    }

    public void canDeleteUser(){
        canDeleteUser = !canDeleteUser;
    }

    public boolean isAccountBlocked(){
        return isAccountBlocked;
    }

    public void blockAccount(){
        isAccountBlocked = !isAccountBlocked;
    }

}
