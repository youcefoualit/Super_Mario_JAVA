package com.oualityoucef.objets;
 
import javax.swing.ImageIcon;

public class TuyauRouge extends Objet {
	
	// *****VARIABLES**********//
	

	
	//************CONSTRUCTEUR*************//
	public TuyauRouge(int x,int y) {
		
	    super(x, y, 43, 65);
		super.icoObjet = new ImageIcon(getClass().getResource("/images/tuyauRouge.png"));
		this.imgObjet =this.icoObjet.getImage();
		
	}
	
	//***************GETTEURS******************//
	
	
	//**************SETTEURS*******************//
	
	
	//*************METHODES********************//
	
	
}
