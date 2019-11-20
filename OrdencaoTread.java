/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoconcorrente;

/**
 *
 * @author RODRIGO-NOT
 */
public class OrdencaoTread extends Thread {
    
    private int tamanho1;
    private int vetor1[];
    
    public OrdencaoTread() {
       
    }
    public OrdencaoTread(int tamanho1, int[] vetor1) {
        this.tamanho1 = tamanho1;
        this.vetor1 = vetor1;
    }
    
    public int getTamanho1() {
        return tamanho1;
    }

    public void setTamanho1(int tamanho1) {
        this.tamanho1 = tamanho1;
    }

    public int[] getVetor1() {
        return vetor1;
    }

    public void setVetor1(int[] vetor1) {
        this.vetor1 = vetor1;
    }
    public void run(){
        try {
                  int t,j;
                      for(t=0;t<this.tamanho1-1;t++){
                          int min_index=t;
                          for(j=t+1;j<=this.tamanho1-1;j++){
                             if(this.vetor1[min_index] > this.vetor1[j]){
                                          min_index =j;
                                 }
                            }
                          int temp = this.vetor1[t];
                          this.vetor1[t] = this.vetor1[min_index];
                          this.vetor1[min_index]= temp;
                      }  
        } catch (Exception ex){
            System.out.println("Thread terminada..."+ ex.getMessage());
        }
    }

}

