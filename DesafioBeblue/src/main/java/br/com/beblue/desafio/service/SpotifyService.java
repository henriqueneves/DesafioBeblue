package br.com.beblue.desafio.service;

import br.com.beblue.desafio.model.Disco;
import br.com.beblue.desafio.model.GeneroMusical;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.enums.ModelObjectType;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import com.wrapper.spotify.requests.data.search.simplified.SearchAlbumsRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author henri
 */
@Service
public class SpotifyService {

    private static final String clientId = "98435399fdb94597b2d893648a9b8cbc";
    private static final String clientSecret = "0981742c5d2f4f88aa41f28058ea4cc6";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .build();

    private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
            .build();

    public static void credenciarEGerarToken() {
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            System.out.println("Expira em: " + clientCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public AlbumSimplified[] buscarAlbuns(String query, Integer quantidade) {
        final SearchAlbumsRequest searchAlbumsRequest = spotifyApi.searchAlbums(query)
                .limit(quantidade)
                .build();

        try {
            return searchAlbumsRequest.execute().getItems();
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Erro: " + e.getMessage());

        }
        return null;
    }

    public void importarDiscosPorGeneroEQuantidade(Iterable<GeneroMusical> generosMusicais, Integer quantidade) {
        credenciarEGerarToken();
        for (GeneroMusical generoMusical : generosMusicais) {
            List<Disco> listaDiscos = new ArrayList();
            for(AlbumSimplified album : buscarAlbuns(generoMusical.getNome(), quantidade)){
                listaDiscos.add(new Disco(album));
            }
        }

    }

}
