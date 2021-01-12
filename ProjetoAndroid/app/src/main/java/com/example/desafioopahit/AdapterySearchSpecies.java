package com.example.desafioopahit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafioopahit.model.SearchSpecies;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterySearchSpecies extends RecyclerView.Adapter<AdapterySearchSpecies.MyViewHolder> {

    private Context mContext;
    private List<SearchSpecies> speciesList;


    public AdapterySearchSpecies(Context mContext, List<SearchSpecies> speciesList) {
        this.mContext = mContext;
        this.speciesList = speciesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.specie_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.name.setText(speciesList.get(position).getName());
        String[] peopleUrl = speciesList.get(position).getPeople();

            for (String person : peopleUrl) {
                holder.people.append(person + "\n");
            }
    }

    @Override
    public int getItemCount() {
        return speciesList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView people;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView5);
            people = itemView.findViewById(R.id.textView6);
        }
    }
}
