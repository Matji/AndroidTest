package com.example.grafiq.testviewapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    RecyclerView myrecyclerView;
    MyAdapter adapter;
    Button openActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openActivity = (Button)findViewById(R.id.btn_Child);
        myrecyclerView = (RecyclerView)findViewById(R.id.myRecycleView);
        adapter = new MyAdapter(this, getData());
        myrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myrecyclerView.setAdapter(adapter);
        myrecyclerView.setItemAnimator(new DefaultItemAnimator());


    }
    //the Dataset
    public static List<MyDataModel> getData()
    {
        List<MyDataModel> myData = new ArrayList<>();
        String[] postText = {"ibm", "apple", "google", "microsoft"};
        int[] postImgUrl = {R.drawable.google, R.drawable.ibm, R.drawable.microsoft, R.drawable.apple};

        for(int x=0; x<postText.length && x<postImgUrl.length; x++)
        {
            MyDataModel myModel = new MyDataModel();
            myModel.postImgUrl = postImgUrl[x];
            myModel.postText = postText[x];
            myData.add(myModel);
        }
        return myData;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

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

    //click event
    public void openChildActivity(View v)
    {
        Log.d("OK4", "Response Data");
        Intent myIntent = new Intent(this, MyChildActivity.class);
        startActivity(myIntent);

    }


}
