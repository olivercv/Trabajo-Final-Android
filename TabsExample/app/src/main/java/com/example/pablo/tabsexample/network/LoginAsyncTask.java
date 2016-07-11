package com.example.pablo.tabsexample.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.pablo.tabsexample.LoginActivity;
import com.example.pablo.tabsexample.R;
import com.example.pablo.tabsexample.model.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Olivercv on 10/07/2016.
 */
public class LoginAsyncTask extends AsyncTask<User, Void, User> {

    private LoginActivity activity;
    public LoginAsyncTask (LoginActivity activity){

        this.activity = activity;
    }

    @Override
    protected User doInBackground(User... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService service = retrofit.create(UserService.class);
        Call<User> call = service.login(params[0]);
        try {
            Response<User> response = call.execute();
            User user = response.body();

            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(User user) {
        if (user == null) {
            // Codigo de error
            Toast.makeText(activity, "Login unsuccessful", Toast.LENGTH_LONG).show();

        } else {
            // Guardar al usuario en las preferencias
            SharedPreferences sharedPreferences = activity.getSharedPreferences(
                    activity.getString(R.string.app_name),
                    Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("user_id", user.getId());
            editor.apply();


            //Toast.makeText(activity, "Login successful, username: " + user.getUsername(), Toast.LENGTH_LONG).show();



        }
    }
}
