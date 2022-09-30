package com.example.aboutlingxiaozhu;

import android.graphics.Color;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.text.Layout;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;
    private boolean colorset=false;

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            =(item)->
    {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mTextMessage.setText("My name is Lingxiao Zhu, looking for a full time software engineering job.\n\nSoftware engineering is always the most interesting thing for me. The process of analyzing problem structure, sorting out logical solution and implementation are always exciting!\n\n" +
                        "I have worked for Amazon AWS for 1.5 years.\n\nFeel free to check any information in this app to know more about me. Know that this app is just a primitive version and will be updated later. If you want to contact me, use info provided in this app.");
                return true;
            case R.id.navigation_websites:
                SpannableString msp;
                msp=new SpannableString("https://www.linkedin.com/in/lingxiaozhuse\n\nhttps://github.com/skywalkerplayer");
                mTextMessage.setText(msp);
                return true;
            case R.id.navigation_Contact:
                mTextMessage.setText("Phone:\n604-828-8569\n\nEmail:\nskywalker_2009@live.cn");
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        BottomNavigationView BotNavView=findViewById(R.id.bottomNavigationView);
        BotNavView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTextMessage = findViewById(R.id.textView2);
        mTextMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
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
        if (id == R.id.action_settings) {
            if(!colorset) {
                mTextMessage.setBackgroundColor(Color.YELLOW);
                colorset = true;
            }
            else {
                mTextMessage.setBackgroundColor(Color.WHITE);
                colorset = false;
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_basic) {
            mTextMessage.setText("My name is Lingxiao Zhu, looking for a full time software engineering job.\n\nSoftware engineering is always the most interesting thing for me. The process of analyzing problem structure, sorting out logical solution and implementation are always exciting!\n\n" +
                    "I have worked for Amazon AWS for 1.5 years.\n\nFeel free to check any information in this app to know more about me. Know that this app is just a primitive version and will be updated later. If you want to contact me, use info provided in this app.\n\n\n\n\n");
        } else if (id == R.id.nav_education) {
            mTextMessage.setText("Education:\n\nMaster of Science Computer Science - Illinois Institute of Technology, Chicago, IL. Aug 2018-Aug 2020\n\n" +
                    "· GPA: 3.28\n" +
                    "· Taken courses of Introduction to Algorithms, Operating systems, Machine learning and so on.\n\n" +
                    "Master of Science in Geology - Bowling Green State University, Bowling Green, OH. Aug 2015-Aug 2017\n\n" +
                    "· Taken courses of Quantitive methods and design, geodesy, GIS and spatial modeling.\n" +
                    "· Designed a whole Matlab project to analyze GPS and other auxiliary data, discovered a relationship between ground level and precipitation were detailed to show a 5-10mm of movement downward.\n" +
                    "· Geology department Tuition Scholarship and a Non-resident Fee Scholarship\n\n" +
                    "Master of Engineering in Geological Engineering - China University of Geosciences, Wuhan, Hubei, China. Sep 2008-Jun 2014\n\n" +
                    "· Focusing on geophysics. Participated in a team produced a sonar image displaying project. Developed algorithm with mathematical morphology methods independently to make the sonar image significantly clearer for object detection.\n" +
                    "· August 2009-August 2010 Proprietor of a campus magazine.");

        } else if (id == R.id.nav_experience) {
            mTextMessage.setText("Experience\n\n" +
                    "·Software development engineer I in Amazon Dec 2020-Jun 2022\n" +
                    "Working for AWS region build team. Constructed plugins for AWS region build automation project, helped with projects like a new region building, required services canary, RDS date displaying on console and so on.\n\n" +
                    "·Research assistant in Bowling Green State University Aug 2016-Jun 2018\n" +
                    "Designed a whole Matlab project to analyze GPS and other auxiliary data, discovered a relationship between ground level and precipitation were detailed to show a 5-10mm of movement downward.\n\n" +
                    "·Data analyst in Qingdao Institution of Marine Geology June 2014-May 2015\n" +
                    "Used Jason to perform seismic-well log data inversion, combined up multiple datasets to analyze underground structure, located possible oil drills in the region alongside a team of 50 team members.\n\n");

        } else if (id == R.id.nav_projects) {
            mTextMessage.setText("Projects\n\n" +
                    "Hosted zone creation plugin for AWS Region building automation Dec 2020-Jun 2022.\n" +
                    "Creates DNS resolving resources for new region\n" +
                    "Fits into a larger automated region building service\n" +
                    "Completed mainly individually with cooperation with team.\n\n"+

                    "Guardrail detection application. A project that allows LIDAR detect guardrail real time. Spring 2019\n" +
                    "Detect all points of guardrail gathered by LIDAR on street view cars.\n" +
                    "Detect and show guardrail from existing 3D point cloud with C++.\n" +
                    "Can be easily modified for real time guardrail detection on street.\n\n" +

                    "GPACE. A researching project of GPS data analyzing and visualization. Aug 2016-Jun 2018\n" +
                    "Displayed data from multiple datasets in both plot and map interface using Matlab\n" +
                    "Able to perform any static and comparison researcher needs to do\n" +
                    "Show a 5-10mm of movement downward related to precipitation\n" +
                    "Publicized on GitHub for anyone needs.\n\n"+

                    "Photo smear detection. A course project of image processing in CS513. Spring 2019\n" +
                    "Developed new operator to detect left and right edge of smears with C++\n" +
                    "Used mathematical morphology to clean up image\n" +
                    "Fast enough for street view cars to run on road.\n\n");

        } else if(id==R.id.nav_skills){
            mTextMessage.setText("Java, Python, Ruby, C++, Matlab, JavaScript, SQL, Android development, IOS development, Linux");
        }
        else if (id == R.id.nav_info) {
            mTextMessage.setText("Phone:\n604-828-8569\n\nEmail:\nskywalker_2009@live.cn");

        } else if (id == R.id.nav_send) {
            mTextMessage.setText("This function will be online in future.");

        }

        if(id==R.id.navigation_Contact)
        {
            mTextMessage.setText("Contact");
            return true;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
