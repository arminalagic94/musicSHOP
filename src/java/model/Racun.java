package model;
// Generated Nov 8, 2017 10:51:57 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Racun generated by hbm2java
 */
@Entity
@Table(name="racun"
    ,catalog="muzicka_prodavnica"
)
public class Racun  implements java.io.Serializable {


     private Integer idRacun;
     private int idKupac;
     private int idProdavac;
     private int idArtikal;
     private int brKomada;
     private String ukupnaCijena;
     private Date datum;

    public Racun() {
    }

    public Racun(int idKupac, int idProdavac, int idArtikal, int brKomada, String ukupnaCijena, Date datum) {
       this.idKupac = idKupac;
       this.idProdavac = idProdavac;
       this.idArtikal = idArtikal;
       this.brKomada = brKomada;
       this.ukupnaCijena = ukupnaCijena;
       this.datum = datum;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_racun", unique=true, nullable=false)
    public Integer getIdRacun() {
        return this.idRacun;
    }
    
    public void setIdRacun(Integer idRacun) {
        this.idRacun = idRacun;
    }

    
    @Column(name="id_kupac", nullable=false)
    public int getIdKupac() {
        return this.idKupac;
    }
    
    public void setIdKupac(int idKupac) {
        this.idKupac = idKupac;
    }

    
    @Column(name="id_prodavac", nullable=false)
    public int getIdProdavac() {
        return this.idProdavac;
    }
    
    public void setIdProdavac(int idProdavac) {
        this.idProdavac = idProdavac;
    }

    
    @Column(name="id_artikal", nullable=false)
    public int getIdArtikal() {
        return this.idArtikal;
    }
    
    public void setIdArtikal(int idArtikal) {
        this.idArtikal = idArtikal;
    }

    
    @Column(name="br_komada", nullable=false)
    public int getBrKomada() {
        return this.brKomada;
    }
    
    public void setBrKomada(int brKomada) {
        this.brKomada = brKomada;
    }

    
    @Column(name="ukupna_cijena", nullable=false)
    public String getUkupnaCijena() {
        return this.ukupnaCijena;
    }
    
    public void setUkupnaCijena(String ukupnaCijena) {
        this.ukupnaCijena = ukupnaCijena;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datum", nullable=false, length=10)
    public Date getDatum() {
        return this.datum;
    }
    
    public void setDatum(Date datum) {
        this.datum = datum;
    }




}

