/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AdminDao;
import dao.AdminDaoImpl;
import dao.guestDao;
import dao.guestDaoImpl;
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
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author ARMIN
 */
@Named(value = "guestOstaloBean")
@RequestScoped
public class guestOstaloBean {
    
    private List<Artikal> ostalo;
    private Artikal selectedOstalo;

    public guestOstaloBean() {
        this.ostalo = new ArrayList<Artikal>();
    }

    public List<Artikal> getOstalo() {
        
        guestDao guestdao = new guestDaoImpl();
        this.ostalo = guestdao.findAllOstalo();
        
        return ostalo;
    }
    
    public Artikal getSelectedOstalo() {
        return selectedOstalo;
    }

    public void setSelectedOstalo(Artikal selectedOstalo) {
        this.selectedOstalo = selectedOstalo;
    }
    
    
}
