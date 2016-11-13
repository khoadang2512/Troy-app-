package com.example.khoa.troyapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by khoa on 11/11/2016.
 */
public class AcademicAdapter extends RecyclerView.Adapter<AcademicAdapter.MyViewHolder> {
    Cursor cursor;
    LayoutInflater inflater;
    Context context;
    View convertview;
    public AcademicAdapter(Context context, Cursor cursor)
    {
        this.context=context;
        this.cursor=cursor;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        cursor.moveToPosition(position);
        holder.classname.setText("name: "+cursor.getString(1));
        holder.building.setText("building: "+cursor.getString(2));
        holder.time.setText("time:"+ cursor.getString(3));
    }

    @Override
    public int getItemCount()
    {
        return cursor.getCount();
    }

    @Override
    public AcademicAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AcademicAdapter.MyViewHolder viewHolder=new MyViewHolder(inflater.inflate(R.layout.academicrow,parent,false));
        return viewHolder;
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView classname,building,time;

        public MyViewHolder(View itemView) {
            super(itemView);
            classname=(TextView) itemView.findViewById(R.id.textView6);
            building=(TextView) itemView.findViewById(R.id.textView7);
            time=(TextView) itemView.findViewById(R.id.textView8);
        }
    }

}
