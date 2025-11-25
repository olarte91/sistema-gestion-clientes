package model;

public class AdminUser extends User{

    public AdminUser( String username, String name, String password){
        super(username, name, password);
    }

    public AdminUser(){}

    @Override
    public boolean canCreateUser(){
        return true;
    }

    @Override
    public boolean canEditUser(){
        return true;
    }

    @Override
    public boolean canDeleteUser(){
        return true;
    }
}
