package demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import demo.entity.Acaunt;

import java.io.IOException;

public class HttpPostDemo {
	
	private final String parametr="/services/data/v20.0/sobjects/Account/";
	
    public void post(String url,String tocen) throws Exception {
    	Acaunt obj=new Acaunt("qq","qq","qq","qq","qq","qq");
    	Gson gson = new GsonBuilder().create();
    	String json = gson.toJson(obj);// obj is your object 
    	JSONObject jsonObj = new JSONObject(json);
    	
        
    	HttpClient client = HttpClientBuilder.create().build();
    	
        HttpPost post = new HttpPost(url+parametr);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");
        post.setHeader("Authorization", "Bearer "+ tocen);
       
        HttpEntity entity = new StringEntity(jsonObj.toString());
        post.setEntity(entity);
        try {
            HttpResponse response = client.execute(post);
            
            System.out.println(response.toString());
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
	    }
   
    
    
}