package model;

public interface UserOperations {

    User create(User user);
    User findById (int id);
    void update(User user);
    boolean delete(Integer userId);
    User[] getUsers();
    boolean changeUserRole(Integer userId);
    Integer lockUnlockUser(Integer userId);

}
