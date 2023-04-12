package veikko.vanninen.grocerylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddGroceryToListActivity extends AppCompatActivity {

    private EditText txtGrocery;
    private EditText txtNote;
    private String grocery;
    private String note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery_to_list);

        txtGrocery = findViewById(R.id.ptGroceryName);
        txtNote = findViewById(R.id.ptGroceryNote);
    }

    public void addGroceryToList (View view) {
        grocery = txtGrocery.getText().toString();
        note = txtNote.getText().toString();

        Grocery newGrocery = new Grocery(grocery, note);
        GroceryStorage.getInstance().addGrocery(newGrocery);
    }
}