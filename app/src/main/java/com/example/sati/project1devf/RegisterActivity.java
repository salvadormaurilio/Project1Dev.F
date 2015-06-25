package com.example.sati.project1devf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {


    @InjectView(R.id.editTextFirstName)
    EditText editTextFirstName;

    @InjectView(R.id.editTextLastName)
    EditText editTextLastName;

    @InjectView(R.id.editTextPassword)
    EditText editTextPassword;

    @InjectView(R.id.editTextConfirmPassword)
    EditText editTextConfirmPassword;

    @InjectView(R.id.editTextPhone)
    EditText editTextPhone;

    @InjectView(R.id.editTextEmailAdress)
    EditText editTextEmailAdress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.inject(this);
    }

    public boolean isEmptyFields() {
        return TextUtils.isEmpty(editTextFirstName.getText())
                || TextUtils.isEmpty(editTextLastName.getText())
                || TextUtils.isEmpty(editTextPassword.getText())
                || TextUtils.isEmpty(editTextConfirmPassword.getText())
                || TextUtils.isEmpty(editTextPhone.getText())
                || TextUtils.isEmpty(editTextEmailAdress.getText());
    }

    @OnClick(R.id.buttonCreateAccount)
    public void myClick(View view) {

        if (!isEmptyFields()){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(RegisterActivity.this, R.string.text_message_full_fields, Toast.LENGTH_SHORT).show();

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
