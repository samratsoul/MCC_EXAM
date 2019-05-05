package com.mcc.q1_gallary_project.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mcc.q1_gallary_project.Pojo.ImagePojo;
import com.mcc.q1_gallary_project.R;

import java.util.List;

/**
 * Created by Samrat on 02-11-17.
 */

public class ImageItemViewAdapter extends RecyclerView.Adapter<ImageItemViewAdapter.ViewHolder> {

    private List<ImagePojo> items;
    private int itemLayout;
    Context context;
    ClickListhener clickListhener;
    //for accepted 1 and rejected 2

    public ImageItemViewAdapter(List<ImagePojo> items, Context context) {

        this.items = items;
        this.context = context;
        this.itemLayout = R.layout.image_item_view;
    }

    @Override
    public ImageItemViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);

        return new ImageItemViewAdapter.ViewHolder(v);

    }


    @Override
    public void onBindViewHolder(ImageItemViewAdapter.ViewHolder holder, int position) {

        ImagePojo item= items.get(position);

        Glide.with(context)
                .load(item.getImagePath())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imvItemViewImage);

    }

    @Override
    public int getItemCount() {

        return items.size();

    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imvItemViewImage;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            imvItemViewImage = view.findViewById(R.id.photoView);
        }


        @Override
        public void onClick(View v) {
            if (clickListhener != null) {
                clickListhener.ItemClick(v, getPosition());
            }
        }
    }

    public void setOnItemClickListhener(ClickListhener clickListhener) {
        this.clickListhener = clickListhener;
    }

    public interface ClickListhener {
        public void ItemClick(View view, int position);
    }
}