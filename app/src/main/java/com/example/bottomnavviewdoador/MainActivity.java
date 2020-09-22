package com.example.bottomnavviewdoador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conatiner, new NewDoacoes()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectFragment = null;
            switch (menuItem.getItemId()){
                case R.id.nav_add:
                selectFragment = new NewDoacoes();
                break;
                case R.id.nav_campanha:
                    selectFragment = new DoacoesCampanhas();
                    break;
                case R.id.nav_doacao:
                    selectFragment = new DoacoesUnicas();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_conatiner,selectFragment).commit();

            return true;
        }
    };

}

