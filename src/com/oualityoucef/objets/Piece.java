package com.oualityoucef.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Piece extends Objet implements Runnable {
	
	//*****************VARIABLES**********//
     private int compteur;
     private final int PAUSE=15; //temps d'attente entre 2 tours de boucle
     
	//****************CONSTRUCTEUR*********//
	 public Piece(int x , int y) {
		 super(x,y,30,30);
		 super.icoObjet= new ImageIcon(getClass().getResource("/images/piece1.png"));
	     super.imgObjet = super.icoObjet.getImage();	}
	//***************GETTEURS*************//
	
	//***************SETTEURS*************//
	
	//***************METHODES************//
	   
	 public Image bouge() {
		 String str; 
		 ImageIcon ico;
		 Image img; 
		 
		 this.compteur++; 
		 if(this.compteur/100 ==0) {str="/images/piece1.png";}
		 else {str="/images/piece2.png";}
		 if(this.compteur ==200) {this.compteur = 0;}
		 
		 //Affichage de l'image du personnage
		 ico =new ImageIcon (getClass().getResource(str));
		 img =ico.getImage();
		 return img;
		 
	 }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {Thread.sleep(20);}
		catch(InterruptedException e) {}
		while(true) {
			this.bouge(); 
			try {Thread.sleep(PAUSE);}
			catch(InterruptedException e) {}
		}
	}

}
