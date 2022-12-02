package com.isaac012.adafruittest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.isaac012.adafruittest.models.Feed;
import com.isaac012.adafruittest.models.InfoList;
import com.isaac012.adafruittest.recyclerview.InfoAdapter;
import com.isaac012.adafruittest.singleton.SingletonRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetInfo extends AppCompatActivity {
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_info);
        Toast.makeText(this, "eyeyeyey", Toast.LENGTH_SHORT).show();
        requestQueue = Volley.newRequestQueue(this);
        solicitud();
    }

    public void solicitud(){
        String URL = "http://io.adafruit.com/api/v2/Victor_Almanza/groups/finalproyect";
        final androidx.recyclerview.widget.RecyclerView rvFeedList = findViewById(R.id.rvFeedList);
        Toast.makeText(this, "Entra aqui", Toast.LENGTH_SHORT).show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(GetInfo.this, "jojojoj", Toast.LENGTH_SHORT).show();
                try {
                    Toast.makeText(GetInfo.this, "Hola por favor funciona", Toast.LENGTH_SHORT).show();
                    Gson gson = new Gson();
                    InfoList respuestaFeeds = gson.fromJson(response.toString(), InfoList.class);
                    List<Feed> feeds = respuestaFeeds.getFeeds();
                    Log.i("El resultado de tu busqueda es: ", feeds.get(0).getName());

                    InfoAdapter adapter = new InfoAdapter(feeds, GetInfo.this);

                    rvFeedList.setAdapter(adapter);
                    rvFeedList.setHasFixedSize(true);

                    androidx.recyclerview.widget.RecyclerView.LayoutManager manager = new LinearLayoutManager(GetInfo.this);
                    rvFeedList.setLayoutManager(manager);

                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                    Toast.makeText(GetInfo.this, "No entro papu", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("X-AIO-Key", "aio_cpfB39oug72DzCwBeuverTwFw4cu");
                return headers;
            }
        };

        SingletonRequest.getInstance(this).addToRequestQue(jsonObjectRequest);
        //requestQueue.add(jsonObjectRequest);
    }
}