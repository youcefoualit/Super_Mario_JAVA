package com.oualityoucef.personnages;
import java.awt.Image; 
import javax.swing.ImageIcon;

import com.oualityoucef.audio.Audio;
import com.oualityoucef.jeu.Main;
import com.oualityoucef.objets.Objet;
import com.oualityoucef.objets.Piece;

public class Mario extends Personnage{
	
	//*******VARIABLES************//
	private Image imgMario; 
	private ImageIcon icoMario; 
	private boolean saut; //vrai si mario saute
	private int compteurSaut; //durée du saut et la hauteur de saut
	protected boolean marioVivant;
	private int compteurMort;
	
	//*************CONSTRUCTEUR**************//
	public Mario(int x,int y) {
		super(x,y,28,50);
		this.icoMario =new ImageIcon(getClass().getResource("/images/marioMarcheDroite.png"));
		this.imgMario =this.icoMario.getImage();
		this.saut = false; 
		this.compteurSaut = 0;
		this.compteurMort =0;
		
	}
	
	 
	//*************GETTEURS******************//
	public Image getImgMario() {return imgMario;}
	public boolean getIsSaut() {return saut;}
	public boolean getMarioVivant() {return marioVivant;}
	
	//*************SETTEURS*******************//
	public void setSaut(boolean saut) {this.saut =saut;}
	public void setMarioVivant(boolean marioVivant) {this.marioVivant = marioVivant;}
	
	
	
	//*************METHODES*******************//
	@Override
	public Image marche(String nom,int frequence) {
		String str;
		ImageIcon ico; 
		Image img;
		
		if(this.marche == false  || Main.scene.getxPos()<=0 || Main.scene.getxPos() > 4430) {
			    if(this.versDroite == true) {str ="/images/" +nom +"ArretDroite.png" ;}
				else {str ="/images/" +nom +"ArretGauche.png";} 
			}
	    else {this.compteur++;
			       if(this.compteur/ frequence == 0 ) {
			        	
			               if(this.versDroite == true) {str ="/images/"+nom+"ArretDroite.png";}
				           else {str ="/images/"+nom+"ArretGauche.png";}
			                                            }
			     
				    else {  
					       if(this.versDroite == true) {str ="/images/"+nom+"MarcheDroite.png";}
				           else {str ="/images/"+nom+"MarcheGauche.png";} 
				         }
				    if(this.compteur == 2* frequence ) {this.compteur=0;}
			        }
			  //affichage de l'image de personnages
			  ico =new ImageIcon(getClass().getResource(str));
			  img =ico.getImage(); 
			  return img;
			
		}
	public Image saute() {
		
		ImageIcon ico; 
		Image img; 
		String str; 
		this.compteurSaut++; 
		 //Montée du saut
		if(this.compteurSaut <=40) {
			if(this.getY()>Main.scene.getHautPlafond()) {this.setY(this.getY()-4);}
			else {this.compteurSaut =41;}
			if(this.isVersDroite() ==true) {str="/images/marioSautDroite.png";}
			else {str ="/images/marioSautGauche.png";}
			
			// Retombée du saut
		}else if(this.getY() +this.getHauteur()< Main.scene.getySol()) {this.setY(this.getY() +1);
		     if(this.isVersDroite() ==true) {str ="/images/marioSautDroite.png";}
		     else {str ="/images/marioSautGauche.png";}
		
		     //Saut terminé
		}else {
			
			 if(this.isVersDroite() == true) {str="/images/marioArretDroite.png";}
			 else {str="/images/marioArretGauche.png";}
			 this.saut= false; 
			 this.compteurSaut =0; 	
		}
		 //Affichage de l'image de mario
		ico =new ImageIcon(getClass().getResource(str)); 
		img =ico.getImage(); 
		return img;	
		}
	public void contact(Objet objet) {
		// Contact horizontal
		if((super.contactAvant(objet)== true && this.isVersDroite() ==true)||(super.contactArriere(objet) == true && isVersDroite()== false))
		{Main.scene.setDx(0);
		this.setMarche(false);
		setMarioVivant(false);
		}
		
		//Contact avec un objet en dessous 
		if(super.contactDessous(objet)== true && this.saut ==true) {
			Main.scene.setySol(objet.getY());
		}else if (super.contactDessous(objet)==false) {
			Main.scene.setySol(293);
			if(this.saut ==false) {this.setY(243);}	
	}
		
		//Contact avec un objet au-dessous
		if(super.contactDessus(objet)==true) {
			Main.scene.setHautPlafond(objet.getY()+objet.getHauteur());
		}else if(super.contactDessus(objet)== false && this.saut ==false) {
			Main.scene.setHautPlafond(0);
		           }
		}
	
	public boolean contactPiece(Piece piece)
	{
		//***ECHEC***Le contact avec une pièce n'a aucune répercussion sur Mario
		if(this.contactArriere(piece)== true || this.contactAvant(piece)== true || this.contactDessous(piece) ==true || this.contactDessus(piece) == true)
		{return true;}
		else {return false;}
		
		
		
	}
	public boolean contactDesactiverClavier(Personnage personnage) {
		if(super.contactAvant(personnage) == true || isVivant() == false || super.contactArriere(personnage)==true || getMarioVivant() == false)
		{
			setMarioVivant(false);
			return false;}
		else {setMarioVivant(true);
			return true;}
		}
	
    public void contact(Personnage personnage) {
    	if((super.contactAvant(personnage) == true) || (super.contactArriere(personnage) == true))
    			{this.setMarche(false);
    			 this.setVivant(false);
    			
    			 
    	}else if(super.contactDessous(personnage) == true) {
    		personnage.setMarche(false);
    		personnage.setVivant(false);
    	}
    }
    //*****Collision entre mario et les personnages
  /*  public Image marioBom() {
    	String str;
    	ImageIcon ico; 
    	Image img; 
    	
    	 
    	ico = new ImageIcon(getClass().getResource(str));
    	img = ico.getImage();
    	return img;	
    }*/
    
    public Image marioMeurt() {
    	String str;
    	ImageIcon Ico;
    	Image img;
    	
    	str="/images/boom.png";
   
         this.compteurMort++;
    	if(this.compteurMort == 1) {
    		Audio.playSound("/audio/boum.wav");}
    	if(this.compteurMort == 100) {Audio.playSound("/audio/partiePerdue.wav");}
    		if(this.compteurMort > 100) {str= "/images/marioMeurt.png";
    		this.setY(this.getY() -1);
    		}                
    	Ico = new ImageIcon(getClass().getResource(str));
		img = Ico.getImage();
    
    		
    		
    		return img;
}
    
    
} 
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


