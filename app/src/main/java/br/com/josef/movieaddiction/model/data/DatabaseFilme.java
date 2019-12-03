package br.com.josef.movieaddiction.model.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.josef.movieaddiction.model.pojos.movieid.Filme;

@androidx.room.Database(entities = {Filme.class}, version = 1, exportSchema = false)
@TypeConverters(ConverterFilme.class) // Adicionamos os conversores
public abstract class DatabaseFilme extends RoomDatabase {

    public abstract FilmeDao filmeDao();

    private static volatile DatabaseFilme INSTANCE;

    public static DatabaseFilme getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseFilme.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseFilme.class, "filme_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}