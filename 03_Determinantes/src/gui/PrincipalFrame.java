/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Rafael
 */
public class PrincipalFrame extends JFrame {
    private final JPanel pnl;
    private final JLabel ask;
    private final JTextField respuesta;
    private final JButton btnOk;
    
    public PrincipalFrame() {
        super.setSize(400, 70);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setTitle("Tamaño Matriz");
        super.getContentPane().setBackground(Color.WHITE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());

        
        pnl = new JPanel();
        ask = new JLabel("Tamaño de la determinante: ");
        respuesta = new JTextField(7);
        btnOk = new JButton("Aceptar");
        btnOk.addActionListener((ActionEvent ae) -> {
            MatrizFrame pf = new MatrizFrame(Integer.valueOf(respuesta.getText()));
            super.setVisible(false);
        });
        
        pnl.add(ask);
        pnl.add(respuesta);
        pnl.add(btnOk);
        
        
        super.add(pnl);
        super.setResizable(false);
        super.setVisible(true);
    }
   
}
