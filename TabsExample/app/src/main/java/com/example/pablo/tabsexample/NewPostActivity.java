package com.example.pablo.tabsexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pablo.tabsexample.model.Post;

public class NewPostActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText contentEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        titleEditText = (EditText)findViewById(R.id.title_text);
        contentEditText = (EditText)findViewById(R.id.content_text);
    }

    public void savePost(View view) {
        Post post = new Post();

        post.setTitle(titleEditText.getText().toString());
        post.setContent(contentEditText.getText().toString());

        //post.save();

        finish();
        Toast.makeText(this,"Save Postdata succesful", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);



    }
}
