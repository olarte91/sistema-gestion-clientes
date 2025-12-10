package model;

public class UserRegister {

    private User[] users = new User[50];
    private int slotCount = 0;
    private int userPosition = 0;

    public UserRegister(User user){

        users[0] = user;
        slotCount += 1;
    }

    public User[] users(){
        return users;
    }

    public User create(User user){
        users[slotCount] = user;

        slotCount += 1;

        return user;
    }

    public User findById(int id) {
        User user = null;
        for (int i = 0; i < users.length; i ++) {
            if(users[i] != null){
                if (users[i].getId() == id) {
                    user = users[i];
                    userPosition = i;
                }
            }else{
                break;
            }  
        }
        return user;
    }

    public User update(User user){
        users[userPosition] = user;

        return users[userPosition];
    }   

    public void delete(User user){
        User deleteUser = findById(user.getId());

        if(deleteUser != null){
            users[userPosition] = null;
            for(User userDelete: users){
                if(userDelete == null){
                    userDelete = users[userPosition +1];
                    users[userPosition + 1] = null;
                }
            }
        }
    }



}
