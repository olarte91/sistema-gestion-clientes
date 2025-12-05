package service;

import model.User;
import model.UserLog;
import model.UserOperations;
import model.UserRegister;
import util.SessionManager;
import util.UserType;

public class UserService implements UserOperations {

    SessionManager sesion = SessionManager.getIsntance();

    public int errorCode = 0;
    public int errorAttemp = 0;

    private final UserRegister userRegister;

    public UserService(UserRegister userRegister) {
        this.userRegister = userRegister;
    }

    @Override
    public User create(User user) {
        return userRegister.create(user);   
    }

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
        errorCode = 0;

        for (User userLogin : userRegister.users()) {
            if (userLogin.getUserName().equals(user.getUserName())) {
                if (!userLogin.getPassword().equals(user.getPassword())) {
                    errorCode = 1;
                    errorAttemp += 1;
                    if (errorAttemp >= 3) {
                        userLogin.blockAccount();
                    }
                    return null;
                } else {
                    errorAttemp = 0;
                    sesion.loginUser(userLogin);
                    return sesion.getCurrentUser();
                }
            }
            return null;
        }
        return null;
    }

    public void logoutUser() {
        sesion.logoutUser();
    }

    public void addUserLog(String message) {
        sesion.getCurrentUser().addUserLog(new UserLog(message));
    }

    public String currentUserData() {
        return "Name: " + sesion.getCurrentUser().getName() + "\n" + "UserName: "
                + sesion.getCurrentUser().getUserName();
    }

    public UserLog[] getUserLogs() {
        return sesion.getCurrentUser().getUserLogs();
    }

}
