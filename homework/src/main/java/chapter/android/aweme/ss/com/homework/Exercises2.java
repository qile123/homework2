package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        TextView tv = findViewById(R.id.textView);
        tv.setGravity(Gravity.CENTER);      //设置输出文字在中间
        tv.setText("此页面所有view的个数为："+getAllChildViewCount(findViewById(R.id.rootview)));
    }

    public int getAllChildViewCount(View view) {
        //todo 补全你的代码、
        int count = 0;
        if(view == null){
            return 0;
        }
        else{
            //遍历整个ViewGroup
            if(view instanceof ViewGroup){
                for(int i = 0; i < ((ViewGroup) view).getChildCount(); i++){
                    View child = ((ViewGroup) view).getChildAt(i);
                    if(child instanceof  ViewGroup){   //子view是viewgroup,遍历子view
                        count += getAllChildViewCount(child);
                    }
                    else{
                        count++;
                    }
                }
            }
            else{
                count++;
            }
            return count;
    }
 }
}
