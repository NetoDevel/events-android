package netodevel.com.br.events_android;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by neto on 18/08/17.
 */
public class SendVideoTask extends AsyncTask<String, Void, String> {

    private EventSingleton eventSingleton;
    private Context mContext;
    private AppPreferences appPreferences;

    public SendVideoTask(Context context) {
        this.mContext = context;
        this.appPreferences = new AppPreferences(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        appPreferences.putBoolean("PROGRESS", true);
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "done";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        appPreferences.putBoolean("PROGRESS", false);
        eventSingleton = EventSingleton.getInstance();
        eventSingleton.emitterDone();
    }

}
