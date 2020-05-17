package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChartRoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int num = getIntent().getIntExtra("key",0);
        num += 1;
        String info = getIntent().getStringExtra("content");
        setContentView(R.layout.activity_chatroom);
        TextView res = findViewById(R.id.tv_content_info);
        TextView head = findViewById(R.id.tv_with_name);
        head.setText("消息");
        res.setText(info + "\n这是你的第" + num + "个消息");
    }
}