package service;

import model.User;
import model.UserLog;
import model.UserOperations;
import model.UserRegister;

public class UserService implements UserOperations{

    public int errorCode = 0;
    public int errorAttemp = 0;

    private final UserRegister userRegister;
    
    private User currentUser = null;

    public UserService(UserRegister userRegister){
        this.userRegister = userRegister;
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
    public User[] getUsers() {
        return userRegister.users();
    }

    public User loginUser(User user){

        for(User userLogin: userRegister.users()){
            if(userLogin.getUserName().equals(user.getUserName())){

                if(userLogin.getPassword().equals(user.getPassword())){
                    currentUser = userLogin;
                    errorCode = 0;
                    return currentUser;
                }else{
                    currentUser = userLogin;
                    errorCode = 1;
                    errorAttemp += 1;
                    if(errorAttemp == 3){
                        currentUser.blockAccount();
                    }
                    return currentUser;
                }

            }
        }

        return currentUser;
       
    }

    public void logoutUser(){
        currentUser = null;
    }

    public void addUserLog(String message){
        currentUser.addUserLog(new UserLog(message));
    }

    public User currentUser(){
        return currentUser;
    }

    public String currentUserData(){
        return "Name: " + currentUser.getName() + "\n" + "UserName: " + currentUser.getUserName();
    }

  
}
