package com.example.pablo.tabsexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.tabsexample.model.User;
import com.example.pablo.tabsexample.network.LoginAsyncTask;

import java.net.IDN;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEditText = (EditText)findViewById(R.id.username_text);
        passwordEditText = (EditText)findViewById(R.id.password_text);
    }

    public void onLogin(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();


        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        LoginAsyncTask task = new LoginAsyncTask(this);
        task.execute(user);




        SharedPreferences sharedPreferences = this.getSharedPreferences(
                this.getString(R.string.app_name),
                Context.MODE_PRIVATE);


         int identificador = sharedPreferences.getInt("user_id", 0);
           // Toast.makeText(this, String.valueOf(identificador), Toast.LENGTH_LONG).show();


        if (identificador>0){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Login unsuccessful", Toast.LENGTH_LONG).show();
        }



    }
}
