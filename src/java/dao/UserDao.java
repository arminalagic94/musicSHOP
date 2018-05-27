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
/**
 *
 * @author ARMIN
 */
public interface UserDao {
    
    public Kupac findByKupac(Kupac username);
    public Kupac login(Kupac username);
    public List<Artikal> findAllBubnjevi();
    public List<Artikal> findAllGitare();
    public List<Artikal> findAllKlavijature();
    public List<Artikal> findAllOstalo();
    public List<Kupac> findAllPodaci(Kupac k);
    public boolean updateKupac(Kupac kupac);
    public List<Racun> findAllRacun(Kupac k);
    public boolean deleteRacun(Integer idRacun);
    public boolean createKupac(Kupac kupac);
    public boolean createRacun(Racun r);
    public boolean updateBrArtikala(Kupac kupac);
    public boolean updateArtikal(Artikal artikal);
    public boolean updateBrArtikalaK(Kupac kupac);
    public boolean updateArtikalK(Racun r);
    
}
