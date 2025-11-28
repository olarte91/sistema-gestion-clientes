package model;

public interface UserOperations {

    User create(User user);
    User findById (int id);
    User update(Integer id, User user);
    boolean delete(User user);
    User[] getUsers();

}
