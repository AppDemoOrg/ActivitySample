package com.abt.activity.static_variable.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abt.activity.R;
import com.abt.activity.static_variable.StaticModel;
import com.abt.activity.static_variable.leak.LeakedActivity;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d(" onCreate");

        final TextView tipsView = findViewById(R.id.textView);
        final String tips = getString(R.string.tips_txt_hint, StaticModel.InnerClass.staticNumOfInnerClass+"", MainActivity.class.getSimpleName());
        tipsView.setText(Html.fromHtml(tips));

        Button addBtn = findViewById(R.id.button_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmp = getString(R.string.tips_txt_hint, (++StaticModel.InnerClass.staticNumOfInnerClass)+"", MainActivity.class.getSimpleName());
                tipsView.setText(Html.fromHtml(tmp));
                Logger.d("the StaticModel.InnerClass.staticNumOfInnerClass num is: " + StaticModel.InnerClass.staticNumOfInnerClass);
            }
        });

        Button jump =  findViewById(R.id.button_jump);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeakedActivity.startActivity(MainActivity.this);
                /*MainActivity2.startActivity(MainActivity.this);
                MainActivity.this.finish();*/
            }
        });
    }

    public static final void startActivity(Context context) {
        final Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(" onDestroy");
    }
}
