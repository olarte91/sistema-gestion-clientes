package model;

import util.UserType;

public class UserRegister {

    private User[] users = new User[50];
    private int slotCount = 0;
    private int userPosition = 0;

    public UserRegister(User user){

        users[0] = user;
        slotCount += 1;
    }

    public User[] getAllUsers(){
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

    public boolean delete(Integer id) {
        User deleteUser = findById(id);

        if (deleteUser != null) {
            for (int i = userPosition; i < slotCount - 1; i++) {
                users[i] = users[i + 1];
            }

            users[slotCount - 1] = null;

            slotCount--;

            return true;
        }

        return false;
    }

    public boolean changeUserRole(Integer id){
        User changeUserRole = findById(id);

        if(changeUserRole != null){
            if(changeUserRole.getUserType().equals(UserType.ADMIN)){
                changeUserRole.setUserType(UserType.STANDARD);
                changeUserRole.canCreateUser();
                changeUserRole.canEditUser();
                changeUserRole.canDeleteUser();
                return true;
            }else{
                changeUserRole.setUserType(UserType.ADMIN);
                changeUserRole.canCreateUser();
                changeUserRole.canEditUser();
                changeUserRole.canDeleteUser();
                return true;
            }
        }
        return false;
    }



}
