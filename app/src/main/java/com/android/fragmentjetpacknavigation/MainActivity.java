package com.android.fragmentjetpacknavigation;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    NavController navController;
    BottomNavigationView bottomNavigationView;
    MenuItem menuItem;
    AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        init();

        NavigationUI.setupWithNavController( bottomNavigationView, navController );
        NavigationUI.setupActionBarWithNavController( this, navController, appBarConfiguration );

    }

    private void init() {
        bottomNavigationView = findViewById( R.id.bottom_navigation_view );
        bottomNavigationView.setItemIconTintList( null );
        bottomNavigationView.setOnNavigationItemSelectedListener( this );
        navController = Navigation.findNavController( this, R.id.nav_host_container );
        appBarConfiguration = new AppBarConfiguration.Builder( new int[]{R.id.categoryFragment, R.id.favouriteFragment, R.id.myPostFragment, R.id.settingFragment} )
                .build();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        menuItem = item;


        switch (item.getItemId()) {
            case R.id.categoryFragment:

                Toast.makeText( getApplicationContext(), "Click category", Toast.LENGTH_SHORT ).show();

                break;

            case R.id.favouriteFragment:

                Toast.makeText( getApplicationContext(), "Click favouriteFragment", Toast.LENGTH_SHORT ).show();

                break;

            case R.id.myPostFragment:
                Toast.makeText( getApplicationContext(), "Click myPostFragment", Toast.LENGTH_SHORT ).show();


                break;

            case R.id.settingFragment:

                Toast.makeText( getApplicationContext(), "Click settingFragment", Toast.LENGTH_SHORT ).show();

                break;
        }

        return NavigationUI.onNavDestinationSelected( item, navController )
                || super.onOptionsItemSelected( item );
    }


    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp( navController, appBarConfiguration );
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }

}