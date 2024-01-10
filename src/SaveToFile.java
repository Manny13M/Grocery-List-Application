import java.util.HashMap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class SaveToFile 
{

    HashMap<String, Item> items;

    SaveToFile(HashMap<String, Item> items)
    {
        this.items = items;
    }

    public void writeToFile()
    {
        try
        {
            //Write hashmap into .obj file
            File file = new File("/Users/manuelmartinez/Documents/Java_2/Assign_5/assign5_code3/src/items.obj");
            FileOutputStream fileOutStream = new FileOutputStream(file);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutStream);

            objectOutStream.writeObject(items); 
            
            objectOutStream.close();
            fileOutStream.close();
        }
        catch (Exception exception)
        {
            System.out.println("Exception occured..." + exception.getMessage());
        }
    }
    
}
