/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Paulette
 */
/** classe pour la creation de l'echiquier */
public class Echiquier {
    
    
    /** booleen pour indiquer le lancement de la partie */
    private Boolean lancement;
    /** plateau 2 dimensions de 8x8 cases */
    private Piece[][] plateau = new Piece[8][8];
    /** recuperation du deplacement des pieces (tapee par le joueur au clavier) */
    Scanner instruction = new Scanner(System.in);
    /** coordonnees pieces */
    private static int initialLigne, initialColonne, destinationLigne, destinationColonne;
    /** score des noirs et des blancs */
    private static int ScoreBlanc = 0, ScoreNoir = 0;
    /** joueur blanc ou joueur noir */
    private static Boolean joueurBlanc;
    /** variable a vrai si mouvement impossible */
    private static Boolean mouvementInvalide = false;
    /** chaine de caractere entree par l'utilisateur au clavier pour le deplacement des pieces */
    String mouvement;
    
    /**
     *
     */
    public Echiquier() {
        initialiseTab(plateau);
	lancement = true;
    }

    /**
     *
     * @return lance la partie
     */
    public Boolean getlancement() {
        return this.lancement;
    }

    /** place les pieces et affiche qui doit commencer (blanc ou noir) */
    private static void initialiseTab(Piece[][] plateau) {
        for (int ligne = 0; ligne < plateau.length; ligne++) {
            for (int col = 0; col < plateau[ligne].length; col++) {
                if (ligne == 0) {
                    /** le switch evite les structures if/else qui auraient ete trop longues et compliquees */
                    switch (col) {
                        case 0:
                            plateau[ligne][col] = new Tour(false);
                            break;
                        case 1:
                            plateau[ligne][col] = new Cavalier(false);
                            break;
			case 2:
                            plateau[ligne][col] = new Fou(false);
                            break;
			case 3:
                            plateau[ligne][col] = new Reine(false);
                            break;
                        case 4:
                            plateau[ligne][col] = new Roi(false);
                            break;
			case 5:
                            plateau[ligne][col] = new Fou(false);
                            break;
                        case 6:
                            plateau[ligne][col] = new Cavalier(false);
                            break;
			case 7:
                            plateau[ligne][col] = new Tour(false);
                            break;
                    }
                } else if (ligne == 1) {
                    plateau[ligne][col] = new Pion(false);
                } else if (ligne == 6) {
                    plateau[ligne][col] = new Pion(true);
		} else if (ligne == 7) {
                    switch (col) {
                        case 0:
                            plateau[ligne][col] = new Tour(true);
                            break;
			case 1:
                            plateau[ligne][col] = new Cavalier(true);
                            break;
			case 2:
                            plateau[ligne][col] = new Fou(true);
                            break;
			case 3:
                            plateau[ligne][col] = new Reine(true);
                            break;
			case 4:
                            plateau[ligne][col] = new Roi(true);
                            break;
                        case 5:
                            plateau[ligne][col] = new Fou(true);
                            break;
			case 6:
                            plateau[ligne][col] = new Cavalier(true);
                            break;
			case 7:
                            plateau[ligne][col] = new Tour(true);
                            break;
                    }
                } else {
                    plateau[ligne][col] = null;
                }
            }
        }
        /** definit qui commence */
        Random rand = new Random();
        joueurBlanc = rand.nextBoolean();
    }
    
    /**
     *
     */
    public void affichageTab() {
        /** affiche des lettres au dessus des colonnes pour se situer et des chiffres pour les lignes */
        System.out.println("\ta\tb\tc\td\te\tf\tg\th");
	for (int ligne = 0; ligne < plateau.length; ligne++) {
            System.out.print(8 - ligne + "\t");
            for (int col = 0; col < plateau[ligne].length; col++) {
                if (plateau[ligne][col] != null) {
                    plateau[ligne][col].affichage();
                    System.out.print("\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
    
    /** retourne vrai si le deplacement est valide*/
    private boolean validiteMouvement() {
        /** condition pour ne pas sortir d ela grille */
        if (initialLigne < 0 || initialLigne > 7 || initialColonne < 0 || initialColonne > 7 || destinationLigne < 0 || destinationLigne > 7 || destinationColonne < 0 || destinationColonne > 7) {
            System.out.println("La piece sort du jeu");
            return false;
	}
        
        /** condition pour que le joueur aux pieces blanches ne joue pas quand c'est le tour de l'autre et vice-versa */
        if ((plateau[initialLigne][initialColonne].blanc && !joueurBlanc) || (!plateau[initialLigne][initialColonne].blanc && joueurBlanc)) {
            System.err.println("Ce n'est pas votre tour");
            return false;
	}
        
        /** condition pour que les deplacements des pieces respectent les regles etablies */
        if (!plateau[initialLigne][initialColonne].deplacement(initialLigne, initialColonne, destinationLigne, destinationColonne)) {
            System.err.println("La piece doit etre deplacee autrement");
            return false;
	}
        
        /** si la case est vide */
	if (plateau[destinationLigne][destinationColonne] == null) {
            return true;
	}
        
	if (plateau[initialLigne][initialColonne].blanc && plateau[destinationLigne][destinationColonne].blanc) {
            System.err.println("Pas de blanc sur blanc");
            return false;
	}
        
	if (!plateau[initialLigne][initialColonne].blanc && !plateau[destinationLigne][destinationColonne].blanc) {
            System.err.println("Pas de noir sur noir");
            return false;
	}
                
        return true;
    }
    
    /** methode pour le calcul du score */
    private void Score() {
        if (plateau[destinationLigne][destinationColonne] == null) {
            return;
	}
	if (joueurBlanc) {
            ScoreBlanc += plateau[destinationLigne][destinationColonne].valeurPiece();
	} else {
            ScoreNoir += plateau[destinationLigne][destinationColonne].valeurPiece();

        }
    }
    
    /** methode qui prend les instructions de deplacements de l'utilisateur au clavier et deplace les pieces (taper au clavier d3 - d4 par exemple) */
    public void mouvement() {
        System.out.println("\n\n Score: blanc"+ScoreBlanc+ " & "+"noir"+ScoreNoir);
        if (mouvementInvalide) {
            System.err.println("Mouvement invalide");
            mouvementInvalide = false;
        } else if (joueurBlanc) {
            System.out.println("\n Au tour des blancs\n"+ "\n");
        } else {
            System.out.println("\n Au tour des noirs\n"+ "\n");
	}
        mouvement = instruction.nextLine();
        if (mouvement.equalsIgnoreCase("fin")) {
            lancement = false;
            return;
	}
        /** traduit la chaine de caractere donnee au clavier par des coordonnees dans la grille */
        String lowerCase = mouvement.toLowerCase();
        String[] components = lowerCase.split(" ");
        initialLigne = 7 - (components[0].charAt(1) - '1');
	initialColonne = components[0].charAt(0) - 'a';
	destinationLigne = 7 - (components[2].charAt(1) - '1');
	destinationColonne = components[2].charAt(0) - 'a';
        if (validiteMouvement()) {
            Score();
            plateau[destinationLigne][destinationColonne] = plateau[initialLigne][initialColonne];
            plateau[initialLigne][initialColonne] = null;
            joueurBlanc = !joueurBlanc;
	} else {
            mouvementInvalide = true;
            mouvement();
        }
    }
    
    
}
