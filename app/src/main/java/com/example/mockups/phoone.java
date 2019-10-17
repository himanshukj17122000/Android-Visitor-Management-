package com.example.mockups;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.regex.Pattern;
import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link phoone.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link phoone#newInstance} factory method to
 * create an instance of this fragment.
 */
public class phoone extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText t;
    MyDBHandler d;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button b,c;


    private OnFragmentInteractionListener mListener;

    public phoone() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment phoone.
     */
    // TODO: Rename and change types and number of parameters
    public static phoone newInstance(String param1, String param2) {
        phoone fragment = new phoone();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_phoone, container, false);
        b=rootView.findViewById(R.id.nextp);
        c=rootView.findViewById(R.id.butp);
        t= rootView.findViewById(R.id.mobile);
        b.setOnClickListener(this);
        c.setOnClickListener(this);



        return rootView;

    }
    public void onClick(View view){
        if(view==b){
            if(TextUtils.isEmpty(t.getText().toString().trim()) || !isValidMobile(t.getText().toString().trim())){
                //Toast.makeText(getActivity(),"Please enter your number", Toast.LENGTH_SHORT).show();
                t.setError("A valid number only!");
            }
            else {
//                if(d.Exists(t.getText().toString())){
//                    visitor present= d.present(t.getText().toString());
//                    Intent i = new Intent(getActivity(), type.class);
//                    i.putExtra("Visitor Present", present);
//                    startActivity(i);
//                }else{
                    visitor v= (visitor)getActivity().getIntent().getSerializableExtra("New Visitor");
                    v.setPhoneem(t.getText().toString());
                    Intent i = new Intent(getActivity(), type.class);
                    i.putExtra("Visitor Phone", v);
                    startActivity(i);
//                }

            }
        }
        else {

                Intent i = new Intent(getActivity(), secondpage.class);
                startActivity(i);

        }

    }
    private boolean isValidMobile(String phone) {
        boolean check=false;
        if(!Pattern.matches("[a-zA-Z]+", phone)) {
            if(phone.length() < 6 || phone.length() > 13) {
                // if(phone.length() != 10) {
                check = false;
                t.setError("Not Valid Number");
            } else {
                check = true;
            }
        } else {
            check=false;
        }
        return check;
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
//    public void onClick2(View v) {
//        if(t.getText().toString().matches("")){
//            Toast.makeText(getActivity(),"Please enter your number", Toast.LENGTH_SHORT).show();
//        }else{
//            Intent i = new Intent(getActivity(), purpose.class);
//            startActivity(i);
//        }
//    }
//
//    public void onClick3(View v){
//        Intent i= new Intent(getActivity(), secondpage.class);
//        startActivity(i);
//    }
}
