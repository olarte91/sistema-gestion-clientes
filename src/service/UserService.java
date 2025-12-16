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
        sesion.getCurrentUser().addUserLog(new UserLog("ha creado un nuevo usuario " + user.getUserName()));
        return userRegister.create(user);
    }

    @Override
    public User findById(int id) {
        return userRegister.findById(id);
    }

    @Override
    public void update(User user) {
        userRegister.update(user);
    }

    @Override
    public boolean delete(Integer userId) {
        User user = userRegister.findById(userId);

        return userRegister.delete(user);
    }

    @Override
    public User[] getUsers() {
        return userRegister.getAllUsers();
    }

    public User loginUser(User user) {
        errorCode = 0;

        for (User userLogin : userRegister.getAllUsers()) {
            if (userLogin == null) {
                return null;
            }

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

    public User getUserLogs(Integer userId) {
        return userRegister.findById(userId);
    }

    @Override
    public boolean changeUserRole(Integer userId) {
        User user = userRegister.findById(userId);

        if(user != null){
            if(user.getUserType().equals(UserType.ADMIN)){
                user.setUserType(UserType.STANDARD);
                user.canCreateUser();
                user.canEditUser();
                user.canDeleteUser();
                userRegister.changeUserRole(user);
                return true;
            }else{
                user.setUserType(UserType.ADMIN);
                user.canCreateUser();
                user.canEditUser();
                user.canDeleteUser();
                userRegister.changeUserRole(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer lockUnlockUser(Integer userId) {

        User user = userRegister.findById(userId);

        if(user != null){
            if(!user.isAccountBlocked()){
                user.blockAccount();
                return 1;
            }else{
                user.blockAccount();
                return 2;
            }
        }
        return 3;
    }

}
