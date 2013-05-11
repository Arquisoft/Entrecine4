package com.entrecine4.expendedorentrecine;

//import models.Purchase;

//import com.entrecine4.infraestructure.Factories;

import models.Purchase;

import com.entrecine4.infraestructure.Factories;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try {
            Button btEscanear = (Button)findViewById(R.id.btEscanear);
            btEscanear.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                    intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                    startActivityForResult(intent, 0);
					
				}
			});
		
		
	} catch (ActivityNotFoundException anfe) {
        Log.e("onCreate", "Scanner Not Found", anfe);
    }	

		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                // Marcamos el ticket como recogido usando la API
                Purchase ticket = Factories.services.createPurchasesService().findByTicketCode(contents);
                if(ticket == null){
                	// Sacamos un mensaje de error y no pasamos a la activity final
                	 Toast toast = Toast.makeText(this, "No existe un ticket con ese código", Toast.LENGTH_LONG);
                     
                     toast.show();
                }
                else{
                	if(ticket.getPaid() == 1){
                		if(ticket.getCollected() == 1){
                			Toast toast = Toast.makeText(this, "Ya se ha recogido esa entrada", Toast.LENGTH_LONG);
                            
                            toast.show();
                		}
                		else{
                	ticket.setCollected(1);
                	Factories.services.createPurchasesService().savePurchase(ticket);
                	// Todo funciona. Entregar entrada
                	 
                   Intent i  = new Intent(getApplicationContext(), TicketActivity.class);
                    startActivity(i);
                		}
                	} else{
                		// La entrada no se había pagado por lo que hay que advertir y no continuar
                		Toast toast = Toast.makeText(this, "La entrada no figura como pagada", Toast.LENGTH_LONG);
                        
                        toast.show();
                	}
                }
                	
                
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Toast toast = Toast.makeText(this, "Scan was Cancelled!", Toast.LENGTH_LONG);
               
                toast.show();
                
            }
        }
    }

}
