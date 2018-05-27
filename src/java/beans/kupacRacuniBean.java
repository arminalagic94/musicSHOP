/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UserDao;
import dao.UserDaoImpl;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Racun;

/**
 *
 * @author ARMIN
 */
@ManagedBean(name = "kupacRacuniBean")
@SessionScoped
public class kupacRacuniBean {
    
    private List<Racun> racun;
    private Racun selectedRacun;
    
    @ManagedProperty(value = "#{loginBean}")
    private loginBean lb;
    /**
     * Creates a new instance of kupacRacuniBean
     */
    public kupacRacuniBean() {
        this.racun = new ArrayList<Racun>();
    }

        public loginBean getLb() {
        return lb;
    }

    public void setLb(loginBean lb) {
        this.lb = lb;
    }
    
    public List<Racun> getRacun() {
        UserDao userDao = new UserDaoImpl();
        this.racun = userDao.findAllRacun(this.lb.getUsername());
        return racun;
    }

    public Racun getSelectedRacun() {
        return selectedRacun;
    }

    public void setSelectedRacun(Racun selectedRacun) {
        this.selectedRacun = selectedRacun;
    }
    
    public void UpdateBrArtikalaK(ActionEvent actionEvent) {
        UserDao userDao = new UserDaoImpl();
        String msg;
        if (userDao.updateBrArtikalaK(this.lb.getUsername())) {
            msg = "Uspješno ažuriranje!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Greška!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void UpdateArtikalK(ActionEvent actionEvent) {
        UserDao userDao = new UserDaoImpl();
        String msg;
        if (userDao.updateArtikalK(this.selectedRacun)) {
            msg = "Uspješno ažuriranje!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Greška!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }
    
    public void btnDeleteRacun(ActionEvent actionEvent) {
        UserDao userDao = new UserDaoImpl();
        String msg;
        if (userDao.deleteRacun(this.selectedRacun.getIdRacun())) {
            msg = "Uspješno brisanje!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            userDao.updateBrArtikalaK(this.lb.getUsername());
            userDao.updateArtikalK(this.selectedRacun);
        } else {
            msg = "Greška!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        
        
        
    }
   
}
