
package br.com.josef.movieaddiction.model.pojos.trailer;

import com.google.gson.annotations.Expose;

import java.util.List;


public class TrailerResult {

    @Expose
    private Long id;
    @Expose
    private List<Trailer> results;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Trailer> getResults() {
        return results;
    }

    public void setResults(List<Trailer> trailers) {
        this.results = trailers;
    }

}
