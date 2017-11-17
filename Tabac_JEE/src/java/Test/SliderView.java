
package Test;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
 
import org.primefaces.event.SlideEndEvent;
 
@ManagedBean
public class SliderView {

    
    public void onInputChanged(ValueChangeEvent event) {
        FacesMessage message = new FacesMessage("Input Changed", "Valeur: " + event.getNewValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
     
    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage(" ", "Nombre de cigarette déclaré: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
}
