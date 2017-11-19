/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Utilisateur
 */
@Entity
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_U")
    private Integer idU;
    @Size(max = 20)
    @Column(name = "pseudo_U")
    private String pseudoU;
    @Size(max = 10)
    @Column(name = "password")
    private String password;
    @Column(name = "age_U")
    private Integer ageU;
    @Column(name = "consommation_U")
    private Integer consommationU;
    @Column(name = "date_inscription")
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    @Lob
    @Column(name = "photo_U")
    private byte[] photoU;
    @JoinColumn(name = "id_marque", referencedColumnName = "id_C")
    @ManyToOne
    private Cigarette idMarque;
    @JoinColumn(name = "programme_U", referencedColumnName = "id_P")
    @ManyToOne
    private Programme programmeU;

    public Utilisateur() {
    }

    public Utilisateur(Integer idU) {
        this.idU = idU;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAgeU() {
        return ageU;
    }

    public void setAgeU(Integer ageU) {
        this.ageU = ageU;
    }

    public Integer getConsommationU() {
        return consommationU;
    }

    public void setConsommationU(Integer consommationU) {
        this.consommationU = consommationU;
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

    public Cigarette getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Cigarette idMarque) {
        this.idMarque = idMarque;
    }

    public Programme getProgrammeU() {
        return programmeU;
    }

    public void setProgrammeU(Programme programmeU) {
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
    
}
