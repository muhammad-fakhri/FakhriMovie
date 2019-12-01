package id.cybershift.fakhrimovie.ui.favorite.moviefavorite;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;

import id.cybershift.fakhrimovie.R;
import id.cybershift.fakhrimovie.data.source.local.entity.FavoriteEntity;

public class FavMoviePagedAdapter extends PagedListAdapter<FavoriteEntity, FavMoviePagedAdapter.FavMoviePagedViewHolder> {
    //    private FavoriteMovieFragmentCallback callback;
    private FavoriteMovieViewModel viewModel;

    FavMoviePagedAdapter() {
        super(DIFF_CALLBACK);

//        this.callback = callback;
    }

    public void setViewModel(FavoriteMovieViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(@NonNull FavMoviePagedViewHolder holder, int position) {
        holder.bind(getItem(position), holder, position);
    }

    @NonNull
    @Override
    public FavMoviePagedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item2, parent, false);
        return new FavMoviePagedViewHolder(view);
    }

    private static DiffUtil.ItemCallback<FavoriteEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<FavoriteEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull FavoriteEntity oldItem, @NonNull FavoriteEntity newItem) {
                    return oldItem.getTitle().equals(newItem.getTitle());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull FavoriteEntity oldItem, @NonNull FavoriteEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    FavoriteEntity getItemById(int swipedPosition) {
        return getItem(swipedPosition);
    }

    class FavMoviePagedViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvName, tvDescription;
        Button unfavoriteBtn;

        FavMoviePagedViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.item_poster);
            tvName = itemView.findViewById(R.id.item_name);
            tvDescription = itemView.findViewById(R.id.item_description);
            unfavoriteBtn = itemView.findViewById(R.id.unfavorite_btn);
        }

        void bind(FavoriteEntity favoriteItem, FavMoviePagedViewHolder viewHolder, final int position) {
            Glide.with(viewHolder.itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w185" + favoriteItem.getPoster())
                    .apply(new RequestOptions().override(200, 250))
                    .into(viewHolder.imgPoster);
            tvName.setText(favoriteItem.getTitle());
            tvDescription.setText(favoriteItem.getOverview());

            unfavoriteBtn.setOnClickListener(v -> {
                viewModel.deleteFavoriteMovie(favoriteItem);
                Snackbar snackbar = Snackbar.make(v, "Unfavoriting " + favoriteItem.getTitle(), Snackbar.LENGTH_LONG);
                snackbar.show();
            });
        }
    }
}