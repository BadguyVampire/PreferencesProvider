package com.ddmeng.preferencesprovider.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ddmeng.preferencesprovider.provider.PreferencesHelper;
import com.ddmeng.preferencesprovider.provider.PreferencesStorageModule;
import com.ddmeng.preferencesprovider.provider.exception.ItemNotFoundException;

public class ProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);

        final PreferencesStorageModule myModule = new PreferencesStorageModule(this, "HelloModule1");
        findViewById(R.id.btn_query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringValue = null;
                try {
                    stringValue = myModule.getString("stringKey");
                    Log.d("messi", "provider query a : " + stringValue);
                } catch (ItemNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
