package com.example.core.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author furlan
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "name")
    private String nameUser;
    @Column(name = "email")
    private String emailUser;
    @Column(name = "senha")
    private String senhaUser;
    @Column(name = "confirmarsenha")
    private String confirmarSenha;
    @Column(name = "nrtentativasacesso")
    private int nrTentativasAcesso = 0;
    @Column(name = "bloqueado")
    private String bloqueado = "N";
    private String ativo = "S";

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public int getNrTentativasAcesso() {
        return nrTentativasAcesso;
    }

    public void setNrTentativasAcesso(int nrTentativasAcesso) {
        this.nrTentativasAcesso = nrTentativasAcesso;
    }

    public String getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(String bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }
}
