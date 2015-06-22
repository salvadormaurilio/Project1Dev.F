package com.example.sati.project1devf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "On create");
        setContentView(R.layout.activity_minha_conta_layout);

        initializeActionBarMinhaConta();

    }

    private void createSpinnersWhatsong() {
        Spinner spinnerMusicProvider = (Spinner) findViewById(R.id.spinnerMusicProvider);
        ArrayAdapter<CharSequence> adapterrMusicProvider = ArrayAdapter.createFromResource(this,
                R.array.music_array, android.R.layout.simple_spinner_item);
        adapterrMusicProvider.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMusicProvider.setAdapter(adapterrMusicProvider);

        Spinner spinnerIcon = (Spinner) findViewById(R.id.spinnerIcon);
        ArrayAdapter<CharSequence> adapterIcon = ArrayAdapter.createFromResource(this,
                R.array.icon_array, android.R.layout.simple_spinner_item);
        adapterIcon.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIcon.setAdapter(adapterIcon);
    }

    private void initializeActionBarMinhaConta() {
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(LOG_TAG, "On stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(LOG_TAG, "On destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(LOG_TAG, "On pause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(LOG_TAG, "On resume");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(LOG_TAG, "On start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i(LOG_TAG, "On restart");
    }
}
