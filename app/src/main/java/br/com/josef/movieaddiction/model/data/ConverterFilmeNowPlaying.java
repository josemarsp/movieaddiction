package br.com.josef.movieaddiction.model.data;


import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import br.com.josef.movieaddiction.model.pojos.nowplaying.FilmeNowPlaying;


public class ConverterFilmeNowPlaying {

    @TypeConverter
    public Date toDate(Long timestamp) {
        if (timestamp == null) {
            return null;
        } else {
            return new Date(timestamp);
        }
    }

    @TypeConverter
    public Long toTimestamp(Date date) {
        return date.getTime();
    }


    @TypeConverter
    public FilmeNowPlaying fromFilme(String value) {
        Type listType = (Type) new TypeToken<FilmeNowPlaying>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromFilme(FilmeNowPlaying filme) {
        Gson gson = new Gson();
        return gson.toJson(filme);
    }

    @TypeConverter
    public Object fromObject(String value) {
        Type listType = (Type) new TypeToken<Object>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public String fromObject(Object list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    // ConverterFilme um List<Long> para o formato Json
    @TypeConverter
    public List<Long> fromListGenre(String value) {
        Type listType = (Type) new TypeToken<List<Long>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    //Converte em json uma List<Long>
    @TypeConverter
    public String fromListGenre(List<Long> listLong) {
        Gson gson = new Gson();
        return gson.toJson(listLong);
    }

}












