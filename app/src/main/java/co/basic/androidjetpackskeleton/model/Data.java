package co.basic.androidjetpackskeleton.model;

import com.google.gson.annotations.SerializedName;

public class Data {


    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("id")
    private int id;

    public String getPosterPath() {
        return posterPath;
    }

    public int getId() {
        return id;
    }
}
