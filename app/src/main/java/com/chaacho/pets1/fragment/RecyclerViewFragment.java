package com.chaacho.pets1.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chaacho.pets1.R;
import com.chaacho.pets1.adapter.Adaptador;
import com.chaacho.pets1.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by Daniel on 29/11/2016.
 */

public class RecyclerViewFragment extends Fragment {
    Mascota mmascotas;
    ArrayList<Mascota> mascotas;
    private RecyclerView listamascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

// Colocar el recyclerVier
        listamascotas = (RecyclerView) v.findViewById(R.id.rvMascota);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.dog1, "Ja", "5"));
        mascotas.add(new Mascota(R.drawable.dog2, "Anil", "4"));
        mascotas.add(new Mascota(R.drawable.dog3, "Poto", "3"));
        mascotas.add(new Mascota(R.drawable.dog4, "Pupu", "2"));
        mascotas.add(new Mascota(R.drawable.dog5, "Pupa", "1"));

    }

    public void inicializarAdaptador() {
        Adaptador ad = new Adaptador(mascotas, getActivity());
        listamascotas.setAdapter(ad);
    }
}
