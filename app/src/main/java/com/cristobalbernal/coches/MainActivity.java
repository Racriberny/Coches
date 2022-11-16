package com.cristobalbernal.coches;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements FragmentDetalle.IOnAttachListener,FragmentListado.IOnAttachListerner,IOnClickListener {
    private static final String COCHE_KEY = "coche";
    private static final String SELECTED_KEY = "selected";
    private Coche[] coches;
    private Coche selectecCoche;
    private FragmentDetalle fragmentDetalle;
    private boolean tablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState !=null){
           coches = (Coche[]) savedInstanceState.getSerializable(COCHE_KEY);
           selectecCoche = (Coche) savedInstanceState.getSerializable(SELECTED_KEY);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablet = findViewById(R.id.FrgDetalle) !=null;
        if (tablet){
            FragmentManager manager = getSupportFragmentManager();
            fragmentDetalle = (FragmentDetalle) manager.findFragmentById(R.id.FrgDetalle);
        }
    }

    public void loadData(){
        ParseJSON parseJSON = new ParseJSON(this);
        if (parseJSON.parsed()){
            coches = parseJSON.getCoches();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(COCHE_KEY,coches);
        outState.putSerializable(SELECTED_KEY,selectecCoche);
        super.onSaveInstanceState(outState);
    }

    @Override
    public Coche getCoche() {
        if (coches == null){
            loadData();
        }
        if (selectecCoche == null){
            loadData();
        }
        Coche coche = selectecCoche;
        setTitle(coche.getMarca());
        return coche;
    }

    @Override
    public Coche[] getCochess() {
        if (coches== null){
            loadData();
        }
        return coches;
    }

    @Override
    public void IOnClick(int posicion) {
        selectecCoche = coches[posicion];
        if (tablet){
            fragmentDetalle.mostrarDetalle(selectecCoche);
        }else {
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .replace(R.id.FrgListado,FragmentDetalle.class,null)
                    .commit();
        }
    }
}