
package br.com.josef.movieaddiction.model.pojos.searchmovies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SearchResult {

    @Expose
    private Long page;
    @Expose
    private List<Search> results;
    @SerializedName("total_pages")
    private Long totalPages;
    @SerializedName("total_results")
    private Long totalResults;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public List<Search> getResults() {
        return results;
    }

    public void setResults(List<Search> searches) {
        this.results = searches;
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
