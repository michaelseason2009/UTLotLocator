package jsm.utlotlocater;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class permitselector extends AppCompatActivity {

    private static final String TAG = "UTLotLocator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permitselector);

        Log.d(TAG, "in onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "in onPause");
    }//end onPause override method

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "in onStop");
    }//end onStop override method

}
