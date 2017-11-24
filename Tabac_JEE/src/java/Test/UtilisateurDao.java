
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
    
    public Integer getMarqueId(){
        Query query = em.createNamedQuery("Utilisateur.getMarqueId");
        return (Integer) query.getSingleResult();
    }
    
    public boolean isInBase(String str, String psw){
        Query query = em.createQuery("SELECT COUNT(u) FROM Utilisateur u WHERE u.pseudoU = :str and u.password=:psw").setParameter("str", str).setParameter("psw", psw);
        int pos = Integer.parseInt(""+query.getSingleResult());
        if(0==pos){
            return false;
        }
        else{
            return true;
        }
    }
    
    public Utilisateur getBypseudoAndPsw(String str, String psw){
            Query query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.pseudoU = :str and u.password=:psw").setParameter("str", str).setParameter("psw", psw);
            return (Utilisateur)query.getSingleResult();
    }
    
    
    public Programme getProgrammeUti(int id){
        Query query=em.createQuery("SELECT p FROM Programme p WHERE p.idP = :id").setParameter("id", id);
        return(Programme)query.getSingleResult();
    }
    
}
