import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class bloc
{ 
   String nom;
   int nvoiture,nmaxvoiture;
   int liggauche[],ligdroite[];
   int colgauche[],coldroite[];
   int occgauche[],occdroite[];
   int entrer;	 
  public bloc(int nlig)
  {
  	this.liggauche=new int[nlig];
  	this.ligdroite=new int[nlig];
  	this.colgauche=new int[nlig];
  	this.coldroite=new int[nlig];
  	this.occgauche=new int[nlig];
  	this.occdroite=new int[nlig];
  	
  	for (int i=0;i<nlig;i++) 
  	{
  		
  		this.occgauche[i]=0;
  		this.occdroite[i]=0;
  	}
 
  	
  }	
}