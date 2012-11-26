package nz.co.iknowtech.vantastic;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class Airport_table extends TabActivity {
	public void onCreate(Bundle savedInstancestate) {
		super.onCreate(savedInstancestate);
	/*	setContentView(R.layout.airport_table); */
		setContentView(R.layout.airport);
		
		Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost    
        TabHost.TabSpec spec;  // Reusable TabSpec for each tab    
        Intent intent;  // Reusable Intent for each tab    
        
        // Create an Intent to launch an Activity for the tab (to be reused) 
        intent = new Intent().setClass(this, Auckland.class);   
        
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("auckland").setIndicator("Auckland",
        		res.getDrawable(R.drawable.icon))   
        		.setContent(intent);  
        		tabHost.addTab(spec);    
        // Do the same for the other tabs    
        intent = new Intent().setClass(this, Wellington.class); 
        spec = tabHost.newTabSpec("wellington").setIndicator("Wellington",       
        			res.getDrawable(R.drawable.icon))             
        		.setContent(intent);   
        tabHost.addTab(spec); 
        tabHost.setCurrentTab(2);
	}
}
