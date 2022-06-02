import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class SearchPassword {

    File storage = new File("data.txt");
    boolean isCreated;

    public static String decript(String message, int key)
    {

        String decripted = "";
        boolean check = false;
        char mat[][] = new char[key][message.length()];
 
        int j = 0;
        for(int i = 0; i < message.length(); i++)
        {
            if(j == 0 || j == key - 1)
                check = !check;

            mat[j][i] = '*';

            if(check) j++;
            else j--;
        }
        int idx = 0;
        for(int i = 0; i < mat.length; i++)
        {
            for(int c = 0; c < message.length(); c++)
            {
                if(mat[i][c] == '*')
                {
                    mat[i][c] = message.charAt(idx++);
                }    
            }
            
        }


        j = 0;
        check = false;
        for(int i = 0; i < message.length(); i++)
        {
            if(j == 0 || j == key - 1)
                check = !check;

            decripted += mat[j][i];

            if(check) j++;
            else j--;
        }
       

        return decripted;
    }

    public  String  search(String username) throws IOException
    {
        isCreated = storage.createNewFile();
        HashMap<String, String> hm = new HashMap<>();
        String[] s;
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
        if(hm.containsKey(username))
        {
            String password = hm.get(username);
            return decript(password, 5);
            
        }
        else{
              
                return null;

        }
        
            
    }

}
