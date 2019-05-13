package com.example.sunilm.twomore;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sunilm on 2/12/2018.
 */


public class AdapterClassForVideos extends ArrayAdapter<VideoClass> {

    Context context;
    int resource;
    ArrayList<VideoClass> listOfExpenses;

    public AdapterClassForVideos(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<VideoClass> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
        this.listOfExpenses = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        VideoClass musicResults = listOfExpenses.get(position);
        ViewGroup123 nn = null;

        if(convertView==null)
        {
            nn = new ViewGroup123();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
            nn.tv1= convertView.findViewById(R.id.textView5);
            nn.tv2= convertView.findViewById(R.id.textView7);
            convertView.setTag(nn);
        }

        nn = (ViewGroup123) convertView.getTag();
        nn.tv1.setText(musicResults.getName());
        nn.tv2.setText(musicResults.getDescription());


        return convertView;
    }

    static  class ViewGroup123
    {
        TextView tv1;
        TextView tv2;

    }
}
