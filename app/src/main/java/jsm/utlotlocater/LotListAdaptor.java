package jsm.utlotlocater;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Query;

/**
 * Created by Jimny on 5/3/2016.
 */
public class LotListAdaptor  extends FirebaseListAdapter<LotListEntry>{
    private String lotName;

    public LotListAdaptor(Query ref, Activity activity, int layout, String mlotName) {
        super(ref, LotListEntry.class, layout, activity);
        this.lotName = mlotName;
    }

    @Override
    protected void populateView(View view, LotListEntry lot) {
        // Map a Chat object to an entry in our listview
        String name = lot.getLotName();
        TextView lotEntry = (TextView) view.findViewById(R.id.userListItem);
        lotEntry.setText(name);
        // If the message was sent by this user, color it differently
    }
}
