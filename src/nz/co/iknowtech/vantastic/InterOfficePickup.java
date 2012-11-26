package nz.co.iknowtech.vantastic;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class InterOfficePickup extends MapActivity {
	List<Overlay> mapOverlays;
	Drawable drawable;
	MapView mapView;
	
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.interofficepickup);
	    MapView mapView = (MapView) findViewById(R.id.mapview);
	    mapView.setBuiltInZoomControls(true);
	    
	    /*	
		GeoPoint point = new GeoPoint(-36846637, 174762947);
		OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
		
		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);
		
		GeoPoint Victoria = new GeoPoint(-36847414, 174758041);
		OverlayItem overlayitem2 = new OverlayItem(Victoria, "Victoria St", "Outside Hardinge St main entrance (in front of NZpost)");
		itemizedoverlay.addOverlay(overlayitem2);
		mapOverlays.add(overlayitem2);
		
		GeoPoint Airedale = new GeoPoint(-36854595, 174764565);
		OverlayItem overlayitem3 = new OverlayItem(Airedale, "Airedale St", "Directly outside the Mayoral Drive exchange building at 35 Airedale St");
		itemizedoverlay.addOverlay(overlayitem3);
		mapOverlays.add(itemizedoverlay);
		
		GeoPoint Wyndham = new GeoPoint(-36846637, 174762947);
		OverlayItem overlayitem4 = new OverlayItem(Wyndham, "Wyndham St", "Outside main entrance 66 Wyndham St");
		itemizedoverlay.addOverlay(overlayitem4);
		mapOverlays.add(itemizedoverlay);
*/
		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		// Define a listener that responds to location updates
		LocationListener locationListener = new LocationListener() {
			public void onLocationChanged(Location location) {
			// Called when a new location is found by the network location provider.
			// makeUseOfNewLocation(location);
		}
		public void onStatusChanged(String provider, int status, Bundle extras) {}    
		public void onProviderEnabled(String provider) {}    
		public void onProviderDisabled(String provider) {}
		
		};
		 
		String locationProvider = LocationManager.NETWORK_PROVIDER;
		// Or, use GPS location data:
		// LocationProvider locationProvider = LocationManager.GPS_PROVIDER;			
		locationManager.requestLocationUpdates(locationProvider, 0, 0, locationListener);
		
		// Register the listener with the Location Manager to receive location updates
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10, 0, locationListener);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, locationListener);
		
		
		// Remove the listener you previously added
		locationManager.removeUpdates(locationListener);
		
	}
	
	public void onResume(){
		// MyLocationOverlay();
	}
}