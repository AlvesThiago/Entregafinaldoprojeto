package com.projeto.shopshoes.view.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.projeto.shopshoes.R;
import com.projeto.shopshoes.view.fragments.HomeFragment;
import com.projeto.shopshoes.view.fragments.SneakersFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    // Hello
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment;
        fragment = new HomeFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_content, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        if (id == R.id.nav_pessoas) {
            fragment = new SneakersFragment();
        } else if (id == R.id.nav_home) {
            fragment = new HomeFragment();
        } else if (id == R.id.nav_sobre) {
            AlertDialog.Builder caixaDeDialogo = new AlertDialog.Builder(this);
            caixaDeDialogo.setTitle("Sobre");
            caixaDeDialogo.setMessage("O New Shoes ?? um aplicativo que tem como objetivo simular a vendas de t??nis e sapatos.\n\n" +
                    "Alunos:\nThiago Alves\n" +
                    "Paulo Gabriel Marques da Cunha de Souza\n" +
                    "Eduardo Almeida Viana\n" +
                    "Renan Isikawa Pinto da Silva\n" +
                    "Gabriel de Paula Jesus \n\n" +
                    "Institui????o: FMU \n\n" +
                    "Curso:\nSISTEMAS DA INFORMA????O \nCIENCIAS DA COMPUTA????O\n\n" +
                    "Professor: EUGENIO AKIHIRO NASSU \n\n" +
                    "Disciplina: COMPUTACAO PARA DISPOSITIVOS MOVEIS \n\n");
            // Adicona um bot??o FECHAR
            caixaDeDialogo.setNeutralButton("Fechar", null);
            caixaDeDialogo.create().show();

        } else if (id == R.id.nav_sair) {
            finish();

        }

        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
