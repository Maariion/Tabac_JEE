/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 * @author M.SERAZIN & A.DAYRE
 */

@Stateless
public class CigaretteDao {
    @PersistenceContext(unitName="Tabac_JEEPU")
    private EntityManager em;
    
    public List<Cigarette> findAll(){
        Query query = em.createNamedQuery("Cigarette.findAll");
        return query.getResultList();
    }
    
    public Cigarette getCigarette (String marque){
        Query query = em.createNamedQuery("Cigarette.id_C");
        return (Cigarette)query.getSingleResult();
        
    }
    
    public boolean IsInBase(String str){
        Query query = em.createNamedQuery("Cigarette.findByMarqueC").setParameter("marqueC", str);
        Cigarette cig = (Cigarette)query.getSingleResult();
        System.out.println(cig.getNomC());
        if (cig!=null){
            return true;
        }else{
            return false;
        }
        
    }
    
    public Cigarette getCigaretteWithMarque(String str){
        Query query=em.createQuery("Select c FROM Cigarette c where c.marqueC = :str").setParameter("str", str);
        return (Cigarette)query.getSingleResult();
    }
    
}
