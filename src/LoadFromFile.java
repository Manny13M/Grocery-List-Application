import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadFromFile 
{
    // ArrayList<Item> items;
    HashMap<String, Item> items;

    LoadFromFile()
    {

    }

    public void readFromFile()
    {
        try
        {
            //Read from obj file
            File file = new File("/Users/manuelmartinez/Documents/Java_2/Assign_5/assign5_code3/src/items.obj");
            FileInputStream fileInStream = new FileInputStream(file);
            ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);

            //Cast object into HashMap so I can work with it
            HashMap<String, Item> items = (HashMap<String, Item>) objectInStream.readObject();

            this.items = items;

            objectInStream.close();
            fileInStream.close(); 
        }

        catch (Exception exception)
        {
            System.out.println("Exception occured..." + exception.getMessage());
        }
    }

    public HashMap<String, Item> getItems()
    {
        return items;
    }
}
