package co.basic.androidjetpackskeleton.networking;


import co.basic.androidjetpackskeleton.model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("now_playing?")
    Call<ApiResponse>getNewReleased(@Query("api_key") String apiKey, @Query("page")int page);


}
