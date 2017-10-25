/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Marion
 */
@Entity
@Table(name = "cigarette")
@NamedQueries({
    @NamedQuery(name = "Cigarette.findAll", query = "SELECT c FROM Cigarette c")
    , @NamedQuery(name = "Cigarette.findByIdC", query = "SELECT c FROM Cigarette c WHERE c.idC = :idC")
    , @NamedQuery(name = "Cigarette.findByNomC", query = "SELECT c FROM Cigarette c WHERE c.nomC = :nomC")
    , @NamedQuery(name = "Cigarette.findByMarqueC", query = "SELECT c FROM Cigarette c WHERE c.marqueC = :marqueC")
    , @NamedQuery(name = "Cigarette.findByTauxnicotineC", query = "SELECT c FROM Cigarette c WHERE c.tauxnicotineC = :tauxnicotineC")})
public class Cigarette implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_C")
    private Integer idC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_C")
    private String nomC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "marque_C")
    private String marqueC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taux_nicotine_C")
    private int tauxnicotineC;

    public Cigarette() {
    }

    public Cigarette(Integer idC) {
        this.idC = idC;
    }

    public Cigarette(Integer idC, String nomC, String marqueC, int tauxnicotineC) {
        this.idC = idC;
        this.nomC = nomC;
        this.marqueC = marqueC;
        this.tauxnicotineC = tauxnicotineC;
    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public String getNomC() {
        return nomC;
    }

    public void setNomC(String nomC) {
        this.nomC = nomC;
    }

    public String getMarqueC() {
        return marqueC;
    }

    public void setMarqueC(String marqueC) {
        this.marqueC = marqueC;
    }

    public int getTauxnicotineC() {
        return tauxnicotineC;
    }

    public void setTauxnicotineC(int tauxnicotineC) {
        this.tauxnicotineC = tauxnicotineC;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idC != null ? idC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cigarette)) {
            return false;
        }
        Cigarette other = (Cigarette) object;
        if ((this.idC == null && other.idC != null) || (this.idC != null && !this.idC.equals(other.idC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Test.Cigarette[ idC=" + idC + " ]";
    }
    
}
