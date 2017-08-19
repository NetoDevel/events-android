package netodevel.com.br.events_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RecordActivity extends AppCompatActivity {

    private Button btnTaskVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        prepareView();

        this.btnTaskVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendVideoTask sendVideoTask = new SendVideoTask(getBaseContext());
                sendVideoTask.execute();

                Intent intent = new Intent(RecordActivity.this, FeedActivity.class);
                startActivity(intent);
            }
        });

    }

    private void prepareView() {
        this.btnTaskVideo = (Button) findViewById(R.id.btn_task_video);
    }

}
