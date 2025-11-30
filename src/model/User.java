package model;

public class User {

    private static Integer userId = 1;
    private Integer id;
    private String name;
    private String username;
    private String password;
    private Boolean isAccountBlocked = false;
    private UserLog[] userLogs = new UserLog[100];
    private int logCounter = 0;

    public User(String username, String name, String password){
        this.id = userId ++;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User(){
        this.id = userId ++;
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

    //Permisos de usuario

    public boolean canCreateUser(){
        return false;
    }

    public boolean canEditUser(){
        return false;
    }

    public boolean canDeleteUser(){
        return false;
    }

    public boolean isAccountBlocked(){
        return isAccountBlocked;
    }

    public void blockAccount(){
        isAccountBlocked = true;
    }

}
