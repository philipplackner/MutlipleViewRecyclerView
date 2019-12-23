package com.androiddevs.mutlipleviewrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ImageData> imageDataList;
    int curImageDataIndex = 0;

    public RecyclerViewAdapter(List<ImageData> imageDataList) {
        this.imageDataList = imageDataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType >= 0 && viewType <= 2) {
            return new ImageViewHolder(inflateResource(parent, R.layout.item_small_image));
        } else if(viewType == 3) {
            return new ImageViewHolder(inflateResource(parent, R.layout.item_image_large));
        } else {
            return new AdViewHolder(inflateResource(parent, R.layout.item_ad));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if(viewType >= 0 && viewType <= 3) {
            ImageData imageData = imageDataList.get(curImageDataIndex);
            ((ImageViewHolder) holder).ivImage.setImageResource(imageData.getResource());
            ((ImageViewHolder) holder).tvTitle.setText(imageData.getTitle());
            ((ImageViewHolder) holder).tvDescription.setText(imageData.getDescription());
        }
        if(curImageDataIndex < 4) {
            curImageDataIndex++;
        } else {
            curImageDataIndex = 0;
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 5;
    }

    private View inflateResource(ViewGroup parent, int resourceId) {
        return LayoutInflater.from(parent.getContext()).inflate(resourceId, parent, false);
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        TextView tvTitle, tvDescription;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }

    class AdViewHolder extends RecyclerView.ViewHolder {

        ImageView ivAd;

        public AdViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAd = itemView.findViewById(R.id.ivAd);
        }
    }
}
