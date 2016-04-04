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

    public enum Permit {
        C, Cplus, R, S, M, N, Nplus
    }

    private static final String TAG = "UTLotLocator";

    private RadioButton mC, mCplus, mR, mS, mM, mN, mNplus;
    private RadioButton mRadioButtonPermit;
    private RadioGroup mRadioGroupPermit;
    private TextView mTestText;
    private Button mButton;
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
//        mR = (RadioButton) findViewById(R.id.R_Permit);
//        mS = (RadioButton) findViewById(R.id.S_permit);
        mM = (RadioButton) findViewById(R.id.M_permit);
        mN = (RadioButton) findViewById(R.id.N_permit);
        mNplus = (RadioButton) findViewById(R.id.Nplus_permit);
        mTestText = (TextView) findViewById(R.id.testText);
        mButton = (Button) findViewById(R.id.button);

        //set default permit type
        permitType = 1;

        //testing for selection
        mRadioGroupPermit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int selected) {
                if (selected == R.id.C_permit) {
                    Toast.makeText(getApplicationContext(), "choice: C", Toast.LENGTH_SHORT).show();
//                    permitType = Permit.C;
                    permitType = 1;
                } else if (selected == R.id.Cplus_permit) {
                    Toast.makeText(getApplicationContext(), "choice: C+", Toast.LENGTH_SHORT).show();
                    permitType = 2;
//                } else if (selected == R.id.R_Permit) {
//                    Toast.makeText(getApplicationContext(), "choice: R", Toast.LENGTH_SHORT).show();
//                    permitType = 3;
//                } else if (selected == R.id.S_permit) {
//                    Toast.makeText(getApplicationContext(), "choice: S", Toast.LENGTH_SHORT).show();
//                    permitType = 4;
                } else if (selected == R.id.M_permit) {
                    Toast.makeText(getApplicationContext(), "choice: M", Toast.LENGTH_SHORT).show();
                    permitType = 5;
                } else if (selected == R.id.N_permit) {
                    Toast.makeText(getApplicationContext(), "choice: N", Toast.LENGTH_SHORT).show();
                    permitType = 6;
                } else { // R.id.Nplus_permit
                    Toast.makeText(getApplicationContext(), "choice: N+", Toast.LENGTH_SHORT).show();
                    permitType = 7;
                }
            }

        });


        //listen for the button and go to the map activity
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = mRadioGroupPermit.getCheckedRadioButtonId();
                mRadioButtonPermit = (RadioButton) findViewById(selectedId);
                mTestText.setText(mRadioButtonPermit.getText());
                Toast.makeText(permitselector.this, mRadioButtonPermit.getText(), Toast.LENGTH_SHORT).show();
                //go to the mapsIntent
                Intent mapIntent = new Intent(v.getContext(), mapview.class);
                mapIntent.putExtra("permitType", permitType);
                startActivity(mapIntent);
            }
        });
        //Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.permit_array, android.R.layout.simple_spinner_item);
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        // Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
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

    //radio group selector code
//    public void onRadioButtonClicked(View view) {
//        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        // Check which radio button was clicked
//        switch(view.getId()) {
//            case R.id.C_permit:
//                if (checked)
//                    Log.d(TAG, "C");
//                    break;
//            case R.id.Cplus_permit:
//                if (checked)
//                    Log.d(TAG, "C+");
//                    break;
//            case R.id.R_Permit:
//                if (checked)
//                    Log.d(TAG, "R");
//                    break;
//            case R.id.S_permit:
//                if (checked)
//                    Log.d(TAG, "S");
//                    break;
//            case R.id.M_permit:
//                if (checked)
//                    Log.d(TAG, "M");
//                    break;
//            case R.id.N_permit:
//                if (checked)
//                    Log.d(TAG, "N");
//                    break;
//            case R.id.Nplus_permit:
//                if (checked)
//                    Log.d(TAG, "N+");
//                    break;
//        }
//    }
}
