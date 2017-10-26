/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Marion
 */
@ManagedBean
public class ImagesView {
    private List<String> pictures;
    
    @PostConstruct
    public void init(){
        pictures = new ArrayList<String>();
        for (int i = 1; i<=9   ; i++){
            pictures.add("I"+i+".PNG");
        }
    }
    
    public List<String> getPictures(){
        return pictures;
    }
    
    
}
