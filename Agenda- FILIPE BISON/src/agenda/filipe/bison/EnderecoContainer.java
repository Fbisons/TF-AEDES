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
public class EnderecoContainer {
    public int id;
    public String logradouro;
    public int  numero;
    public String complemento;
    public String Bairro;
    public String Cidade;
    public String Estado;
    public String Cep;
    
    EnderecoContainer(){
        id=numero=0;
        logradouro=complemento=Bairro=Cidade=Estado=Cep=null;
    }
}
