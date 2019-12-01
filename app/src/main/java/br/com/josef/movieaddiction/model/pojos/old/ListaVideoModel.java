package br.com.josef.movieaddiction.model.pojos.old;

public class ListaVideoModel {
    private int imageId;
    private String videoId;

    public ListaVideoModel(int imageId, String youtubeId) {
        this.imageId = imageId;
        this.videoId = youtubeId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getYoutubeId() {
        return videoId;
    }

    public void setYoutubeId(String youtubeId) {
        this.videoId = youtubeId;
    }
}
