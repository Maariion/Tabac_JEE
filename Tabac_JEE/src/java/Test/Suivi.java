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

/**
 *
 * @author Marion
 */
@Entity
@Table(name = "suivi")
@NamedQueries({
    @NamedQuery(name = "Suivi.findAll", query = "SELECT s FROM Suivi s")
    , @NamedQuery(name = "Suivi.findByIdS", query = "SELECT s FROM Suivi s WHERE s.idS = :idS")
    , @NamedQuery(name = "Suivi.findByIdC", query = "SELECT s FROM Suivi s WHERE s.idC = :idC")
    , @NamedQuery(name = "Suivi.findByIdM", query = "SELECT s FROM Suivi s WHERE s.idM = :idM")
    , @NamedQuery(name = "Suivi.findByIdP", query = "SELECT s FROM Suivi s WHERE s.idP = :idP")})
public class Suivi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_S")
    private Integer idS;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_C")
    private int idC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_M")
    private int idM;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_P")
    private int idP;

    public Suivi() {
    }

    public Suivi(Integer idS) {
        this.idS = idS;
    }

    public Suivi(Integer idS, int idC, int idM, int idP) {
        this.idS = idS;
        this.idC = idC;
        this.idM = idM;
        this.idP = idP;
    }

    public Integer getIdS() {
        return idS;
    }

    public void setIdS(Integer idS) {
        this.idS = idS;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idS != null ? idS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suivi)) {
            return false;
        }
        Suivi other = (Suivi) object;
        if ((this.idS == null && other.idS != null) || (this.idS != null && !this.idS.equals(other.idS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Test.Suivi[ idS=" + idS + " ]";
    }
    
}
