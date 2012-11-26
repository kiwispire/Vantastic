package nz.co.iknowtech.vantastic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class InterOfficeTable extends Activity {
	public void onCreate(Bundle savedInstancestate) {
		super.onCreate(savedInstancestate);
		setContentView(R.layout.interoffice_table2);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {  
		MenuInflater inflater = getMenuInflater();  
		inflater.inflate(R.menu.auckland_menu, menu);
		return true;
		}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		// What to do when item in menu is selected
		switch (item.getItemId()) {
		case R.id.AK_pickups:
			Intent myIntent = new Intent(this,LocateActivity.class);
    		startActivity(myIntent);
			return true;
		default:
			return onOptionsItemSelected(item);
		}
	}
}