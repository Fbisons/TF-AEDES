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
public class Endereco {
    static int idgeral=0;
    final int ID;
    private final EnderecoContainer dados;
    
    Endereco(){
        idgeral=idgeral+1;
        ID=idgeral;
        dados= new EnderecoContainer();
    }
    
    public int getID(){
        return ID;
    }
    
    public String getLogradouro(){
        return this.dados.logradouro;
    }
    
    public void setLogradouro(String logradouro){
        this.dados.logradouro=logradouro;
    }
    
    public int getnumero(){
        return this.dados.numero;
    }
    
    public void setnumero(int numero){
        this.dados.numero=numero;
    }
    
    public String getComplemento(){
        return this.dados.complemento;
    }
    
    public void setComplemento(String complemento){
        this.dados.complemento=complemento;
    }
    
    public String getBairro(){
        return this.dados.Bairro;
    }
    
    public void setBairro(String Bairro){
        this.dados.Bairro=Bairro;
    }
    
    public String getCidade(){
        return this.dados.Cidade;
    }
    
    public void setCidade(String Cidade){
        this.dados.Cidade=Cidade;
    }
    
    public String getEstado(){
        return this.dados.Estado;
    }
    
    public void setEstado(String Estado){
        this.dados.Estado=Estado;
    }
    
    public String getCep(){
        return this.dados.Cep;
    }
    
    public void setCep(String Cep){
        this.dados.Cep=Cep;
    }
    
    public void imprimeEndereço(){
        System.out.println("-----------ENDEREÇO------------");
        System.out.println("ID:" + ID);
        System.out.printf("%s , %d || %s , %s \n %s , %s, %s . ",   dados.Cep,  dados.numero, dados.Cidade, dados.Estado,
                                                                dados.Bairro, dados.logradouro, dados.complemento);
        System.out.println("\n-------------------------------");
    }
}
