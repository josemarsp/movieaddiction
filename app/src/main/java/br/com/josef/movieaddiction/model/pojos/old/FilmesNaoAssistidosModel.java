package br.com.josef.movieaddiction.model.pojos.old;
import android.os.Parcel;
import android.os.Parcelable;

public class FilmesNaoAssistidosModel implements Parcelable {
    private int capaDoFilme;
    private String notaDoFilme;
    private String nomeDoFilme;
    private String descricaoDoFilme;

    public FilmesNaoAssistidosModel(int capaDoFilme, String notaDoFilme, String nomeDoFilme, String descricaoDoFilme) {
        this.capaDoFilme = capaDoFilme;
        this.notaDoFilme = notaDoFilme;
        this.nomeDoFilme = nomeDoFilme;
        this.descricaoDoFilme = descricaoDoFilme;
    }

    protected FilmesNaoAssistidosModel(Parcel in) {
        capaDoFilme = in.readInt();
        notaDoFilme = in.readString();
        nomeDoFilme = in.readString();
        descricaoDoFilme = in.readString();
    }

    public static final Creator<FilmesNaoAssistidosModel> CREATOR = new Creator<FilmesNaoAssistidosModel>() {
        @Override
        public FilmesNaoAssistidosModel createFromParcel(Parcel in) {
            return new FilmesNaoAssistidosModel(in);
        }

        @Override
        public FilmesNaoAssistidosModel[] newArray(int size) {
            return new FilmesNaoAssistidosModel[size];
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