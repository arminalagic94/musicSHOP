/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Artikal;
import model.Kupac;
import model.Racun;
import util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author ARMIN
 */
public class UserDaoImpl implements UserDao{

    @Override
    public Kupac findByKupac(Kupac username) {
          Kupac model = null;
          Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
          String sql = "FROM Kupac WHERE username='"+username.getUsername()+"'";
          
          try{
              sesion.getTransaction().begin();
              model = (Kupac) sesion.createQuery(sql).uniqueResult();
              sesion.getTransaction().commit();
          } catch(Exception e){
              
              sesion.getTransaction().rollback();
          
          }
          
          return model;
    }

    @Override
    public Kupac login(Kupac username) {
            Kupac model = this.findByKupac(username);
            if (model != null){
            
                if(!username.getPassword().equals(model.getPassword())){
                    
                    model = null;
                    
                }
                
            }
            
            return model;
    }

@Override
    public List<Artikal> findAllBubnjevi() {
        List<Artikal> lista = null;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "FROM Artikal WHERE tip='bubanj' and brKomada>0";

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
        String sql = "FROM Artikal WHERE tip='gitara' and brKomada>0"; 

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
        String sql = "FROM Artikal WHERE tip='klavijatura' and brKomada>0";

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
        String sql = "FROM Artikal WHERE tip='ostalo' and brKomada>0";

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
    public List<Racun> findAllRacun(Kupac k) {
        
        List<Racun> model = null;
        Session sesion = (Session)HibernateUtil.getSessionFactory().openSession();
        String sql = "FROM Racun WHERE idKupac = '"+k.getIdKupac()+"'";
        try {
            sesion.getTransaction().begin();
            model = sesion.createQuery(sql).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            sesion.getTransaction().rollback();
        }

        return model;

    }
    
    @Override
    public List<Kupac> findAllPodaci(Kupac k) {
        
        List<Kupac> model = null;
        Session sesion = (Session)HibernateUtil.getSessionFactory().openSession();
        String sql = "FROM Kupac WHERE idKupac = '"+k.getIdKupac()+"'";
        try {
            sesion.getTransaction().begin();
            model = sesion.createQuery(sql).list();
            sesion.getTransaction().commit();
        } catch (Exception e) {
            sesion.getTransaction().rollback();
        }

        return model;

    }
    
    @Override
    public boolean updateBrArtikalaK(Kupac kupac) {
        boolean flag = false;
        Session sesion = (Session) HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            sesion.getTransaction().begin();
            Kupac kupacdb = (Kupac) sesion.load(Kupac.class, kupac.getIdKupac());

            kupacdb.setBrKupljenihArtikala(kupacdb.getBrKupljenihArtikala() - 1);

            sesion.update(kupacdb);
            sesion.getTransaction().commit();
            flag = true;
        } catch (Exception e) {

            flag = false;
            sesion.getTransaction().rollback();

        }

        return flag;
    }

    @Override
    public boolean updateArtikalK(Racun r) {
        boolean flag = false;
        Session sesion = (Session) HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            sesion.getTransaction().begin();
            Artikal artikaldb = (Artikal) sesion.load(Artikal.class, r.getIdArtikal());

            artikaldb.setBrKomada(artikaldb.getBrKomada() + 1);

            sesion.update(artikaldb);
            sesion.getTransaction().commit();
            flag = true;
        } catch (Exception e) {

            flag = false;
            sesion.getTransaction().rollback();

        }

        return flag;
    }

    @Override
    public boolean deleteRacun(Integer idRacun) {
          boolean flag = false;
          Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            
          try{
              sesion.getTransaction().begin();
              Racun racun = (Racun) sesion.load(Racun.class, idRacun);
              sesion.delete(racun);
              sesion.getTransaction().commit();
              flag = true;
          } catch(Exception e){
              
              flag = false;
              sesion.getTransaction().rollback();
          
          }
          
          return flag;
    }
    
    @Override
    public boolean updateKupac(Kupac k) {
        boolean flag = false;
        Session sesion = (Session)HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            sesion.getTransaction().begin();
            Kupac kupacdb = (Kupac)sesion.load(Kupac.class, k.getIdKupac());

            kupacdb.setIme(k.getIme());
            kupacdb.setPrezime(k.getPrezime());
            kupacdb.setUsername(k.getUsername());
            kupacdb.setPassword(k.getPassword());
            kupacdb.setAdresa(k.getAdresa());
            kupacdb.setEmail(k.getEmail());
            kupacdb.setBrTelefona(k.getBrTelefona());

            sesion.update(kupacdb);
            sesion.getTransaction().commit();
            flag = true;
        } catch (Exception e) {

            flag = false;
            sesion.getTransaction().rollback();

        }

        return flag;
    }

    @Override
    public boolean createKupac(Kupac kupac) {
          boolean flag = false;
          Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
            
          try{
              sesion.getTransaction().begin();
              sesion.save(kupac);
              sesion.getTransaction().commit();
              flag = true;
          } catch(Exception e){
              
              flag = false;
              sesion.getTransaction().rollback();
          
          }
          
          return flag;
    }
    
    @Override
    public boolean updateBrArtikala(Kupac k) {
        boolean flag = false;
        Session sesion = (Session) HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            sesion.getTransaction().begin();
            Kupac kupacdb = (Kupac) sesion.load(Kupac.class, k.getIdKupac());

            kupacdb.setBrKupljenihArtikala(kupacdb.getBrKupljenihArtikala() + 1);

            sesion.update(kupacdb);
            sesion.getTransaction().commit();
            flag = true;
        } catch (Exception e) {

            flag = false;
            sesion.getTransaction().rollback();

        }

        return flag;
    }

    @Override
    public boolean updateArtikal(Artikal a) {
        boolean flag = false;
        Session sesion = (Session) HibernateUtil.getSessionFactory().getCurrentSession();

        try {

            sesion.getTransaction().begin();
            Artikal artikaldb = (Artikal) sesion.load(Artikal.class, a.getIdArtikal());

            artikaldb.setBrKomada(artikaldb.getBrKomada() - 1);

            sesion.update(artikaldb);
            sesion.getTransaction().commit();
            flag = true;
        } catch (Exception e) {

            flag = false;
            sesion.getTransaction().rollback();

        }

        return flag;
    }


    @Override
    public boolean createRacun(Racun r) {
        boolean zastava;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            sesion.getTransaction().begin();
            sesion.save(r);
            sesion.getTransaction().commit();
            zastava = true;
        } catch (Exception e) {
            zastava = false;
            sesion.getTransaction().rollback();
        }

        return zastava;
    }
  
}
