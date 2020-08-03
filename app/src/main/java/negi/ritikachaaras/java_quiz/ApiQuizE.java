package negi.ritikachaaras.java_quiz;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiQuizE {
    String BASE_URL = "http://ritikanegi.com/javaQuiz/";
    @FormUrlEncoded
    @POST("mydata.php")

    Call<List<Quiz>> getQuestion(@Field("name") String name);
}
