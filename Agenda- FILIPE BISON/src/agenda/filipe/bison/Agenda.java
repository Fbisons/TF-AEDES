/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.filipe.bison;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Fbiso
 */
public class Agenda {
    List <Registro> registros = new ArrayList<>();
    
    public void addRegistro(Registro novo){
        registros.add(novo);
    }
    public void imprimeAgenda (){
        System.out.println("|---------------------------------------|");
        for(int i=0; i<registros.size(); i++){
            registros.get(i).imprimirRegistro();
            System.out.println("|---------------------------------------|");

        }
    }
    
    public int acharRegistro (String numero) throws Exception{
        for(int i=0; i<registros.size(); i++){
            if(registros.get(i).getNumeroIndentificacao().equals(numero)){
                return i;
            }
        }
        throw new Exception("numeroinvalido");
    }
    public void deletarRegistro(int index){
        registros.remove(registros.get(index));
    }
}
