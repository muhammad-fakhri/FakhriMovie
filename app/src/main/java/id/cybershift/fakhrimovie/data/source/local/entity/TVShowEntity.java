package id.cybershift.fakhrimovie.data.source.local.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShowEntity implements Parcelable {
    public static final Creator<TVShowEntity> CREATOR = new Creator<TVShowEntity>() {
        @Override
        public TVShowEntity createFromParcel(Parcel in) {
            return new TVShowEntity(in);
        }

        @Override
        public TVShowEntity[] newArray(int size) {
            return new TVShowEntity[size];
        }
    };
    private String title;
    private String overview;
    private double rate;
    private String year;
    private String poster;

    public TVShowEntity(String title, String overview, double rate, String year, String poster) {
        this.title = title;
        this.overview = overview;
        this.rate = rate;
        this.year = year;
        this.poster = poster;
    }

    protected TVShowEntity(Parcel in) {
        title = in.readString();
        overview = in.readString();
        rate = in.readDouble();
        year = in.readString();
        poster = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeDouble(rate);
        parcel.writeString(year);
        parcel.writeString(poster);
    }
}