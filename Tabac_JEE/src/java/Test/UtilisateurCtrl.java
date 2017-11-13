
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
    private Utilisateur uti;
    
    public UtilisateurCtrl(){
        this.uti = new Utilisateur();
    }
    
    public List<Utilisateur> getUtilisateur(){
        return dao.findAll();
    }
    
    public void addUtilisateur(){
        dao.addUtilisateur(this.uti);
        this.uti = new Utilisateur();
    }

    public Utilisateur getUti() {
        return uti;
    }

    public void setUti(Utilisateur uti) {
        this.uti = uti;
    }
    
    
}
