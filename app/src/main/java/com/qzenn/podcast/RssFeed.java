package com.qzenn.podcast;

import android.os.AsyncTask;
import android.view.View;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RssFeed {
    public String rssResult = "";
    private boolean item = false;

    protected RssFeed(){
    }

    public String getRss(String Url) {
        new DownloadWebpageTask().execute(Url);

        return rssResult;
    }



    //    // When user clicks button, calls AsyncTask.
//    // Before attempting to fetch the URL, makes sure that there is a network connection.
//    public void myClickHandler(View view) {
//
//        ConnectivityManager connMgr = (ConnectivityManager)
//                getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//        if (networkInfo != null && networkInfo.isConnected()) {
//            new DownloadWebpageTask().execute(stringUrl);
//        } else {
////            textView.setText("No network connection available.");
//        }
//    };

    // Uses AsyncTask to create a task away from the main UI thread. This task takes a
    // URL string and uses it to create an HttpUrlConnection. Once the connection
    // has been established, the AsyncTask downloads the contents of the webpage as
    // an InputStream. Finally, the InputStream is converted into a string, which is
    // displayed in the UI by the AsyncTask's onPostExecute method.
