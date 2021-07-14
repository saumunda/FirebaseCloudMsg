package com.leosword.saurabh.msons;


import android.app.Notification;
import android.content.Intent;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;


import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

   displaySelectedScreen(R.id.home_msons);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            exit(0);

        }
        if (id == R.id.help) {
            Intent localIntent2 = new Intent(this, HelpCenter.class);
            localIntent2.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(localIntent2);

        }

        return super.onOptionsItemSelected(item);
    }
    private boolean displaySelectedScreen(int itemId){
        //creating fragment object
        Fragment fragment = null;


        NavigationView nv= (NavigationView) findViewById(R.id.nav_view);
        Menu m=nv.getMenu();

        switch (itemId) {
            case R.id.home_msons:
                fragment = new HOME();
                break;
            case R.id.profile:
                fragment = new Profile();
             //   Intent localIntent1 = new Intent(this, Profile.class);
             //   localIntent1.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
              //  startActivity(localIntent1);
                break;
            case R.id.help:
                Intent localIntent2 = new Intent(this, HelpCenter.class);
                localIntent2.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(localIntent2);
                break;






            case R.id.contact_us:
                fragment = new ContactUs();
                break;
            }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.screen_area, fragment);
            ft.commit();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
      return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }
}