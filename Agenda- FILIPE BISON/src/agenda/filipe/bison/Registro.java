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
public class Registro {
    private Pessoa pessoa;
    private String nome;
    private List <Telefone> Telefones = new ArrayList<>() ; 
    private List <Endereco> Enderecos = new ArrayList<>() ;
    
    public String getNumeroIndentificacao(){
        return this.pessoa.numero;
    }
    
    public void SetPessoaFisica(){
        this.pessoa= new PessoaFisica();
    }
    
    public void SetPessoaJuridica(){
        this.pessoa= new PessoaJuridica();
    }
    
    public void setNumeroIndentificacao(String numID) throws Exception{
        this.pessoa.setNumero(numID);
        if(this.pessoa.getNumero() == null){
            throw new Exception("numeroinvalido");
        }
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    public void adcionaTelefone(String telefone) throws Exception{
        try{
            Telefone adicionar= new Telefone(telefone);
            this.Telefones.add(adicionar);
        }catch(Throwable e){
            throw new Exception("numeroinvalido");
        }
        
    }
    public void removeTelefone (String telefone) throws Exception{
        for(int i =0; i < this.Telefones.size(); i++){
            if(telefone.equals(this.Telefones.get(i).getTelefone())){
                this.Telefones.remove(i);
                return;
            }
        }
        throw new Exception("numeroinvalido");
    }
    
    public List <Telefone> obtemTelefones(){
        return this.Telefones;
    }
    public void adcionaEndereco( String logradouro,int  numero,
                                String complemento, String Bairro, String Cidade,
                                String Estado, String Cep){
        Endereco adcionar= new Endereco();
        
        adcionar.setLogradouro(logradouro);
        adcionar.setnumero(numero);
        adcionar.setComplemento(complemento);
        adcionar.setBairro(Bairro);
        adcionar.setCidade(Cidade);
        adcionar.setEstado(Estado);
        adcionar.setCep(Cep);
        
        this.Enderecos.add(adcionar);
    }
    public void removeEndereco (int ID) throws Exception{
        for(int i =0; i < this.Enderecos.size(); i++){
            if(this.Enderecos.get(i).getID()== ID){
                this.Enderecos.remove(i);
                return;
            }
        }
        throw new Exception("idinvalido");
    }
    
    public List <Endereco> obtemEnderecos(){
        return this.Enderecos;
    }
    
    public void imprimirRegistro(){
        if(pessoa instanceof PessoaFisica){
            System.out.println("/////////////////////Pessoa Fisica /////////////////////");
            System.out.printf("CPF: %s \n", pessoa.getNumero());
        }else if(pessoa instanceof PessoaJuridica){
            System.out.println("/////////////////////Pessoa Jurídica /////////////////////");
            System.out.printf("CNPJ: %s \n", pessoa.getNumero());
        }
        System.out.printf("Nome: %s \n", nome);
        for(int i =0; i < this.Enderecos.size(); i++){
            this.Enderecos.get(i).imprimeEndereço();
        }
        for(int i =0; i < this.Telefones.size(); i++){
            System.out.println(this.Telefones.get(i).getTelefone());
        }
    }
}
