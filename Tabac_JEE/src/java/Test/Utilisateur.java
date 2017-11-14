
package Test;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author M.SERAZIN & A.DAYRE
 */

@Entity
@Table(name = "utilisateur")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIdU", query = "SELECT u FROM Utilisateur u WHERE u.idU = :idU")
    , @NamedQuery(name = "Utilisateur.findByPseudoU", query = "SELECT u FROM Utilisateur u WHERE u.pseudoU = :pseudoU")
    , @NamedQuery(name = "Utilisateur.findByAgeU", query = "SELECT u FROM Utilisateur u WHERE u.ageU = :ageU")
    , @NamedQuery(name = "Utilisateur.findByConsommationU", query = "SELECT u FROM Utilisateur u WHERE u.consommationU = :consommationU")
    , @NamedQuery(name = "Utilisateur.findByIdMarque", query = "SELECT u FROM Utilisateur u WHERE u.idMarque = :idMarque")
    , @NamedQuery(name = "Utilisateur.findByDateInscription", query = "SELECT u FROM Utilisateur u WHERE u.dateInscription = :dateInscription")
    , @NamedQuery(name = "Utilisateur.findByProgrammeU", query = "SELECT u FROM Utilisateur u WHERE u.programmeU = :programmeU")})
public class Utilisateur implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "photo_U")
    private byte[] photoU;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_U")
    private Integer idU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "pseudo_U")
    private String pseudoU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age_U")
    private int ageU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "consommation_U")
    private int consommationU;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_marque")
    private int idMarque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_inscription")
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "programme_U")
    private boolean programmeU;

    public Utilisateur() {
    }

    public Utilisateur(Integer idU) {
        this.idU = idU;
    }

    public Utilisateur(Integer idU, String pseudoU, int ageU, int consommationU, int idMarque, Date dateInscription, byte[] photoU, boolean programmeU) {
        this.idU = idU;
        this.pseudoU = pseudoU;
        this.ageU = ageU;
        this.consommationU = consommationU;
        this.idMarque = idMarque;
        this.dateInscription = dateInscription;
        this.photoU = photoU;
        this.programmeU = programmeU;
    }

    public Integer getIdU() {
        return idU;
    }

    public void setIdU(Integer idU) {
        this.idU = idU;
    }

    public String getPseudoU() {
        return pseudoU;
    }

    public void setPseudoU(String pseudoU) {
        this.pseudoU = pseudoU;
    }

    public int getAgeU() {
        return ageU;
    }

    public void setAgeU(int ageU) {
        this.ageU = ageU;
    }

    public int getConsommationU() {
        return consommationU;
    }

    public void setConsommationU(int consommationU) {
        this.consommationU = consommationU;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public byte[] getPhotoU() {
        return photoU;
    }

    public void setPhotoU(byte[] photoU) {
        this.photoU = photoU;
    }

    public boolean getProgrammeU() {
        return programmeU;
    }

    public void setProgrammeU(boolean programmeU) {
        this.programmeU = programmeU;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idU != null ? idU.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idU == null && other.idU != null) || (this.idU != null && !this.idU.equals(other.idU))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Test.Utilisateur[ idU=" + idU + " ]";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
