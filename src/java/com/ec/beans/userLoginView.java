/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.beans;

import com.ec.util.MyUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author angel
 */
@Named(value = "userLoginView")
@SessionScoped
@ManagedBean
public class userLoginView implements Serializable {

       private String username; 
        private String password;
    public userLoginView() {
    }
  

 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta ="";
        if(username != null && username.equals("1720478822") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome Admin", username);
             ruta = MyUtil.basepathlogin()+"faces/index.xhtml";
        
        } else if(username != null && username.equals("paciente") && password != null && password.equals("paciente")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome paciente", username);
            // ruta = MyUtil.basepathlogin()+"/index.xhtml";
        }else if(username != null && username.equals("doctor") && password != null && password.equals("doctor")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            // ruta = MyUtil.basepathlogin()+"/index.xhtml";      
        }else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }  
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
         context.addCallbackParam("ruta", ruta);
    }   


}

