package jsm.utlotlocater;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class permitselector extends AppCompatActivity {

    private static final int C_PERMIT = 1;
    private static final int CPLUS_PERMIT = 2;
    private static final int R_PERMIT = 3;
    private static final int S_PERMIT = 4;
    private static final int M_PERMIT = 5;
    private static final int N_PERMIT = 6;
    private static final int NPLUS_PERMIT = 7;

    private static final String TAG = "UTLotLocator";

    private RadioButton mC, mCplus, mR, mS, mM, mN, mNplus;
    private RadioButton mRadioButtonPermit;
    private RadioGroup mRadioGroupPermit;
//    private TextView mTestText;
    private Button mButton;
    // switched to ints for ease of use with intents
//    private Permit permitType;
    private int permitType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permitselector);
        Log.d(TAG, "in onCreate");
        //connect the radio group and buttons
        mRadioGroupPermit = (RadioGroup) findViewById(R.id.radioGroup);
        mC = (RadioButton) findViewById(R.id.C_permit);
        mCplus = (RadioButton) findViewById(R.id.Cplus_permit);
        mR = (RadioButton) findViewById(R.id.R_Permit);
        mS = (RadioButton) findViewById(R.id.S_permit);
        mM = (RadioButton) findViewById(R.id.M_permit);
        mN = (RadioButton) findViewById(R.id.N_permit);
        mNplus = (RadioButton) findViewById(R.id.Nplus_permit);
//        mTestText = (TextView) findViewById(R.id.testText);
        mButton = (Button) findViewById(R.id.button);

        //set default permit type
        permitType = C_PERMIT;  // C permit by default

        //testing for selection
        mRadioGroupPermit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int selected) {
                if (selected == R.id.C_permit) {
                    Toast.makeText(getApplicationContext(), "choice: C", Toast.LENGTH_SHORT).show();
//                    permitType = Permit.C;
                    permitType = C_PERMIT;
                } else if (selected == R.id.Cplus_permit) {
                    Toast.makeText(getApplicationContext(), "choice: C+", Toast.LENGTH_SHORT).show();
                    permitType = CPLUS_PERMIT;
                } else if (selected == R.id.R_Permit) {
                    Toast.makeText(getApplicationContext(), "choice: R", Toast.LENGTH_SHORT).show();
                    permitType = R_PERMIT;
                } else if (selected == R.id.S_permit) {
                    Toast.makeText(getApplicationContext(), "choice: S", Toast.LENGTH_SHORT).show();
                    permitType = S_PERMIT;
                } else if (selected == R.id.M_permit) {
                    Toast.makeText(getApplicationContext(), "choice: M", Toast.LENGTH_SHORT).show();
                    permitType = M_PERMIT;
                } else if (selected == R.id.N_permit) {
                    Toast.makeText(getApplicationContext(), "choice: N", Toast.LENGTH_SHORT).show();
                    permitType = N_PERMIT;
                } else { // R.id.Nplus_permit
                    Toast.makeText(getApplicationContext(), "choice: N+", Toast.LENGTH_SHORT).show();
                    permitType = NPLUS_PERMIT;
                }
            }

        });


        //listen for the button and go to the map activity
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = mRadioGroupPermit.getCheckedRadioButtonId();
                mRadioButtonPermit = (RadioButton) findViewById(selectedId);
//                mTestText.setText(mRadioButtonPermit.getText());
                Toast.makeText(permitselector.this, mRadioButtonPermit.getText(), Toast.LENGTH_SHORT).show();
                //go to the mapsIntent
                Intent mapIntent = new Intent(v.getContext(), mapview.class);
                mapIntent.putExtra("permitType", permitType);
                startActivity(mapIntent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "in onPause");
    }//end onPause override method

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "in onResume");
    }//end onResume override method

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "in onStop");
    }//end onStop override method

}
