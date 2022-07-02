package CLASSES;

import java.util.ArrayList;

public class Cart {
    private int cartquantity;
    private boolean cartlimit;
    private double total;
    private ArrayList<Books> arr;


    public Cart(int cartquantity, ArrayList<Books> arr) {
        this.cartquantity = cartquantity;
        this.arr = arr;
    }

    public double calctotal ()
    {
       for (int i = 0 ; i < arr.size() ; i++)
       {
           total += arr.get(i).getPrice();
       }
       return total;
    }
    public double calctotal (int cartquantity)
    {
        for (int i = 0 ; i < arr.size() ; i++)
        {
            total += arr.get(i).getPrice();
        }
        if (cartquantity > 3) total += total * 0.9 ;
        return total;
    }
    public void addBook(Books book)
    {
        arr.add(book);
    }
    public void getquantity()
    {
        cartquantity = arr.size();
    }
    public void removeBook(Books book)
    {
        arr.remove(book);
    }
    public void clearcart()
    {
        arr.clear();
    }

}
