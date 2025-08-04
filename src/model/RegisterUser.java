package model;

import java.util.ArrayList;
import java.util.List;

public class RegisterUser {

    private List<User> users = new ArrayList<>(List.of(new User("admin", "administrador", "123")));

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }
}
