package br.com.josef.movieaddiction.model.data;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.josef.movieaddiction.model.pojos.movieid.Filme;


@androidx.room.Database(entities = {Filme.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static volatile Database INSTANCE;

    public abstract FilmeDao filmeDao();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "filme_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}