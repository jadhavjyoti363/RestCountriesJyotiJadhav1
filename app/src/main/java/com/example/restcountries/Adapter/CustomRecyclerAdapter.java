package com.example.restcountries.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.restcountries.ModelClass.RestCountries;
import com.example.restcountries.R;

import org.json.JSONObject;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerAdapter extends RecyclerView.Adapter <CustomRecyclerAdapter.ViewHolder>{

    private Context context;
    private List<RestCountries> restCountries;

    public CustomRecyclerAdapter(Context context, List<RestCountries> restCountries) {
        this.context = context;
        this.restCountries = restCountries;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewrestcountries, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
     //   return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.itemView.setTag(restCountries.get(position));

        RestCountries rec = restCountries.get(position);


        holder.Name.setText(rec.getName());
        holder.Region.setText(rec.getRegion());
        holder.Borders.setText(rec.getBorders());
        holder.Capital.setText(rec.getCapital());
        holder.Population.setText(rec.getPopulation());
        holder.Subregion.setText(rec.getSubregion());
        holder.Language.setText(rec.getLanguage());


    }

    @Override
    public int getItemCount() {
        
        return restCountries.size();
        //return 0;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView Name;
        public TextView Capital;
        public TextView Flag;
        public TextView Region;
        public TextView  Subregion;
        public TextView Population;
        public TextView Borders;
        public TextView Language;



        public ViewHolder( View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.Nametxt);
            Capital = (TextView) itemView.findViewById(R.id.Capital);
            //Flag = (TextView) itemView.findViewById(R.id.F);
            Region = (TextView) itemView.findViewById(R.id.Region);
            Subregion= (TextView) itemView.findViewById(R.id.Subregion);
            Population = (TextView) itemView.findViewById(R.id.Population);
            Borders = (TextView) itemView.findViewById(R.id.Borders);
            Language= (TextView) itemView.findViewById(R.id.Language);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  RestCountries  rc = (RestCountries) view.getTag();

              //      Toast.makeText(view.getContext(), rc.getName()+" "+cpu.getFinalPrice()+" is "+ cpu.getFinalPrice(), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }
}
