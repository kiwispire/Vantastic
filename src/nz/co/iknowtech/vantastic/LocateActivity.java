package nz.co.iknowtech.vantastic;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;


public class LocateActivity extends MapActivity {
	
	MapView map;
	MapController mControl;
	final GeoPoint curloc = null; 
	LocationManager locationManager;
	LocationListener locationListener;
	Toast toast;
	
	@Override 
	public void onCreate(Bundle savedInstanceState) { 
	    super.onCreate(savedInstanceState); 
	    setContentView(R.layout.locate);
	    
	    map = (MapView) findViewById(R.id.mapview);
	    map.displayZoomControls(true);
	    map.setBuiltInZoomControls(true);
	    
	    Context context = getApplicationContext();
	    CharSequence text = "Obtaining current location";
	    int duration = Toast.LENGTH_SHORT;

	    Toast toast = Toast.makeText(context, text, duration);
	    toast.show();   
	    
		map.getController().animateTo(curloc);
		map.getController().setZoom(18);
		
	 // Location Listener Block
		// Acquire a reference to the system Location Manager 
		LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE); 
		
		// Define a listener that responds to location updates 
		LocationListener locationListener = new LocationListener() {

			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				// Add Overlay Items
//				Gathers the current location and updates the map
				int lat = (int) (location.getLatitude() * 1E6);
				int lng = (int) (location.getLongitude() * 1E6);
				
				GeoPoint curloc = new GeoPoint (lat, lng);
				map.getController().animateTo(curloc);
			}

			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}		  
		  }; 
		 		  
		// Register the listener with the Location Manager to receive location updates 
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 0, locationListener);
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0, locationListener);
		
// Map Overlay Code
		List<Overlay> mapOverlays = map.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.icon);
		LocationOverlay itemizedoverlay = new LocationOverlay(drawable, this);
		
		GeoPoint Hardinge = new GeoPoint(-36847474,174758247);
		OverlayItem overlayitem = new OverlayItem(Hardinge, "Hardinge St", "Outside the Hardinge St main entrance. (opposite NZ Post)");
		
		GeoPoint Wyndham = new GeoPoint(-36846701,174762849);
		OverlayItem overlaywyndham = new OverlayItem(Wyndham, "Wyndham St", "Outside the main entrance 66 Wyndham St.");
		
		GeoPoint Airedale = new GeoPoint(-36854627,174764559);
		OverlayItem overlayairedale = new OverlayItem(Airedale, "Airedale St", "Pickup location is outside 31 Airedale St.");
	
		itemizedoverlay.addOverlay(overlayitem);
		itemizedoverlay.addOverlay(overlaywyndham);
		itemizedoverlay.addOverlay(overlayairedale);
		mapOverlays.add(itemizedoverlay);
	}
	
	@Override
	public void onPause(){
		super.onPause();
		if (locationListener !=null){
		locationManager.removeUpdates(locationListener);
		}
//		Toast.makeText(this, "Pause", Toast.LENGTH_SHORT);
//		locationManager.removeUpdates((LocationListener) this);		
	}
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}