package co.basic.androidjetpackskeleton.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movie {

    @SerializedName("budget")
    private int budget;

    @SerializedName("genres")
    private ArrayList<genres> genres;

    @SerializedName("id")
    private int id;

    @SerializedName("original_title")
    private String originalTitle;

    @SerializedName("overview")
    private String overview;

    @SerializedName("popularity")
    private double popularity;

    @SerializedName("backdrop_path")
    private String BackDropPath;

    @SerializedName("production_companies")
    private ArrayList<productionCompanies> productionCompanies;

    @SerializedName("production_countries")
    private ArrayList<productionCountries> productionCountries;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("spoken_languages")
    private ArrayList<SpokenLanguage> spokenLanguages;

    @SerializedName("vote_average")
    private float voteAverage;

    public int getVoteCount() {
        return voteCount;
    }

    @SerializedName("vote_count")
    private int voteCount;

    @SerializedName("poster_path")
    private String posterPath;

    public String getPosterPath() {
        return posterPath;
    }

    public int getBudget() {
        return budget;
    }

    public ArrayList<co.basic.androidjetpackskeleton.model.genres> getGenres() {
        return genres;
    }

    public int getId() {
        return id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public String getBackDropPath() {
        return BackDropPath;
    }

    public ArrayList<co.basic.androidjetpackskeleton.model.productionCompanies> getProductionCompanies() {
        return productionCompanies;
    }

    public ArrayList<co.basic.androidjetpackskeleton.model.productionCountries> getProductionCountries() {
        return productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public ArrayList<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public Movie() {
    }


}
