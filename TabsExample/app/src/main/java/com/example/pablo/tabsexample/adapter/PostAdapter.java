package com.example.pablo.tabsexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pablo.tabsexample.R;
import com.example.pablo.tabsexample.model.Post;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends ArrayAdapter<Post> {
    public PostAdapter(Context context) {
        super(context, R.layout.post_item_layout);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Post post = getItem(position);
        View currentView;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            currentView = inflater.inflate(R.layout.post_item_layout, parent, false);
        } else {
            currentView = convertView;
        }

        TextView titleTextView = (TextView)currentView.findViewById(R.id.title_text_view);
        TextView contentTextView = (TextView)currentView.findViewById(R.id.content_text_view);
        CircleImageView profileImageView = (CircleImageView) currentView.findViewById(R.id.profile_image_view);

        titleTextView.setText(post.getTitle());
        contentTextView.setText(post.getContent());
        Glide.with(getContext()).load(post.getUser().getPicture_url()).into(profileImageView);

        return currentView;
    }
}
