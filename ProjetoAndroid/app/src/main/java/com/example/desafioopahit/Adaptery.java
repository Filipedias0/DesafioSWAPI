package com.example.desafioopahit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.desafioopahit.model.SearchPerson;

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
        holder.hair_color.setText("Hair color: "+ personsList.get(position).getHair_color());
        holder.skin_color.setText("Skin color: "+ personsList.get(position).getSkin_color());



        String[] speciesUrl = personsList.get(position).getSpecies();

        String url;
        if (speciesUrl.length == 0){
            holder.specie.setText("Jedi");
        }else {
            for (String specie : speciesUrl) {

                holder.specie.append(specie);
                 url = specie;

                 //holder.specie.append(url.substring(29,30));

            }

            //http://swapi.dev/api/species/*28*2*29*/

        }

    }

    @Override
    public int getItemCount() {
        return personsList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView specie;
        TextView hair_color;
        TextView skin_color;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textViewName);
            specie = itemView.findViewById(R.id.textViewSpecie);
            hair_color = itemView.findViewById(R.id.textViewHairColor);
            skin_color = itemView.findViewById(R.id.textViewEyeColor);

        }
    }
}
