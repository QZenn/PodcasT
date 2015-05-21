package ru.qzenn.radiot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RadiotMainActivity extends Activity {
    private OnClickListener startMediaPlayerActivity = new OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),
                    MediaPlayer.class);
            startActivity(intent);
        }

    };
    private OnClickListener startTwitterFeedActivity = new OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent(getApplication(),
                    TwitterFeed.class);
            startActivity(intent);
        }

    };
    private OnClickListener startJabberChatActivity = new OnClickListener() {

        public void onClick(View v) {
            Intent intent = new Intent(getApplication(),
                    JabberChat.class);
            startActivity(intent);
        }

    };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button openMediaPlayerButton = (Button) findViewById(R.id.openMediaPlayer);
        openMediaPlayerButton.setOnClickListener(startMediaPlayerActivity);
        Button openTwitterFeedButton = (Button) findViewById(R.id.openTwitterFeed);
        openTwitterFeedButton.setOnClickListener(startTwitterFeedActivity);
        Button openJabberChatButton = (Button) findViewById(R.id.openJabberChat);
        openJabberChatButton.setOnClickListener(startJabberChatActivity);
    }
}
