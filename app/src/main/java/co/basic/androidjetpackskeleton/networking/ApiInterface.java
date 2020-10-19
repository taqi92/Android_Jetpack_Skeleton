package co.basic.androidjetpackskeleton.networking;


import co.basic.androidjetpackskeleton.model.Movie;
import co.basic.androidjetpackskeleton.model.PagedMovieList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("now_playing?")
    Call<PagedMovieList<Movie>> getNewReleased(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("top_rated?")
    Call<PagedMovieList<Movie>> getTopRated(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("upcoming?")
    //Call<ApiResponse> getUpcoming(@Query("api_key") String apiKey, @Query("page") int page);
    Call<PagedMovieList<Movie>> getUpcoming(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("https://api.themoviedb.org/3/movie/{movie_id}")
    Call<Movie> getMovieDetail(@Path("movie_id") int movieId, @Query("api_key") String apiKey);


}
