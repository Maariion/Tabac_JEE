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
@Table(name = "programme")
@NamedQueries({
    @NamedQuery(name = "Programme.findAll", query = "SELECT p FROM Programme p")
    , @NamedQuery(name = "Programme.findByIdP", query = "SELECT p FROM Programme p WHERE p.idP = :idP")
    , @NamedQuery(name = "Programme.findByDescriptionP", query = "SELECT p FROM Programme p WHERE p.descriptionP = :descriptionP")
    , @NamedQuery(name = "Programme.findByNombrecmoinsP", query = "SELECT p FROM Programme p WHERE p.nombrecmoinsP = :nombrecmoinsP")})
public class Programme implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_P")
    private Integer idP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "description_P")
    private String descriptionP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre_c_moins_P")
    private int nombrecmoinsP;

    public Programme() {
    }

    public Programme(Integer idP) {
        this.idP = idP;
    }

    public Programme(Integer idP, String descriptionP, int nombrecmoinsP) {
        this.idP = idP;
        this.descriptionP = descriptionP;
        this.nombrecmoinsP = nombrecmoinsP;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public String getDescriptionP() {
        return descriptionP;
    }

    public void setDescriptionP(String descriptionP) {
        this.descriptionP = descriptionP;
    }

    public int getNombrecmoinsP() {
        return nombrecmoinsP;
    }

    public void setNombrecmoinsP(int nombrecmoinsP) {
        this.nombrecmoinsP = nombrecmoinsP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Test.Programme[ idP=" + idP + " ]";
    }
    
}
