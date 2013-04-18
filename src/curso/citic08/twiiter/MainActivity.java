package curso.citic08.twiiter;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.*;

import com.loopj.android.http.JsonHttpResponseHandler;

import curso.citic08.twiiter.client.TwitterRestClient;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {
	private final static String TAG = "MAIN";
	
	private ArrayList<String> tweets = new ArrayList<String>();
	Context context = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		
		try {
			getPublicTimeline();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
    public void getPublicTimeline() throws JSONException {
    	Log.d(TAG, "Send Request");
        TwitterRestClient.get("statuses/user_timeline/pabloformoso.json", null, new JsonHttpResponseHandler() {

        });
    }	

}
