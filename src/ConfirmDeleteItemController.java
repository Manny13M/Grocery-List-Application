import javafx.scene.control.TextField;
import java.util.HashMap;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConfirmDeleteItemController implements EventHandler<ActionEvent>
{
    GridPane pane;
    TextField nameTextField;
    HashMap<String, Item> items;

    ConfirmDeleteItemController(GridPane pane, TextField nameTextField)
    {
        this.pane = pane;
        this.nameTextField = nameTextField;
    }

    //Action event handler method
    public void handle(ActionEvent event) 
    {
        LoadFromFile load = new LoadFromFile();
        load.readFromFile();
        items = load.getItems();
        
        for(String name: items.keySet())
        {
            System.out.println(name);
        }

        System.out.println("\n\n\n");

        for(String name: items.keySet())
        {
            if(nameTextField.getText() == name)
            {
                items.remove(name, items.get(name));
            }
        }

        items.remove("Water", items.get("Water"));

        for(String name: items.keySet())
        {
            System.out.println(name);
        }
    }
    
}
