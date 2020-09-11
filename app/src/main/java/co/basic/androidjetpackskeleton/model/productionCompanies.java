package co.basic.androidjetpackskeleton.model;

import com.google.gson.annotations.SerializedName;

public class productionCompanies {

    @SerializedName("id")
    private int id;

    @SerializedName("logo_path")
    private String logoPath;

    @SerializedName("name")
    private String name;

    @SerializedName("origin_country")
    private String originCountry;

    public int getId() {
        return id;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public String getName() {
        return name;
    }

    public String getOriginCountry() {
        return originCountry;
    }
}
