package service;

import java.util.List;

import model.AdminUser;
import model.RegisterUser;
import model.StandardUser;
import model.User;

public class UserService {

    public RegisterUser registerUser;

    public void createNewUser(String[] userData) {

        if ("admin".equalsIgnoreCase(userData[3])) {

            User user = new AdminUser(userData[0], userData[1], userData[2]);
            registerUser = new RegisterUser();
            registerUser.addUser(user);
        } else {
            User user = new StandardUser(userData[0], userData[1], userData[2]);
            this.registerUser.addUser(user);
        }

    }

    public List<User> showUsers() {
        return registerUser.getUsers();
    }

    public boolean loginUser(String [] userData) {
        RegisterUser registerUser = new RegisterUser();
        for (User user : registerUser.getUsers()) {
            if (userData[0].equals(user.getUserName())) {
                if(userData[1].equals(user.getPassword())){
                    return true;
                }
            } 
        }
        return false;
    }
}
