/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.beans;

import com.ec.util.MyUtil;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author angel
 */
@Named(value = "appBean")
@ApplicationScoped
public class appBean {

    /**
     * Creates a new instance of appBean
     */
    public appBean() {
    }
    public String getBaseUrl(){
    return MyUtil.baseurl();
    }
         
}
