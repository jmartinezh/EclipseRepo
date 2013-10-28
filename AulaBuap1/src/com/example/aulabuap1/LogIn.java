package com.example.aulabuap1;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class LogIn extends android.support.v4.app.FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	setContentView(R.layout.horario);
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
