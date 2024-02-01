package it.betacom.GestionaleDipendenti.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "dipendente")
public class DipendenteModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cognome;
    @Temporal(TemporalType.DATE)
    private Date data_nascita;

    @Temporal(TemporalType.DATE)
    private Date data_assunzione;

    @Temporal(TemporalType.DATE)
    private Date data_fine_rapporto;
    private String sede_appartenza;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }

    public Date getData_assunzione() {
        return data_assunzione;
    }

    public void setData_assunzione(Date data_assunzione) {
        this.data_assunzione = data_assunzione;
    }

    public Date getData_fine_rapporto() {
        return data_fine_rapporto;
    }

    public void setData_fine_rapporto(Date data_fine_rapporto) {
        this.data_fine_rapporto = data_fine_rapporto;
    }

    public String getSede_appartenza() {
        return sede_appartenza;
    }

    public void setSede_appartenza(String sede_appartenza) {
        this.sede_appartenza = sede_appartenza;
    }

}
