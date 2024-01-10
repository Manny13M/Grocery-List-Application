import javafx.scene.control.Label;
import java.util.HashMap;
import javafx.scene.layout.GridPane;

public class displayItemsOnPane 
{
    GridPane pane;
    HashMap<String, Item> items;

    displayItemsOnPane(GridPane pane, HashMap<String, Item> items)
    {
        this.pane = pane;
        this.items = items;
    }

    public void displayItems()
    {
        
        /* This loop iterates through every activity in the activities list, creates
         * labels with that activity information, then displays them on the grid.
         */

        int rowIndex = 1;
        for(String name: items.keySet())
        {
            //Create labels
            Label nameLabel     = new Label();
            Label priceLabel    = new Label();
            Label commentLabel  = new Label();

            //Give labels values
            nameLabel.setText       (items.get(name).name);
            priceLabel.setText      (items.get(name).price + "");
            commentLabel.setText    (items.get(name).comment + "");

            //This loop is used to determine the column index
            for(int columnIndex = 0; columnIndex < 3; columnIndex++)
            {
                pane.add(nameLabel, columnIndex, rowIndex);
                columnIndex++;

                pane.add(priceLabel, columnIndex, rowIndex);
                columnIndex++;

                pane.add(commentLabel, columnIndex, rowIndex);
            }

            rowIndex++;
        }
    } 


}
