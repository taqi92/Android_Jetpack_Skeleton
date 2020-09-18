package co.basic.androidjetpackskeleton.networking;


import co.basic.androidjetpackskeleton.model.ApiResponse;
import co.basic.androidjetpackskeleton.model.MovieDetail;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("now_playing?")
    Call<ApiResponse>getNewReleased(@Query("api_key") String apiKey, @Query("page")int page);

    @GET("top_rated?")
    Call<ApiResponse>getTopRated(@Query("api_key") String apiKey, @Query("page")int page);

    @GET("upcoming?")
    Call<ApiResponse>getUpcoming(@Query("api_key") String apiKey, @Query("page")int page);

    @GET("https://api.themoviedb.org/3/movie/{movie_id}")
    Call<MovieDetail>getMovieDetail(@Path("movie_id")int movieId,@Query("api_key")String apiKey);




}
