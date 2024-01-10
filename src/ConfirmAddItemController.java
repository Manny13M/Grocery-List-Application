import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.util.HashMap;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ConfirmAddItemController implements EventHandler<ActionEvent>
{
    HashMap<String, Item> items;
    TextField       nameTextField;
    TextField       priceTextField;
    TextField       commentTextField;
    Button          addButton;
    GridPane        pane;

    //Constructor
    ConfirmAddItemController(HashMap<String, Item> items, TextField nameTextField,
    TextField priceTextField, TextField commentTextField, Button addButton, GridPane pane)
    {
        this.items              = items;
        this.nameTextField      = nameTextField;
        this.priceTextField     = priceTextField;
        this.commentTextField   = commentTextField;
        this.addButton          = addButton;
        this.pane               = pane;
    }

    //Action event handler method
    public void handle(ActionEvent event) 
    {
        storeTextFieldValues();

        SaveToFile save = new SaveToFile(items);
        save.writeToFile();

        LoadFromFile load = new LoadFromFile();
        load.readFromFile();
        items = load.getItems();

        displayItemsOnPane display = new displayItemsOnPane(pane, items);
        display.displayItems();
    }

    public void storeTextFieldValues()
    {
        //Store textfield input into variables
        String  name     = nameTextField.getText();
        String  comment  = commentTextField.getText();
        int     price    = Integer.parseInt(priceTextField.getText());
    
        //Create Item and store in Hashmap
        Item item = new Item(name, price , comment);
        items.put(item.name, item);

        pane.getChildren().removeAll(nameTextField, priceTextField, commentTextField, addButton);
    }
}
