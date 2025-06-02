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
public class QuestaoVO {
    private int id;
    private String pergunta;
    // private Timestamp dataCriacao;
    // private Timestamp dataAtualizacao;

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    // public Timestamp getDataCriacao() {;
    //     return dataCriacao;
    // }

    // public void setDataCriacao(Timestamp dataCriacao) {
    //     this.dataCriacao = dataCriacao;
    // }

    // public Timestamp getDataAtualizacao() {
    //     return dataAtualizacao;
    // }

    // public void setDataAtualizacao(Timestamp dataAtualizacao) {
    //     this.dataAtualizacao = dataAtualizacao;
    // }
}
