package Adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewactivity.DetaildActivity;
import com.example.recycleviewactivity.R;

import java.util.List;

import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<ListItem> listitem;

    public  MyAdapter(Context context, List listitem){
        this.context=context;
        this.listitem=listitem;


    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {

        ListItem item = listitem.get(position);


        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());

    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView name;
        public TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            name=itemView.findViewById(R.id.title);
            description=itemView.findViewById(R.id.description);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            ListItem item = listitem.get(position);

            Intent intent = new Intent(context, DetaildActivity.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("description", item.getDescription());

            context.startActivity(intent);



            //Toast.makeText(context, item.getName(), Toast.LENGTH_LONG).show();

        }
    }
}
