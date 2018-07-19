/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.puc.se.liblogapp.datawriter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.client.entity.UrlEncodedFormEntity;  
import org.apache.http.client.methods.HttpGet;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.omg.CORBA.NameValuePair;

public class NetRequest {

    public NetRequest()
    {
        
    }
    
    public Boolean SendRequest(String url, String content)
    {
        Boolean r = false;
        try {
            String result = null;
            HttpClient httpclient = HttpClients.createDefault();
            HttpResponse response = null;
            HttpPost httppost = new HttpPost(url);
            List<String> params = new ArrayList<String>(2);
            params.add(content);
            response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                try {
                    // do something useful
                } finally {
                    instream.close();
                }
            }
            r = true;
        } 
        catch (Exception ex) 
        {
            r = false;
        }
        return r;
    }
    
}
