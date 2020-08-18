package com.android.fragmentjetpacknavigation;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
   NavController navController;
    BottomNavigationView bottomNavigationView;
    MenuItem menuItem;
    private boolean backPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        bottomNavigationView = findViewById( R.id.bottom_navigation_view );
        bottomNavigationView.setItemIconTintList( null );
        bottomNavigationView.setOnNavigationItemSelectedListener( this );

        navController = Navigation.findNavController(this, R.id.nav_host_container);
        NavigationUI.setupActionBarWithNavController(this, navController);

     /*   navController.addOnDestinationChangedListener( new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

                Log.e("destination id" ,navController.getCurrentDestination().getId()+"");


                //bottomNavigationView.setSelectedItemId(destination.getId());

                // Here want to change selected tab active right now its not showing active when backpress but fragment is change tab not showing active here

            }


        } );
*/
    }

    public void setUpNavigation() {

     /*   NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById( R.id.frame_container );
    //    NavigationUI.setupWithNavController( bottomNavigationView, navHostFragment.getNavController() );*/


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        menuItem=item;


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

        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (navController.getGraph().getStartDestination() == navController.getCurrentDestination().getId())
        {
            if (backPressedOnce)
            {
                super.onBackPressed();
                return;
            }

            backPressedOnce = true;
            Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    backPressedOnce = false;  // setting isBackActivated after 2 second
                }
            }, 2000);


        }else
        {
            super.onBackPressed();
          //  Toast.makeText( getApplicationContext(),"handle to preivous tab how ??",Toast.LENGTH_SHORT ).show();

        }


    }

}