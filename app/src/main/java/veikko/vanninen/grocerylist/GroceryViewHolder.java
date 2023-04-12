package veikko.vanninen.grocerylist;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryViewHolder extends RecyclerView.ViewHolder {
    TextView holderGrocery;
    TextView holderNote;
    ImageView editImage;
    ImageView removeImage;
    EditText editGrocery;

    public GroceryViewHolder(@NonNull View itemView) {
        super(itemView);

        holderGrocery = itemView.findViewById(R.id.txtViewGrocery);
        holderNote = itemView.findViewById(R.id.txtViewNote);
        editGrocery = itemView.findViewById(R.id.editGroceryName);
        editImage = itemView.findViewById(R.id.imgViewEdit);
        removeImage = itemView.findViewById(R.id.imgViewDelete);
    }

}
