/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoconcorrente;

import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author RODRIGO-NOT
 */

public class Main {


    public static void select_sort(int[] vetor, int tamanho){
                      int t,j;
                      for(t=0;t<tamanho-1;t++){
                          int min_index=t;
                          for(j=t+1;j<=tamanho-1;j++){
                             if(vetor[min_index] > vetor[j]){
                                          min_index =j;
                                 }
                            }
                          int temp = vetor[t];
                          vetor[t] = vetor[min_index];
                          vetor[min_index]= temp;
                      }
    }
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws InterruptedException {
        Scanner imput = new Scanner(System.in);
        int controlador;
        do{
            System.out.println(""
                        + "+++++++++++++++++++++++++\n"
                        + "+ Digite opcao de Menu: +\n"
                        + "+-----------------------+\n"
                        + "+0 - Sair               +\n"
                        + "+1 - CPU BOUND         +\n"
                        + "+2 - I/O BOUND        +\n"
                        + "+++++++++++++++++++++++++\n");
                    controlador = imput.nextInt();
                switch(controlador) {
                    case 0:
                        System.out.println("Sair"); // encerra o programa
                    break;
                    case 1:
                        System.out.printf("IMPLEMENTACAO CPU bound\n");
                        int controlador1;
                        do{
                            System.out.println(""
                            + "+++++++++++++++++++++++++\n"
                            + "+ Digite opcao de Menu: +\n"
                            + "+-----------------------+\n"
                            + "+0 - Sair               +\n"
                            + "+1 - Sequencial         +\n"
                            + "+2 - Concorrente        +\n"
                            + "+++++++++++++++++++++++++\n");
                            
                            controlador1 = imput.nextInt();
                            switch(controlador1){
                                case 0:
                                    System.out.println("Sair"); // encerra o programa
                                break;
                                case 1:
                                    int tamanho;
                                    System.out.printf("IMPLEMENTACAO CPU bound (Sequencial)\n");
                                    do{
                                       System.out.printf("Digite o tamanho da entrada para o Algoritmo:"
                                                + "\n10"
                                                + "\n1000"
                                                + "\n10000"
                                                + "\n100000"
                                                + "\n1000000"
                                                + "\n10000000\n");
                                       tamanho = imput.nextInt();
                                       if(tamanho!=10 && tamanho!=1000 && tamanho!=10000 && tamanho!=100000 && tamanho!=1000000 && tamanho!=10000000)
                                            System.out.println("ERROR:INSTANCIA INVALIDA DIGITE NOVAMENTE: \n");   

                                    }while(tamanho!=10 && tamanho!=1000 && tamanho!=10000 && tamanho!=100000 && tamanho!=1000000 && tamanho!=10000000);
                                   int vetor[] = new int[tamanho];
                                   int vetor1[] = new int[tamanho];
                                   Random random = new Random(tamanho);

                                   for(int i=0;i<tamanho;i++){   
                                       vetor[i] = random.nextInt(tamanho);
                                   }
                                   System.arraycopy(vetor, 0, vetor1, 0, tamanho);
                                    /*for(int i=0;i<tamanho;i++){
                                      System.out.printf("%d-",vetor[i]);
                                   }*/
                                   System.out.println("ORDENANDO...");
                                    long tempoInicial = System.currentTimeMillis();
                                    select_sort(vetor,tamanho);
                                    select_sort(vetor1,tamanho);
                                   /*for(int i=0;i<tamanho;i++){
                                      System.out.println(vetor[i]);
                                   }*/
                                    long tempoFinal = System.currentTimeMillis();
                                    double tempo =((tempoFinal - tempoInicial) / 1000d);
                                    System.out.println("TEMPO DE ORDENACAO:"+tempo+"MILISEGUNDOS PARA TAMANHO DE ENTRADA:"+tamanho);
                                  break;
                                case 2:
                                    System.out.printf("IMPLEMENTACAO CPU bound (Concorrente)\n");
                                    int tamanho1;
                                    do{
                                       System.out.printf("Digite o tamanho da entrada para o Algoritmo:"
                                                + "\n10"
                                                + "\n1000"
                                                + "\n10000"
                                                + "\n100000"
                                                + "\n1000000"
                                                + "\n10000000\n");
                                       tamanho1 = imput.nextInt();
                                       if(tamanho1!=10 && tamanho1!=1000 && tamanho1!=10000 && tamanho1!=100000 && tamanho1!=1000000 && tamanho1!=10000000)
                                            System.out.println("ERROR:INSTANCIA INVALIDA DIGITE NOVAMENTE: \n");   

                                    }while(tamanho1!=10 && tamanho1!=1000 && tamanho1!=10000 && tamanho1!=100000 && tamanho1!=1000000 && tamanho1!=10000000);
                                   OrdencaoTread t1,t2;
                                   
                                   t1 = new OrdencaoTread();
                                   t2 = new OrdencaoTread();
                                   
                                   int vetor2[] = new int[tamanho1];
                                   int vetor3[] = new int[tamanho1];
                                   Random random1 = new Random(tamanho1);
                                   t1.setTamanho1(tamanho1);
                                   t2.setTamanho1(tamanho1);
                                   for(int i=0;i<tamanho1;i++){   
                                       vetor2[i] = random1.nextInt(tamanho1);
                                   }
                                   System.arraycopy(vetor2, 0, vetor3, 0, tamanho1);
                                   
                                   t1.setVetor1(vetor2);
                                   t2.setVetor1(vetor3);
                                   
                                   System.out.println("ORDENANDO...");
                                    long tempoInicial1 = System.currentTimeMillis();
                                   
                                    t1.start();              
                                    t1.join();
                                    t2.join();
                                    t2.start();
                                   

                                    long tempoFinal1 = System.currentTimeMillis();
                                    double tempo1 =((tempoFinal1 - tempoInicial1) / 1000d);
                                    System.out.println("TEMPO DE ORDENACAO:"+tempo1+"MILISEGUNDOSPARA TAMANHO DE ENTRADA:"+tamanho1);
                                  break;
                                default:
                                    System.out.println("entrada inválida");
                    
                            }
                        }while(controlador1 != 0);
                       break;
                    case 2:
                        System.out.printf("IMPLEMENTACAO I/O bound\n");
                        int controlador2;
                        do{
                            System.out.println(""
                            + "+++++++++++++++++++++++++\n"
                            + "+ Digite opcao de Menu: +\n"
                            + "+-----------------------+\n"
                            + "+0 - Sair               +\n"
                            + "+1 - Sequencial         +\n"
                            + "+2 - Concorrente        +\n"
                            + "+++++++++++++++++++++++++\n");
                            
                            controlador2 = imput.nextInt();
                            switch(controlador2){
                                case 0:
                                    System.out.println("Sair"); // encerra o programa
                                break;
                                case 1:
                                    System.out.printf("IMPLEMENTACAO I/O bound (Sequencial)\n");
                                    FileWriter arquivo;
                                    System.out.println("Criando Pasta...");
                                    try {
                                         File diretorio = new File("C:/tmp/");
                                         diretorio.mkdir();
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
                                        System.out.println(ex);
                                    }       
                                    //Limpando Pasta
                                    System.out.println("Limpando Pasta...");
                                    File folder = new File("C:/tmp/");
                                    if (folder.isDirectory()) {
                                        File[] sun = folder.listFiles();
                                        for (File toDelete : sun) {
                                                toDelete.delete();
                                        }
                                    }
                                                                        System.out.println("Criando Pasta...");
                                    try {
                                         File diretorio = new File("C:/tmp1/");
                                         diretorio.mkdir();
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
                                        System.out.println(ex);
                                    }       
                                    //Limpando Pasta
                                    System.out.println("Limpando Pasta...");
                                    File folder1 = new File("C:/tmp1/");
                                    if (folder1.isDirectory()) {
                                        File[] sun = folder1.listFiles();
                                        for (File toDelete : sun) {
                                                toDelete.delete();
                                        }
                                    }
                                    System.out.println("Criando arquivos e salvando...");
                                    long tempoInicial1 = System.currentTimeMillis();
                                    try {
                                            String fileName = "Arquivo";
                                            int quant = 10000;
                                            for(int i=0;i <quant;i++){
                                            arquivo = new FileWriter(new File("C:/tmp/"+fileName+i+".txt"));
                                            for(int j=0;j<50000;j++){   
                                                arquivo.write("teste+");
                                            }
                                            arquivo.close();}                                            
                                            for(int i=0;i <quant;i++){
                                            arquivo = new FileWriter(new File("C:/tmp1/"+fileName+i+".txt"));
                                            for(int j=0;j<50000;j++){   
                                                arquivo.write("teste+");
                                            }
                                            arquivo.close();}
                                    } catch (IOException e) {
                                            e.printStackTrace();
                                    } catch (Exception e) {
                                            e.printStackTrace();
                                    }
                                    long tempoFinal1 = System.currentTimeMillis();
                                    double tempo1 =((tempoFinal1 - tempoInicial1) / 1000d);
                                   System.out.println("Criado com sucesso...");
                                   System.out.println("DE CRIACAO DE ARQUIVOS:"+tempo1+"MILISEGUNDOS");
                                break;
                                case 2:
                                    System.out.printf("IMPLEMENTACAO I/O bound (Concorrente)\n");
                                    
                                    System.out.println("Criando Pasta...");
                                    try {
                                         File diretorio = new File("C:/tmp2/");
                                         diretorio.mkdir();
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
                                        System.out.println(ex);
                                    }       
                                    //Limpando Pasta
                                    System.out.println("Limpando Pasta...");
                                    File folder2 = new File("C:/tmp2/");
                                    if (folder2.isDirectory()) {
                                        File[] sun = folder2.listFiles();
                                        for (File toDelete : sun) {
                                                toDelete.delete();
                                        }
                                    }
                                    System.out.println("Criando Pasta...");
                                    try {
                                         File diretorio = new File("C:/tmp3/");
                                         diretorio.mkdir();
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
                                        System.out.println(ex);
                                    }       
                                    //Limpando Pasta
                                    System.out.println("Limpando Pasta...");
                                    File folder3 = new File("C:/tmp3/");
                                    if (folder3.isDirectory()) {
                                        File[] sun = folder3.listFiles();
                                        for (File toDelete : sun) {
                                                toDelete.delete();
                                        }
                                    }
                                    TranferenciaTread t3,t4;
                                    t3 = new TranferenciaTread();
                                    t4 = new TranferenciaTread();
                                    t3.setDir("C:/tmp2/");
                                    t4.setDir("C:/tmp3/");
                                    System.out.println("Criando arquivos e salvando...");
                                    long tempoInicial2 = System.currentTimeMillis();
                                        t3.start();
                                        t4.start();
                                        t3.join();
                                        t4.join(); 
                                    long tempoFinal3 = System.currentTimeMillis();
                                    double tempo2 =((tempoFinal3 - tempoInicial2) / 1000d);
                                   System.out.println("Criado com sucesso...");
                                   System.out.println("DE CRIACAO DE ARQUIVOS:"+tempo2+"MILISEGUNDOS");
                                break;
                                default:
                                    System.out.println("entrada inválida");
                    
                            }
                        }while(controlador2 != 0);
                        
                    break;
                    default:
                        System.out.println("entrada inválida");
                    

                }
        }while(controlador != 0);
         
    }
}
