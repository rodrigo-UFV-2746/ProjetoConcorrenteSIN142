/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoconcorrente;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author RODRIGO-NOT
 */
public class TranferenciaTread extends Thread{
    private String dir;
    TranferenciaTread(){
    }
    public TranferenciaTread(String dir) {
        this.dir = dir;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    public void run(){
        FileWriter arquivo;
        try {
            String fileName = "Arquivo";
             int quant = 10000;
             for(int i=0;i <quant;i++){
                arquivo = new FileWriter(new File(this.dir+fileName+i+".txt"));
                for(int j=0;j<50000;j++){   
                arquivo.write("teste+");
                }
            arquivo.close();}                                            
                                   
    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
    
}
