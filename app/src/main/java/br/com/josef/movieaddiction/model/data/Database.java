package br.com.josef.movieaddiction.model.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.josef.movieaddiction.model.pojos.movieid.Filme;


@androidx.room.Database(entities = {Filme.class}, version = 1, exportSchema = false)
@TypeConverters(Converter.class) // Adicionamos os conversores
public abstract class Database extends RoomDatabase {

    public abstract FilmeDao filmeDao();

    private static volatile Database INSTANCE;

    public static Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "filme_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}