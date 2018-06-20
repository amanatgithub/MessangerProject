package com.example.aman.messanger;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private ArrayList<DataID> arrlistadapt;
    private Context context;

    public  MyAdapter(Context ctx,ArrayList<DataID> cont)
    {  context=ctx;
        arrlistadapt=cont;

        }

    @Override
    public int getItemViewType(int position) {
        return arrlistadapt.get(position).getId();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(context);
        View inflatedView;
        if(viewType==1)
            inflatedView= li.inflate(R.layout.layout1,parent,false);
        else inflatedView= li.inflate(R.layout.layout2,parent,false);
        return new MyHolder(inflatedView,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        DataID currentData=arrlistadapt.get(position);
        holder.txt.setText(currentData.getData());


    }

    @Override
    public int getItemCount() {
        return arrlistadapt.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        TextView txt;
        public MyHolder(View itemView,int i) {
            super(itemView);
            if(i==1)
                txt=itemView.findViewById(R.id.editText3);
            else
                txt=itemView.findViewById(R.id.editText4);
        }
    }


}
