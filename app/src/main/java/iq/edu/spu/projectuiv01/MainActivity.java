package iq.edu.spu.projectuiv01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private SearchView mainSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        //setting the action bar we created
        Toolbar mToolbar = findViewById(R.id.main_toolbar);;
        setSupportActionBar(mToolbar);

        //connecting drawerLayout with the toolbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_main,new ServicesFragment()).commit();

        mNavigationView.setNavigationItemSelectedListener(this);
        mNavigationView.setCheckedItem(R.id.navigation_services);

    }



     /*
     close the navigation drawer if it open when pressing the back
     button else call the parent function
     */
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent navigationIntent;
        switch (item.getItemId()){
            case R.id.navigation_services:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_main,new ServicesFragment()).commit();
                break;
            case R.id.navigation_tasks:
                navigationIntent = new Intent(this, TasksActivity.class);
                startActivity(navigationIntent);
                break;
            case R.id.navigation_account:
                navigationIntent = new Intent(this, AccountActivity.class);
                startActivity(navigationIntent);
                break;
            case R.id.action_logout:
                break;
        }
//        mainSearchView = findViewById(R.id.search_view_bar_main);
//        if(item.getItemId() == R.id.navigation_services){
//            mainSearchView.setVisibility(View.VISIBLE);
//        }else{
//            mainSearchView.setVisibility(View.GONE);
//        }
        this.setTitle("");
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //initializing all the view
    private void initViews(){
        mDrawerLayout = findViewById(R.id.drawer_layout_main);
        mNavigationView = findViewById(R.id.navigation_drawer_main);

    }
}