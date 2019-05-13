package com.example.sunilm.twomore;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements VideoListFragement.OnListFragmentInteractionListener,AddNewVideoFragment.OnFragmentInteractionListener{

    ArrayList<VideoClass> expensesSoFar = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   /*     Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        Button loginLater = (Button)findViewById(R.id.loginlater2);
        loginLater.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                FragmentManager man = getSupportFragmentManager();
               man.beginTransaction()
                        .add(R.id.container2,new VideoListFragement(),"second tag")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void AddFragement(int ss) {
        FragmentManager man = getSupportFragmentManager();
        man.beginTransaction()
                .replace(R.id.container2,new AddNewVideoFragment(),"secom")
                .addToBackStack("firstTag")
                .commit();
    }

    @Override
    public void displayListViewMethod(ListView Lv) {
        VideoClass hh = new VideoClass("ssda","asdsad");
        expensesSoFar.add(hh);
        AdapterClassForVideos cc = new AdapterClassForVideos(this,R.layout.layoutforvideoadapter,expensesSoFar);

   /*     if(lv!=null)
        {
            lv.setAdapter(cc);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    FirebaseDatabase database = FirebaseDatabase.getInstance();

                    Intent in = new Intent(MainActivity.this, Showexpense22.class);
                    in.putExtra("Expense", expensesSoFar.get(position));
                    startActivity(in);

                }
            });
        }*/
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
