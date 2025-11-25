package service;

import java.util.List;

import model.User;
import model.UserLog;
import model.UserOperations;
import model.UserRegister;

public class UserService implements UserOperations{

    private final UserRegister userRegister;
    private User currentUser = null;

    public UserService(User user, UserRegister userRegister){
        this.userRegister = userRegister;
        this.currentUser = user;
    }

    @Override
    public User create(User user) {
        if(!currentUser.canCreateUser()){
            return null;
        }

        userRegister.create(user);

        currentUser.addUserLog(new UserLog("Se ha guardado el usuario: " + user.getUserName()));

        return user;
    }

    @Override
    public User findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public User update(Integer id, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<User> getUsers() {
        return userRegister.users();
    }

  
}
