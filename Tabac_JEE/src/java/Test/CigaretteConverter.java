/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
/**
 *
 * @author Utilisateur
 */

@FacesConverter("cigaretteConverter")
public class CigaretteConverter implements Converter {

    CigaretteDao dao = lookupCigaretteDaoBean();


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value!=null && dao.IsInBase(value)){
            try{
                
                Cigarette cig = new Cigarette();
                cig = dao.getCigaretteWithMarque(value);
                return cig;
            }
            catch(NumberFormatException e){
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme"));
            }
        }
        else{
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object!=null || !"".equals(object)){
            return (String) object;   
        }
        else{
            return null;
        }
        
    }

    private CigaretteDao lookupCigaretteDaoBean() {
        try {
            Context c = new InitialContext();
            return (CigaretteDao) c.lookup("java:global/Tabac_JEE/CigaretteDao!Test.CigaretteDao");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
}
