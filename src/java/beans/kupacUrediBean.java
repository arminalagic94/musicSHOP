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
import model.Kupac;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;


/**
 *
 * @author ARMIN
 */
@ManagedBean(name = "kupacUrediBean")
@SessionScoped
public class kupacUrediBean {
    
    private List<Kupac> kupac;
    private Kupac selectedKupac;
    
    @ManagedProperty(value = "#{loginBean}")
    private loginBean lb;

    /**
     * Creates a new instance of kupacUrediBean
     */
    public kupacUrediBean() {
        this.kupac = new ArrayList<Kupac>();
    }
    
    public loginBean getLb() {
        return lb;
    }

    public void setLb(loginBean lb) {
        this.lb = lb;
    }

    public List<Kupac> getKupac() {
        UserDao userDao = new UserDaoImpl();
        this.kupac = userDao.findAllPodaci(this.lb.getUsername());
        return kupac;
    }

    public Kupac getSelectedKupac() {
        return selectedKupac;
    }

    public void setSelectedKupac(Kupac selectedKupac) {
        this.selectedKupac = selectedKupac;
    }
    
    public void UpdateKupac(ActionEvent actionEvent){
        UserDao userDao = new UserDaoImpl();
        String msg;
        if(userDao.updateKupac(this.selectedKupac)){
            msg="Uspješno ažuriranje!";
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
