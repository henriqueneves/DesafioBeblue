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

    @Value("${spotify.api.client-id}")
    private String clientId;
    @Value("${spotify.api.cliente-secret}")
    private String clientSecret;

    private SpotifyApi spotifyApi;
    private ClientCredentialsRequest clientCredentialsRequest;

    public void credenciarEGerarToken() {

        try {
            spotifyApi = new SpotifyApi.Builder()
                    .setClientId(clientId)
                    .setClientSecret(clientSecret)
                    .build();
            
            clientCredentialsRequest = spotifyApi.clientCredentials()
                    .build();
            
            ClientCredentials clientCredentials = clientCredentialsRequest.execute();
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

    public List<Disco> getDiscosPorGeneroEQuantidade(Iterable<GeneroMusical> generosMusicais, Integer quantidade) {
        List<Disco> listaDiscos = new ArrayList();
        credenciarEGerarToken();
        for (GeneroMusical generoMusical : generosMusicais) {
            for (AlbumSimplified album : buscarAlbuns(generoMusical.getNome(), quantidade)) {
                listaDiscos.add(new Disco(album, generoMusical));
            }
        }
        return listaDiscos;
    }

}
