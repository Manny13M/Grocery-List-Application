import java.util.HashMap;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ShowItemsButtonController implements EventHandler<ActionEvent>
{
    GridPane pane;
    HashMap<String, Item> items;

    //Constructor
    ShowItemsButtonController(GridPane pane)
    {
        this.pane = pane;
    }

    //Action event handler method
    public void handle(ActionEvent event) 
    {
        LoadFromFile load = new LoadFromFile();
        load.readFromFile();
        items = load.getItems();

        displayItemsOnPane display = new displayItemsOnPane(pane, items);
        display.displayItems();
    }


}
