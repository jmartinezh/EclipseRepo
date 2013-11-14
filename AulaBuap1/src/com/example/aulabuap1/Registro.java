package com.example.aulabuap1;
import com.example.Controlador.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Registro extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registro);
		
		
		final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.carrerasfcc, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
		
		final Button aceptar = (Button) findViewById(R.id.button1);
		final EditText txtNombre = (EditText) findViewById(R.id.editText2);
		final EditText txtApellidos = (EditText) findViewById(R.id.editText3);
		final EditText txtCorreo = (EditText) findViewById(R.id.editText5);
		final EditText txtMatricula = (EditText) findViewById(R.id.editText1);
		final EditText txtPass = (EditText) findViewById(R.id.editText6);
		
		aceptar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ControlUno nuevo = new ControlUno();
            	String nombre = nuevo.registrarse(txtMatricula.getText().toString(), 
            			txtPass.getText().toString(), txtCorreo.getText().toString(),
            			spinner.getSelectedItem().toString(), txtApellidos.getText().toString(), 
            			txtNombre.getText().toString());
            	
            	
            		Toast toast = Toast.makeText(getApplicationContext(), nombre, Toast.LENGTH_SHORT);
            		toast.show();
            		
              	
				
				
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
