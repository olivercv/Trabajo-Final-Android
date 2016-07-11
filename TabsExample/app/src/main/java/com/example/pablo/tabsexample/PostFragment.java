package com.example.pablo.tabsexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pablo.tabsexample.adapter.PostAdapter;
import com.example.pablo.tabsexample.model.Post;
import com.example.pablo.tabsexample.network.RetrievePostsAsyncTask;


public class PostFragment extends Fragment {
    private ListView listView;
    private PostAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        // Inflate the layout for this fragment
        listView = (ListView)view.findViewById(R.id.posts_list_view);
        adapter = new PostAdapter(getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Post p = adapter.getItem(position);

               // Toast.makeText(getActivity(), p.getTitle(), Toast.LENGTH_LONG).show();


                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(
                        getActivity().getString(R.string.app_name),
                        Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("titulo", p.getTitle());
                editor.putString("contenido", p.getContent());
                editor.putString("urlimagen", p.getUser().getPicture_url());
                editor.apply();

                Intent intent = new Intent(getActivity(), DetailPostActivity.class);
                startActivity(intent);
            }
        });

        RetrievePostsAsyncTask task = new RetrievePostsAsyncTask(this);
        task.execute();

        return view;
    }

    public PostAdapter getAdapter() {
        return adapter;
    }
}
