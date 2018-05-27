/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UserDao;
import dao.UserDaoImpl;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Artikal;
import model.Kupac;
import model.Racun;

/**
 *
 * @author ARMIN
 */
@ManagedBean(name = "kupacKupiBean")
@SessionScoped
public class kupacKupiBean {

    private Artikal artikal;
    private Racun racun;
    
    @ManagedProperty(value = "#{loginBean}")
    private loginBean lb;

    public kupacKupiBean() {
        this.racun = new Racun();
        this.artikal = new Artikal();
    }
    
    public loginBean getLb() {
        return lb;
    }

    public void setLb(loginBean lb) {
        this.lb = lb;
    }

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }
    
    public void UpdateBrArtikala(ActionEvent actionEvent) {
        UserDao userDao = new UserDaoImpl();
        String msg;
        if (userDao.updateBrArtikala(this.lb.getUsername())) {
            msg = "Uspješno ažuriranje!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Greška!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void UpdateArtikal(ActionEvent actionEvent) {
        UserDao userDao = new UserDaoImpl();
        String msg;
        if (userDao.updateArtikal(this.artikal)) {
            msg = "Uspješno ažuriranje!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);

        } else {
            msg = "Greška!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }
    
    
    public void btnCreateRacun(Kupac k) {
        UserDao userDao = new UserDaoImpl();
        String msg;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String datum = dateFormat.format(date);
        
        int ka = k.getIdKupac();
        System.out.println(ka);
        
        this.racun.setBrKomada(1);
        this.racun.setDatum(java.sql.Date.valueOf(datum));
        this.racun.setIdKupac(k.getIdKupac());
        this.racun.setIdProdavac(1);
        this.racun.setIdArtikal(this.artikal.getIdArtikal());
        if(k.getBrKupljenihArtikala() > 9){
        this.racun.setUkupnaCijena(this.artikal.getPopustCijena());
        }else{
        this.racun.setUkupnaCijena(this.artikal.getRedovnaCijena());
        }

        if (userDao.createRacun(this.racun)) {
            msg = "Kupljeno!";
            userDao.updateBrArtikala(this.lb.getUsername());
            userDao.updateArtikal(this.artikal);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            
        } else {
            msg = "Greška!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
}
