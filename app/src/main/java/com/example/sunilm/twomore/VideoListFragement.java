package com.example.sunilm.twomore;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VideoListFragement.OnListFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VideoListFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideoListFragement extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_ACTISELECTED = "activitySelected";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnListFragmentInteractionListener mListener;

    public VideoListFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideoListFragement.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoListFragement newInstance(String param1, String param2) {
        VideoListFragement fragment = new VideoListFragement();
        Bundle args = new Bundle();
        args.putString(ARG_ACTISELECTED, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_ACTISELECTED);
        }
        ImageButton x = (ImageButton) getActivity().findViewById(R.id.addImagebutton);
        TextView header = (TextView) getActivity().findViewById(R.id.textView);
        header.setText(mParam1);

        if (x != null) {
            x.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("demo", "clicked");

                    mListener.AddFragement(R.id.container2,mParam1);

                }
            });
            ;

        }
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_ACTISELECTED);
        }

        View view= inflater.inflate(R.layout.fragment_video_list_fragement, container, false);
        ListView lv = view.findViewById(R.id.currentExpenseslist);
        mListener.displayListViewMethod(lv,mParam1);
        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
          //  mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
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
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void AddFragement(int ss,String buttonClicked);
        void displayListViewMethod(ListView Lv,String buttonClicked);
    }
}
