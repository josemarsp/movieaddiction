package br.com.josef.movieaddiction.model.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlaying;

@androidx.room.Database(entities = {FilmeNowPlaying.class}, version = 1, exportSchema = false)
@TypeConverters(ConverterFilmeNowPlaying.class) // Adicionamos os conversores

public abstract class DatabaseFilmeNowPlaying extends RoomDatabase {

    public abstract FilmeNowPlayingDao filmeNowPlayingDao();

    private static volatile DatabaseFilmeNowPlaying INSTANCE;

    public static DatabaseFilmeNowPlaying getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseFilmeNowPlaying.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseFilmeNowPlaying.class, "filmeNowPlaying_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}