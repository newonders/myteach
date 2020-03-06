package cn.cssf.chapter3.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.cssf.chapter3.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StaticLeftFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StaticLeftFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StaticLeftFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public StaticLeftFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StaticLeftFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StaticLeftFragment newInstance(String param1, String param2) {
        StaticLeftFragment fragment = new StaticLeftFragment();
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
        View view = inflater.inflate(R.layout.fragment_static_left, container, false);
        ImageOnClickListener listener = new ImageOnClickListener(view);
        view.findViewById(R.id.imageView0).setOnClickListener(listener);
        view.findViewById(R.id.imageView1).setOnClickListener(listener);
        view.findViewById(R.id.imageView2).setOnClickListener(listener);
        view.findViewById(R.id.imageView3).setOnClickListener(listener);
        view.findViewById(R.id.imageView4).setOnClickListener(listener);
        view.findViewById(R.id.imageView5).setOnClickListener(listener);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String name, String company) {
        if (mListener != null) {
            mListener.onFragmentInteraction(name,company);
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
        void onFragmentInteraction(String name, String company);
    }

    private class ImageOnClickListener implements View.OnClickListener{
        private View fatherView;
        public ImageOnClickListener(View view){
            this.fatherView = view;
        }
        @Override
        public void onClick(View view) {
            TextView textView = null;
            switch (view.getId()){
                case R.id.imageView0:
                    break;
                case R.id.imageView1:
                    textView = fatherView.findViewById(R.id.textView1);
                    break;
                case R.id.imageView2:
                    textView = fatherView.findViewById(R.id.textView2);
                    break;
                case R.id.imageView3:
                    textView = fatherView.findViewById(R.id.textView3);
                    break;
                case R.id.imageView4:
                    textView = fatherView.findViewById(R.id.textView4);
                    break;
                case R.id.imageView5:
                    textView = fatherView.findViewById(R.id.textView5);
                    break;
            }
//            Log.d("StaticLeftFragment", "onClick: " + textView);
            if (textView != null)
                mListener.onFragmentInteraction(null,textView.getText().toString());
//                mListener.onFragmentInteraction(null,"迪斯尼");
            else
                mListener.onFragmentInteraction(null,"");

        }
    }
}
