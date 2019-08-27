package com.example.sunilm.twomore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddNewVideoFragment.AddStoryMethod} interface
 * to handle interaction events.
 * Use the {@link AddNewVideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddNewVideoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_ACTISELECTED = "activitySelected";
    private static final int  PICK_IMAGE_REQUEST = 234 ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    // TODO: Rename and change types of parameters
    private TextView storyNametextiew;
    private TextView storyDeascriptionTextView;
    private String storyName;
    private String storyDeascription;
    VideoClass videoClass = new VideoClass();
    StoriesClass storiesClass = new StoriesClass();
    private ImageView imageview;
private ImageView storyPicture;
    private AddStoryMethod mListener;
    private AddVideoMethod mListener1;

    public AddNewVideoFragment() {
        // Required intempty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddNewVideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddNewVideoFragment newInstance(String param1, String param2) {
        AddNewVideoFragment fragment = new AddNewVideoFragment();
        Bundle args = new Bundle();
      /*  args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);*/
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_add_new_video, container, false);

    /*    storyNametextiew = view.findViewById(R.id.addNewstoryTolisteditText);
        storyName =  storyNametextiew.getText().toString();
        storyDeascriptionTextView = view.findViewById(R.id.addNewstoryDescriptionlisteditText);
        storyDeascription =  storyDeascriptionTextView.getText().toString();

        final Button addNewStoryToList = view.findViewById(R.id.addNewStorytoList);
        if(addNewStoryToList!=null)
        {
            addNewStoryToList.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    videoClass.setName(storyName);
                    videoClass.setDescription(storyDeascription);
                    mListener.AddNewStoryMethod(videoClass);

                }
            });
        }
        return view;*/



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_ACTISELECTED);
        }

        Button addewStoryButton = (Button) getView().findViewById(R.id.addNewStorytoList);
        imageview = (ImageView)getView().findViewById(R.id.imageView3);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select an Image"),PICK_IMAGE_REQUEST);
            }
        });

        if(addewStoryButton!=null) {
            addewStoryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("demo","clicked");
                    if( mParam1.equalsIgnoreCase("videos")) {
                        storyNametextiew = (TextView) getView().findViewById(R.id.addNewstoryTolisteditText);
                        storyDeascriptionTextView = (TextView) getView().findViewById(R.id.addNewstoryDescriptionlisteditText);
                        videoClass.setName(storyNametextiew.getText().toString());
                        videoClass.setDescription(storyDeascriptionTextView.getText().toString());
                        mListener1.AddNewVideoMethod(videoClass);
                    }else
                    {
                        storyNametextiew = (TextView) getView().findViewById(R.id.addNewstoryTolisteditText);
                        storyDeascriptionTextView = (TextView) getView().findViewById(R.id.addNewstoryDescriptionlisteditText);
                        storyPicture=(ImageView) getView().findViewById(R.id.imageView3);
                        storiesClass.setName(storyNametextiew.getText().toString());
                        storiesClass.setDescription(storyDeascriptionTextView.getText().toString());
                        storiesClass.setBitmap(storyPicture.getDrawable());
                        mListener.AddNewStoryMethod(storiesClass);
                    }

                }
            });
        }


        super.onActivityCreated(savedInstanceState);
    }

/*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AddStoryMethod) {
            mListener = (AddStoryMethod) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNextButtonClicked");
        }
        if (context instanceof AddVideoMethod) {
            mListener1 = (AddVideoMethod) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNextButtonClicked");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        mListener1=null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface AddStoryMethod {
        // TODO: Update argument type and name
        void AddNewStoryMethod(StoriesClass storiesClass);
    }
    public interface AddVideoMethod {
        // TODO: Update argument type and name
        void AddNewVideoMethod(VideoClass videoClass);
    }
}
