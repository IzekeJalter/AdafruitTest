package com.isaac012.adafruittest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.isaac012.adafruittest.singleton.SingletonRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.apagado).setOnClickListener(this);
        findViewById(R.id.encendido).setOnClickListener(this);
        findViewById(R.id.informacion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                irRecycle();
            }
        });
    }

    @Override
    public void onClick(View view) {
        String URL = "https://io.adafruit.com/api/v2/Victor_Almanza/feeds/finalproyect.controlled/data";
        String v = "0";
        JSONObject jsonObject = new JSONObject();

        switch (view.getId()){
            case R.id.apagado:
                v = "0";
                break;
            case R.id.encendido:
                v = "1";
                break;
        }

        try {
            jsonObject.put("value", v);

        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(MainActivity.this, "Hecho", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Hubo algun problema", Toast.LENGTH_SHORT).show();
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

    }

    public void irRecycle(){
        Intent i = new Intent(getApplicationContext(), GetInfo.class);
        startActivity(i);
    }

}