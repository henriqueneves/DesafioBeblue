package br.com.beblue.desafio.util.filters;

import org.springframework.data.domain.Sort.Direction;

/**
 *
 * @author henri
 */
public class FiltroPageRequest {

    private int pagina = 0;
    private int tamanho = 10;
    private String ordem = "ASC";
    private String ordenarPor;

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getOrdenarPor() {
        return ordenarPor;
    }

    public void setOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
    }
    
    public Direction getDirection(){
        if(ordem != null && ordem.toUpperCase().equals("DESC")){
            return Direction.DESC;
        } else {
            return Direction.ASC;
        }
    }

}
