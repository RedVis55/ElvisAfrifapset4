package com.example.elvis.elvisafrifapset8;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends android.support.v4.app.ListFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String url ="https://resto.mprog.nl/categories";
        ArrayList<String> myArray = new ArrayList<>() ;
        RequestQueue queue = Volley.newRequestQueue(getActivity());

        JsonObjectRequest jsonobject = new JsonObjectRequest(Request.Method.GET, url,null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ArrayList<String> newArray = new ArrayList<>();
                        JSONArray jarray;

                        try {
                            jarray = response.getJSONArray("categories");
                            for (int i = 0; i < jarray.length(); i++) {
                                newArray.add(jarray.getString(i));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        setAdapter(newArray);

                    }
                }

                , null);
        queue.add(jsonobject);
    }

    private void setAdapter( ArrayList<String> arry){
        ArrayAdapter<String> myAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arry);

        this.setListAdapter(myAdapter);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

}
