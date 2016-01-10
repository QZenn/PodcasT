package com.qzenn.podcast;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * A placeholder fragment containing a simple view.
 */
public class ActTwitterFragment extends Fragment {

    public String rssResult = "";
    private boolean item = false;


    public ActTwitterFragment() {
    }

    EditText twitterText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView =  inflater.inflate(R.layout.fragment_act_twitter, container, false);
        Button btnGetRss = (Button) mView.findViewById(R.id.btnGetRss);
        btnGetRss.setOnClickListener(getRssFeed);
        twitterText = (EditText) mView.findViewById(R.id.twitterText);
        return mView;
    }

    private View.OnClickListener getRssFeed = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DownloadWebpageTask.execute("http://feeds2.feedburner.com/Mobilab");
            String rssText = new RssFeed().getRss("http://feeds2.feedburner.com/Mobilab");
            twitterText.setText(rssText);
        }
    };

    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            rssResult = result;
        }

        // Given a URL, establishes an HttpUrlConnection and retrieves
        // the web page content as a InputStream, which it returns as
        // a string.
        private String downloadUrl(String Url) throws IOException {
            try {
                URL rssUrl = new URL(Url);
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                XMLReader xmlReader = saxParser.getXMLReader();
                RSSHandler rssHandler = new RSSHandler();
                xmlReader.setContentHandler(rssHandler);
                InputSource inputSource = new InputSource(rssUrl.openStream());
                xmlReader.parse(inputSource);
            } catch (IOException e) {
                rssResult = e.getMessage();
            } catch (ParserConfigurationException e) {
                rssResult = e.getMessage();
            } catch (SAXException e) {
                rssResult = e.getMessage();
            }
            return rssResult;

//            InputStream is = null;
//            // Only display the first 500 characters of the retrieved
//            // web page content.
//            int len = 500;
//
//            try {
//                URL url = new URL(myurl);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setReadTimeout(10000 /* milliseconds */);
//                conn.setConnectTimeout(15000 /* milliseconds */);
//                conn.setRequestMethod("GET");
//                conn.setDoInput(true);
//                // Starts the query
//                conn.connect();
//                int response = conn.getResponseCode();
//                Log.d(DEBUG_TAG, "The response is: " + response);
//                is = conn.getInputStream();
//
//                // Convert the InputStream into a string
//                String contentAsString = readIt(is, len);
//                return contentAsString;
//
//                // Makes sure that the InputStream is closed after the app is
//                // finished using it.
//            } finally {
//                if (is != null) {
//                    is.close();
//                }
//            }
        }

    }

    private class RSSHandler extends DefaultHandler {

        public void startElement(String uri, String localName, String qName,
                                 Attributes attrs) throws SAXException {
            if (localName.equals("item"))
                item = true;

            if (!localName.equals("item") && item)
                rssResult = rssResult + localName + ": ";

        }

        public void endElement(String namespaceURI, String localName,
                               String qName) throws SAXException {

        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            String cdata = new String(ch, start, length);
            if (item)
                rssResult = rssResult + (cdata.trim()).replaceAll("\\s+", " ") + "\t";

        }

    }


}
