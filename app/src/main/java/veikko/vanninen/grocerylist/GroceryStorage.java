package veikko.vanninen.grocerylist;

import java.util.ArrayList;

public class GroceryStorage {
    ArrayList<Grocery> groceries = new ArrayList<>();

    private static GroceryStorage groceryStorage = null;

    public static GroceryStorage getInstance() {
        if (groceryStorage == null) {
            groceryStorage = new GroceryStorage();
        }
        return groceryStorage;
    }

    public void addGrocery (Grocery grocery) {
        groceries.add(grocery);
    }

    public void removeGrocery (int position) {
        groceries.remove(position);
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public Grocery getGroceryPosition (int position) {
        return groceries.get(position);
    }
}
