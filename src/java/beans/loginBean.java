/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AdminDao;
import dao.AdminDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import java.awt.event.ActionEvent;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Kupac;
import org.primefaces.context.RequestContext;
import util.MyUtil;
import javax.servlet.http.HttpSession;
import model.Prodavac;

/**
 *
 * @author ARMIN
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    private Kupac username;
    private UserDao usernameDao;
    private Prodavac usernameAdmin;
    private AdminDao usernameAdminDao;
        
    public loginBean() {
        this.usernameDao = new UserDaoImpl();
        if(this.username == null){
        
            this.username=new Kupac();
            
        }
        
        this.usernameAdminDao = new AdminDaoImpl();
        if(this.usernameAdmin == null){
        
            this.usernameAdmin=new Prodavac();
            
        }
        
    }
    
  
    public Kupac getUsername() {
        return username;
    }

    public void setUsername(Kupac username) {
        this.username = username;
    }
    
    public Prodavac getUsernameAdmin() {
        return usernameAdmin;
    }

    public void setUsernameAdmin(Prodavac usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }
    
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message;
        boolean loggedIn;
        String ruta = "";        
        
        this.username = this.usernameDao.login(this.username);
        this.usernameAdmin = this.usernameAdminDao.login(this.usernameAdmin);
        
        if(this.username != null && this.usernameAdmin == null){
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", this.username.getUsername());
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dobrodošli", this.username.getUsername());
            ruta=MyUtil.basepathlogin()+"index_kupac.xhtml";
        }
                
        else if(this.username == null && this.usernameAdmin != null){
            loggedIn = true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usernameAdmin", this.usernameAdmin.getUsername());
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dobrodošli", this.usernameAdmin.getUsername());
            ruta=MyUtil.basepathlogin()+"index_admin.xhtml";
        }
        
        else {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "GREŠKA!", "Pogrešni podaci");
            loggedIn = false;
        }
        
        if (this.username == null) {
            this.username = new Kupac();
        }
        
        if (this.usernameAdmin == null) {
            this.usernameAdmin = new Prodavac();
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }   
       
public String odjava() {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        String a="index?faces-redirect=true";
        System.out.println(a);
        return a;
    }
}
