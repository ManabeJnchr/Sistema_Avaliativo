/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vo;

import java.sql.Timestamp;

/**
 *
 * @author José Victor, Lucas Felipe, Lucas Samuel
 */
public class RelatorioSetorVO {
    private String nome_setor;
    private int quantidade_avaliacoes;
    private double media_avaliacoes;

    public String getNome_setor() {
        return nome_setor;
    }
    public void setNome_setor(String nome_setor) {
        this.nome_setor = nome_setor;
    }
    public int getQuantidade_avaliacoes() {
        return quantidade_avaliacoes;
    }
    public void setQuantidade_avaliacoes(int quantidade_avaliacoes) {
        this.quantidade_avaliacoes = quantidade_avaliacoes;
    }
    public double getMedia_avaliacoes() {
        return media_avaliacoes;
    }
    public void setMedia_avaliacoes(double media_avaliacoes) {
        this.media_avaliacoes = media_avaliacoes;
    }
}
