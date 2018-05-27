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
@Named(value = "kupacGitareBean")
@RequestScoped
public class kupacGitareBean {

    private List<Artikal> gitare; 
    private Artikal selectedGitare;

    public kupacGitareBean() {
        this.gitare = new ArrayList<Artikal>();
    }

    public List<Artikal> getGitare() {
        
        UserDao userdao = new UserDaoImpl();
        this.gitare = userdao.findAllGitare();
        
        return gitare;
    }

    public Artikal getSelectedGitare() {
        return selectedGitare;
    }

    public void setSelectedGitare(Artikal selectedGitare) {
        this.selectedGitare = selectedGitare;
    }  
}
