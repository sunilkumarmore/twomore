package com.example.sunilm.twomore;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OverViewFragement.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OverViewFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OverViewFragement extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Button gamesButton;
    private Button videosButton;
    private Button storiesButton;

   // private Toolbar mTopToolbar;
    private InterfaceFromOverAllFragement mListener;

    public OverViewFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OverViewFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static OverViewFragement newInstance(String param1, String param2) {
        OverViewFragement fragment = new OverViewFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 /*       mTopToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mTopToolbar);*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_over_view_fragement, container, false);

        storiesButton = (Button)view.findViewById(R.id.Storiesbutton);
        storiesButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onButtonPressed(storiesButton.getText().toString());
            }
        });
        videosButton = (Button)view.findViewById(R.id.videosbutton);
        videosButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onButtonPressed(videosButton.getText().toString());
            }
        });
        gamesButton = (Button)view.findViewById(R.id.gamesButton);
        gamesButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                onButtonPressed(gamesButton.getText().toString());
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String buttonName) {
        if (mListener != null) {
            mListener.OverAllFragementMethod(buttonName);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InterfaceFromOverAllFragement) {
            mListener = (InterfaceFromOverAllFragement) context;
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
    public interface InterfaceFromOverAllFragement {
        // TODO: Update argument type and name
        void OverAllFragementMethod(String buttonName);
    }
}
