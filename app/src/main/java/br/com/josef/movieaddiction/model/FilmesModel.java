package br.com.josef.movieaddiction.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FilmesModel implements Parcelable {

    private int imagem;
    private String nome;

    public FilmesModel(int imagem, String nome) {
        this.imagem = imagem;
        this.nome = nome;
    }

    protected FilmesModel(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
    }

    public static final Creator<FilmesModel> CREATOR = new Creator<FilmesModel>() {
        @Override
        public FilmesModel createFromParcel(Parcel in) {
            return new FilmesModel(in);
        }

        @Override
        public FilmesModel[] newArray(int size) {
            return new FilmesModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nome);
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}