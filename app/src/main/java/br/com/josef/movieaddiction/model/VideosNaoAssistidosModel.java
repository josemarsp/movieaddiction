package br.com.josef.movieaddiction.model;

import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class VideosNaoAssistidosModel {
    private ImageView capaDoFilme, estrelaRating;
    private String tituloDoFilme, descricaoDoFilme;
    private double notaDoFilme;

    public VideosNaoAssistidosModel(ImageView capaDoFilme, ImageView estrelaRating, String tituloDoFilme, String descricaoDoFilme, double notaDoFilme){
        this.capaDoFilme = capaDoFilme;
        this.estrelaRating = estrelaRating;
        this.tituloDoFilme = tituloDoFilme;
        this.descricaoDoFilme = descricaoDoFilme;
        this.notaDoFilme = notaDoFilme;
    }

    public ImageView getCapaDoFilme() {
        return capaDoFilme;
    }

    public void setCapaDoFilme(ImageView capaDoFilme) {
        this.capaDoFilme = capaDoFilme;
    }

    public ImageView getEstrelaRating() {
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
