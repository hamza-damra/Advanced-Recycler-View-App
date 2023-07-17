package com.example.recyclerviewfullapppractice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    ArrayList<CourseDomain> items;
    DecimalFormat formatter;
    Context context;

    public CourseAdapter(ArrayList<CourseDomain> items) {
        this.items = items;
        formatter = new DecimalFormat("###,###,###,###.##");
    }

    @NonNull
    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_course,parent,false);
        context = parent.getContext();

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        holder.titleText.setText(Objects.requireNonNull(items.get(position)).getTitle());
        holder.ownerText.setText(Objects.requireNonNull(items.get(position)).getOwner());
        holder.priceText.setText(String.valueOf((int) Objects.requireNonNull(items.get(position)).getPrice()));

        @SuppressLint("DiscouragedApi") int drawableRecourseId = holder.itemView.getResources().getIdentifier(Objects.requireNonNull(items.get(position)).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableRecourseId).into(holder.picture);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, ownerText, priceText;
        ImageView picture;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
            ownerText = itemView.findViewById(R.id.ownerText);
            priceText = itemView.findViewById(R.id.priceText);
            picture = itemView.findViewById(R.id.pic);
        }
    }
}
