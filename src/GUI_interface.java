import java.util.HashMap;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class GUI_interface extends Application
{
    public void start(Stage stage)
    {
       
        //Pane width and height
        final int PANE_WIDTH = 600;
        final int PANE_HEIGHT = 500;

        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, PANE_WIDTH, PANE_HEIGHT);

        //Create buttons
        Button createListButton  = new Button("Create New List");
        Button addItemButton = new Button("Add Item"); 
        Button deleteItemButton = new Button("Delete Item"); 
        Button showItemsButton = new Button("Show Items"); 

        //Add things to pane
        pane.add(createListButton, 0, 0);
        pane.add(showItemsButton, 1, 0);
        pane.add(addItemButton, 2, 0);
        pane.add(deleteItemButton, 3, 0);

        //Create show items button event handler object
        ShowItemsButtonController showItemsButtonCNTR = new ShowItemsButtonController(pane);
        showItemsButton.setOnAction(showItemsButtonCNTR);

        //Create show items button event handler object
        AddItemButtonController addItemButtonCNTR = new AddItemButtonController(pane);
        addItemButton.setOnAction(addItemButtonCNTR);

        //Create delete item button event handler object
        DeleteItemButtonController deleteItemButtonCNTR = new DeleteItemButtonController(pane);
        deleteItemButton.setOnAction(deleteItemButtonCNTR);

        //Pressing this button takes you to a second window
        createListButton.setOnAction
        (e ->
            {
                start2(stage);
            }
        );

        stage.setScene(scene);
        stage.setTitle("Main Window");
        stage.show();
    }



    //----------------------------------------------------------------------


    //Second scene in the same window/ create post window 
    public void start2(Stage stage)
    {
        //Pane width and height
        final int PANE_WIDTH = 400;
        final int PANE_HEIGHT = 300;

        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, PANE_WIDTH, PANE_HEIGHT);

        //Create array list
        HashMap<String, Item> items = new HashMap<>();

        //Create buttons
        Button homeButton = new Button("Home"); 
        Button submitButton    = new Button("Submit");

        //Create Labels
        Label nameLabel = new Label("Name");
        Label priceLabel = new Label("Price");
        Label commentLabel = new Label("Comment");

        //Create text fields
        TextField nameTextField= new TextField("Name");
        TextField priceTextField= new TextField("Price");
        TextField commentTextField= new TextField("Type comment here");

        //Position stuff on the pane
        pane.add(homeButton, 0, 0);
        pane.add(submitButton, 3, 5);

        pane.add(nameLabel, 1, 1);
        pane.add(priceLabel, 1, 3);
        pane.add(commentLabel, 1, 5);

        pane.add(nameTextField, 2, 1);
        pane.add(priceTextField, 2, 3);
        pane.add(commentTextField, 2, 5);

        //Create submit button event handler object
        submitButtonController submitButtonCNTR = new submitButtonController(
            items, nameTextField, priceTextField, commentTextField);
        submitButton.setOnAction(submitButtonCNTR);

        
        //Clicking this button takes you back to the first window
        homeButton.setOnAction
        (e ->
            {
                start(stage);
            }
        );

        stage.setScene(scene);
        stage.setTitle("Create Post");
        stage.show();
    }


    //--------------------------------------------------------------------

    public static void main (String[] args) 
    {
        launch();
    }
}
