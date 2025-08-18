package service;

import java.util.List;

import model.User;
import model.UserLog;
import model.UserRegister;

public class UserService {

    private UserRegister userRegister;

    public UserService (UserRegister userRegister){
        this.userRegister = userRegister;
    }

    public User login(User user){
        for(User userInList:userRegister.getUsers()){
            if(verifyUserExist(user.getUserName(), user.getPassword(), userInList)){
                UserLog userLog = new UserLog("Usuario inicia sesión");
                userInList.setUserLog(userLog);
                return userInList;
            }
        }
        return null;
    }

    private boolean verifyUserExist(String username, String password, User user){
        if(user.getUserName().equals(username) && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public List<UserLog> getUserLogs(User user){
        return user.getUserLogs();
    }
}
