package veikko.vanninen.grocerylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private GroceryStorage groceryStorage;
    private RecyclerView recyclerView;
    private ImageView sortListByAlphabets;
    private ImageView sortListByCreationTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groceryStorage = GroceryStorage.getInstance();
        recyclerView = findViewById(R.id.rvGroceryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GroceryListAdapter(getApplicationContext(), groceryStorage.getGroceries()));
        sortListByAlphabets = findViewById(R.id.imgViewSortByAlphabet);
        sortListByCreationTime = findViewById(R.id.imgViewSortByDate);

        sortListByAlphabets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(groceryStorage.getGroceries(), new Comparator<Grocery>() {
                    @Override
                    public int compare(Grocery grocery1, Grocery grocery2) {
                        return grocery1.getName().compareToIgnoreCase(grocery2.getName());
                    }
                });
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        sortListByCreationTime.setOnClickListener(view -> {
            Collections.sort(groceryStorage.getGroceries(), new Comparator<Grocery>() {
                @Override
                public int compare(Grocery grocery1, Grocery grocery2) {
                    return Long.compare(grocery1.getCreation(), grocery2.getCreation());
                }
            });
            recyclerView.getAdapter().notifyDataSetChanged();
        });
    }

    public void switchToActivityAddGroceryToList (View view) {
        Intent intent = new Intent(this, AddGroceryToListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}