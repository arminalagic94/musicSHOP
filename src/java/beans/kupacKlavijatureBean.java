/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.UserDao;
import dao.UserDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import model.Artikal;

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
@Named(value = "kupacKlavijatureBean")
@RequestScoped
public class kupacKlavijatureBean {

    private List<Artikal> klavijature;
    private Artikal selectedKlavijature;

    public kupacKlavijatureBean() {
        this.klavijature = new ArrayList<Artikal>();
    }

    public List<Artikal> getKlavijature() {
        
        UserDao userdao = new UserDaoImpl();
        this.klavijature = userdao.findAllKlavijature();
        
        return klavijature;
    }

    public Artikal getSelectedKlavijature() {
        return selectedKlavijature;
    }

    public void setSelectedKlavijature(Artikal selectedKlavijature) {
        this.selectedKlavijature = selectedKlavijature;
    }  
}
