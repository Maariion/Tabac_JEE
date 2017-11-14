/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


/**
 * @author M.SERAZIN & A.DAYRE
 */
@Named(value="cigarettectrl")
@ViewScoped
public class CigaretteCtrl implements Serializable {
   @EJB 
    private CigaretteDao dao;
   
    
    public CigaretteCtrl(){
        
    }
    public List<Cigarette> getCigarette(){
        return dao.findAll();
    }
}
