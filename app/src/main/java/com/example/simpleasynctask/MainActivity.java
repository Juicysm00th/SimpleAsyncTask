package com.example.simpleasynctask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TEXT_STATE = "currentText";
    private TextView mTextView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView);
        progressBar = findViewById((R.id.progressBar));
        if(savedInstanceState!=null){
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }
    public void startTask(View view){
        mTextView.setText(R.string.processing);

        new MyAsyncTask(mTextView,progressBar).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}