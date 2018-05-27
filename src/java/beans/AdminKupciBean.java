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
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Artikal;
import model.Kupac;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author ARMIN
 */
@Named(value = "AdminKupciBean")
@RequestScoped
public class AdminKupciBean {
    
    private List<Kupac> kupci;
    private Kupac selectedKupci;
     
    public AdminKupciBean() {
        this.kupci = new ArrayList<Kupac>();
    }

    public List<Kupac> getKupci() {
                
        AdminDao adminDao = new AdminDaoImpl();
        this.kupci = adminDao.findAllKupci();
        
        return kupci;
    }

    public Kupac getSelectedKupci() {
        return selectedKupci;
    }

    public void setSelectedKupci(Kupac selectedKupci) {
        this.selectedKupci = selectedKupci;
    }
    
}
