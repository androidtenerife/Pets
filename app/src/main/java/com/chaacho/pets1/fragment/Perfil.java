package com.chaacho.pets1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.chaacho.pets1.R;
import com.chaacho.pets1.adapter.Adaptador;
import com.chaacho.pets1.poyo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {
    Mascota mmascotas;
    ArrayList<Mascota> mascotas;
    protected GridLayout listamascotas;

    public Perfil() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listamascotas = (GridLayout) v.findViewById(R.id.misMascotas);
        GridLayout llm = new GridLayout(getActivity());
        llm.setOrientation(GridLayout.HORIZONTAL);
        listamascotas.getColumnCount();
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
        //listamascotas.setAdapter(ad);
    }

}
