package com.lacak.androidjetpackprosubmission.ui.film;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lacak.androidjetpackprosubmission.data.FilmEntity;
import com.lacak.androidjetpackprosubmission.databinding.ItemFilmBinding;
import com.lacak.androidjetpackprosubmission.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {
    private final List<FilmEntity> listFilms = new ArrayList<>();
    private static Context context;

    public FilmAdapter(Context context){
        this.context = context;
    }

    void setListFilms(List<FilmEntity> listFilms){
        if(listFilms == null) return;
        this.listFilms.clear();
        this.listFilms.addAll(listFilms);
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
        holder.bind(filmEntity);
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
        void bind(FilmEntity filmEntity){
            itemFilmBinding.textViewTitle.setText(filmEntity.getTitle());
            itemFilmBinding.textViewYear.setText(filmEntity.getYear());
            itemFilmBinding.textViewRating.setText(filmEntity.getRating());

            int imageResource = context.getResources().getIdentifier(filmEntity.getImagePath(), null, context.getPackageName());
            itemFilmBinding.imageView.setImageDrawable(context.getResources().getDrawable(imageResource));

            itemView.setOnClickListener(v -> {
                Intent moveToDetailActivity = new Intent(itemView.getContext(), DetailActivity.class);
                moveToDetailActivity.putExtra(DetailActivity.EXTRA_FILM, filmEntity);
                itemView.getContext().startActivity(moveToDetailActivity);
            });
        }
    }
}
