package br.com.josef.movieaddiction.model;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class FilmesNaoAssistidosModel {
    private ImageView capaDoFilme, estrelaRating;
    private String tituloDoFilme, descricaoDoFilme;
    private double notaDoFilme;

    public FilmesNaoAssistidosModel(ImageView capaDoFilme, ImageView estrelaRating, String tituloDoFilme, String descricaoDoFilme, double notaDoFilme){
        this.capaDoFilme = capaDoFilme;
        this.estrelaRating = estrelaRating;
        this.tituloDoFilme = tituloDoFilme;
        this.descricaoDoFilme = descricaoDoFilme;
        this.notaDoFilme = notaDoFilme;
    }

    public Drawable getCapaDoFilme() {
        return capaDoFilme;
    }

    public void setCapaDoFilme(ImageView capaDoFilme) {
        this.capaDoFilme = capaDoFilme;
    }

    public Drawable getEstrelaRating() {
        return estrelaRating;
    }

    public void setEstrelaRating(ImageView estrelaRating) {
        this.estrelaRating = estrelaRating;
    }

    public String getTituloDoFilme() {
        return tituloDoFilme;
    }

    public void setTituloDoFilme(String tituloDoFilme) {
        this.tituloDoFilme = tituloDoFilme;
    }

    public String getDescricaoDoFilme() {
        return descricaoDoFilme;
    }

    public void setDescricaoDoFilme(String descricaoDoFilme) {
        this.descricaoDoFilme = descricaoDoFilme;
    }

    public double getNotaDoFilme() {
        return notaDoFilme;
    }

    public void setNotaDoFilme(double notaDoFilme) {
        this.notaDoFilme = notaDoFilme;
    }
}
