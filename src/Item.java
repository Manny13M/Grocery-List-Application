public class Item implements java.io.Serializable
{
    String name;
    String comment;
    double price;


    public Item(String name, double price, String comment)
    {
        this.name = name;
        this.price = price;
        this.comment = comment;
    }
}
