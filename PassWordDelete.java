import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class PassWordDelete {

    File storage = new File("data.txt");

    public static void clearfile() throws IOException
    {
        
        try {
            FileWriter pen = new FileWriter("data.txt", false);
            pen.write("");
            pen.close();
            
        } catch (Exception e) {
            
        }
    }

    public String delete(String username)
    {
        if(username.equals("password manager"))
            return "SORRY YOU CANNOT DELETE THIS ACCOUNT";
        try{
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
                clearfile();
                hm.remove(username);
                for(String s: hm.keySet())
                {
                    String record = s + ": " + hm.get(s) + "\n";
                    pen.write(record);
                }
               returnMess = "DELETED SUCCESSFULLY!!";
            }
            else
            {
                returnMess =  "USER NOT EXIST !!";
            }

            sc.close();
            pen.close();
            return returnMess;
        
            

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return username;

    }

}
