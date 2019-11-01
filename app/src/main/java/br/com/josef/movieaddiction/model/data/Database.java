package br.com.josef.movieaddiction.model.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.josef.movieaddiction.model.FilmesModel;


@androidx.room.Database(entities = {FilmesModel.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    private static volatile Database INSTANCE;

    public abstract FilmeDao tarefaDao();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, Database.class, "filmes_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
