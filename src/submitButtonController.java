import java.util.HashMap;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class submitButtonController implements EventHandler<ActionEvent>
{

    HashMap<String, Item> items = new HashMap<>();

    TextField nameTextField;
    TextField priceTextField;
    TextField commentTextField;
    
    //Constructor
    submitButtonController(HashMap<String, Item> items, TextField nameTextField, 
        TextField priceTextField, TextField commentTextField)
    {
        this.items              = items;
        this.nameTextField      = nameTextField;
        this.priceTextField     = priceTextField;
        this.commentTextField   = commentTextField;
        
    }

    //Action event handler method
    public void handle(ActionEvent event) 
    {
        
        //Store textfield input into variables
        String  name     = nameTextField.getText();
        String  comment  = commentTextField.getText();
        int     price    = Integer.parseInt(priceTextField.getText());
        
        //Create activity object with values from the variables, then add to HashMap
        Item item = new Item(name, price, comment);
        items.put(item.name, item);

        //Clear the textfields
        nameTextField.clear();
        priceTextField.clear();
        commentTextField.clear();

        //Create save variable then call the writeToFile method
        SaveToFile save = new SaveToFile(items);
        save.writeToFile();

        for(String each: items.keySet())
        {
            System.out.println(items.get(each).name);
        }
    }
}
