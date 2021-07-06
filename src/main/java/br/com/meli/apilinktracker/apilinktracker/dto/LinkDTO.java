package br.com.meli.apilinktracker.apilinktracker.dto;

public class LinkDTO {

    private String url;
    private Long linkId;
    private String senha;
    private int estatistica;

    public LinkDTO(String url, Long linkId, String senha) {
        this.url = url;
        this.linkId = linkId;
        this.senha = senha;
        this.estatistica = 0;
    }

    public String getUrl() {
        return url;
    }

    public Long getLinkId() {
        return linkId;
    }

    public String getSenha() {
        return senha;
    }

    public int getEstatistica() {
        return estatistica;
    }

    public void setEstatistica(int estatistica) {
        this.estatistica = estatistica;
    }
}
