package com.crisspian.fragment_guide_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean isFragmentShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFragmentShow) {
                    showFragment();
                } else {
                    closeFragment();
                }

            }
        });

    }

    private void showFragment() {
        // Generamos la instancia del fragmento gracias al factory method
        FirstFragment firstFragment = FirstFragment.newInstance("","");
        //Obtener instancia del FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //Obtenemos e instanciamos una transacción
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // añadir el fragmento y lo asociamos al contenedor donde se mostrara
        fragmentTransaction.add(R.id.content_fragment, firstFragment)
                //.addToBackStack(null)
                .commit();
        isFragmentShow = true;
    }

    private void closeFragment() {
        //Obtener instancia del FragmentManager
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FirstFragment mFirstFragment = (FirstFragment) mFragmentManager
                .findFragmentById(R.id.content_fragment);
        if (mFirstFragment != null) {
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.remove(mFirstFragment).commit();
            isFragmentShow = false;
        }
    }


}