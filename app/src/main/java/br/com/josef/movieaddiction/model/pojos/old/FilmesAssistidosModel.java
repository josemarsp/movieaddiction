package br.com.josef.movieaddiction.model.pojos.old;
import android.os.Parcel;
import android.os.Parcelable;

public class FilmesAssistidosModel implements Parcelable {
    private int capaDoFilme;
    private String notaDoFilme;
    private String nomeDoFilme;
    private String descricaoDoFilme;

    public FilmesAssistidosModel(int capaDoFilme, String notaDoFilme, String nomeDoFilme, String descricaoDoFilme) {
        this.capaDoFilme = capaDoFilme;
        this.notaDoFilme = notaDoFilme;
        this.nomeDoFilme = nomeDoFilme;
        this.descricaoDoFilme = descricaoDoFilme;
    }

    protected FilmesAssistidosModel(Parcel in) {
        capaDoFilme = in.readInt();
        notaDoFilme = in.readString();
        nomeDoFilme = in.readString();
        descricaoDoFilme = in.readString();
    }

    public static final Creator<FilmesAssistidosModel> CREATOR = new Creator<FilmesAssistidosModel>() {
        @Override
        public FilmesAssistidosModel createFromParcel(Parcel in) {
            return new FilmesAssistidosModel(in);
        }

        @Override
        public FilmesAssistidosModel[] newArray(int size) {
            return new FilmesAssistidosModel[size];
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

    public void setNotaDoFilme(double notaDoFilme) {
        this.notaDoFilme = nomeDoFilme;
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