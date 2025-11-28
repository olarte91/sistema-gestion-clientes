package model;

public class UserRegister {

    private User[] users = new User[50];
    private int slotCount = 0;

    public UserRegister(User user){

        users[0] = user;
        slotCount += 1;;
    }

    public User[] users(){
        return users;
    }

    public User create(User user){
        users[slotCount] = user;

        return user;
    }

    public User findById(int id) {
        User user = null;
        for (User usuario : users) {
            if (usuario.getId().equals(id)) {
                user = usuario;
            }
        }
        return user;
    }

    public User update(User user){
        User updateUser = findById(user.getId());

        if(updateUser != null){
            updateUser.setName(user.getName());
            updateUser.setUserName(user.getUserName());
            updateUser.setPassword(user.getPassword());
        }

        return updateUser;
    }

    // public void delete(User user){
    //     User deleteUser = findById(user.getId());

    //     if(deleteUser != null){
    //         users.remove(deleteUser);
    //     }
    // }



}
