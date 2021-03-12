/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.filipe.bison;

/**
 *
 * @author Fbiso
 */
public class Telefone {
    private String numero;
    
    Telefone(String numero) throws Exception{
        if(valida(numero)==true){
            this.numero=numero;
        }else{
            this.numero=null;
            throw new Exception("invalido");
        }
    }
    public String getTelefone(){
        return this.numero;
    }
    
    private boolean valida (String numero){
        String copy=numero;
        copy = copy.replaceAll("-", "");
        copy = copy.replaceAll("|", "");
        copy = copy.replaceAll("/", "");
        copy = copy.replaceAll("\\(", "");
        copy = copy.replaceAll("\\)", "");
        copy = copy.replaceAll("\\.", "");
        copy = copy.replaceAll("\\ ", "");
        if(copy.length()>8 && copy.length()<12){
            return true;
        }else{
            return false;
        }
    }
    
    public void setTelefone(String numero) throws Exception{
        
        if(valida(numero)==true){
            this.numero=numero;
        }else{
            throw new Exception("invalido");
        }
    }
}
