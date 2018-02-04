package demo;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.json.JSONException;

public class Authentication extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    private final String PASS = "kolunia.93";
    private final String SecurityToken = "mzHP6GDgmr24rw9y6d8TM2TZ";
    private final String USERNAME = "nik@1993.com";
    private final String PASSWORD = PASS + SecurityToken;
    private final String LOGINURL = "https://login.salesforce.com";
    private final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
    private final String CLIENTID = "3MVG9TSaZ8P6zP1of92qDh6nhoUvS39cJ8KKJZP7CSCw3WxNGWbmI_wMnJbsH0gWYtUdEH0paqlguWK_S5TGB";
    private final String CLIENTSECRET = "2521621574532223813";

    private JSONObject jsonObject = null;
    private String loginAccessToken = null;
    private String loginInstanceUrl = null;
   
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	HttpClient httpclient = HttpClientBuilder.create().build();
       
    	String loginURL = LOGINURL + GRANTSERVICE + "&client_id=" + CLIENTID + "&client_secret=" + CLIENTSECRET + "&username=" + USERNAME + "&password=" + PASSWORD;
        
        HttpPost httpPost = new HttpPost(loginURL);
        HttpResponse resp = null;

        try {
            resp = httpclient.execute(httpPost);
        } catch (ClientProtocolException cpException) {
            cpException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        final int statusCode = resp.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Error authenticating to SalesForce: " + statusCode);
            return;
        }

        String getResult = null;
        try {
            getResult = EntityUtils.toString(resp.getEntity());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        
        try {
            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
            loginAccessToken = jsonObject.getString("access_token");
            loginInstanceUrl = jsonObject.getString("instance_url");
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
        System.out.println(resp.getStatusLine());
        System.out.println("Successful login");
        System.out.println("  instance URL: " + loginInstanceUrl);
        System.out.println("  access token/session ID: " + loginAccessToken);
        
        httpPost.releaseConnection();
    }
    
	public String getLoginAccessToken() {
		return loginAccessToken;
	}

	public String getLoginInstanceUrl() {
		return loginInstanceUrl;
	}

    
}