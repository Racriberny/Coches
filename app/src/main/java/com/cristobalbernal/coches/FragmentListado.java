package com.cristobalbernal.coches;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentListado extends Fragment {
    private Coche[] coches;
    private IOnClickListener listener;
    public interface IOnAttachListerner{
        Coche[] getCochess();
    }

    public FragmentListado(){
        super(R.layout.fragment_listado);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AdaptadorCoches adaptadorCoches = new AdaptadorCoches(coches,listener);
        RecyclerView recyclerView = view.findViewById(R.id.rcListado);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptadorCoches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IOnClickListener) context;
        IOnAttachListerner attachLister = (IOnAttachListerner) context;
        coches = attachLister.getCochess();
    }
}
