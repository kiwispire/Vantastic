package nz.co.iknowtech.vantastic;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class MyLocationItemizedOverlay extends ItemizedOverlay {
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	
	public MyLocationItemizedOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker))	;
		// TODO Auto-generated constructor stub
	}

	public void addOverlay(OverlayItem overlay) {
		mOverlays.add(overlay); 
		populate();
	}
	
	@Override
	protected OverlayItem createItem(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
