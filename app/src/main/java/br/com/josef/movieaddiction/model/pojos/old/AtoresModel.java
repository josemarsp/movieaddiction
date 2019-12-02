package br.com.josef.movieaddiction.model.pojos.old;

import android.os.Parcel;
import android.os.Parcelable;

public class AtoresModel implements Parcelable {

    private int imagem;
    private String nome;

    public AtoresModel () {

    }

    public AtoresModel(String nome, int imagem) {
        this.nome = nome;
        this.imagem = imagem;

    }

    protected AtoresModel(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
    }

    public static final Creator<AtoresModel> CREATOR = new Creator<AtoresModel>() {
        @Override
        public AtoresModel createFromParcel(Parcel in) {
            return new AtoresModel(in);
        }

        @Override
        public AtoresModel[] newArray(int size) {
            return new AtoresModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nome);
    }
}
