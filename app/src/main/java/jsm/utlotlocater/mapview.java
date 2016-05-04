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

import org.w3c.dom.Text;

public class mapview extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;
    public enum Permit {
        C,Cplus, R, S, M, N, Nplus
    }
    private int currentPermit;
    private String lotname;
    private static final String TAG = "UTLotLocator";
    private String markerTitle;

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
        TextView p_title = (TextView) findViewById(R.id.p_title);
        TextView p_desc = (TextView) findViewById(R.id.p_desc);
        switch (currentPermit){
            case 1: // C
                p_title.setText(getString(R.string.cPermit));
                p_desc.setText(getString(R.string.cPermitDesc));
                break;
            case 2: // C+
                p_title.setText(getString(R.string.cplusPermit));
                p_desc.setText(getString(R.string.cplusPermitDesc));
                break;
            case 3: // R
                p_title.setText(getString(R.string.rPermit));
                p_desc.setText(getString(R.string.rPermitDesc));
                break;
            case 4: // S
                p_title.setText(getString(R.string.sPermit));
                p_desc.setText(getString(R.string.sPermitDesc));
                break;
            case 5: // M
                p_title.setText(getString(R.string.mPermit));
                p_desc.setText(getString(R.string.mPermitDesc));
                break;
            case 6: // N
                p_title.setText(getString(R.string.nPermit));
                p_desc.setText(getString(R.string.nPermitDesc));
                break;
            case 7: // N+
                p_title.setText(getString(R.string.nplusPermit));
                p_desc.setText(getString(R.string.nplusPermitDesc));
                break;
        }



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
//        if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == getPackageManager().PERMISSION_GRANTED)
        try {
            mMap.setMyLocationEnabled(true);
        }catch(SecurityException s) {
            return;
        }

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

                markerTitle = arg0.getTitle();

                // Setting the custom info window's image and title
                // One for each marker possibility
                if (markerTitle.equals(getString(R.string.l70_title))) {
                    pic.setImageResource(R.drawable.lot70);
                    title.setText(R.string.l70_title);
                    lotname = getString(R.string.clot);

                } else if (markerTitle.equals(getString(R.string.l37m_title))) {
                    pic.setImageResource(R.drawable.lot37m);
                    title.setText(R.string.l37m_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.l113_title))) {
                    pic.setImageResource(R.drawable.lot113);
                    title.setText(R.string.l113_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l37c_title))) {
                    pic.setImageResource(R.drawable.lot37c);
                    title.setText(R.string.l37c_title);
                    lotname = getString(R.string.clot);

                } else if (markerTitle.equals(getString(R.string.m21st_title))) {
                    pic.setImageResource(R.drawable.m21st);
                    title.setText(R.string.m21st_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.l35_title))) {
                    pic.setImageResource(R.drawable.lot35);
                    title.setText(R.string.l35_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l103_title))) {
                    pic.setImageResource(R.drawable.lot103);
                    title.setText(R.string.l103_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l104_title))) {
                    pic.setImageResource(R.drawable.lot104);
                    title.setText(R.string.l104_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l107_title))) {
                    pic.setImageResource(R.drawable.lot107);
                    title.setText(R.string.l107_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l108_title))) {
                    pic.setImageResource(R.drawable.lot108);
                    title.setText(R.string.l108_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l109_title))) {
                    pic.setImageResource(R.drawable.lot109);
                    title.setText(R.string.l109_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l110_title))) {
                    pic.setImageResource(R.drawable.lot110);
                    title.setText(R.string.l110_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l112_title))) {
                    pic.setImageResource(R.drawable.lot112);
                    title.setText(R.string.l112_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l114_title))) {
                    pic.setImageResource(R.drawable.lot114);
                    title.setText(R.string.l114_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l115_title))) {
                    pic.setImageResource(R.drawable.lot115);
                    title.setText(R.string.l115_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l116_title))) {
                    pic.setImageResource(R.drawable.lot116);
                    title.setText(R.string.l116_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l117_title))) {
                    pic.setImageResource(R.drawable.lot117);
                    title.setText(R.string.l117_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l118_title))) {
                    pic.setImageResource(R.drawable.lot118);
                    title.setText(R.string.l118_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.l119_title))) {
                    pic.setImageResource(R.drawable.lot119);
                    title.setText(R.string.l119_title);
                    lotname = getString(R.string.llot);

                } else if (markerTitle.equals(getString(R.string.brg_title))) {
                    pic.setImageResource(R.drawable.brg);
                    title.setText(R.string.brg_title);
                    lotname = getString(R.string.gbra);

                } else if (markerTitle.equals(getString(R.string.ccg_title))) {
                    pic.setImageResource(R.drawable.ccg);
                    title.setText(R.string.ccg_title);
                    lotname = getString(R.string.gconf);

                } else if (markerTitle.equals(getString(R.string.gug_title))) {
                    pic.setImageResource(R.drawable.gug);
                    title.setText(R.string.gug_title);
                    lotname = getString(R.string.gguad);

                } else if (markerTitle.equals(getString(R.string.mag_title))) {
                    pic.setImageResource(R.drawable.mag);
                    title.setText(R.string.mag_title);
                    lotname = getString(R.string.gman);

                } else if (markerTitle.equals(getString(R.string.sag_title))) {
                    pic.setImageResource(R.drawable.sag);
                    title.setText(R.string.sag_title);
                    lotname = getString(R.string.gsana);

                } else if (markerTitle.equals(getString(R.string.sjg_title))) {
                    pic.setImageResource(R.drawable.sjg);
                    title.setText(R.string.sjg_title);
                    lotname = getString(R.string.gsanj);

                } else if (markerTitle.equals(getString(R.string.swg_title))) {
                    pic.setImageResource(R.drawable.swg);
                    title.setText(R.string.swg_title);
                    lotname = getString(R.string.gswy);

                } else if (markerTitle.equals(getString(R.string.trg_title))) {
                    pic.setImageResource(R.drawable.trg);
                    title.setText(R.string.trg_title);
                    lotname = getString(R.string.gtrin);

                } else if (markerTitle.equals(getString(R.string.tsg_title))) {
                    pic.setImageResource(R.drawable.tsg);
                    title.setText(R.string.tsg_title);
                    lotname = getString(R.string.g27);

                } else if (markerTitle.equals(getString(R.string.mDk_title))) {
                    pic.setImageResource(R.drawable.mdk);
                    title.setText(R.string.mDk_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mRdm_title))) {
                    pic.setImageResource(R.drawable.mrdm);
                    title.setText(R.string.mRdm_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mTr_title))) {
                    pic.setImageResource(R.drawable.mtr);
                    title.setText(R.string.mTr_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mSw_title))) {
                    pic.setImageResource(R.drawable.msw);
                    title.setText(R.string.mSw_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.m27_title))) {
                    pic.setImageResource(R.drawable.m27);
                    title.setText(R.string.m27_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mWh_title))) {
                    pic.setImageResource(R.drawable.mwh);
                    title.setText(R.string.mWh_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mbur_title))) {
                    pic.setImageResource(R.drawable.mbur);
                    title.setText(R.string.mbur_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.m24_title))) {
                    pic.setImageResource(R.drawable.m24);
                    title.setText(R.string.m24_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mJes_title))) {
                    pic.setImageResource(R.drawable.mjes);
                    title.setText(R.string.mJes_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mSjc_title))) {
                    pic.setImageResource(R.drawable.msjc);
                    title.setText(R.string.mSjc_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mL70S_title))) {
                    pic.setImageResource(R.drawable.ml70s);
                    title.setText(R.string.mL70S_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mL70N_title))) {
                    pic.setImageResource(R.drawable.ml70n);
                    title.setText(R.string.mL70N_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mL118_title))) {
                    pic.setImageResource(R.drawable.lot118);
                    title.setText(R.string.mL118_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.m16_title))) {
                    pic.setImageResource(R.drawable.m16);
                    title.setText(R.string.m16_title);
                    lotname = getString(R.string.mot);

                } else if (markerTitle.equals(getString(R.string.mL116_title))) {
                    pic.setImageResource(R.drawable.ml116);
                    title.setText(R.string.mL116_title);
                    lotname = getString(R.string.mot);

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
                LatLng lot37c = new LatLng(30.283916, -97.728252);
                mMap.addMarker(new MarkerOptions().position(lot37c).title(getString(R.string.l37c_title)));
                if(currentPermit == 2) { // C+ specific
                    LatLng brg = new LatLng(30.280952, -97.736243);
                    mMap.addMarker(new MarkerOptions().position(brg).title(getString(R.string.brg_title)));
                    LatLng gug = new LatLng(30.279390, -97.743028);
                    mMap.addMarker(new MarkerOptions().position(gug).title(getString(R.string.gug_title)));
                    LatLng mag = new LatLng(30.282589, -97.731074);
                    mMap.addMarker(new MarkerOptions().position(mag).title(getString(R.string.mag_title)));
                    LatLng sag = new LatLng(30.288677, -97.742646);
                    mMap.addMarker(new MarkerOptions().position(sag).title(getString(R.string.sag_title)));
                    LatLng sjg = new LatLng(30.287743, -97.732849);
                    mMap.addMarker(new MarkerOptions().position(sjg).title(getString(R.string.sjg_title)));
                    LatLng swg = new LatLng(30.291188, -97.737120);
                    mMap.addMarker(new MarkerOptions().position(swg).title(getString(R.string.swg_title)));
                    LatLng trg = new LatLng(30.279104, -97.733862);
                    mMap.addMarker(new MarkerOptions().position(trg).title(getString(R.string.trg_title)));
                    LatLng tsg = new LatLng(30.291298, -97.738554);
                    mMap.addMarker(new MarkerOptions().position(tsg).title(getString(R.string.tsg_title)));
                }
                break;
            case 3:  // R and S
            case 4:
                LatLng brg = new LatLng(30.280952, -97.736243);
                mMap.addMarker(new MarkerOptions().position(brg).title(getString(R.string.brg_title)));
                LatLng ccg = new LatLng(30.281934, -97.740420);
                mMap.addMarker(new MarkerOptions().position(ccg).title(getString(R.string.ccg_title)));
                LatLng gug = new LatLng(30.279390, -97.743028);
                mMap.addMarker(new MarkerOptions().position(gug).title(getString(R.string.gug_title)));
                LatLng mag = new LatLng(30.282589, -97.731074);
                mMap.addMarker(new MarkerOptions().position(mag).title(getString(R.string.mag_title)));
                LatLng sag = new LatLng(30.288677, -97.742646);
                mMap.addMarker(new MarkerOptions().position(sag).title(getString(R.string.sag_title)));
                LatLng sjg = new LatLng(30.287743, -97.732849);
                mMap.addMarker(new MarkerOptions().position(sjg).title(getString(R.string.sjg_title)));
                LatLng swg = new LatLng(30.291188, -97.737120);
                mMap.addMarker(new MarkerOptions().position(swg).title(getString(R.string.swg_title)));
                LatLng trg = new LatLng(30.279104, -97.733862);
                mMap.addMarker(new MarkerOptions().position(trg).title(getString(R.string.trg_title)));
                LatLng tsg = new LatLng(30.291298, -97.738554);
                mMap.addMarker(new MarkerOptions().position(tsg).title(getString(R.string.tsg_title)));
                break;
            case 5:  // M
                LatLng lot37m = new LatLng(30.283475, -97.728240);
                mMap.addMarker(new MarkerOptions().position(lot37m).title(getString(R.string.l37m_title)));
                LatLng m21st = new LatLng(30.283606, -97.739193);
                mMap.addMarker(new MarkerOptions().position(m21st).title(getString(R.string.m21st_title)));
                LatLng mDk = new LatLng(30.287565, -97.728848);
                mMap.addMarker(new MarkerOptions().position(mDk).title(getString(R.string.mDk_title)));
                LatLng mRdm = new LatLng(30.287529, -97.729881);
                mMap.addMarker(new MarkerOptions().position(mRdm).title(getString(R.string.mRdm_title)));
                LatLng mTr = new LatLng(30.287846, -97.731615);
                mMap.addMarker(new MarkerOptions().position(mTr).title(getString(R.string.mTr_title)));
                LatLng mSw = new LatLng(30.289754, -97.736723);
                mMap.addMarker(new MarkerOptions().position(mSw).title(getString(R.string.mSw_title)));
                LatLng m27 = new LatLng(30.291578, -97.738141);
                mMap.addMarker(new MarkerOptions().position(m27).title(getString(R.string.m27_title)));
                LatLng mWh = new LatLng(30.290891, -97.739988);
                mMap.addMarker(new MarkerOptions().position(mWh).title(getString(R.string.mWh_title)));
                LatLng mBur = new LatLng(30.288603, -97.738115);
                mMap.addMarker(new MarkerOptions().position(mBur).title(getString(R.string.mbur_title)));
                LatLng m24 = new LatLng(30.287563, -97.740752);
                mMap.addMarker(new MarkerOptions().position(m24).title(getString(R.string.m24_title)));
                LatLng mJes = new LatLng(30.281469, -97.735616);
                mMap.addMarker(new MarkerOptions().position(mJes).title(getString(R.string.mJes_title)));
                LatLng mSjc = new LatLng(30.280634, -97.733674);
                mMap.addMarker(new MarkerOptions().position(mSjc).title(getString(R.string.mSjc_title)));
                LatLng mL70S = new LatLng(30.281080, -97.731058);
                mMap.addMarker(new MarkerOptions().position(mL70S).title(getString(R.string.mL70S_title)));
                LatLng mL70N = new LatLng(30.281644, -97.730954);
                mMap.addMarker(new MarkerOptions().position(mL70N).title(getString(R.string.mL70N_title)));
                LatLng mL118 = new LatLng(30.277802, -97.732050);
                mMap.addMarker(new MarkerOptions().position(mL118).title(getString(R.string.mL118_title)));
                LatLng m16 = new LatLng(30.279073, -97.743528);
                mMap.addMarker(new MarkerOptions().position(m16).title(getString(R.string.m16_title)));
                LatLng mL116 = new LatLng(30.287073, -97.723293);
                mMap.addMarker(new MarkerOptions().position(mL116).title(getString(R.string.mL116_title)));
                break;
            case 6:
                break;
            case 7: // N and N+
                LatLng brgN = new LatLng(30.280952, -97.736243);
                mMap.addMarker(new MarkerOptions().position(brgN).title(getString(R.string.brg_title)));
                LatLng gugN = new LatLng(30.279390, -97.743028);
                mMap.addMarker(new MarkerOptions().position(gugN).title(getString(R.string.gug_title)));
                LatLng magN = new LatLng(30.282589, -97.731074);
                mMap.addMarker(new MarkerOptions().position(magN).title(getString(R.string.mag_title)));
                LatLng sagN = new LatLng(30.288677, -97.742646);
                mMap.addMarker(new MarkerOptions().position(sagN).title(getString(R.string.sag_title)));
                LatLng sjgN = new LatLng(30.287743, -97.732849);
                mMap.addMarker(new MarkerOptions().position(sjgN).title(getString(R.string.sjg_title)));
                LatLng swgN = new LatLng(30.291188, -97.737120);
                mMap.addMarker(new MarkerOptions().position(swgN).title(getString(R.string.swg_title)));
                LatLng trgN = new LatLng(30.279104, -97.733862);
                mMap.addMarker(new MarkerOptions().position(trgN).title(getString(R.string.trg_title)));
                LatLng tsgN = new LatLng(30.291298, -97.738554);
                mMap.addMarker(new MarkerOptions().position(tsgN).title(getString(R.string.tsg_title)));
                break;
        }
        // add longhorn lot markers for all cases
        LatLng lot35 = new LatLng(30.282071, -97.727128);
        mMap.addMarker(new MarkerOptions().position(lot35).title(getString(R.string.l35_title)));
        LatLng lot113 = new LatLng(30.282140, -97.725518);
        mMap.addMarker(new MarkerOptions().position(lot113).title(getString(R.string.l113_title)));
        LatLng lot118 = new LatLng(30.278272, -97.731690);
        mMap.addMarker(new MarkerOptions().position(lot118).title(getString(R.string.l118_title)));
        LatLng lot108 = new LatLng(30.275395, -97.732232);
        mMap.addMarker(new MarkerOptions().position(lot108).title(getString(R.string.l108_title)));
        LatLng lot104 = new LatLng(30.279697, -97.727748);
        mMap.addMarker(new MarkerOptions().position(lot104).title(getString(R.string.l104_title)));
        LatLng lot117 = new LatLng(30.279651, -97.724946);
        mMap.addMarker(new MarkerOptions().position(lot117).title(getString(R.string.l117_title)));
        LatLng lot119 = new LatLng(30.279600, -97.723572);
        mMap.addMarker(new MarkerOptions().position(lot119).title(getString(R.string.l119_title)));
        LatLng lot115 = new LatLng(30.280945, -97.723810);
        mMap.addMarker(new MarkerOptions().position(lot115).title(getString(R.string.l115_title)));
        LatLng lot109 = new LatLng(30.281384, -97.724809);
        mMap.addMarker(new MarkerOptions().position(lot109).title(getString(R.string.l109_title)));
        LatLng lot114 = new LatLng(30.281816, -97.724248);
        mMap.addMarker(new MarkerOptions().position(lot114).title(getString(R.string.l114_title)));
        LatLng lot110 = new LatLng(30.282708, -97.724149);
        mMap.addMarker(new MarkerOptions().position(lot110).title(getString(R.string.l110_title)));
        LatLng lot112 = new LatLng(30.283009, -97.725839);
        mMap.addMarker(new MarkerOptions().position(lot112).title(getString(R.string.l112_title)));
        LatLng lot116 = new LatLng(30.287014, -97.723543);
        mMap.addMarker(new MarkerOptions().position(lot116).title(getString(R.string.l116_title)));
        LatLng lot107 = new LatLng(30.286022, -97.724440);
        mMap.addMarker(new MarkerOptions().position(lot107).title(getString(R.string.l107_title)));
        LatLng lot103 = new LatLng(30.281119, -97.726136);
        mMap.addMarker(new MarkerOptions().position(lot103).title(getString(R.string.l103_title)));
        // move camera to central point
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CenterPt, 14));
    }

    @Override
    public void onInfoWindowClick(Marker marker){
//        Toast.makeText(mapview.this, "Future location of lot info page", Toast.LENGTH_SHORT).show();
        Intent infoIntent = new Intent(mapview.this, MessagingActivity.class);
        String mesg = "lotname = " + lotname;
        Log.d(TAG, mesg);
        infoIntent.putExtra("name", lotname);
        infoIntent.putExtra("markerTitle", markerTitle);
        startActivity(infoIntent);
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
