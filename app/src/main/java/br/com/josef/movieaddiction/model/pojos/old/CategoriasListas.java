package br.com.josef.movieaddiction.model.pojos.old;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoriasListas implements Parcelable {

    private String TexTCategoria;

    public CategoriasListas(String texTCategoria) {
        TexTCategoria = texTCategoria;
    }

    protected CategoriasListas(Parcel in) {
        TexTCategoria = in.readString();
    }

    public static final Creator<CategoriasListas> CREATOR = new Creator<CategoriasListas>() {
        @Override
        public CategoriasListas createFromParcel(Parcel in) {
            return new CategoriasListas(in);
        }

        @Override
        public CategoriasListas[] newArray(int size) {
            return new CategoriasListas[size];
        }
    };

    public String getTexTCategoria() {
        return TexTCategoria;
    }

    public void setTexTCategoria(String texTCategoria) {
        TexTCategoria = texTCategoria;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(TexTCategoria);
    }
}