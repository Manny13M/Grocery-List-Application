import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.util.HashMap;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AddItemButtonController implements EventHandler<ActionEvent>
{
    GridPane pane;
    // ArrayList<Item> items;
    HashMap<String, Item> items;

    //Constructor
    AddItemButtonController(GridPane pane)
    {
        this.pane = pane;
    }

    //Action event handler method
    public void handle(ActionEvent event) 
    {
        LoadFromFile load = new LoadFromFile();
        load.readFromFile();
        items = load.getItems();
        displayTextField();
    }

    public void displayTextField()
    {
        //Create text fields
        TextField nameTextField = new TextField();
        TextField priceTextField = new TextField();
        TextField commentTextField = new TextField();

        //Create add button
        Button confirmAddButton = new Button("Confirm Add Item");

        int rowIndex = items.size() + 1;

        //This loop is used to determine the column index
        for(int columnIndex = 0; columnIndex < 4; columnIndex++)
        {
            pane.add(nameTextField, columnIndex, rowIndex);
            columnIndex++;

            pane.add(priceTextField, columnIndex, rowIndex);
            columnIndex++;

            pane.add(commentTextField, columnIndex, rowIndex);
            columnIndex++;

            pane.add(confirmAddButton, columnIndex, rowIndex);
        }

        //Create add button event handler object
        ConfirmAddItemController confirmAddButtonCNTR = new ConfirmAddItemController(items, nameTextField, 
            priceTextField, commentTextField, confirmAddButton, pane);
        confirmAddButton.setOnAction(confirmAddButtonCNTR); 
    }  
}
