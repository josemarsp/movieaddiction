package br.com.josef.movieaddiction.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FavoritosModel implements Parcelable {
    private int capaDoFilme;
    private String notaDoFilme;
    private String nomeDoFilme;
    private String descricaoDoFilme;

    public FavoritosModel(int capaDoFilme, String notaDoFilme, String nomeDoFilme, String descricaoDoFilme) {
        this.capaDoFilme = capaDoFilme;
        this.notaDoFilme = notaDoFilme;
        this.nomeDoFilme = nomeDoFilme;
        this.descricaoDoFilme = descricaoDoFilme;
    }

    protected FavoritosModel(Parcel in) {
        capaDoFilme = in.readInt();
        notaDoFilme = in.readString();
        nomeDoFilme = in.readString();
        descricaoDoFilme = in.readString();
    }

    public static final Creator<FavoritosModel> CREATOR = new Creator<FavoritosModel>() {
        @Override
        public FavoritosModel createFromParcel(Parcel in) {
            return new FavoritosModel(in);
        }

        @Override
        public FavoritosModel[] newArray(int size) {
            return new FavoritosModel[size];
        }
    };

    public int getCapaDoFilme() {
        return capaDoFilme;
    }

    public void setCapaDoFilme(int capaDoFilme) {
        this.capaDoFilme = capaDoFilme;
    }

    public String getNotaDoFilme() {
        return notaDoFilme;
    }

    public void setNotaDoFilme(String notaDoFilme) {
        this.notaDoFilme = notaDoFilme;
    }

    public String getNomeDoFilme() {
        return nomeDoFilme;
    }

    public void setNomeDoFilme(String nomeDoFilme) {
        this.nomeDoFilme = nomeDoFilme;
    }

    public String getDescricaoDoFilme() {
        return descricaoDoFilme;
    }

    public void setDescricaoDoFilme(String descricaoDoFilme) {
        this.descricaoDoFilme = descricaoDoFilme;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(capaDoFilme);
        parcel.writeString(notaDoFilme);
        parcel.writeString(nomeDoFilme);
        parcel.writeString(descricaoDoFilme);
    }
}
