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

                switch (arg0.getTitle()) {
                    case "Lot 70":
                        pic.setImageResource(R.drawable.lot70);
                        break;
//                    case "Lot 37 Motorcycle Spots":
//                        pic.setImageResource();
//                        break;
                }

                // Returning the view containing InfoWindow contents
                return v;

            }
        }); // end info window adapter

        // switch case for markers
        switch (currentPermit) {
            case 1:
            case 2: // C and C+
                LatLng lot70 = new LatLng(30.281352, -97.730823);
                Marker mLot70 = mMap.addMarker(new MarkerOptions().position(lot70).title("Lot 70"));


                break;
//            case 3:  // R
//                break;
//            case 4:  // S
//                LatLng lot70 = new LatLng(30.281352, -97.730823);
//                mMap.addMarker(new MarkerOptions().position(lot70).title("Lot 70"));
//                break;
            case 5:  // M
                LatLng lot37m = new LatLng(30.283475, -97.728240);
                mMap.addMarker(new MarkerOptions().position(lot37m).title("Lot 37 Motorcycle Spots"));
//                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lot37m, 15));
                break;
            case 6:
            case 7:
                LatLng lot113 = new LatLng(30.282140, -97.725518);
                mMap.addMarker(new MarkerOptions().position(lot113).title("Lot 113"));
//                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lot113, 15));
                break;
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CenterPt, 15));



        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(lot70));
    }

    @Override
    public void onInfoWindowClick(Marker marker){
        Toast.makeText(mapview.this, "This is working!", Toast.LENGTH_SHORT).show();

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
