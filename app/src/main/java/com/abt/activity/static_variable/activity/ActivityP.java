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

public class ActivityP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d(" onCreate");

        final String tips = ActivityP.class.getSimpleName()+" The Number Is: ";
        final TextView tipsView = findViewById(R.id.textView);
        tipsView.setText(tips + StaticModel.InnerClass.staticNum);

        Button addBtn = findViewById(R.id.button_add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipsView.setText(tips + (++StaticModel.InnerClass.staticNum));
                Logger.d("the StaticModel.InnerClass.staticNum num is: "
                        + StaticModel.InnerClass.staticNum);
            }
        });

        Button jumpBtn =  findViewById(R.id.button_jump);
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityQ.startActivity(ActivityP.this);
                ActivityP.this.finish();
            }
        });
    }

    public static final void startActivity(Context context) {
        final Intent intent = new Intent(context, ActivityP.class);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(" onDestroy");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Logger.d("LeakedActivity has been recycled!!!");
    }
}
