package com.lacak.androidjetpackprosubmission.ui.favoritefilm;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.ItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFilmAdapter extends RecyclerView.Adapter<FavoriteFilmAdapter.FavoriteFilmViewHolder> {
    private final ArrayList<FilmEntity> favoriteFilmList = new ArrayList<>();
    private final Activity activity;
    private static OnItemClickCallback onItemClickCallback;

    FavoriteFilmAdapter(Activity activity) {
        this.activity = activity;
    }

    void setFavoriteFilmList(List<FilmEntity> favoriteFilmList) {
        if(favoriteFilmList == null) return;
        this.favoriteFilmList.clear();
        this.favoriteFilmList.addAll(favoriteFilmList);
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public FavoriteFilmAdapter.FavoriteFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavoriteFilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteFilmAdapter.FavoriteFilmViewHolder holder, int position) {
        holder.bind(favoriteFilmList.get(position));
    }

    @Override
    public int getItemCount() {
        return favoriteFilmList.size();
    }

    class FavoriteFilmViewHolder extends RecyclerView.ViewHolder {
        final ItemFilmBinding binding;

        FavoriteFilmViewHolder(ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(FilmEntity filmEntity) {
            binding.textViewTitle.setText(filmEntity.getTitle());
            binding.textViewYear.setText(filmEntity.getYear());
            binding.textViewRating.setText(filmEntity.getRating());

            int imageResource = activity.getResources().getIdentifier(filmEntity.getImagePath(), null, activity.getPackageName());
            binding.imageView.setImageDrawable(activity.getResources().getDrawable(imageResource));

            itemView.setOnClickListener(v -> {
                onItemClickCallback.onItemClicked(filmEntity);
            });
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(FilmEntity filmEntity);
    }
}
