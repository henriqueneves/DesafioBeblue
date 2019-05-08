package br.com.beblue.desafio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wrapper.spotify.model_objects.specification.AlbumSimplified;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author henri
 */
@Entity
public class Disco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(updatable = false)
    private GeneroMusical generoMusical;
    private BigDecimal preco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disco")
    @JsonIgnore
    private List<VendaDisco> vendaDiscos = new ArrayList();

    public Disco() {
    }
    
    public Disco(Long id) {
        this.id = id;
    }

    public Disco(AlbumSimplified album, GeneroMusical generoMusical) {
        this.nome = album.getName();
        this.generoMusical = generoMusical;
        this.preco = geraPrecoAleatorio();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    public void transformaEmDiscoComPrecoAleatorio(AlbumSimplified album) {

    }

    private BigDecimal geraPrecoAleatorio() {
        return new BigDecimal((new Random().nextDouble() * 99) + 1);
    }

}
