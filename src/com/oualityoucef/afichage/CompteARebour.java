package com.oualityoucef.afichage;

public class CompteARebour implements Runnable{
 //**********VARIABLES**********
	private final int PAUSE =1000;
	private int compteurTemps; 
	private String str; 
	
	//**********CONSTRUCTEUR************//
	public CompteARebour() {
		this.compteurTemps=60;
		this.str ="Remaining time";
		
		Thread compteARebours = new Thread(this);
		compteARebours.start(); 
	}
	
	
	//**********GETTEURS**********
	public int getCompteurTemps() {return compteurTemps;}
	
	public String getStr() {return str;}
	
	
	//*********SETTEURS**********
	
	
	
	//*************METHODES*******//
	@Override
	public void run() {
		
		while(true) {//
			try {Thread.sleep(PAUSE);}
			catch(InterruptedException e) {}
			this.compteurTemps --; 
			this.str ="Remaining time : "+ this.compteurTemps;
		}
		
	}

}
