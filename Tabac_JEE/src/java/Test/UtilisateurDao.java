
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
public class UtilisateurDao {
    
    @PersistenceContext(unitName="Tabac_JEEPU")
    private EntityManager em;
    
   //Methode qui va être utilisée lors de la création d'un compte utilisateur
    public void addUtilisateur(Utilisateur u){
        em.persist(u);
        em.flush();
    }
    
   //Méthode qui va être utilisée pour enregistrer les informations d'un utilisateur     
    public void updateUtilisateur(Utilisateur u){
        em.merge(u);
        em.flush();
    }
    
    //Méthode qui va être utilisée pour supprimer un utilisateur lors de sa désinscription
    public void deleteUtilisateur(Utilisateur u){
        em.remove(em.merge(u));
        em.flush();
    }
    
    //A voir si on a besoin d'afficher tous les utilisateurs pour les stats 
    //exemple si on fait des stats générales collectives
    public List<Utilisateur> findAll(){
        Query query = em.createNamedQuery("Utilisateur.findAll");
        return query.getResultList();
    }
}
