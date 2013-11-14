package com.example.Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import android.os.AsyncTask;

public class ControlUno {
	JSONObject jsonObject = null;
	ArrayList<NameValuePair> nameValuePairs;
	HttpParams httpParameters;
	HttpClient httpclient;
	HttpPost httppost;
	HttpResponse response;
	HttpEntity entity;
	String result;
	private String jsonResult;
	private String url = "http://aulabuap.web44.net/controlador.php";
	 
	
	
	public ControlUno(){
		
		
		
		//Create the HTTP request
		httpParameters = new BasicHttpParams();

		//Setup timeouts
		HttpConnectionParams.setConnectionTimeout(httpParameters, 15000);
		HttpConnectionParams.setSoTimeout(httpParameters, 15000);			

		httpclient = new DefaultHttpClient(httpParameters);
		httppost = new HttpPost("http://aulabuap.web44.net/controlador.php");
		
		
	}
	
	public String resultado(){
		try {
			
			return jsonObject.getString("nombre");
		} catch (Exception e) {
			return "error";
		}
	}
	
	public String login(String user, String pass){
		nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("matricula-login", user));
		nameValuePairs.add(new BasicNameValuePair("password-login", pass));	
		conectar();
		
		try {
			
			return jsonObject.getString("nombre");
		} catch (Exception e) {
			return "error";
		}

		
		
	}
	
	public String registrarse(String user, String pass, String correo, String carrera, String apellidos, String nombre){
		nameValuePairs = new ArrayList<NameValuePair>();
		
				
		nameValuePairs.add(new BasicNameValuePair("matricula-registro", user));
		nameValuePairs.add(new BasicNameValuePair("password-registro", pass));	
		nameValuePairs.add(new BasicNameValuePair("nombre-registro", nombre));
		nameValuePairs.add(new BasicNameValuePair("apellidos-registro", apellidos));	
		nameValuePairs.add(new BasicNameValuePair("correo-registro", correo));
		nameValuePairs.add(new BasicNameValuePair("carrera-registro", carrera));	
		conectar();
		
		try {
			
			return jsonObject.toString();
		} catch (Exception e) {
			return result;
		}

		
		
	}
	
	
	public void conectar(){
		try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			response = httpclient.execute(httppost);
			entity = response.getEntity();

			
			result = EntityUtils.toString(entity);
			
			jsonObject = new JSONObject(result);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private class JsonReadTask extends AsyncTask<String, Void, String> {
		  @Override
		  protected String doInBackground(String... params) {
		   HttpClient httpclient = new DefaultHttpClient();
		   HttpPost httppost = new HttpPost(params[0]);
		   try {
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		    HttpResponse response = httpclient.execute(httppost);
		    jsonResult = inputStreamToString(
		      response.getEntity().getContent()).toString();
		   }
		 
		   catch (ClientProtocolException e) {
		    e.printStackTrace();
		   } catch (IOException e) {
		    e.printStackTrace();
		   }
		   return null;
		  }
		 
		  private StringBuilder inputStreamToString(InputStream is) {
		   String rLine = "";
		   StringBuilder answer = new StringBuilder();
		   BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		 
		   try {
		    while ((rLine = rd.readLine()) != null) {
		     answer.append(rLine);
		    }
		   }
		 
		   catch (IOException e) {
		    // e.printStackTrace();
		   }
		   return answer;
		  }
		 
		  @Override
		  protected void onPostExecute(String result) {
		   //ListDrwaer();
		  }
		 }// end async task
		 
		 public void accessWebService() {
		  JsonReadTask task = new JsonReadTask();
		  // passes values for the urls string array
		  task.execute(new String[] { url });
		 }
		 
		 // build hash set for list view
		 public void ListDrwaer() {
		 
//		  try {
		   //JSONObject jsonResponse = new JSONObject(jsonResult);
		   
		   //JSONArray jsonMainNode = jsonResponse.optJSONArray("emp_info");
		 
//		   for (int i = 0; i < jsonMainNode.length(); i++) {
//		    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
//		    String name = jsonChildNode.optString("employee name");
//		    String number = jsonChildNode.optString("employee no");
//		    String outPut = name + "-" + number;
//		    //employeeList.add(createEmployee("employees", outPut));
//		   }
//		  } catch (JSONException e) {
//		  }
		 
//		  SimpleAdapter simpleAdapter = new SimpleAdapter(this, employeeList,
//		    android.R.layout.simple_list_item_1,
//		    new String[] { "employees" }, new int[] { android.R.id.text1 });
//		  listView.setAdapter(simpleAdapter);
		 }
		 
//		 private HashMap<String, String> createEmployee(String name, String number) {
//		  HashMap<String, String> employeeNameNo = new HashMap<String, String>();
//		  employeeNameNo.put(name, number);
//		  return employeeNameNo;
//		 }
//		 
	
	

}





