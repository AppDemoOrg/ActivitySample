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

public class ActivityQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d(" onCreate");

        final TextView tipsView = findViewById(R.id.textView);
        String tips = ActivityQ.class.getSimpleName()+" The Number Is: ";
        tipsView.setText(tips + StaticModel.InnerClass.staticNum);

        Button addBtn =  findViewById(R.id.button_add);
        addBtn.setClickable(false);

        Button jumpBtn =  findViewById(R.id.button_jump);
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityO.startActivity(ActivityQ.this);
                ActivityQ.this.finish();
            }
        });
    }

    public static final void startActivity(Context context) {
        final Intent intent = new Intent(context, ActivityQ.class);
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
