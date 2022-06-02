import java.io.IOException;

public class PasswordUpdate {
    
    public String update(String username, String password) throws IOException
    {
        if(password.length() < 8)
        {
            return "password size must be atleast 8";
        }
        SearchPassword searchpass = new SearchPassword();
        String pass = searchpass.search(username);

        if(pass == null)
        {
            return "INVALID USERNAME";
        }
        else{
            if(pass.equals(password))
            {
                return "OLD PASSWORD IS SAME AS NEW PASSWRD !!";
            }
            else{
                PassWordDelete passdel = new PassWordDelete();
                passdel.delete(username);
                PasswordStore passstore = new PasswordStore();
                passstore.store(username, password);
                return "Password Updated Successfully !!";
            

            }
        }
        
    }
}
