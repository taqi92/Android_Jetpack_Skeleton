package co.basic.androidjetpackskeleton.model

import com.google.gson.annotations.SerializedName

data class PagedMovieList<T>(

    @SerializedName("results")
    val movieList: List<T>? = null,
    @SerializedName("page")
    val pageNumber: Int? = null,
    @SerializedName("total_results")
    val totalResults: Int? = null,
    @SerializedName("maximum")
    val maximum: String? = null,
    @SerializedName("minimum")
    val minimum: String? = null,
    @SerializedName("dates")
    val dates: PagedMovieList<Any>? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null


)
