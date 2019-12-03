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
    public List<Long> fromListGenre(String value){
        Type listType = (Type) new TypeToken<List<Long>>(){
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    //Converte em json uma List<Long>
    @TypeConverter
    public String fromListGenre(List<Long> listLong){
        Gson gson = new Gson();
        return gson.toJson(listLong);
    }

//
//    @TypeConverter
//    public Genre fromGenre(String value) {
//        Type listType = (Type) new TypeToken<Genre>() {
//        }.getType();
//        return new Gson().fromJson(value, listType);
//    }
//
//
//    @TypeConverter
//    public String fromGenere(Genre list) {
//        Gson gson = new Gson();
//        return gson.toJson(list);
//    }
//
//    public String fromGenere (List list){
//        Gson gson = new Gson();
//        return gson.toJson(list);
//    }

    //ConverterFilme um List<Genre> para o formato Json
//    @TypeConverter
//    public  List<Genre> fromListGenre(String value){
//        Type listType = (Type) new TypeToken<List<Genre>>(){
//        }.getType();
//        return new Gson().fromJson(value, listType);
//    }
//
//    //Converte em json uma List<Genre>
//    @TypeConverter
//    public String fromListGenre(List<Genre> listGenre){
//        Gson gson = new Gson();
//        return gson.toJson(listGenre);
//    }
//
//    //ConverterFilme um List<ProductionCompany> para o formato Json
//    @TypeConverter
//    public  List<ProductionCompany> fromListProductionCompany(String valueProdCompany){
//        Type listType = (Type) new TypeToken<List<ProductionCompany>>(){
//        }.getType();
//        return new Gson().fromJson(valueProdCompany, listType);
//    }
//
//    //Converte em json uma List<ProductionCompany>
//    @TypeConverter
//    public String fromListProductionCompany(List<ProductionCompany> listProductionCompany){
//        Gson gson = new Gson();
//        return gson.toJson(listProductionCompany);
//    }
//
//    //ConverterFilme um List<ProductionCountry> para o formato Json
//    @TypeConverter
//    public  List<ProductionCountry> fromListProductionCountry(String valueProdCountry){
//        Type listType = (Type) new TypeToken<List<ProductionCountry>>(){
//        }.getType();
//        return new Gson().fromJson(valueProdCountry, listType);
//    }
//
//    //Converte em json uma List<ProductionCountry>
//    @TypeConverter
//    public String fromListProductionCountry(List<ProductionCountry> listProductionCountry){
//        Gson gson = new Gson();
//        return gson.toJson(listProductionCountry);
//    }
//
//    //ConverterFilme um List<SpokenLanguage> para o formato Json
//    @TypeConverter
//    public  List<SpokenLanguage> fromListSpokenLanguage(String valueSpokenLanguage){
//        Type listType = (Type) new TypeToken<List<SpokenLanguage>>(){
//        }.getType();
//        return new Gson().fromJson(valueSpokenLanguage, listType);
//    }
//
//    //Converte em json uma List<SpokenLanguage>
//    @TypeConverter
//    public String fromListSpokenLanguage(List<SpokenLanguage> listSpokenLanguage){
//        Gson gson = new Gson();
//        return gson.toJson(listSpokenLanguage);
//    }


}


















