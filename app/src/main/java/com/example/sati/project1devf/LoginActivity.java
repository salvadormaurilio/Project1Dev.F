package com.example.sati.project1devf;

import android.content.Intent;
import android.net.Uri;
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

public class LoginActivity extends AppCompatActivity {

    public static final String LOG_TAG = LoginActivity.class.getName();

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
//                Toast.makeText(LoginActivity.this, R.string.text_message_forgot_password, Toast.LENGTH_SHORT).show();
                launchAction();
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
            launchHomeActivity();
        } else {
            Toast.makeText(LoginActivity.this, R.string.text_message_full_fields, Toast.LENGTH_SHORT).show();
        }
    }

    private void launchHomeActivity() {
        try {
            Intent homeActivity = HomeActivity.provideIntent(this,
                    editTextUserName.getText().toString(),
                    editTextPassword.getText().toString());

            startActivity(homeActivity);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param myClass Clase que hereda de {@link android.app.Activity}
     */
    private void launchActivity(Class myClass) {
        Intent intent = new Intent(LoginActivity.this, myClass);
        startActivity(intent);
    }


    private void launchAction() {

//        Uri uri = Uri.parse("http://developer.android.com/");
//        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        Uri uri = Uri.parse("tel:555-555-555");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);

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
