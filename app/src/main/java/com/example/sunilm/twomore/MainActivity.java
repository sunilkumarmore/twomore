package com.example.sunilm.twomore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements VideoListFragement.OnListFragmentInteractionListener,AddNewVideoFragment.AddStoryMethod,AddNewVideoFragment.AddVideoMethod, ShowStoryFragement.OnNextButtonClicked,
        OverViewFragement.InterfaceFromOverAllFragement
{
    private static final String ARG_ACTISELECTED = "activitySelected";
    private Toolbar mTopToolbar;
    ArrayList<VideoClass> videosSoFar = new ArrayList<>();
    ArrayList<StoriesClass> storiesSoFar = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTopToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mTopToolbar);

        FragmentManager man = getSupportFragmentManager();
        man.beginTransaction()
                .replace(R.id.container2, new OverViewFragement(), "second tag")
                .addToBackStack(null)
                .commit();
    }

/*
    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()>0)
        {
         Fragment fragment= getSupportFragmentManager().findFragmentByTag("videolist");

if(fragment!=null)
{
    FragmentManager man = getSupportFragmentManager();
    man.beginTransaction()
            .replace(R.id.container2, fragment , "videolist")
            .addToBackStack(null)
            .commit();
}
        }
        super.onBackPressed();
    }*/

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
    public void AddFragement(int ss,String buttonClicked) {

        Bundle bundle = new Bundle();
        bundle.putString("activitySelected", buttonClicked );
// set Fragmentclass Arguments
        AddNewVideoFragment fragobj = new AddNewVideoFragment();
        fragobj.setArguments(bundle);
        FragmentManager man = getSupportFragmentManager();
        man.beginTransaction()
                .replace(R.id.container2, fragobj, buttonClicked)
                .addToBackStack(null)
                .commit();



    }

    @Override
    public void displayListViewMethod(ListView lv,String buttonClicked) {
   /*     VideoClass hh = new VideoClass("ssda","asdsad");
        expensesSoFar.add(hh);*/
        AdapterClassForVideos cc1;
        AdapterClassForStories cc;

        if(buttonClicked.equalsIgnoreCase("stories"))
{
     cc = new AdapterClassForStories(this,R.layout.layoutforstoriesadapter, storiesSoFar);
    if(lv!=null)
    {
        lv.setAdapter(cc);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //  FirebaseDatabase database = FirebaseDatabase.getInstance();

            /*      Intent in = new Intent(MainActivity.this, Showexpense22.class);
                    in.putExtra("Expense", expensesSoFar.get(position));
                    startActivity(in);*/

                Bundle bundle = new Bundle();
                bundle.putParcelable("currentStory",  storiesSoFar.get(position));
// set Fragmentclass Arguments
                ShowStoryFragement fragobj = new ShowStoryFragement();
                fragobj.setArguments(bundle);
                FragmentManager man = getSupportFragmentManager();
                man.beginTransaction()
                        .replace(R.id.container2,fragobj,"currentStory")
                        .addToBackStack(null)
                        .commit();

            }
        });
    }
}
        else//if(buttonClicked.equalsIgnoreCase("videos"))
        {
            cc1 = new AdapterClassForVideos(this,R.layout.layoutforvideoadapter, videosSoFar);
            if(lv!=null)
            {
                lv.setAdapter(cc1);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        //  FirebaseDatabase database = FirebaseDatabase.getInstance();

            /*      Intent in = new Intent(MainActivity.this, Showexpense22.class);
                    in.putExtra("Expense", expensesSoFar.get(position));
                    startActivity(in);*/
/*


                        ShowStoryFragement fragobj = new ShowStoryFragement();
                        fragobj.setArguments(bundle);
                        FragmentManager man = getSupportFragmentManager();
                        man.beginTransaction()
                                .replace(R.id.container2,fragobj,"currentVideo")
                                .addToBackStack(null)
                                .commit();
*/

                        Bundle bundle = new Bundle();
                        bundle.putParcelable("currentVideo",  videosSoFar.get(position));
                        Intent in = new Intent(MainActivity.this, VideoPlayerActivity.class);
                      //  in.putExtra("Expense", expensesSoFar.get(position));
                        startActivity(in);

                    }
                });
            }
        }

    }

    @Override
    public void AddNewStoryMethod(StoriesClass storyClass) {
        storiesSoFar.add(storyClass);
        Bundle bundle = new Bundle();
        bundle.putString(ARG_ACTISELECTED, "stories" );
// set Fragmentclass Arguments
        VideoListFragement fragobj = new VideoListFragement();
        fragobj.setArguments(bundle);
        FragmentManager man = getSupportFragmentManager();
        man.beginTransaction()
                .replace(R.id.container2, fragobj, "videolist")
                .addToBackStack(null)
                .commit();

    }


    @Override
    public void AddNewVideoMethod(VideoClass videoClass) {
        videosSoFar.add(videoClass);
        Bundle bundle = new Bundle();
        bundle.putString(ARG_ACTISELECTED, "videos" );
// set Fragmentclass Arguments
        VideoListFragement fragobj = new VideoListFragement();
        fragobj.setArguments(bundle);
        FragmentManager man = getSupportFragmentManager();
        man.beginTransaction()
                .replace(R.id.container2, fragobj, "videolist")
                .addToBackStack(null)
                .commit();

    }



    @Override
    public void OverAllFragementMethod(String buttonName) {

     if(buttonName.equalsIgnoreCase("videos")) {
         Bundle bundle = new Bundle();
         bundle.putString("activitySelected", "videos" );
// set Fragmentclass Arguments
         VideoListFragement fragobj = new VideoListFragement();
         fragobj.setArguments(bundle);
         FragmentManager man = getSupportFragmentManager();
         man.beginTransaction()
                 .replace(R.id.container2, fragobj, "videolist")
                 .addToBackStack(null)
                 .commit();

     }
  else     if(buttonName.equalsIgnoreCase("stories")) {
         Bundle bundle = new Bundle();
         bundle.putString("activitySelected", "stories" );
// set Fragmentclass Arguments
         VideoListFragement fragobj = new VideoListFragement();
         fragobj.setArguments(bundle);
         FragmentManager man = getSupportFragmentManager();
         man.beginTransaction()
                 .replace(R.id.container2, fragobj, "videolist")
                 .addToBackStack(null)
                 .commit();

     }
     else     if(buttonName.equalsIgnoreCase("games")) {
         Bundle bundle = new Bundle();
         bundle.putString("activitySelected", "games" );
// set Fragmentclass Arguments
         VideoListFragement fragobj = new VideoListFragement();
         fragobj.setArguments(bundle);
         FragmentManager man = getSupportFragmentManager();
         man.beginTransaction()
                 .replace(R.id.container2, fragobj, "videolist")
                 .addToBackStack(null)
                 .commit();
     }

    }

    @Override
    public void OnNextButtonClicked(String buttonClicked, StoriesClass currentStory) {

        if(buttonClicked.equalsIgnoreCase("next"))
        {

                    //  FirebaseDatabase database = FirebaseDatabase.getInstance();

            /*      Intent in = new Intent(MainActivity.this, Showexpense22.class);
                    in.putExtra("Expense", expensesSoFar.get(position));
                    startActivity(in);*/
            int currentItem = storiesSoFar.indexOf(currentStory);
            if(currentItem== storiesSoFar.size()-1) {

                Bundle bundle = new Bundle();
                bundle.putParcelable("currentStory", storiesSoFar.get(currentItem + 1));
// set Fragmentclass Arguments
                ShowStoryFragement fragobj = new ShowStoryFragement();
                fragobj.setArguments(bundle);
                FragmentManager man = getSupportFragmentManager();
                man.beginTransaction()
                        .replace(R.id.container2, fragobj, "currentStory")
                        .addToBackStack(null)
                        .commit();
            }


           /*     Intent in = new Intent(MainActivity.this, DisplayStoryActivitybackup.class);
                 in.putExtra("currentStory", bundle);
                startActivity(in);
*/

           // storiesSoFar.indexOf(currentStoryName)+1;
        }
    }
}
