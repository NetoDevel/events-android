package netodevel.com.br.events_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FeedActivity extends AppCompatActivity {

    private EventSingleton eventSingleton;
    private Button btnSendVideo;
    private TextView textViewProgress;
    private AppPreferences mAppPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mAppPreferences = new AppPreferences(this);

        prepareView();
        showProgress();

        eventSingleton = EventSingleton.getInstance();
        eventSingleton.registerEvent(new EventListener() {
            @Override
            public void done() {
                dimissProgress();
                Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_SHORT).show();
            }
        });

        btnSendVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent videoActivity = new Intent(FeedActivity.this, RecordActivity.class);
                startActivity(videoActivity);
            }
        });
    }

    private void showProgress() {
        if (this.mAppPreferences.getBoolean("PROGRESS", false)) {
            textViewProgress.setVisibility(View.VISIBLE);
            textViewProgress.requestLayout();
        }
    }

    private void dimissProgress() {
        textViewProgress.setVisibility(View.INVISIBLE);
        textViewProgress.requestLayout();
    }

    private void prepareView() {
        this.btnSendVideo = (Button) findViewById(R.id.btn_send_video);
        this.textViewProgress = (TextView) findViewById(R.id.text_progress);
    }

}
