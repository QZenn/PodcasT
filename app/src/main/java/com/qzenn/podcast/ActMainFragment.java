package com.qzenn.podcast;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class ActMainFragment extends Fragment {


    public ActMainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_act_main, container, false);
        Button openMediaPlayerButton = (Button) mView.findViewById(R.id.openMediaPlayer);
        openMediaPlayerButton.setOnClickListener(startMediaPlayerActivity);
        openMediaPlayerButton.setContentDescription(getActivity().getApplication().getString(R.string.openMediaPlayerButton));
        openMediaPlayerButton.setTag(getActivity().getApplication().getString(R.string.openMediaPlayerButton));
        Button openTwitterFeedButton = (Button) mView.findViewById(R.id.openTwitterFeed);
        openTwitterFeedButton.setOnClickListener(startTwitterFeedActivity);
        Button openJabberChatButton = (Button) mView.findViewById(R.id.openJabberChat);
        openJabberChatButton.setOnClickListener(startJabberChatActivity);
        openJabberChatButton.setContentDescription(getActivity().getApplication().getString(R.string.openJabberChatButton));
        return mView;
    }

    private View.OnClickListener startMediaPlayerActivity = new View.OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent(getActivity().getApplicationContext(),
                    ActPlayer.class);
            startActivity(intent);
        }

    };
    private View.OnClickListener startTwitterFeedActivity = new View.OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent(getActivity().getApplication(),
                    ActTwitter.class);
            startActivity(intent);
        }

    };
    private View.OnClickListener startJabberChatActivity = new View.OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent(getActivity().getApplication(),
                    ActJabber.class);
            startActivity(intent);
        }

    };

}
