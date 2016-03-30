package jsm.utlotlocater;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class permitselector extends AppCompatActivity {

    private static final String TAG = "UTLotLocator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permitselector);
        Log.d(TAG, "in onCreate");

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.permit_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
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
