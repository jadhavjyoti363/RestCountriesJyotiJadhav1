package com.example.restcountries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.restcountries.Adapter.CustomRecyclerAdapter;
import com.example.restcountries.ModelClass.RestCountries;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.motion.widget.MotionScene.TAG;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

   List<RestCountries> restCountriesList;

    RequestQueue rq;

    String request_url ="https://restcountries.eu/rest/v2/alpha/col";
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rq = Volley.newRequestQueue(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycleViewContainer);
        button =(Button)findViewById(R.id.btn);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        restCountriesList = new ArrayList<>();

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
            }
        });


//        sendRequest();
        
    }





    private void sendRequest() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                request_url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObject1 = new JSONObject(response.toString());

                            jsonObject1.getString("name");
                            Log.d("jobject","res::"+ jsonObject1.getString("name"));

                            Log.d("jobject","res::"+ jsonObject1.getString("region"));

                            RestCountries restCountries= new RestCountries();

                            restCountries.setName(jsonObject1.getString("name"));
                           restCountries.setRegion(jsonObject1.getString("region"));
                            restCountries.setBorders(jsonObject1.getString("borders"));
                            restCountries.setCapital(jsonObject1.getString("capital"));
                            restCountries.setPopulation(jsonObject1.getString("population"));
                            restCountries.setSubregion(jsonObject1.getString("subregion"));
                            restCountries.setLanguage(jsonObject1.getString("language"));

                            restCountriesList.add(restCountries);


//                            Groceries groceries1 = new Groceries();
//                            groceries1.setName(jsonObject1.getString("name"));
//                            groceries1.setFinalPrice(jsonObject1.getString("capital"));
//
//                            groceriesList.add(groceries1);
//                        groceries1.setFinalPrice(jsonObject.getString("final_price"));



//
//                            JSONArray jsonArray = jsonObject1.getJSONArray("altSpellings");
//
//                             // Log.d("JsonArray::", "onResponse: "+jsonArray);
//
//                           //JSONArray jsonArray = jsonObject1.getJSONArray("name");
////                            Log.d("Json response", "onResponse: "+jsonObject1.toString());
//
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                                Log.d("jsonObject::", "onResponse: "+jsonObject);
//
//                                //Here you will get your result so can use textview
//                                //to populate the result
//                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        mAdapter = new CustomRecyclerAdapter(MainActivity.this, restCountriesList);

                        recyclerView.setAdapter(mAdapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: "+error);
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);


    }
}
