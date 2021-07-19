/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xenon.ui_packx;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author xenxi
 */
public class TableHeaderRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent jcomponent = null;
        
        if( value instanceof String ) {
            jcomponent = new JLabel(String.valueOf(value));
            ((JLabel)jcomponent).setHorizontalAlignment( SwingConstants.CENTER );
            ((JLabel)jcomponent).setSize( 30, jcomponent.getWidth() );   //header height
            ((JLabel)jcomponent).setPreferredSize( new Dimension(6, jcomponent.getWidth())  );
        }         
   
        //jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(221, 211, 211)));
        //jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new Color(255, 255, 255)));
        //jcomponent.setBorder(BorderFactory.createLineBorder(new Color(46, 45, 53), 1));
        jcomponent.setBorder(BorderFactory.createLineBorder(new Color(117, 122, 125), 1));
        
        jcomponent.setOpaque(true);
        //jcomponent.setBackground( new Color(236,234,219) );
        //jcomponent.setBackground( new Color(196, 50, 74) );
        jcomponent.setBackground(new Color(41, 38, 42));
        //jcomponent.setToolTipText("Tabla Seguimiento");
        jcomponent.setForeground(new Color(0, 222, 253));
        Font headerFont = new Font("Segoe UI", Font.BOLD, 15);
        jcomponent.setFont(headerFont);
        
        return jcomponent;
    }
    
}
