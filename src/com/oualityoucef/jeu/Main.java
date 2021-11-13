package com.oualityoucef.jeu;

import javax.swing.JFrame;

public class Main {
	
	public static Scene scene;

	public static void main(String[] args) {
		//création de la fenêtre de jeu
		JFrame fenetre =new JFrame("youcefoualit15@gmail.com");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(800,360);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);

		//Initiation de l'objet scene
		
	     scene =new Scene();
	      
	        fenetre.setContentPane(scene);//On assossie la scène à la fenetre de l'application
	        fenetre.setVisible(true);
	        
	     
		
	}

}
