package br.com.josef.movieaddiction.model.data;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import br.com.josef.movieaddiction.model.pojos.movieid.ProductionCompany;
import io.reactivex.Flowable;

public interface ProductionCompanyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ProductionCompany> results);

    @Query("Delete from productionCompany")
    void deleteAll();

    //Método que retorna uma consulta do banco com um limite de 30 itens
    @Query("Select * from productionCompany limit 30")
    Flowable<List<ProductionCompany>> getAll(); // Aqui retornamos um Flowable que é o observavel para o ROOM DATABASE


}
