package com.chaacho.pets1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.chaacho.pets1.adapter.PageAdapter;
import com.chaacho.pets1.fragment.Perfil;
import com.chaacho.pets1.fragment.RecyclerViewFragment;
import com.chaacho.pets1.poyo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Mascota mmascotas;
    ArrayList <Mascota>mascotas;
    Activity activity;
    private RecyclerView listamascotas;
    private TabLayout tabLayout;
    private Toolbar toolbar, miapbar;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Defino la tolbar
        miapbar = (Toolbar) findViewById(R.id.miApbar);
        setSupportActionBar(miapbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();


        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }
// Activo el menu de opciones.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuoption, menu);
        return true;
    }
    // Activo las pulsaciones del menú.


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menuContacto:
                Intent intentContact = new Intent( this, Contacto.class);
                startActivity(intentContact);
                break;
            case R.id.menuAbout:
                Intent intentAb = new Intent( this, About.class );
                startActivity(intentAb);
                break;

        }

        return super.onOptionsItemSelected(item);
    }


    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Perfil());
        fragments.add(new RecyclerViewFragment());

        return fragments;
    }

    private void setUpViewPager() {
        // Pasamotodo incluso la lista de fragments
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        // hay que agregar al tablayout
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(1).setIcon(R.drawable.doghouse);
        tabLayout.getTabAt(0).setIcon(R.drawable.dog);


    }


    public void goDetalle(View view){
        ImageView iv = (ImageView) findViewById(R.id.cvImgFoto);
        int var = iv.getId();

        Intent intent=new Intent(this, About.class);
        intent.putExtra("Nombre", mmascotas.getNombre());
        intent.putExtra("Foto", mmascotas.getFoto());
        intent.putExtra("Rating", String.valueOf(mmascotas.getRating()));
        startActivity(intent);



    }



    public void iniciarLike(){
        Intent in = new Intent(this,Activity2.class);
        startActivity(in);
    }
}
