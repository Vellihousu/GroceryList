package veikko.vanninen.grocerylist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryViewHolder>{
    private Context context;
    private ArrayList<Grocery> groceries = new ArrayList<>();

    public GroceryListAdapter (Context context, ArrayList<Grocery> groceries) {
        this.context = context;
        this.groceries = groceries;
    }


    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GroceryViewHolder(LayoutInflater.from(context).inflate(R.layout.grocery_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        holder.holderGrocery.setText(groceries.get(position).getName());
        holder.holderNote.setText(groceries.get(position).getNote());
        holder.editGrocery.setText(groceries.get(position).getName());

        holder.editGrocery.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            if (holder.editGrocery.getVisibility() == View.VISIBLE) {
                Grocery grocery = GroceryStorage.getInstance().getGroceryPosition(pos);
                grocery.setName(holder.editGrocery.getText().toString());
                holder.editGrocery.setVisibility(View.GONE);
                notifyDataSetChanged();
            } else {
                holder.editGrocery.setVisibility(View.VISIBLE);
            }
        });

        holder.removeImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            GroceryStorage.getInstance().removeGrocery(pos);
            notifyItemRemoved(pos);
        });

    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }
}
