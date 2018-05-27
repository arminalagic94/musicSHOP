/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UserDao;
import dao.UserDaoImpl;
import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Kupac;

/**
 *
 * @author ARMIN
 */
@Named(value = "kupacBean")
@RequestScoped
public class kupacBean {
    
    private Kupac noviKupac;

    /**
     * Creates a new instance of kupacBean
     */
    public kupacBean() {
        
        this.noviKupac = new Kupac();
        
    }

    public Kupac getNoviKupac() {
        return noviKupac;
    }

    public void setNoviKupac(Kupac noviKupac) {
        this.noviKupac = noviKupac;
    }

    public void btnCreateKupac(ActionEvent actionEvent) {
        UserDao userDao = new UserDaoImpl();
        String msg;
        if (userDao.createKupac(this.noviKupac)) {
            msg = "Uspješan unos!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Greška!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
       
}
