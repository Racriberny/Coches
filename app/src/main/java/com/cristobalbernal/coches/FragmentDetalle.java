package com.cristobalbernal.coches;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetalle extends Fragment {
    public interface IOnAttachListener{
        Coche getCoche();
    }
    private Coche coche;
    private TextView marca;
    private TextView modelo;
    private TextView color;
    private TextView ruedas;

    public FragmentDetalle(){
        super(R.layout.fragment_detalle);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        marca = view.findViewById(R.id.tvMarcaDetalle);
        modelo = view.findViewById(R.id.tvModeloDetalle);
        color = view.findViewById(R.id.tvColorDetalle);
        ruedas = view.findViewById(R.id.tvRuedasDetalle);
        if (coche !=null){
            mostrarDetalle(coche);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttachListener attachListener = (IOnAttachListener) context;
        coche = attachListener.getCoche();
    }

    public void mostrarDetalle(Coche coche) {
        marca.setText(coche.getMarca());
        modelo.setText(coche.getModelo());
        color.setText(coche.getColor());
        ruedas.setText(String.valueOf(coche.getRuedas()));
    }
}
