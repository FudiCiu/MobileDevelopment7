package com.latihanandroid.contohrecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder> {
    private  ArrayList<President> listpresident;
    private Context context;
    public  ArrayList<President> getListPresident(){
        return listpresident;
    }
    public  void setListPresident(ArrayList<President> listpresident){
        this.listpresident=listpresident;
    }

    public ListPresidentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_president,parent,false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListPresident().get(position).getName());
        holder.tvRemark.setText(getListPresident().get(position).getRemarks());
        Glide.with(context).load(getListPresident().get(position).getPhoto())
                .override(55,55)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listpresident.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemark;
        ImageView imgPhoto;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tvName= (TextView) itemView.findViewById(R.id.tv_item_name);
            tvRemark=(TextView) itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto=(ImageView) itemView.findViewById(R.id.img_item_photo);
        }

    }
}
