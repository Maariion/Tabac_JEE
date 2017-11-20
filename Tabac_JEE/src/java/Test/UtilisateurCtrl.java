
package Test;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.sql.Timestamp;
import javax.faces.bean.SessionScoped;

/**
 * @author M.SERAZIN & A.DAYRE
 */

@SessionScoped
@ManagedBean
public class UtilisateurCtrl implements Serializable {
    
    @EJB 
    private UtilisateurDao dao;
    private Utilisateur uti = new Utilisateur();
    private String idMarqueSelected;
    
    public UtilisateurCtrl(){
        
    }
    
    public List<Utilisateur> getUtilisateur(){
        return dao.findAll();
    }
    
    public void getIdMarqueSelected(String marque){
        this .idMarqueSelected=marque;
    }
    
    public String addUtilisateur(){
        initialiserDateInscription();
        dao.addUtilisateur(uti);
        return "mon_programme";
    }
    
    private void initialiserDateInscription() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        this.uti.setDateInscription(date);
    }
    
    public String delUtilisateur(){
        dao.deleteUtilisateur(uti);
        this.uti.setAgeU(0);
        this.uti.setConsommationU(0);
        this.uti.setDateInscription(null);
        this.uti.setIdMarque(null);
        this.uti.setPassword("");
        this.uti.setPhotoU(null);
        this.uti.setProgrammeU(null);
        this.uti.setPseudoU("");
        return "index";
    }
    
   
    public String update(){
        dao.updateUtilisateur(uti);
       
        return "index";
    }

    public Utilisateur getUti() {
        return uti;
    }

    public void setUti(Utilisateur uti) {
        this.uti = uti;
    }
    
    
    public String controlLogin(){
        if(dao.isInBase(uti.getPseudoU(), uti.getPassword())){
            uti = dao.getBypseudoAndPsw(uti.getPseudoU(), uti.getPassword());
            return "mon_programme";
        }
        else{
            return "connexion";
        }
        
    }
    
    
}
