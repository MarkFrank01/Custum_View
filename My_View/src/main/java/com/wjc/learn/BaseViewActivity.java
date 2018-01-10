package com.wjc.learn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.wjc.learn.data.MorePages;
import com.wjc.learn.fragment.BaseViewFragment;
import com.wjc.learn.fragment.BaseViewFragment2;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.draw_view.draw_1
 * File_NAME : BaseViewActivity
 * Created by WJC on 2017/11/7 16:15
 * Describe : TODO
 */

public class BaseViewActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;

    private BaseViewFragment baseViewFragment;
    private BaseViewFragment2 baseViewFragment2;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, BaseViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_view);

        Log.e("AAAAA", MorePages.draw_basal().size()+"XXXX");

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle(R.string.my_view);
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        // Set up the navigation drawer.
        mDrawerLayout =  findViewById(R.id.drawer_layout);
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        navigationView =  findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        if (savedInstanceState != null) {
            baseViewFragment = (BaseViewFragment) getSupportFragmentManager().getFragment(savedInstanceState, "baseViewFragment");
            baseViewFragment2 = (BaseViewFragment2) getSupportFragmentManager().getFragment(savedInstanceState, "baseViewFragment2");

        } else {
            baseViewFragment = (BaseViewFragment) getSupportFragmentManager().findFragmentById(R.id.content_main);
            if (savedInstanceState == null) {
                baseViewFragment = BaseViewFragment.newInstance2(MorePages.draw_basal());
            }

            baseViewFragment2 = (BaseViewFragment2) getSupportFragmentManager().findFragmentById(R.id.content_main);
            if (savedInstanceState == null) {
                baseViewFragment2 = BaseViewFragment2.newInstance2(MorePages.draw_myself());
            }
        }


        showBaseViewFragment();

    }

    /**
     * Close the drawer when a back click is called.
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Open the navigation drawer when the home icon is selected from the toolbar.
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.back_to_home:

                        Toast.makeText(BaseViewActivity.this, "emmmmmm", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.to_page_one:
                        showBaseViewFragment();
                        break;
                    case R.id.to_page_two:
                        showBaseViewFragment2();
                        break;
                    default:
                        break;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void showBaseViewFragment() {

        if (!baseViewFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_main, baseViewFragment, "baseViewFragment")
                    .commit();
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(baseViewFragment);
        fragmentTransaction.hide(baseViewFragment2);
        fragmentTransaction.commit();

        navigationView.setCheckedItem(R.id.to_page_one);
    }

    private void showBaseViewFragment2() {

        if (!baseViewFragment2.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_main, baseViewFragment2, "baseViewFragment2")
                    .commit();
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(baseViewFragment2);
        fragmentTransaction.hide(baseViewFragment);
        fragmentTransaction.commit();

        navigationView.setCheckedItem(R.id.to_page_two);
    }
}
