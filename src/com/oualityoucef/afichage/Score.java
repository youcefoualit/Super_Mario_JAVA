package com.oualityoucef.afichage;

public class Score {
	// ********VARIABLES************
	  private final int NBRE_TOTAL_PIECES=10;
	  private int nbrePieces;
	
	//********CONSTRUCTEUR***********
	public Score() {
		nbrePieces =0;
	}
	//********GETTEURS************
	public int getNbrePieces() {return nbrePieces;}
	public int getNBRE_TOTAL_PIECES() {return this.NBRE_TOTAL_PIECES;}
	
	
	//********SETTEURS************
	public void setNbrePieces(int nbrePieces) {this.nbrePieces = nbrePieces;}

}
