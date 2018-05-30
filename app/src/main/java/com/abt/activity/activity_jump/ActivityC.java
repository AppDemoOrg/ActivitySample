package com.abt.activity.activity_jump;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.abt.activity.R;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityC extends BaseActivity {

    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        ButterKnife.bind(this);
        textView.setText("ActivityC");
        Logger.d(" onCreate");
        getTask();
    }

    public static final void startActivity(Context context) {
        final Intent intent = new Intent(context, ActivityC.class);
        context.startActivity(intent);
    }

    public void onClick(View view) {
        ActivityD.startActivity(this);
    }
}
