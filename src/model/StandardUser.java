package model;

public class StandardUser extends User{

    public StandardUser(String userName, String password){
        super(userName, password);
    }

    public User view(){
        return this;
    }

    public User update(User user){
        this.setUserName(user.getUserName());
        this.setPassword(user.getPassword());

        return this;
    }

}
