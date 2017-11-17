
package Test;
 /**
 * @author M.SERAZIN & A.DAYRE
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
 
 
@ManagedBean
public class SelectOneMenuView {
    private List<Cigarette> cig;
    
    public SelectOneMenuView(){  
    }
    
    @PostConstruct
    public void init(){
    
    }
    
    

}
