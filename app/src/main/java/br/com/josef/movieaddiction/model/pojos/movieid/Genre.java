
package br.com.josef.movieaddiction.model.pojos.movieid;

import androidx.room.Entity;

import com.google.gson.annotations.Expose;

@Entity(tableName = "Genre")
public class Genre {

    @Expose
    private Long id;
    @Expose
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
