/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pong.objetos;

import br.com.pong.util.Colisao2D;
import br.com.pong.util.Comuns;
import br.com.pong.util.Vector2D;
import java.awt.Image;

/**
 *
 * @author Leila
 */
public class Objeto implements Comuns{
    
    private Image imagem;
    
    private boolean visibilidade;
    private boolean destruicao;
    
    private Vector2D dimensao = new Vector2D();
    
    protected Vector2D direcao = new Vector2D(1 , 1);
    protected Vector2D posicao = new Vector2D();
    protected Vector2D velocidade = new Vector 2D();
    
    protected Colisao2D area;
    
    private boolean isColidivel;
    private boolean isNaTela;
    
    public Objeto(){
        this.visibilidade = true;
        this.destruicao = false;
        
        this.isColidivel = true;
        this.isNaTela = false;
    }
    
    public Image getImagem(){
        return imagem;
    }
    
    public void setImagem(Image imagem){
        this.imagem = imagem;
    }
    
    public boolean isVisivel(){
        return visibilidade;
    }
    
    public void setVisibilidade(boolean visibilidade){
        this.visibilidade = visibilidade;
    }
    
    public boolean isDestruido(){
        return destruicao;
    }
    
    public void setDestruicao(boolean destruicao){
        this.destruicao = destruicao;
    }
    
    public boolean isColidivel(){
        return isColidivel;
    }
    
    public void setIsColidivel(boolean isColidivel){
        this.isColidivel = isColidivel;
    }
    
    public boolean isNaTela(){
        return isNaTela;
    }
    
    public void setIsNaTela(boolean isNaTela){
        this.isNaTela = isNaTela;
    }
    
    public int getAltura(){
        return dimensao.getY();
    }
    
    public void setAltura(int altura){
        this.dimensao.setY(altura);
    }
    
    public int getLargura(){
        return dimensao.getX();
    }
    
    public void setLargura(int largura){
        this.dimensao.setX(largura);
    }
    
    public boolean isEmColisao(Objeto a){
        if(this == a){
            return false;
        }
        
        if(!a.isColidivel){
            return false;
        }
        
        return (this.area.esquerda <= a.area.direita && a.area.esquerda <= this.area.direita &&
                this.area.topo <= a.area.base && a.area.topo <= this.area.base);
    }
}
