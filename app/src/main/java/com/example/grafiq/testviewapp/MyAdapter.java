package com.example.grafiq.testviewapp;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by grafiQ on 2015/06/18.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    List<MyDataModel> MyDataset;
    private LayoutInflater inflater;
    public MyAdapter(Context cont, List<MyDataModel> MyDataset)
    {
        inflater = LayoutInflater.from(cont);
        this.MyDataset = MyDataset;
    }

    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType)
    {
        //get ItemLayoutView from xml
        View itemLayoutView = inflater.inflate(R.layout.my_items_row, parent, false);
        //pass it to the ViewHolder
        ViewHolder myViewHolder = new ViewHolder(itemLayoutView);
        return myViewHolder;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        viewHolder.postText.setText(MyDataset.get(position).postText);
        viewHolder.postImage.setImageResource(MyDataset.get(position).postImgUrl);
    }

    public int getItemCount()
    {
       return MyDataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView postText;
        public ImageView postImage;

        public ViewHolder(View v)
        {
            super(v);
            postText = (TextView)v.findViewById(R.id.myPostText);
            postImage = (ImageView)v.findViewById(R.id.myPostImage);
        }

    }
}
