package nz.co.iknowtech.vantastic;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class Airport extends TabActivity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.airport_layout2);
        
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost    
        TabHost.TabSpec spec;  // Reusable TabSpec for each tab    
        Intent intent;  // Reusable Intent for each tab    
        
        // Create an Intent to launch an Activity for the tab (to be reused) 
        intent = new Intent().setClass(this, Auckland.class);   
        
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("auckland").setIndicator("Tab1",
        		res.getDrawable(R.drawable.icon))   
        		.setContent(intent);  
        		tabHost.addTab(spec);    
        // Do the same for the other tabs    
        intent = new Intent().setClass(this, Wellington.class); 
        spec = tabHost.newTabSpec("wellington").setIndicator("Tab2",       
        			res.getDrawable(R.drawable.icon))             
        		.setContent(intent);   
        tabHost.addTab(spec);  
        tabHost.setCurrentTab(2);
    }
}
