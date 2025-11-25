package model;

import java.util.List;

public interface UserOperations {

    User create(User user);
    User findById (int id);
    User update(Integer id, User user);
    boolean delete(User user);
    List<User> getUsers();

}
