package com.example.elvis.elvisafrifapset8;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = getSupportFragmentManager();
        CategoriesFragment fragment = new CategoriesFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment, "categories");
        ft.commit();
    }

//    public void openCategory() {
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "https://resto.mprog.nl/categories";
//
//        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    public JSONArray Jarray;
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try(
//                                JSONObject obj = new JSONObject(response.toString());
//                                Jarray = obj.getJSONArray("categories");
//                        }catch (JSONException e) {
//                            throw new RuntimeException(e);
//                        }
//                        JSONArray ArrayJ = (JSONArray)Jarray;
//                        if (ArrayJ != null) {
//                            itemlist = new String(ArrayJ.length());
//                            for (int i=0;i<ArrayJ.length();i++) {
//                                try (
//                                        itemlist[i]=(ArrayJ.getString(i));
//                                } catch (JSONException e){
//                                    throw new RuntimeException(e);
//                                }3
//                            }
//                    }
//                }
//    }
}
