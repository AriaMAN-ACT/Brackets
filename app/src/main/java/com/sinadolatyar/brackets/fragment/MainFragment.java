package com.sinadolatyar.brackets.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sinadolatyar.brackets.R;

import java.util.Dictionary;
import java.util.Hashtable;

public class MainFragment extends Fragment implements View.OnClickListener {
    EditText editText;
    Button button;

    public MainFragment() {
        // Required empty public constructor
    }
    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        editText = view.findViewById(R.id.fragment_main_edit_text);
        button = view.findViewById(R.id.fragment_main_button);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String input = String.valueOf(editText.getText());
        editText.setText("");
        if (isFine(input)) {
            Toast.makeText(getActivity(), "text is fine", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "text isn't ok", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isFine(String input) {
        Dictionary<Character, Character> brackets = new Hashtable();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');
        try {
            if (input.length() == 0 || input.length() % 2 != 0) {
                return true;
            } else if (brackets.get(input.charAt(0)) != input.charAt(input.length() - 1)) {
                return false;
            }
            return isFine(input.substring(1, input.length() - 1));
        } catch (Exception e) {
            return false;
        }
    }
}
