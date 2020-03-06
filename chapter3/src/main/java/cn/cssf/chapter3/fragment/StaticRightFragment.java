package cn.cssf.chapter3.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.cssf.chapter3.Person;
import cn.cssf.chapter3.R;
import cn.cssf.chapter3.RecyclerFamousAdapter;
import cn.cssf.chapter3.The3_3_RecyclerView_Activity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StaticRightFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StaticRightFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StaticRightFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private List<Person> dataList;
    private Map<String,List<Person>> dataByCompany;
    private Map<String,List<Person>> dataByFirstWord, dataByFirstTwoWords, dataByFirstThreeWords;
    private RecyclerFamousAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public StaticRightFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StaticRightFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StaticRightFragment newInstance(String param1, String param2) {
        StaticRightFragment fragment = new StaticRightFragment();
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
        View view = inflater.inflate(R.layout.fragment_static_right, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerFamousAdapter(getActivity());
        dataList = adapter.getDataList();
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        initDataMap();
        return view;
    }

    public void initDataMap(){
        dataByCompany = new HashMap();
        for (Person person : dataList){
            String company = person.getCompany();
            if (dataByCompany.containsKey(company)){
                List<Person> tmpPersons = dataByCompany.get(company);
                tmpPersons.add(person);
                dataByCompany.put(company,tmpPersons);
            }
            else {
                List<Person> tmpPersons = new ArrayList();
                tmpPersons.add(person);
                dataByCompany.put(company,tmpPersons);
            }
        }
        dataByFirstWord = new HashMap();
        dataByFirstTwoWords = new HashMap(); dataByFirstThreeWords = new HashMap();
        StringBuffer stringBuffer = null;
        for (Person person : dataList){
            String name = person.getName();
            stringBuffer = new StringBuffer();
            char[] charArray = name.toCharArray();
            for (int i=0; i<charArray.length; i++){
                stringBuffer.append(String.valueOf(charArray[i]));
                String theWord = stringBuffer.toString();
                if (i == 0){
                    if (dataByFirstWord.containsKey(theWord)){
                        List<Person> tmpPersons = dataByFirstWord.get(theWord);
                        tmpPersons.add(person);
                        dataByFirstWord.put(theWord,tmpPersons);
                    }
                    else {
                        List<Person> tmpPersons = new ArrayList();
                        tmpPersons.add(person);
                        dataByFirstWord.put(theWord,tmpPersons);
                    }
                }
                else if (i == 1){
                    if (dataByFirstTwoWords.containsKey(theWord)){
                        List<Person> tmpPersons = dataByFirstTwoWords.get(theWord);
                        tmpPersons.add(person);
                        dataByFirstTwoWords.put(theWord,tmpPersons);
                    }
                    else {
                        List<Person> tmpPersons = new ArrayList();
                        tmpPersons.add(person);
                        dataByFirstTwoWords.put(theWord,tmpPersons);
                    }
                }
                else if (i == 2){
                    if (dataByFirstThreeWords.containsKey(theWord)){
                        List<Person> tmpPersons = dataByFirstThreeWords.get(theWord);
                        tmpPersons.add(person);
                        dataByFirstThreeWords.put(theWord,tmpPersons);
                    }
                    else {
                        List<Person> tmpPersons = new ArrayList();
                        tmpPersons.add(person);
                        dataByFirstThreeWords.put(theWord,tmpPersons);
                    }
                }
            }
        }
    }

    public void reFlush(String name, String company){
        if (name != null){
            List<Person> tmpPersonList = null;
            if (name.length() == 1) {
                tmpPersonList = dataByFirstWord.get(name);
            }
            else if (name.length() == 2)
                tmpPersonList = dataByFirstTwoWords.get(name);
            else if (name.length() == 3)
                tmpPersonList = dataByFirstThreeWords.get(name);

            if (null == tmpPersonList)
                adapter.setDataList(new ArrayList());
            else adapter.setDataList(tmpPersonList);
        }
        else if (null != company && dataByCompany.containsKey(company)){
            adapter.setDataList(dataByCompany.get(company));
        }
        else adapter.setDataList(dataList);
        adapter.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String message) {
        if (mListener != null) {
            mListener.onFragmentInteraction(message);
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
        void onFragmentInteraction(String message);
    }
}
