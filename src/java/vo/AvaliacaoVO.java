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
public class AvaliacaoVO {
    private int id;
    private Integer id_usuario;
    private int id_setor;
    private int id_questao;
    private Integer nota;
    private Timestamp data_avaliacao;

    public AvaliacaoVO() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_setor() {
        return id_setor;
    }
    public void setId_setor(int id_setor) {
        this.id_setor = id_setor;
    }

    public int getId_questao() {
        return id_questao;
    }
    public void setId_questao(int id_questao) {
        this.id_questao = id_questao;
    }

    public Integer getNota() {
        return nota;
    }
    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Timestamp getData_avaliacao() {
        return data_avaliacao;
    }
    public void setData_avaliacao(Timestamp data_avaliacao) {
        this.data_avaliacao = data_avaliacao;
    }
}
