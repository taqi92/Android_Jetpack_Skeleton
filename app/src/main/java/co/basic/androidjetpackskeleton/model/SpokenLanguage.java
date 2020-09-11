package co.basic.androidjetpackskeleton.model;

import com.google.gson.annotations.SerializedName;

public class SpokenLanguage {

    @SerializedName("iso_639_1")
    private String iso;

    @SerializedName("name")
    private String name;

    public String getIso() {
        return iso;
    }

    public String getName() {
        return name;
    }
}
