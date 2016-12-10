/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pong.util;

/**
 *
 * @author Leila
 */
public class Colisao2D {
    
    public int topo;
    public int base;
    public int esquerda;
    public int direita;
    public int centroX;
    public int centroY;
    
    public void montar(int x, int y, int largura, int altura){
        this.topo = y;
        this.base = y + altura;
        this.esquerda = x;
        this.direita = x + largura;
        this.centroX = x + (largura / 2);
        this.centroY = y + (altura / 2);
    }
    
    public Quadrante localizacao(Colisao2D a){
        if((esquerda > a.esquerda
                && direita < a.direita
                && base >= a.topo
                && base < a.centroY)
                ||
                (direita < a.esquerda
                && esquerda < a.direita
                && base >= a.topo
                && centroY <= a.topo))
        {
            return Quadrante.TOPO;
        }        
        if(esquerda > a.esquerda
                && direita < a.direita
                && topo > a.centroY
                && topo <= a.base
                ||
                (direita < a.esquerda
                && esquerda < a.direita
                && centroY >= a.base
                && topo <= a.base))
        {
            return Quadrante.BASE;
        }
        else if(direita >= a.esquerda
                && direita < a.centroX
                && topo > a.topo
                && base < a.base
                ||
                (base > a.topo 
                && topo < a.base
                && direita >= a.esquerda
                && centroX <= a.esquerda))
        {
            return Quadrante.ESQUERDA;
        }
        else if(esquerda > a.centroX
                && esquerda <= a.direita
                && topo > a.topo
                && base < a.base
                ||
                (base > a.topo
                && topo < a.base
                && centroX >= a.direita
                && esquerda <= a.direita))
                
        {
            return Quadrante.DIREITA;
        }
        else if(base >= a.topo
                && base <= a.centroY
                && direita >= a.esquerda
                && direita <= a.centroX)
        {
            return Quadrante.ESQUERDA_TOPO;
        }
        else if(base >= a.topo
                && base <= a.centroY
                && esquerda >= a.centroX
                && esquerda <= a.direita)
        {
            return Quadrante.DIREITA_TOPO;
        }
        else if(topo >= a.centroY
                && topo <= a.base
                && direita >= a.esquerda
                && direita <= a.centroX)
        {
            return Quadrante.ESQUERDA_BASE;
        }
        else if(topo >= a.centroY
                && topo <= a.base
                && esquerda >= a.centroX
                && esquerda <= a.direita)
        {
            return Quadrante.DIREITA_BASE;
        }
        else
        {
            return Quadrante.INSIDE;
        }
    }
}
