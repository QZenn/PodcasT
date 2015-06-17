package com.qzenn.podcast;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class ActPlayerFragment extends Fragment {

    public ActPlayerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_act_player, container, false);

        EditText urlEditText = (EditText) mView.findViewById(R.id.urlEditText);
        Button playStopButton = (Button) mView.findViewById(R.id.playStopButton);
        playStopButton.setOnClickListener(playStopButtonHandler);

        return mView;
    }

    private View.OnClickListener playStopButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            //
        }
    };
}
