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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Artikal;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author ARMIN
 */
@ManagedBean(name = "kupacBubnjeviBean")
@SessionScoped
public class kupacBubnjeviBean {
    
    private List<Artikal> bubnjevi;
    private Artikal selectedBubnjevi;

    public kupacBubnjeviBean() {
        this.bubnjevi = new ArrayList<Artikal>();
    }

    public List<Artikal> getBubnjevi() {
        
        UserDao userdao = new UserDaoImpl();
        this.bubnjevi = userdao.findAllBubnjevi();
        
        return bubnjevi;
    }

    public Artikal getSelectedBubnjevi() {
        return selectedBubnjevi;
    }

    public void setSelectedBubnjevi(Artikal selectedBubnjevi) {
        this.selectedBubnjevi = selectedBubnjevi;
    }
    
}
