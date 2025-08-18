package model;

import java.util.List;

public class AdminUser extends User{

    UserRegister userRegister;

    public AdminUser(String userName, String password, UserRegister userRegister){
        super(userName, password);
        this.userRegister = userRegister;
    }

    public User createUser(User user){
        return userRegister.create(user);
    }

    public User updateUser(Integer userId, User user){
        return userRegister.update(userId, user);
    }

    public boolean deleteUser(User user){
        return userRegister.delete(user);
    }

    public List<User> getAllUsers(){
        return userRegister.getUsers();
    }

}
