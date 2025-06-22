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
    private String status; // 'ativo' ou 'inativo'
    private Timestamp data_cadastro;
    private Timestamp data_atualizacao;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Timestamp data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Timestamp getData_atualizacao() {
        return data_atualizacao;
    }

    public void setData_atualizacao(Timestamp data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }
}
