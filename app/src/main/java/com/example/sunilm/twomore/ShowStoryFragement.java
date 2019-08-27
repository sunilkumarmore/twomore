package com.example.sunilm.twomore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnNextButtonClicked} interface
 * to handle interaction events.
 * Use the {@link ShowStoryFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowStoryFragement extends  Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View view;
    private TextView showStoryNmae;
    private TextView showSToryDescription;
    private ImageView storyImage;
    private StorageReference mStorageRef;
    private   FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mdataBaseReference;
    private StoriesClass currentStory;
    private String imageName;
    private String currentStoryName;
  //  private Button nextButton;

    private OnNextButtonClicked mListener;

    public ShowStoryFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShowStoryFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowStoryFragement newInstance(String param1, String param2) {
        ShowStoryFragement fragment = new ShowStoryFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mStorageRef = FirebaseStorage.getInstance().getReference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_show_story_fragement, container, false);
      //  showStoryNmae = view.findViewById(R.id.showstoryname);
        mFirebaseDatabase  = FirebaseDatabase.getInstance();
        //mdataBaseReference= mFirebaseDatabase.getReference().child("Stories");
        Button nextButton = (Button)view.findViewById(R.id.button_nextstory);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.OnNextButtonClicked("next",currentStory);
            }
        });

        if(getArguments().getParcelable("currentStory")!=null) {
             currentStory = getArguments().getParcelable("currentStory");
           // if (showStoryNmae != null) {
              //  showStoryNmae.setText(currentStory.getName());
            currentStoryName = currentStory.getName();
                getActivity().setTitle(currentStory.getName());
                mdataBaseReference= mFirebaseDatabase.getReference().child("Stories").child(currentStory.getName()).child("imageName");
                mdataBaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                         imageName = dataSnapshot.getValue(String.class);
                        StorageReference islandRef = mStorageRef.child("images/"+imageName+".jpg");

                        final long ONE_MEGABYTE = 2024 * 2024;
                        islandRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                            @Override
                            public void onSuccess(byte[] bytes) {
                                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                                storyImage.setImageBitmap(bitmap);
                                // Data for "images/island.jpg" is returns, use this as needed
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {

                            }
                        });

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

           // }


            showSToryDescription = view.findViewById(R.id.showstoryDescription);

            if (showSToryDescription != null) {
                showSToryDescription.setText(currentStory.getDescription());
            }
            storyImage= view.findViewById(R.id.storyPicture);
            if(storyImage!=null)
            {
           /*     Drawable bitmap = currentStory.getBitmap();
                storyImage.setImageDrawable(bitmap);*/


            }

        }
        else if (getArguments().getParcelable("currentVideo")!=null)
        {

         /*   VideoClass currentVideo = getArguments().getParcelable("currentVideo");
            if (showStoryNmae != null) {
                showStoryNmae.setText(currentVideo.getName());
            }
            showSToryDescription = view.findViewById(R.id.showstoryDescription);

            if (showSToryDescription != null) {
                showSToryDescription.setText(currentVideo.getDescription());
            }*/
        }
        return view;
    }


/*    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        //   View view= inflater.inflate(R.layout.fragment_add_new_video, container, false);

        storyNametextiew = (TextView) getView().findViewById(R.id.addNewstoryTolisteditText);
        storyName =  storyNametextiew.getText().toString();
        storyDeascriptionTextView = (TextView) getView().findViewById(R.id.addNewstoryDescriptionlisteditText);
        storyDeascription =  storyDeascriptionTextView.getText().toString();;

        final Button addNewStoryToList = (Button) getView().findViewById(R.id.addNewStorytoList);
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

        super.onActivityCreated(savedInstanceState);
    }*/




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ShowStoryFragement.OnNextButtonClicked) {
            mListener = (ShowStoryFragement.OnNextButtonClicked) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnNextButtonClicked");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnNextButtonClicked {
        // TODO: Update argument type and name
        void OnNextButtonClicked(String buttonClicked,StoriesClass currentStor);
    }
}
