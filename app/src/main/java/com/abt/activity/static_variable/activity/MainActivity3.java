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

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.d(" onCreate");

        final TextView tipsView = findViewById(R.id.textView);
        String tips = MainActivity3.class.getSimpleName()+" The Number Is: ";
        tipsView.setText(tips + StaticModel.InnerClass.staticNumOfInnerClass);

        Button addBtn =  findViewById(R.id.button_add);
        addBtn.setClickable(false);

        Button jumpBtn =  findViewById(R.id.button_jump);
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.startActivity(MainActivity3.this);
                MainActivity3.this.finish();
            }
        });
    }

    public static final void startActivity(Context context) {
        final Intent intent = new Intent(context, MainActivity3.class);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(" onDestroy");
    }

}
