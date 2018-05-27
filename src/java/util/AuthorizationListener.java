/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ARMIN
 */
public class AuthorizationListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String currentPage = facesContext.getViewRoot().getViewId();
        boolean isLoginPage = (currentPage.lastIndexOf("prijava.xhtml") > -1) ? true : false;
        HttpSession sesion = (HttpSession) facesContext.getExternalContext().getSession(true);
        
        Object username = sesion.getAttribute("username");
        Object usernameAdmin = sesion.getAttribute("usernameAdmin");

        /* PROBLEM PREDSTAVLJA OVAJ JEBENI IF 
        
        if (!isLoginPage && username == null) { 
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "/index_kupac.xhtml");
        }

        if (!isLoginPage && usernameAdmin == null) {
            NavigationHandler nh = facesContext.getApplication().getNavigationHandler();
            nh.handleNavigation(facesContext, null, "/index_admin.xhtml");
        }
        */
        
    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
