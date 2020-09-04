package co.basic.androidjetpackskeleton.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ApiResponse {

    @SerializedName("results")
    private ArrayList<Data>results;

    @SerializedName("page")
    private String page;

    @SerializedName("total_pages")
    private String totalPages;

    public ArrayList<Data> getResults() {
        return results;
    }

    public String getPage() {
        return page;
    }

    public String getTotalPages() {
        return totalPages;
    }
}
