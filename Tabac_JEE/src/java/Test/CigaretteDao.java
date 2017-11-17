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
    
    
}
