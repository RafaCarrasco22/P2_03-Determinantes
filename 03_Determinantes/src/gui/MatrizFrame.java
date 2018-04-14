/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Objects.Determinante;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



/**
 *
 * @author Rafael
 */
public class MatrizFrame extends JFrame {

    private final JTextField[][] matriz;
    private final JPanel pnlUnico;
    private final JPanel pnlBoton;
    private final JButton btnCalcular;
    private Determinante determinante;
    Integer solucion = 0;
    private final JButton btnCerrar;

    public MatrizFrame(Integer tamanoMatriz) {
        super.setSize(300, 300);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.getContentPane().setBackground(Color.WHITE);
        super.setLocationRelativeTo(null);
        super.setLayout(new BorderLayout());

        pnlUnico = new JPanel();
        pnlUnico.setLayout(new GridLayout(tamanoMatriz, tamanoMatriz));

        matriz = new JTextField[tamanoMatriz][tamanoMatriz];
        for (int i = 0; i < tamanoMatriz; i++) {
            for (int j = 0; j < tamanoMatriz; j++) {
                matriz[i][j] = new JTextField();
                pnlUnico.add(matriz[i][j]);
            }
        }

        pnlBoton = new JPanel();
        pnlBoton.setBackground(Color.WHITE);
        btnCalcular = new JButton("Calcular");
        determinante = new Determinante();

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int[][] resolverMatriz = new int[tamanoMatriz][tamanoMatriz];

                for (int i = 0; i < tamanoMatriz; i++) {
                    for (int j = 0; j < tamanoMatriz; j++) {
                        resolverMatriz[i][j] = Integer.valueOf(matriz[i][j].getText());
                    }
                }

                solucion = determinante.determinante(resolverMatriz, tamanoMatriz);
                JOptionPane.showMessageDialog(null,"El resultado es: "+solucion);
            }
        });
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });

        pnlBoton.add(btnCalcular);
        pnlBoton.add(btnCerrar);

        super.add(pnlUnico, BorderLayout.CENTER);
        super.add(pnlBoton, BorderLayout.PAGE_END);

        super.setVisible(true);
    }
}