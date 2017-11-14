
package Test;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author M.SERAZIN & A.DAYRE
 */
@Named(value="utilisateurctrl")
@ViewScoped
public class UtilisateurCtrl implements Serializable {
    
    @EJB 
    private UtilisateurDao dao;
    private Utilisateur uti = new Utilisateur();
    
    public UtilisateurCtrl(){
        
    }
    
    public List<Utilisateur> getUtilisateur(){
        return dao.findAll();
    }
    
    public void addUtilisateur(){
        dao.addUtilisateur(uti);
        
    }

    public Utilisateur getUti() {
        return uti;
    }

    public void setUti(Utilisateur uti) {
        this.uti = uti;
    }
    
    
}
