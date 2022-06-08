import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class PasswordAuthenticaton {

    File storage = new File("data.txt");
    boolean isCreated;

      public boolean check(String pass) throws IOException
      {
        isCreated = storage.createNewFile();
        HashMap<String, String> hm = new HashMap<>();
        String[] s;
        String acc = "password manager";
        try (Scanner sc = new Scanner(storage)) {
            while(sc.hasNextLine())
            {
                String record = sc.nextLine();
                s = record.split(": ");
                hm.put(s[0], s[1]);
            }
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
        if(hm.containsKey(acc))
        {
            
            SearchPassword searchpass = new SearchPassword();
            String password = searchpass.search(acc);
            System.out.println(password);
            if(pass.equals(password))
                return true;
            else
            return false;


            
        }
        else{
              
                return false;

        }
      }  
    
}
