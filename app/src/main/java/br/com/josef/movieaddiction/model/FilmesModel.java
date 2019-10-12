package br.com.josef.movieaddiction.model;
import android.os.Parcel;
import android.os.Parcelable;

public class FilmesModel implements Parcelable {

    private int imagem;
    private String nome;
    private String sinopse;
    private String elenco;
    private String notaFilme;
    private String anoLancamento;
    private String tempoDuracao;
    private String censura;
    private String categoria;

    public FilmesModel(int hobbit, String o_hobbit) {
    }

    public FilmesModel(int imagem, String nome, String sinopse, String elenco, String notaFilme, String anoLancamento, String tempoDuracao, String censura, String categoria) {
        this.imagem = imagem;
        this.nome = nome;
        this.sinopse = sinopse;
        this.elenco = elenco;
        this.notaFilme = notaFilme;
        this.anoLancamento = anoLancamento;
        this.tempoDuracao = tempoDuracao;
        this.censura = censura;
        this.categoria = categoria;
    }

    protected FilmesModel(Parcel in) {
        imagem = in.readInt();
        nome = in.readString();
        sinopse = in.readString();
        elenco = in.readString();
        notaFilme = in.readString();
        anoLancamento = in.readString();
        tempoDuracao = in.readString();
        censura = in.readString();
        categoria = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imagem);
        dest.writeString(nome);
        dest.writeString(sinopse);
        dest.writeString(elenco);
        dest.writeString(notaFilme);
        dest.writeString(anoLancamento);
        dest.writeString(tempoDuracao);
        dest.writeString(censura);
        dest.writeString(categoria);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getNotaFilme() {
        return notaFilme;
    }

    public void setNotaFilme(String notaFilme) {
        this.notaFilme = notaFilme;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(String tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }

    public String getCensura() {
        return censura;
    }

    public void setCensura(String censura) {
        this.censura = censura;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}