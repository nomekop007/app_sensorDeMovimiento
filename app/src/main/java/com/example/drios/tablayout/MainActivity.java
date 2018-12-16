package com.example.drios.tablayout;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager pager;

    private  AdapterPager adapter;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.sr);

    swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            //carga todos los datos denuevo

            //obtener los controles definidos en la UI
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            tabs = (TabLayout) findViewById(R.id.tabs);
            pager = (ViewPager) findViewById(R.id.pager);

            //definir el action bar asociado al toolbar
            setSupportActionBar(toolbar);

            //definir la configuracion del tabs
            adapter = new AdapterPager(getSupportFragmentManager());
            pager.setAdapter(adapter);

            //hacer relacion entre el tabLayout y las ViewPager
            tabs.setupWithViewPager(pager);


            tabs.getTabAt(0).setIcon(R.drawable.img1);
            tabs.getTabAt(1).setIcon(R.drawable.img2);
            tabs.getTabAt(2).setIcon(R.drawable.img3);

            swipeRefreshLayout.setRefreshing(false);
        }
    });

        //obtener los controles definidos en la UI
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabs = (TabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);

        //definir el action bar asociado al toolbar
        setSupportActionBar(toolbar);

        //definir la configuracion del tabs
        adapter = new AdapterPager(getSupportFragmentManager());
        pager.setAdapter(adapter);

        //hacer relacion entre el tabLayout y las ViewPager
        tabs.setupWithViewPager(pager);


        tabs.getTabAt(0).setIcon(R.drawable.img1);
        tabs.getTabAt(1).setIcon(R.drawable.img2);
        tabs.getTabAt(2).setIcon(R.drawable.img3);

    }

    public class AdapterPager extends FragmentPagerAdapter{

        public AdapterPager(FragmentManager fm){
            super(fm);
        }


        //define cantidad de tabs en la barra
        @Override
        public int getCount() {
            return 3;
        }


            //define los nombres de cada tabs
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                return "alertas";
                case 1:
                    return "ultima alerta";
                case 2:
                    return "opcion 3";
            }
            return null;
        }


        //define la interfase que se cargara en cada tabs
        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0:
                    Tab1 t1 = new Tab1();
                    return t1;
                case 1:
                    Tab2 t2 = new Tab2();
                    return t2;
                case 2:
                    Tab3 t3 = new Tab3();
                    return t3;
            }
            return null;
        }
    }


}
