package model;
// Generated Nov 8, 2017 10:51:57 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Prodavac generated by hbm2java
 */
@Entity
@Table(name="prodavac"
    ,catalog="muzicka_prodavnica"
)
public class Prodavac  implements java.io.Serializable {


     private Integer idProdavac;
     private String ime;
     private String prezime;
     private String username;
     private String password;

    public Prodavac() {
    }

    public Prodavac(String ime, String prezime, String username, String password) {
       this.ime = ime;
       this.prezime = prezime;
       this.username = username;
       this.password = password;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_prodavac", unique=true, nullable=false)
    public Integer getIdProdavac() {
        return this.idProdavac;
    }
    
    public void setIdProdavac(Integer idProdavac) {
        this.idProdavac = idProdavac;
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




}


