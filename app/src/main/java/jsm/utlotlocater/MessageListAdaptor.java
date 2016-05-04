package jsm.utlotlocater;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Query;

/**
 * Created by Jimny on 5/3/2016.
 */
public class MessageListAdaptor extends FirebaseListAdapter<message> {
    private String mUsername;

    public MessageListAdaptor(Query ref, Activity activity, int layout, String mUsername) {
        super(ref, message.class, layout, activity);
        this.mUsername = mUsername;
    }

    protected void populateView(View view, message message) {
        // Map a Chat object to an entry in our listview
        String username = message.getUsername();
        TextView selfText = (TextView) view.findViewById(R.id.author);
        selfText.setText(username + ": ");
        // If the message was sent by this user, color it differently
        if (mUsername != null && username.equals(mUsername)) {
            selfText.setTextColor(Color.RED);
        } else {
            selfText.setTextColor(Color.BLUE);
        }
        ((TextView) view.findViewById(R.id.message)).setText(message.getMessage());
    }

}
