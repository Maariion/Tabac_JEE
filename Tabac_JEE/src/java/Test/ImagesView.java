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
import javax.faces.bean.SessionScoped;

/**
 
 * @author Marion
 */
@ManagedBean
@SessionScoped
public class ImagesView {
    private List<String> pictures;

    public ImagesView() {
    }
    
    
    @PostConstruct
    public void init(){
        pictures = new ArrayList<>();
        for (int i = 1; i<=13  ; i++){
            pictures.add("I"+i+".PNG");
        }
    }
    
    public List<String> getPictures(){
        return pictures;
        
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
    
    
    
    
}
