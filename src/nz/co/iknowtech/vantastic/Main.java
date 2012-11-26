package nz.co.iknowtech.vantastic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Main extends Activity {
	/** Called when the activity is first created. */
	ImageButton Button_InterOffice;
	ImageButton Button_Airport;
	ImageButton Button_FindShuttle;
	ImageButton Button_Contact;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlayout);
        
        Button_InterOffice = (ImageButton)findViewById(R.id.InterOfficeButton);
        Button_Airport = (ImageButton)findViewById(R.id.AirportButton);
        Button_Contact = (ImageButton)findViewById(R.id.ContactButton);
        
        
        Button_InterOffice.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {  	
        		Intent myIntent = new Intent(Main.this,InterOfficeTable.class);
        		startActivity(myIntent);
        	}
        });
        
        Button_Airport.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {  	
        		Intent myIntent = new Intent(Main.this,Airport_table.class);
        		startActivity(myIntent);
        	}
        });
      
/**        Button_FindShuttle.setOnClickListener(new OnClickListener() {
        	@Override
        	public void onClick(View v) {  	
        		Intent myIntent = new Intent(Main.this,Table.class);
        		startActivity(myIntent);
        	}
        });
*/
        Button_Contact.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {  	
        		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        		emailIntent.setType("plain/text"); 
        		
        		String Email[] = { "robert.donaldson@iknowtech.co.nz" };  
        		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, Email);
        		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Query Re: VANTASTIC");   
           		  
        		startActivity(Intent.createChooser(emailIntent, "Send your email in:"));    
        	}
        });
	}
/*	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {  
		MenuInflater inflater = getMenuInflater();  
		inflater.inflate(R.menu.main_menu, menu);
		return true;
		}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		// What to do when item in menu is selected
		switch (item.getItemId()) {
		case R.id.changelog:
			Intent myIntent = new Intent(Main.this,Changelog.class);
    		startActivity(myIntent);
			return true;
		case R.id.AK_pickups:
			Intent myIntent2 = new Intent(Main.this,InterOfficePickup.class);
    		startActivity(myIntent2);
			return true;
		default:
			return onOptionsItemSelected(item);
		}
	}
*/
}
	