/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AdminDao;
import dao.AdminDaoImpl;
import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Artikal;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;




/**
 *
 * @author ARMIN
 */
@ManagedBean(name = "AdminArtikliBean") 
@SessionScoped
public class AdminArtikliBean {

    private List<Artikal> artikli;
    private Artikal selectedArtikli;
    private Artikal noviArtikal;
     
    public AdminArtikliBean() {
        this.artikli = new ArrayList<Artikal>();
        this.noviArtikal = new Artikal();
    }

    public Artikal getNoviArtikal() {
        return noviArtikal;
    }

    public void setNoviArtikal(Artikal noviArtikal) {
        this.noviArtikal = noviArtikal;
    }

    public List<Artikal> getArtikli() {
        
        AdminDao adminDao = new AdminDaoImpl();
        this.artikli = adminDao.findAll();
        
        return artikli;
    }

    public Artikal getSelectedArtikli() {
        return selectedArtikli;
    }

    public void setSelectedArtikli(Artikal selectedArtikli) {
        this.selectedArtikli = selectedArtikli;
    }
    

    public void btnCreateArtikli(ActionEvent actionEvent){
        AdminDao adminDao = new AdminDaoImpl();
        String msg;
        if(adminDao.create(this.noviArtikal)){
            msg="Uspješan unos!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        else{
            msg="Greška!";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    
    public void btnUpdateArtikli(ActionEvent actionEvent){
        AdminDao adminDao = new AdminDaoImpl();
        String msg;

        if(adminDao.update(this.selectedArtikli)){
            msg="Uspješno ažuriranje!";
        FacesMessage massage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, massage);
        }
        else{
            msg="Greška!";
        FacesMessage massage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
        FacesContext.getCurrentInstance().addMessage(null, massage);
        }
    
    }
        
    public void btnDeleteArtikli(ActionEvent actionEvent){
        
        AdminDao adminDao = new AdminDaoImpl();
        String msg; 
        if(adminDao.delete(this.selectedArtikli.getIdArtikal())){
            msg="Uspješno brisanje!";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        }
        else{
            msg="Greška!";
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
        FacesContext.getCurrentInstance().addMessage(null, message);
        }
    } 
    
}