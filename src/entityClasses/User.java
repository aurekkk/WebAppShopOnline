package entityClasses;

import model.DBcon;

public class User {

    public boolean isValidLogin(String username, String password){
        DBcon dBcon = new DBcon();

        return dBcon.isValidLoginCredentials(username, password);
    }

    public String userRole(String username){
        DBcon dBcon = new DBcon();

        return dBcon.DBUserRole(username);
    }

    public boolean registerUser(String username, String password){
        DBcon dBcon = new DBcon();
        if (dBcon.DBRegisterUser(username, password)>0) return true;
        return false;
    }

}
