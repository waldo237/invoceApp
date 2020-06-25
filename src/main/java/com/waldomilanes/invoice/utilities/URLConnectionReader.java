package com.waldomilanes.invoice.utilities;

import java.net.*;
import java.io.*;

public class URLConnectionReader {

    private URL url;

    public URLConnectionReader() {

    }

    public URLConnectionReader(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public void setUrl(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public void read() throws IOException {

        URLConnection yc = url.openConnection();
        /*here yoou can put a base64 method to find what you want*/
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public void write(String url, String post) throws Exception {

        if (post.length() != 2) {
            System.err.println("Usage:  java Reverse "
                    + "http://<location of your servlet/script>"
                    + " string_to_reverse");
            System.exit(1);
        }

        String stringToReverse = URLEncoder.encode(post, "UTF-8");

        this.url = new URL(url);
        URLConnection connection = this.url.openConnection();
        connection.setDoOutput(true);

        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        out.write("string=" + stringToReverse);
        out.close();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream()));
        String decodedString;
        while ((decodedString = in.readLine()) != null) {
            System.out.println(decodedString);
        }
        in.close();

    }
    
}
