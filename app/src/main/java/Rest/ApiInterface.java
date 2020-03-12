package Rest;

import java.util.List;

import Model.Example;
import Model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MovieResponse> getMovies(@Query("api_key") String apiKey);
}
