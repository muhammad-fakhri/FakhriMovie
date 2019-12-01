package id.cybershift.fakhrimovie.data.source;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;

import id.cybershift.fakhrimovie.data.source.local.entity.MovieEntity;
import id.cybershift.fakhrimovie.data.source.local.entity.TVShowEntity;

public interface CatalogueDataSource {
    LiveData<ArrayList<MovieEntity>> getAllMovies();

    LiveData<ArrayList<TVShowEntity>> getAllTVShows();

    LiveData<MovieEntity> getMovie(int position);

    LiveData<TVShowEntity> getTVShow(int position);

}