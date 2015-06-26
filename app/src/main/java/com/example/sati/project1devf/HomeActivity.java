package com.example.sati.project1devf;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.sati.project1devf.cutomviews.Constants;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        showUserData();

    }

    private void showUserData(){
        Toast.makeText(this, obtainUsernameFromExtras() + " " + obtainPasswordFromExtras(), Toast.LENGTH_SHORT).show();
    }


    private String obtainUsernameFromExtras() {
        return getIntent().getStringExtra(Constants.EXTRA_USERNAME);
    }


    private String obtainPasswordFromExtras() {
        return getIntent().getStringExtra(Constants.EXTRA_PASSWORD);
    }


    /**
     * Este metodo provee un intent para lanzar {@link HomeActivity}
     *
     * @param from Contexto desde donde se va a lanzar {@link HomeActivity}
     * @param params Arreglo de strings, el cual deberá contener el username y el password
     * */
    public static Intent provideIntent(Context from, String... params) throws IllegalArgumentException{

        if(params.length != 2)
            throw new IllegalArgumentException("Los parametros deben ser dos: username y password");

        Intent homeIntent = new Intent(from, HomeActivity.class);
        homeIntent.putExtra("username",params[0]);
        homeIntent.putExtra("password",params[1]);

        return homeIntent;
    }
}
