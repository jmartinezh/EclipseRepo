package com.example.aulabuap1;
import com.example.Controlador.*;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		
		
		final Button button = (Button) findViewById(R.id.button1);
		final EditText usr = (EditText) findViewById(R.id.editText1);
		final EditText pass = (EditText) findViewById(R.id.editText2);
		final TextView reg = (TextView) findViewById(R.id.textView1);
		
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	ControlUno nuevo = new ControlUno();
            	String nombre = nuevo.login(usr.getText().toString(), pass.getText().toString());
            	if(nombre.equals("error")){
            		
            	}else if(nombre.equals("null")){
            		
            	}else{
            		
            		setContentView(R.layout.horario);
            		
              	}
            	
            	
            	
            }
        });
        
        
        reg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {			
				Intent inten = new Intent();
				inten.setClass(getApplicationContext(), Registro.class);
				startActivity(inten);
       		 
				
			}
		});
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
