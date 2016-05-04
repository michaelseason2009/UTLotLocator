package jsm.utlotlocater;

import android.app.ListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class ListLotsActivity extends ListActivity {

    private String username;
    private TextView testText;
    private Firebase mFirebaseRef;
    private LotListAdaptor mLotListAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lots);

        mFirebaseRef = new Firebase("https://utlotlocator.firebaseio.com/").child("lots");

        Intent intent = getIntent();
        username = intent.getStringExtra("name");
        testText = (TextView) findViewById(R.id.textView3);
        testText.setText("Username:" + username);

    }

    public void onStart() {
        super.onStart();
        // Setup our view and list adapter. Ensure it scrolls to the bottom as data changes
        final ListView listView = getListView();
        // Tell our list adapter that we only want 50 messages at a time
        mLotListAdaptor = new LotListAdaptor(mFirebaseRef, this, R.layout.user_list_item, username);
        listView.setAdapter(mLotListAdaptor);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                LotListEntry entry=  (LotListEntry)parent.getAdapter().getItem(position);
                String lotname =entry.getLotName();
                Toast.makeText(getApplicationContext(), lotname, Toast.LENGTH_SHORT).show();
                Intent messageIntent = new Intent(ListLotsActivity.this, MessagingActivity.class);
                messageIntent.putExtra("name", lotname);
                messageIntent.putExtra("username", username);
                startActivity(messageIntent);
            }
        });
    }

}
