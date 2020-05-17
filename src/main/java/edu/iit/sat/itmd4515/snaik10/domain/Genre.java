/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.domain;

/**
 *
 * @author siddhi
 * below is the enum for Genres of music
 */
public enum Genre {

    /**
     *
     */
    JZ("Jazz"),

    /**
     *
     */
    POP("PopCulture"),

    /**
     *
     */
    CS("CountrySide"),

    /**
     *
     */
    RK("Rock"),

    /**
     *
     */
    SUF("Sufi"),

    /**
     *
     */
    PTY("Party"),

    /**
     *
     */
    BWD("Bollywood"),

    /**
     *
     */
    ICL("Indian Classical");
    
    private Genre(String label){
        this.label = label;
    }
    
    private String label;
    
    /**
     *
     * @return
     */
    public String getlabel(){
        return label;
    }
    
}
