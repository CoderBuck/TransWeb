package me.buck.transweb;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.d("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //如果不是跟activity说明翻译网页已经打开了，finish 掉直接显示翻译网页
        if (!isTaskRoot()) {
            finish();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
