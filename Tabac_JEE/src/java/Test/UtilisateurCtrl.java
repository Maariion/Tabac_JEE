
package Test;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author M.SERAZIN & A.DAYRE
 */
@Named(value="utilisateurctrl")
@ViewScoped
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
        
        dao.addUtilisateur(uti);
        return "index";
        
    }
    

    public Utilisateur getUti() {
        return uti;
    }

    public void setUti(Utilisateur uti) {
        this.uti = uti;
    }
    
    
}
