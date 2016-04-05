package jsm.utlotlocater;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapview extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    public enum Permit {
        C,Cplus, R, S, M, N, Nplus
    }
    private int currentPermit;
    private static final String TAG = "UTLotLocator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapview);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        // As of now, this line crashes the app when MapView is called.
        currentPermit = intent.getIntExtra("permitType", 1);



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng CenterPt = new LatLng(30.285218, -97.732760);
        mMap.setOnInfoWindowClickListener(this);

        // info window adapter
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            // Use default InfoWindow frame
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            // Defines the contents of the InfoWindow
            @Override
            public View getInfoContents(Marker arg0) {

                // Getting view from the layout file info_window_layout
                View v = getLayoutInflater().inflate(R.layout.custom_info_window, null);

                ImageView pic = (ImageView) v.findViewById(R.id.infoImage);
                TextView title = (TextView) v.findViewById(R.id.infoTitle);

                String markerTitle = arg0.getTitle();

                // Setting the custom info window's image and title
                // One for each marker possibility (minus each marker copy
                //                                  e.g. lot113 is used twice)
                if (markerTitle.equals(getString(R.string.l70_title))) {
                    pic.setImageResource(R.drawable.lot70);
                    title.setText(R.string.l70_title);

                } else if (markerTitle.equals(getString(R.string.l37m_title))) {
                    pic.setImageResource(R.drawable.lot37m);
                    title.setText(R.string.l37m_title);

                } else if (markerTitle.equals(getString(R.string.l113_title))) {
                    pic.setImageResource(R.drawable.lot113);
                    title.setText(R.string.l113_title);

                } else if (markerTitle.equals(getString(R.string.l37c_title))) {
                    pic.setImageResource(R.drawable.lot37c);
                    title.setText(R.string.l37c_title);

                } else if (markerTitle.equals(getString(R.string.m21st_title))) {
                    pic.setImageResource(R.drawable.m21st);
                    title.setText(R.string.m21st_title);

                } else if (markerTitle.equals(getString(R.string.l35_title))) {
                    pic.setImageResource(R.drawable.lot35);
                    title.setText(R.string.l35_title);

                }

                // Returning the view containing InfoWindow contents
                return v;

            }
        }); // end info window adapter

        // switch case for markers
        switch (currentPermit) {
            case 1:
            case 2: // C and C+
                LatLng lot70c = new LatLng(30.281352, -97.730823);
                mMap.addMarker(new MarkerOptions().position(lot70c).title(getString(R.string.l70_title)));
                LatLng lot113c = new LatLng(30.282140, -97.725518);
                mMap.addMarker(new MarkerOptions().position(lot113c).title(getString(R.string.l113_title)));
                LatLng lot37c = new LatLng(30.283916, -97.728252);
                mMap.addMarker(new MarkerOptions().position(lot37c).title(getString(R.string.l37c_title)));
                break;
//            case 3:  // R
//                break;
//            case 4:  // S
//                break;
            case 5:  // M
                LatLng lot37m = new LatLng(30.283475, -97.728240);
                mMap.addMarker(new MarkerOptions().position(lot37m).title(getString(R.string.l37m_title)));
                LatLng m21st = new LatLng(30.283606, -97.739193);
                mMap.addMarker(new MarkerOptions().position(m21st).title(getString(R.string.m21st_title)));
                break;
            case 6:
            case 7: // N and N+
                LatLng lot113 = new LatLng(30.282140, -97.725518);
                mMap.addMarker(new MarkerOptions().position(lot113).title(getString(R.string.l113_title)));
                LatLng lot35 = new LatLng(30.282071, -97.727128);
                mMap.addMarker(new MarkerOptions().position(lot35).title(getString(R.string.l35_title)));
                break;
        }
        // move camera to central point
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CenterPt, 14));
    }

    @Override
    public void onInfoWindowClick(Marker marker){
        Toast.makeText(mapview.this, "Future location of lot info page", Toast.LENGTH_SHORT).show();

    }

//    @Override
//    public boolean onMarkerClick(Marker marker) {
//        // Use a specific layout (some_layout.xml) for this activity
//        setContentView(R.layout.custom_info_window);
//
//        ImageView pic = (ImageView) findViewById(R.id.infoImage);
//
//
//        return false;
//    }
}
