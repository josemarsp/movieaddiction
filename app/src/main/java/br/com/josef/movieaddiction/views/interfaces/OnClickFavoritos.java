package br.com.josef.movieaddiction.views.interfaces;

import br.com.josef.movieaddiction.model.pojos.movieid.Filme;

public interface OnClickFavoritos {
        void onClickFavoritos(Filme filme);
        void removeClickFavoritos(Filme filme);
}
