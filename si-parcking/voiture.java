import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;


public class voiture
{
	int indetat;//indice de l'etat actuel de la voiture
	int tabetats[]=new int[5];//1 monter,2 descendre,3 avancer,4 rentrer,5 marche arriere A,6 marche arriere R,7 arret
	int tabmax[]=new int[5];
	int positionx,positiony,temps,vitesse,color;
	
	
  public voiture(int x,int y,int etatvoiture,int frequence,int couleur)
  {
  	this.positionx=x;
  	this.positiony=y;
  	this.indetat=etatvoiture;
  	this.vitesse=frequence;
  	this.color=couleur;
  	this.temps=0;
  	indetat=0;
  	
  }	
  
  public void deplacer(int px,int py,int ev,int max)
  {
  	switch(ev)
  	{
  	case 1:if(py>=max) py=py-vitesse; if(py<max) indetat=indetat+1;  break;
  	case 2:if(py<=max) py=py+vitesse; if(py>max) indetat=indetat+1;  break;
  	case 3:if(px<max) px=px+vitesse; if(px>=max) indetat=indetat+1;  break;
  	case 4:if(px>=max) px=px-vitesse ; if(px<max) indetat=indetat+1; break;
  	case 5:if(px<max) px=px+vitesse ; if(px>=max) indetat=indetat+1;  break;
  	case 6:if(px>=max) px=px-vitesse ; if(px<max) indetat=indetat+1;  break;
  	case 7: indetat=4;  break;
  	default: ev=7;
   }
   positionx=px;
  	positiony=py;
  	temps=temps+1;
  
  }
  
  
}