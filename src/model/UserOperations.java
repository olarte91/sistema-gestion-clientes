package model;

public interface UserOperations {

    User create(User user);
    User findById (int id);
    void update(User user);
    boolean delete(User user);
    User[] getUsers();

}
