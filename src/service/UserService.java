package service;

import model.User;
import model.UserLog;
import model.UserOperations;
import model.UserRegister;
import util.SessionManager;

public class UserService implements UserOperations {

    SessionManager sesion = SessionManager.getIsntance();

    public int errorCode = 0;
    public int errorAttemp = 0;

    private final UserRegister userRegister;

    public UserService(UserRegister userRegister) {
        this.userRegister = userRegister;
    }

    // @Override
    // public User create(User user) {
    //     // if(!currentUser.canCreateUser()){
    //     // return null;
    //     // }

    //     // userRegister.create(user);

    //     // currentUser.addUserLog(new UserLog("Se ha creado el usuario: " +
    //     // user.getUserName()));

    //     // return user;
    // }

    @Override
    public User findById(int id) {
        return userRegister.findById(id);
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

    public User loginUser(User user) {

        for (User userLogin : userRegister.users()) {
            if (!userLogin.getUserName().equals(user.getUserName())) {
                return sesion.getCurrentUser();
            } else {
                if (!userLogin.getPassword().equals(user.getPassword())) {
                    sesion.loginUser(user);
                    errorCode = 1;
                    errorAttemp += 1;
                    if(errorAttemp == 3){
                        sesion.getCurrentUser().blockAccount();
                    }
                }else{
                    sesion.loginUser(userLogin);
                    return sesion.getCurrentUser();
                }
            }

        }
        return sesion.getCurrentUser();
    }

    public void logoutUser() {
        sesion.logoutUser();
    }

    public void addUserLog(String message) {
        sesion.getCurrentUser().addUserLog(new UserLog(message));
    }

    public String currentUserData() {
        return "Name: " + sesion.getCurrentUser().getName() + "\n" + "UserName: " + sesion.getCurrentUser().getUserName();
    }

    public UserLog[] getUserLogs() {
        return sesion.getCurrentUser().getUserLogs();
    }

    @Override
    public User create(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

}
