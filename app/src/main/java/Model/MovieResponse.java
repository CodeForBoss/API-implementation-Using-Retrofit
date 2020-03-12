package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("results")
    private List<Example>results;
    public List<Example> getResults() {
        return results;
    }
    public void setResults(List<Example> results) {
        this.results = results;
    }
}
