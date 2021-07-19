/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xenon.ui_packx;

import java.awt.Dimension;

/**
 *
 * @author xenxi
 */
public class ScreenMatrixUtility {
    
    public static double getWidth(){
        return java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    }
    
    public static double getHeight(){
        return java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    }

    public static double[] getSreenSize() {
        return new double[]{java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
            java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()};
    }
    
    public static double[] getCenteringLocation(int[] active_form_size){
        return new double[]{(ScreenMatrixUtility.getWidth() / 2) - (active_form_size[0]/ 2), (ScreenMatrixUtility.getHeight() / 2) - (active_form_size[1] / 2)};
    }
   

}
