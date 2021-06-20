package com.lacak.androidjetpackprosubmission.ui.favoritefilm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.ItemFilmBinding;

public class FavoriteFilmAdapter extends PagedListAdapter<FilmEntity, FavoriteFilmAdapter.FavoriteFilmViewHolder> {
    private final Activity activity;
    private static OnItemClickCallback onItemClickCallback;

    FavoriteFilmAdapter(Activity activity) {
        super(DIFF_CALLBACK);
        this.activity = activity;
    }

    private static DiffUtil.ItemCallback<FilmEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FilmEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull FilmEntity oldItem, @NonNull FilmEntity newItem) {
                    return oldItem.getTitle().equals(newItem.getTitle());
                }
                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull FilmEntity oldItem, @NonNull FilmEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

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
        FilmEntity filmEntity = getItem(position);
        if(filmEntity != null) {
            holder.bind(filmEntity);
        }
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
