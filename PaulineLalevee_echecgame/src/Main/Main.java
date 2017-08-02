/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.Echiquier;
import java.util.Scanner;

/**
 *
 * @author Paulette
 */
/** classe principale pour le lancement du jeu */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    /** recuperation de ce que l utilisateur ecrit au clavier pour deplacer les pieces */
    static Scanner instruction = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        /** creation du jeu */
        Echiquier partie = new Echiquier();
        while (partie.getlancement()) {
            System.out.println("\n");
            partie.affichageTab();
            partie.mouvement();
        }
    }
    
}
