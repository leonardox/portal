package models;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by X on 14/03/2015.
 */


@Entity
@Table(name = "DICA")
public class Dica {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dicaID;

    @Column
    private long autorID;

    @Column
    private String conhecimento;

    @Column
    private String preRequisito;

    @Column
    private String razao;

    @Column
    private String material;

    @Column
    private String conselho;

    @Column
    private Date data;

    @Column
    private long temaID;

    @Column
    private int votos;

    @Column
    private int votosPositivos;

    @Column
    private int denuncias;

    @Column
    private boolean aberto;

    public Dica(){

    }

    public Dica(Usuario autor, Date data, Tema tema) {
        this.autorID = autor.getId();
        this.conhecimento = "";
        this.preRequisito = "";
        this.razao = "";
        this.material = "";
        this.conselho = "";
        this.data = data;
        temaID = tema.getID();

        votos = 0;
        votosPositivos= 0;
        denuncias = 0;
        aberto = true;
    }

    public int getVotosPositivos() {
        return votosPositivos;
    }

    public void setConhecimento(String conhecimento) {
        this.conhecimento = conhecimento;
    }

    public void setPreRequisito(String preRequisito) {
        this.preRequisito = preRequisito;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }

    public long getAutorID() {
        return autorID;
    }

    public String getConhecimento() {
        return conhecimento;
    }

    public String getPreRequisito() {
        return preRequisito;
    }

    public String getRazao() {
        return razao;
    }

    public String getMaterial() {
        return material;
    }

    public String getConselho() {
        return conselho;
    }

    public Date getData() {
        return data;
    }

    public long getTemaID() {
        return temaID;
    }

    public int getVotos() {
        return votos;
    }

    public int getDenuncias() {
        return denuncias;
    }

    public boolean isAberto() {
        return aberto;
    }

    public long getDicaID() {
        return dicaID;
    }
    public float getIndiceConcordancia() {
        return votosPositivos / votos;
    }

    public void incrementaVotos(Voto voto) {
        if (voto.getVoto() == 1){
            votosPositivos++;
        }
        votos++;
    }

}