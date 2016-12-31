package com.wjc.learn.draw_view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.wjc.learn.R;
import com.wjc.learn.data.MorePageModel;
import com.wjc.learn.data.PageModel;
import com.wjc.learn.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

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

    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.sample_color, R.layout.practice_color, R.string.title_draw_color));
        pageModels.add(new PageModel(R.layout.sample_circle, R.layout.practice_circle, R.string.title_draw_circle));

    }
    private static final String KEY_NAV_ITEM = "CURRENT_NAV_ITEM";

    private int selectedNavItem = 0;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, BaseViewActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_view);

        Log.e("getData", MorePageModel.getData().size()+"+AAAAA");

        // Set up the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setTitle(R.string.my_view);
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        // Set up the navigation drawer.
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setStatusBarBackground(R.color.colorPrimaryDark);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        if (savedInstanceState != null) {
            baseViewFragment = (BaseViewFragment) getSupportFragmentManager().getFragment(savedInstanceState, "baseViewFragment");
            baseViewFragment2 = (BaseViewFragment2) getSupportFragmentManager().getFragment(savedInstanceState, "baseViewFragment2");

        } else {
            baseViewFragment = (BaseViewFragment) getSupportFragmentManager().findFragmentById(R.id.content_main);
            if (savedInstanceState == null) {
//                baseViewFragment = BaseViewFragment.newInstance();
                baseViewFragment = BaseViewFragment.newInstance2(pageModels);
            }

            baseViewFragment2 = (BaseViewFragment2) getSupportFragmentManager().findFragmentById(R.id.content_main);
            if (savedInstanceState == null) {
                baseViewFragment2 = BaseViewFragment2.newInstance();
            }
        }

        if (!baseViewFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_main, baseViewFragment, "baseViewFragment")
                    .commit();
        }

        if (!baseViewFragment2.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_main, baseViewFragment2, "baseViewFragment2")
                    .commit();
        }

//        new FirstPresenter(firstFragment, new ToFindItemsInteractorImpl());

        if (selectedNavItem == 0) {
            showBaseViewFragment();
        } else if (selectedNavItem == 1) {
            showBaseViewFragment2();
        }

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

    /**
     * Store the state when the activity may be recycled.
     *
     * @param outState The state data.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Menu menu = navigationView.getMenu();
        if (menu.findItem(R.id.one).isChecked()) {
            outState.putInt(KEY_NAV_ITEM, 0);
        } else if (menu.findItem(R.id.two).isChecked()) {
            outState.putInt(KEY_NAV_ITEM, 1);
        }
        // Store the fragments' states.
        if (baseViewFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, "BaseViewFragment", baseViewFragment);
        }
        if (baseViewFragment2.isAdded()) {
            getSupportFragmentManager().putFragment(outState, "BaseViewFragment2", baseViewFragment2);
        }
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.back_to_home:
                        Intent intent =
                                new Intent(BaseViewActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
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
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(baseViewFragment);
        fragmentTransaction.hide(baseViewFragment2);
        fragmentTransaction.commit();

        navigationView.setCheckedItem(R.id.to_page_one);
    }

    private void showBaseViewFragment2() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.show(baseViewFragment2);
        fragmentTransaction.hide(baseViewFragment);
        fragmentTransaction.commit();

        navigationView.setCheckedItem(R.id.to_page_two);
    }
}
