package model;

public class StandardUser extends User{

    public StandardUser(String username, String name, String password){
        super(username, name, password);
    }

    @Override
    public boolean canEditUser(){
        return true;
    }

}
