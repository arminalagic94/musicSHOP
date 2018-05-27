/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AdminDao;
import dao.AdminDaoImpl;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Artikal;
import model.Kupac;
import model.Racun;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author ARMIN
 */
@Named(value = "AdminRedovniBean")
@RequestScoped
public class AdminRedovniBean {

    private List<Kupac> redovni;
    private Kupac selectedRedovni;
    
    public AdminRedovniBean() {
         this.redovni = new ArrayList<Kupac>();
    }
    
    public List<Kupac> getRedovni() {
        
        AdminDao adminDao = new AdminDaoImpl();
        this.redovni = adminDao.findAllRedovni();
        return redovni;
    }

    public Kupac getSelectedRedovni() {
        return selectedRedovni;
    }

    public void setSelectedRedovni(Kupac selectedRedovni) {
        this.selectedRedovni = selectedRedovni;
    }

}
