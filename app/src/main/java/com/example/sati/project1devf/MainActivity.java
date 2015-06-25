package com.example.sati.project1devf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @InjectView(R.id.editTextUserName)
    EditText editTextUserName;

    @InjectView(R.id.editTextPassword)
    EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "On create");
        setContentView(R.layout.activity_friska_linear_layouts);

        ButterKnife.inject(this);

    }

    @OnClick({R.id.textViewForgotPassword, R.id.buttonLogin, R.id.buttonCreateAccount})
    public void myClick(View view) {

        switch (view.getId()) {
            case R.id.textViewForgotPassword:
                Toast.makeText(MainActivity.this, R.string.text_message_forgot_password, Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonLogin:
                isFullFields();
                break;
            case R.id.buttonCreateAccount:
                launchActivity(RegisterActivity.class);
                break;
        }
    }

    private void isFullFields() {

        if (!TextUtils.isEmpty(editTextUserName.getText()) && !TextUtils.isEmpty(editTextPassword.getText())) {
            launchActivity(HomeActivity.class);
        } else {
            Toast.makeText(MainActivity.this, R.string.text_message_full_fields, Toast.LENGTH_SHORT).show();
        }
    }

    private void launchActivity(Class myClass) {
        Intent intent = new Intent(MainActivity.this, myClass);
        startActivity(intent);
    }


    //añadir el metodo para la pantalla de What Song
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

    //    añadir el metodo para la pantalla de Minha Conta
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
