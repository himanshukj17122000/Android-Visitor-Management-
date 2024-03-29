package com.example.mockups;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link email.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link email#newInstance} factory method to
 * create an instance of this fragment.
 */
public class email extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button r,o;
    EditText k;
    MyDBHandler d;

    private OnFragmentInteractionListener mListener;

    public email() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment email.
     */
    // TODO: Rename and change types and number of parameters
    public static email newInstance(String param1, String param2) {
        email fragment = new email();
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

        View rootView = inflater.inflate(R.layout.fragment_email, container, false);
        r=rootView.findViewById(R.id.nextee);
        o=rootView.findViewById(R.id.bute);
        k= rootView.findViewById(R.id.email);
        r.setOnClickListener(this);
        o.setOnClickListener(this);

        return rootView;

    }
    public void onClick(View view) {
        if(view==r){
            if(TextUtils.isEmpty(k.getText().toString().trim()) || !isValidMail(k.getText().toString())){
                //Toast.makeText(getActivity(),"Please enter your number", Toast.LENGTH_SHORT).show();
                k.setError("A valid email id only");
            }
            else {
//                if(d.Exists(k.getText().toString())) {
//                    visitor present = d.present(k.getText().toString());
//                    Intent i = new Intent(getActivity(), type.class);
//                    i.putExtra("Visitor Present", present);
//                    startActivity(i);
//                }
//                    else{


                        visitor v= (visitor)getActivity().getIntent().getSerializableExtra("New Visitor");
                        v.setEmail(k.getText().toString());
                        Intent i = new Intent(getActivity(), type.class);
                        i.putExtra("Visitor Phone", v);
                        startActivity(i);
//                    }

            }
        }
        else {


                Intent i = new Intent(getActivity(), secondpage.class);
                startActivity(i);

        }
        }
    private boolean isValidMail(String email) {
        boolean check;
        Pattern p;
        Matcher m;

        String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        p = Pattern.compile(EMAIL_STRING);

        m = p.matcher(email);
        check = m.matches();

        if(!check) {
            k.setError("Not Valid Email");
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


}
