/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Rafael
 */
public class Determinante {
    
    public Integer determinante(int[][] det, Integer tamano) {
        Integer determinante = 0;

        if (tamano == 1) {
            return det[0][0];
        } else {
            int signo = 1;
            for (int i = 0; i < tamano; i++) {
                determinante += signo * (det[0][i] * determinante(submatriz(det, 0, i, tamano), tamano - 1));
                signo *= -1;
            }
        }
        return determinante;
    }

    public int[][] submatriz(int[][] matriz, Integer f, Integer c, Integer size) {
        int[][] sub = new int[size - 1][size - 1];
        Integer x = 0;
        Integer y = 0;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != f && j != c) {
                    sub[x][y] = matriz[i][j];
                    y++;
                }
            }
            if (i != f) {
                x++;
                y = 0;
            }
        }
        return sub;
    }
}
