package com.abt.activity.static_variable.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abt.activity.R;
import com.abt.activity.static_variable.StaticModel;
import com.orhanobut.logger.Logger;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d(" onCreate");

        final String tips = MainActivity2.class.getSimpleName()+" The Number Is: ";
        final TextView tipsView = findViewById(R.id.textView);
        tipsView.setText(tips + StaticModel.InnerClass.staticNumOfInnerClass);

        Button addBtn = findViewById(R.id.button_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipsView.setText(tips + (++StaticModel.InnerClass.staticNumOfInnerClass));
                Logger.d("the StaticModel.InnerClass.staticNumOfInnerClass num is: " + StaticModel.InnerClass.staticNumOfInnerClass);
            }
        });

        Button jumpBtn =  findViewById(R.id.button_jump);
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity3.startActivity(MainActivity2.this);
                MainActivity2.this.finish();
            }
        });
    }

    public static final void startActivity(Context context) {
        final Intent intent = new Intent(context, MainActivity2.class);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(" onDestroy");
    }
}
