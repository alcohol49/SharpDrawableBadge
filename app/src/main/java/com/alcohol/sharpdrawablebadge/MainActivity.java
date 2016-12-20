package com.alcohol.sharpdrawablebadge;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean mRun;
    private int mCount;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ((TextView) findViewById(R.id.badge)).setText(String.valueOf(++mCount));

            if (mRun) sendMessageDelayed(obtainMessage(), 100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onIncrease(View view) {
        if (mRun) {
            mRun = false;
            ((TextView) findViewById(R.id.increase)).setText("Increase");
        } else {
            mRun = true;
            mHandler.obtainMessage().sendToTarget();
            ((TextView) findViewById(R.id.increase)).setText("Stop");
        }
    }
}
