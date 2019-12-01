
package br.com.josef.movieaddiction.model.pojos.nowplaying;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class FilmeNowPlayingResult {



    @Expose
    private Dates dates;
    @Expose
    private Long page;
    @Expose
    private List<FilmeNowPlaying> results;
    @SerializedName("total_pages")
    private Long totalPages;
    @SerializedName("total_results")
    private Long totalResults;




    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<FilmeNowPlaying> getResults() {
        return results;
    }

    public void setResults(List<FilmeNowPlaying> filmeNowPlayings) {
        this.results = filmeNowPlayings;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

}
