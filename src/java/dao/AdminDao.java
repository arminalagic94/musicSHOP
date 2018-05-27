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

/**
 *
 * @author ARMIN
 */
public interface AdminDao {
    public Prodavac findByProdavac(Prodavac username);
    public Prodavac login(Prodavac username);
    public List<Artikal> findAll();
    public List<Kupac> findAllKupci();
    public List<Racun> findAllRacuni();
    public List<Kupac> findAllRedovni();
    public boolean create(Artikal naziv);
    public boolean update(Artikal naziv);
    public boolean delete(Integer id);
}