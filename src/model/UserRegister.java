package model;

import java.util.List;

public interface UserRegister {

    User create(User user);
    User update(Integer id, User user);
    boolean delete(User user);
    List<User> getUsers();

}
