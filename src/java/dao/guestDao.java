/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Artikal;

/**
 *
 * @author ARMIN
 */
public interface guestDao {
    public List<Artikal> findAllBubnjevi();
    public List<Artikal> findAllGitare();
    public List<Artikal> findAllKlavijature();
    public List<Artikal> findAllOstalo();
}
