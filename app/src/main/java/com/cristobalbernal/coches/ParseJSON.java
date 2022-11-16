package com.cristobalbernal.coches;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class ParseJSON {
    private Coche[] coches;
    private InputStream selecionarJson;

    public ParseJSON(Context context){
        selecionarJson = context.getResources().openRawResource(R.raw.coches);
    }

    public boolean parsed(){
        boolean parsed = false;
        coches = null;
        String json;

        try {
            int size = selecionarJson.available();
            byte[] buffer = new byte[size];
            selecionarJson.read(buffer);
            selecionarJson.close();
            json = new String(buffer,"UTF-8");
            JSONTokener tokener = new JSONTokener(json);
            JSONArray array = new JSONArray(tokener);
            coches = new Coche[array.length()];
            for (int i = 0; i <array.length() ; i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                int ruedas  = jsonObject.getInt("ruedas");
                String mmodelo  = jsonObject.getString("modelo");
                String color  = jsonObject.getString("color");
                String marca  = jsonObject.getString("marca");
                coches[i] = new Coche(marca,mmodelo,color,ruedas);
            }
            parsed = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsed;
    }

    public Coche[] getCoches() {
        return coches;
    }
}
