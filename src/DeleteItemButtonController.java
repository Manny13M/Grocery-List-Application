import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;



public class DeleteItemButtonController implements EventHandler<ActionEvent>
{
    GridPane pane;

    DeleteItemButtonController(GridPane pane)
    {
        this.pane = pane;
    }

    //Action event handler method
    public void handle(ActionEvent event) 
    {
        createTextField();  
    }

    public void createTextField()
    {
        TextField nameTextField = new TextField();
        Button confirmDeleteButton = new Button("Confirm");

        pane.add(nameTextField, 4, 0);
        pane.add(confirmDeleteButton, 5, 0);

        //Create add button event handler object
        ConfirmDeleteItemController confirmDeleteButtonCNTR = new ConfirmDeleteItemController(pane, nameTextField);
        confirmDeleteButton.setOnAction(confirmDeleteButtonCNTR); 
    } 
}
