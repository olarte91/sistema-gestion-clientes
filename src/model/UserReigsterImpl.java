package model;

import java.util.List;

public class UserReigsterImpl implements UserRegister{

    List<User> users = List.of(
        new User("miguel", "123")
    );

    @Override
    public User create(User user) {
        users.add(user);
        return user; 
    }

    @Override
    public User update(Integer id, User user) {
        for(User userInList: users){
            if(id.equals(userInList.getId())){
                userInList.setUserName(user.getUserName());
                return userInList;
            }
        }

        return null;
    }

    @Override
    public boolean delete(User user) {
        if(users.contains(user)){
            users.remove(user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

}
