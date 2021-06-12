package com.lacak.androidjetpackprosubmission.ui.film;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lacak.androidjetpackprosubmission.data.source.local.entity.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.ItemFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {
    private final List<FilmEntity> listFilms = new ArrayList<>();
    private static Context context;
    private static OnItemClickCallback onItemClickCallback;
    private String filmType = "";

    public FilmAdapter(Context context){
        this.context = context;
    }

    void setListFilms(List<FilmEntity> listFilms){
        if(listFilms == null) return;
        this.listFilms.clear();
        this.listFilms.addAll(listFilms);
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding itemFilmBinding = ItemFilmBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(itemFilmBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        FilmEntity filmEntity = listFilms.get(position);
        holder.bind(filmEntity, filmType);
    }

    @Override
    public int getItemCount() {
        return listFilms.size();
    }

    static class FilmViewHolder extends RecyclerView.ViewHolder {
        private final ItemFilmBinding itemFilmBinding;

        FilmViewHolder(ItemFilmBinding itemFilmBinding){
            super(itemFilmBinding.getRoot());
            this.itemFilmBinding = itemFilmBinding;
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        void bind(FilmEntity filmEntity, String filmType){
            itemFilmBinding.textViewTitle.setText(filmEntity.getTitle());
            itemFilmBinding.textViewYear.setText(filmEntity.getYear());
            itemFilmBinding.textViewRating.setText(filmEntity.getRating());

            int imageResource = context.getResources().getIdentifier(filmEntity.getImagePath(), null, context.getPackageName());
            itemFilmBinding.imageView.setImageDrawable(context.getResources().getDrawable(imageResource));

            itemView.setOnClickListener(v -> {
                onItemClickCallback.onItemClicked(filmEntity, filmType);
            });
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(FilmEntity filmEntity, String filmType);
    }
}
