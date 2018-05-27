/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Artikal;
import model.Kupac;
import model.Prodavac;
import model.Racun;
import util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ARMIN
 */
public class AdminDaoImpl implements AdminDao{

    @Override
    public Prodavac findByProdavac(Prodavac username) {
          Prodavac model = null;
          Session sesion = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
          String sql = "FROM Prodavac WHERE username='"+username.getUsername()+"'";
          
          try{
              sesion.getTransaction().begin();
              model = (Prodavac) sesion.createQuery(sql).uniqueResult();
              sesion.getTransaction().commit();
          } catch(Exception e){
              
              sesion.getTransaction().rollback();
          
          }
          
          return model;
    }
    
    @Override
    public Prodavac login(Prodavac username) {
            Prodavac model = this.findByProdavac(username);
            if (model != null){
            
                if(!username.getPassword().equals(model.getPassword())){
                    
                    model = null;
                    
                }
                
            }
            
            return model;
    }

    @Override
    public List<Artikal> findAll() {
        List<Artikal> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Artikal";

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
    public List<Kupac> findAllKupci() {
        List<Kupac> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Kupac";

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
        public List<Racun> findAllRacuni() {
        List<Racun> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Racun";

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
    public List<Kupac> findAllRedovni() {
        List<Kupac> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Kupac WHERE brKupljenihArtikala>9";

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
    public boolean create(Artikal naziv) {
          boolean flag = false;
          Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            
          try{
              sesion.getTransaction().begin();
              sesion.save(naziv);
              sesion.getTransaction().commit();
              flag = true;
          } catch(Exception e){
              
              flag = false;
              sesion.getTransaction().rollback();
          
          }
          
          return flag;
    }

    @Override
    public boolean update(Artikal naziv) {
          boolean flag = false;
          Session sesion = (Session) HibernateUtil.getSessionFactory().getCurrentSession();
          
          try{
              
              sesion.getTransaction().begin();
              Artikal artikaldb = (Artikal) sesion.load(Artikal.class, naziv.getIdArtikal()); //pisi ovdje

              artikaldb.setTip(naziv.getTip());
              
              artikaldb.setOpis(naziv.getOpis());
              artikaldb.setRedovnaCijena(naziv.getRedovnaCijena());
              artikaldb.setPopustCijena(naziv.getPopustCijena());
              artikaldb.setBrKomada(naziv.getBrKomada());
              
              
              sesion.update(artikaldb);
              sesion.getTransaction().commit();
              flag = true;
          } catch(Exception e){
              
              flag = false;
              sesion.getTransaction().rollback();
          
          }
          
          return flag;
    }

    @Override
    public boolean delete(Integer id) {
          boolean flag = false;
          Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            
          try{
              sesion.getTransaction().begin();
              Artikal artikaldb = (Artikal) sesion.load(Artikal.class, id); //pisi ovdje

              sesion.delete(artikaldb);
              sesion.getTransaction().commit();
              flag = true;
          } catch(Exception e){
              
              flag = false;
              sesion.getTransaction().rollback();
          
          }
          
          return flag;
    }
    
}