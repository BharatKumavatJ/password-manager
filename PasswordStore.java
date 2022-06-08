import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class PasswordStore {



    File storage = new File("data.txt");
    boolean isCreated;


    public static String encript(String message, int key)
    {
        String encrypted = "";
        char mat[][] = new char[key][message.length()];

        boolean check = false;

        int j = 0;
        for(int i = 0; i < message.length(); i++)
        {
            if(j == 0 || j == key - 1)
                check = !check;

            mat[j][i] = message.charAt(i);

            if(check) j++;
            else j--;
        }

        for(int i = 0; i < mat.length; i++)
        {
            for(int c = 0; c < message.length(); c++)
            {
                if(mat[i][c] != '\0')
                {
                    encrypted += mat[i][c];
                }
            }
           
        }


        return encrypted;
    }
    public String store(String username, String password)
    {
        try{
            isCreated = storage.createNewFile();
            if(password.length() < 8)
                return "PASSWORD SIZE MUST BE ATLEAST 8";
            password = encript(password, 5);
            Scanner sc = new Scanner(storage);
            HashMap<String, String> hm = new HashMap<>();
            FileWriter pen = new FileWriter("data.txt", true); 

            while(sc.hasNextLine())
            {
                String record = sc.nextLine();
                String[] s = record.split(": ");
                hm.put(s[0], s[1]);
            }
            String returnMess = "";
            if(hm.containsKey(username))
            {
               returnMess = "Account already present !! ";
                
            }
            else{
                    pen.write(username + ": " + password + "\n");
                    returnMess = "Data inserted successfully !!";

            }
          
            sc.close();
            pen.close();
            return returnMess;
        
            

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return password;
    }

}
