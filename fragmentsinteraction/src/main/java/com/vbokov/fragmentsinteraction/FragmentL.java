package com.vbokov.fragmentsinteraction;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by vladimirbokov on 15/07/15.
 */
public class FragmentL extends Fragment {

    private static EditText editTextURL;

    UrlListener activityCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_l,
                container, false);

        editTextURL = (EditText) view.findViewById(R.id.edittext_url);

        final Button button = (Button) view.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        return view;
    }

    public void buttonClicked(View view) {
        activityCallback.onButtonClick(editTextURL.getText().toString());
    }


    public interface UrlListener {
        void onButtonClick(String url);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityCallback = (UrlListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    " must implement ToolbarListener");
        }
    }
}
