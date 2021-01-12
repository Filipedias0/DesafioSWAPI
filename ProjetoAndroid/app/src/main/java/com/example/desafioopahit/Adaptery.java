package com.example.desafioopahit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafioopahit.model.SearchPerson;
import com.example.desafioopahit.model.SearchSpecies;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private Context mContext;
    private List<SearchPerson> personsList;

    public Adaptery(Context mContext, List<SearchPerson> persons) {
        this.mContext = mContext;
        this.personsList = persons;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.person_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(personsList.get(position).getName());
        String[] speciesUrl = personsList.get(position).getSpecies();

        if (speciesUrl.length == 0){
            holder.specie.setText("Human"+"\n");
        }else {
            for (String specie : speciesUrl) {

                holder.specie.append(specie + "\n");
            }
        }

    }

    @Override
    public int getItemCount() {
        return personsList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView specie;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView2);
            specie = itemView.findViewById(R.id.textView4);
        }
    }
}
