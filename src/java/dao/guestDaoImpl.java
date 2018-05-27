/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Artikal;
import util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ARMIN
 */
public class guestDaoImpl implements guestDao{
    
    @Override
    public List<Artikal> findAllBubnjevi() {
        List<Artikal> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Artikal WHERE tip='bubanj'";

        try {
            sesion.getTransaction().begin();
            lista = sesion.createQuery(sql).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {

            sesion.getTransaction().rollback();

        }

        return lista;
    }
    
    @Override
    public List<Artikal> findAllGitare() {
        List<Artikal> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Artikal WHERE tip='gitara'";

        try {
            sesion.getTransaction().begin();
            lista = sesion.createQuery(sql).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {

            sesion.getTransaction().rollback();

        }

        return lista;
    }
    
    @Override
    public List<Artikal> findAllKlavijature() {
        List<Artikal> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Artikal WHERE tip='klavijatura'";

        try {
            sesion.getTransaction().begin();
            lista = sesion.createQuery(sql).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {

            sesion.getTransaction().rollback();

        }

        return lista;
    }
    
    @Override
    public List<Artikal> findAllOstalo() {
        List<Artikal> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Artikal WHERE tip='ostalo'";

        try {
            sesion.getTransaction().begin();
            lista = sesion.createQuery(sql).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {

            sesion.getTransaction().rollback();

        }

        return lista;
    }

}
