package model;
// Generated Nov 8, 2017 10:51:57 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Kupac generated by hbm2java
 */
@Entity
@Table(name="kupac"
    ,catalog="muzicka_prodavnica"
)
public class Kupac  implements java.io.Serializable {


     private Integer idKupac;
     private String ime;
     private String prezime;
     private String username;
     private String password;
     private String email;
     private String adresa;
     private int brTelefona;
     private int brKupljenihArtikala;

    public Kupac() {
    }

    public Kupac(String ime, String prezime, String username, String password, String email, String adresa, int brTelefona, int brKupljenihArtikala) {
       this.ime = ime;
       this.prezime = prezime;
       this.username = username;
       this.password = password;
       this.email = email;
       this.adresa = adresa;
       this.brTelefona = brTelefona;
       this.brKupljenihArtikala = brKupljenihArtikala;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_kupac", unique=true, nullable=false)
    public Integer getIdKupac() {
        return this.idKupac;
    }
    
    public void setIdKupac(Integer idKupac) {
        this.idKupac = idKupac;
    }

    
    @Column(name="ime", nullable=false, length=45)
    public String getIme() {
        return this.ime;
    }
    
    public void setIme(String ime) {
        this.ime = ime;
    }

    
    @Column(name="prezime", nullable=false, length=45)
    public String getPrezime() {
        return this.prezime;
    }
    
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    
    @Column(name="username", nullable=false, length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="email", nullable=false, length=45)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="adresa", nullable=false, length=45)
    public String getAdresa() {
        return this.adresa;
    }
    
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    
    @Column(name="br_telefona", nullable=false)
    public int getBrTelefona() {
        return this.brTelefona;
    }
    
    public void setBrTelefona(int brTelefona) {
        this.brTelefona = brTelefona;
    }

    
    @Column(name="br_kupljenih_artikala", nullable=false)
    public int getBrKupljenihArtikala() {
        return this.brKupljenihArtikala;
    }
    
    public void setBrKupljenihArtikala(int brKupljenihArtikala) {
        this.brKupljenihArtikala = brKupljenihArtikala;
    }




}

