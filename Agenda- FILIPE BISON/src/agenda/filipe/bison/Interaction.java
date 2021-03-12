/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.filipe.bison;

import java.util.Scanner;


/**
 *
 * @author Fbiso
 */
public class Interaction {
    
    //função copiada da internet por que não achei buffer bom
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
     }
    
    public void AlteraNome(Registro Registro){
        Scanner reader = new Scanner(System.in);
        clearBuffer(reader);
        System.out.println("Digite o Nome do nome que você deseja colocar:");
        Registro.setNome(reader.nextLine());
    }
     
    public void AdcionarTelefone(Registro novo){
        int chave=0;
        Scanner reader = new Scanner(System.in);
        do{
            System.out.println("Digite o telefone dessa Pessoa");
            try{
                novo.adcionaTelefone(reader.nextLine());
                System.out.println("Digite: \n 1- Para Adcionar mais um Telefone \n Qualquer outro Número- Seguir para próxima informação");
                chave=reader.nextInt();
                clearBuffer(reader);
                
            }catch (Exception e){
                System.out.println("Telefone Invalido: por favor digite telefones brasileiros");
                chave=1;
            }
        }while(chave==1);
    }
    
    public void RemoverTelefone(Registro novo){
        int chave=0;
        Scanner reader = new Scanner(System.in);
        do{
            novo.imprimirRegistro();
            System.out.println("Desses digite o telefone que deseja deletar");
            try{
                novo.removeTelefone(reader.nextLine());
            }catch (Throwable e){
                System.out.println("Telefone Invalido: por favor digite um telefone cadastrado");
                System.out.println("Se quiser digitar de novo digite 1, se tiver desistido digite outro número");
                chave=reader.nextInt();
            }
        }while(chave==1);
    }
    
    public void AdcionarEndereco(Registro novo){
        int chave=0;
        int  numero;
        String complemento, Bairro , Cidade, Estado,Cep, logradouro;
        Scanner reader = new Scanner(System.in);
        do{
            System.out.println("Digite o CEP dessa Pessoa");
            Cep=reader.nextLine();
            System.out.println("Digite o Bairro dessa Pessoa");
            Bairro=reader.nextLine();
            System.out.println("Digite a cidade dessa Pessoa");
            Cidade=reader.nextLine();
            System.out.println("Digite o Estado dessa Pessoa");
            Estado=reader.nextLine();
            System.out.println("Digite o Logradouro dessa Pessoa");
            logradouro=reader.nextLine();
            System.out.println("Digite o Complemento dessa Pessoa");
            complemento=reader.nextLine();
            
            System.out.println("Digite o numero da casa/apartamento dessa Pessoa");
            numero=reader.nextInt();
            clearBuffer(reader);
            novo.adcionaEndereco( logradouro,numero,
                                complemento, Bairro, Cidade,
                                Estado, Cep);
            System.out.println("Digite: \n 1- Para Adcionar mais um Endereço \n Qualquer outro Número- Seguir para próxima informação");
            chave=reader.nextInt();
            clearBuffer(reader);
        }while(chave==1);
    }
    
    public void RemoverEndereco(Registro novo){
        int chave=0;
        int  numero;
        Scanner reader = new Scanner(System.in);
        
        do{
            novo.imprimirRegistro();
            System.out.println("Digite o ID do endereço que deseja deletar");
            numero=reader.nextInt();
            clearBuffer(reader);
            try{
                novo.removeEndereco(numero);
            }catch (Exception e){
                System.out.println("Endereço Invalido: por favor digite um ID que há na lista ");
                System.out.println("Se quiser digitar de novo digite 1, se tiver desistido digite outro número");
                chave=reader.nextInt();
            }
        }while(chave==1);
    }
    
    public Registro AdcionarRegistro(){
        Registro novo = new Registro();
        int chave=0;
        String temp= new String();
        Scanner reader = new Scanner(System.in);
        
        do{
            System.out.println("Você gostaria de adcionar: \n 1- Pessoa Fisica \n 2-Pessoa Jurifica");
            chave=reader.nextInt();
            clearBuffer(reader);
            if(chave==1){
                novo.SetPessoaFisica();
                do{
                    System.out.println("Digite o CPF dessa pessoa:");
                    try{
                        chave=1;
                        novo.setNumeroIndentificacao(reader.next());
                        clearBuffer(reader);
                    }catch (Exception e){
                        System.out.println("CPF Invalido");
                        chave=3;
                    }
                }while(chave==3);
                chave=1;
            }else if(chave ==2 ){
                novo.SetPessoaJuridica();
                do{
                    System.out.println("Digite o CNPJ dessa pessoa:");
                    try{
                        novo.setNumeroIndentificacao(reader.nextLine());
                        
                    }catch (Exception e){
                        System.out.println("CNPJ Invalido");
                        chave=3;
                    }
                }while(chave==3);
                chave=1;
            }else{
                System.out.println("Digite somente o número oferecidos, 1 ou 2");
                chave=0;
            }
        }while(chave == 0);
        
        System.out.printf("Digite o nome dessa Pessoa \n");
        temp=reader.nextLine();
        novo.setNome(temp);
        
        AdcionarTelefone(novo);
        AdcionarEndereco(novo);
        novo.imprimirRegistro();
                
        return novo;
    }

    public void DeletaRegistro(Agenda Agenda){
        int chave=0;
        Scanner reader = new Scanner(System.in);
        clearBuffer(reader);
        do{
            Agenda.imprimeAgenda();
            System.out.println("|---------------------------------------|");
            System.out.println("|-Digite CPF/CNPJ de qual deseja deletar|");
            
            try{
                Agenda.deletarRegistro(Agenda.acharRegistro(reader.nextLine()));
                chave=2;
            }catch(Exception e){
                
                System.out.println("|---------------------------------------|");
                System.out.println("|-----Esse número não está na Agenda----|");
                do{
                    System.out.println("|-DIGITE O NÚMERO PARA ESCOLHER A OPÇÃO-|");
                    System.out.println("|-1----Escrever um Número Novamente-----|");
                    System.out.println("|-2-------Voltar ao Menu Inicial--------|");
                    System.out.println("|---------------------------------------|");
                    chave=reader.nextInt();
                    if(chave!=1 && chave !=2){
                        System.out.println("|-----------Opção Inválida----------|");
                        chave=3;
                    }                
            }while(chave==3);
            }
        }while(chave!=2);    
    }
    
    public void AlteraEnderecos(Registro Registro){
        Scanner reader = new Scanner(System.in);
        int chave ;    
        do{
                System.out.println("|---------------------------------------|");
                System.out.println("|------------ALTERAR O QUE?-------------|");
                System.out.println("|-DIGITE O NÚMERO PARA ESCOLHER A OPÇÃO-|");
                System.out.println("|-1-Adcionar Endereço-------------------|");
                System.out.println("|-2-Deletar Endereço--------------------|");
                System.out.println("|-3-Sair--------------------------------|");
                System.out.println("|---------------------------------------|");
                chave=reader.nextInt();
                if(chave==1){
                    AdcionarEndereco(Registro);
                }else if(chave==2){
                    RemoverEndereco(Registro);
                }
            }while(chave>3 || chave<=0);
    }
    
    public void AlteraTelefones(Registro Registro){
        Scanner reader = new Scanner(System.in);
        int chave;    
        do{
                System.out.println("|---------------------------------------|");
                System.out.println("|------------ALTERAR O QUE?-------------|");
                System.out.println("|-DIGITE O NÚMERO PARA ESCOLHER A OPÇÃO-|");
                System.out.println("|-1-Adcionar Telefone-------------------|");
                System.out.println("|-2-Deletar Telefone--------------------|");
                System.out.println("|-3-Sair--------------------------------|");
                System.out.println("|---------------------------------------|");
                chave=reader.nextInt();
                if(chave==1){
                    AdcionarTelefone(Registro);
                }else if(chave==2){
                    RemoverTelefone(Registro);
                }
            }while(chave>3 || chave<=0);
    }
    
    public void AlterarRegistro(Registro Registro){
        Scanner reader = new Scanner(System.in);
        int chave;
        do{
            System.out.println("|---------------------------------------|");
            System.out.println("|------------ALTERAR O QUE?-------------|");
            System.out.println("|-DIGITE O NÚMERO PARA ESCOLHER A OPÇÃO-|");
            System.out.println("|-1-Nome--------------------------------|");
            System.out.println("|-2-Lista de Telefones------------------|");
            System.out.println("|-3-Lista de Endereços------------------|");
            System.out.println("|-4-Sair--------------------------------|");
            System.out.println("|---------------------------------------|");
            chave=reader.nextInt();
            switch (chave) {
                case 1:  AlteraNome(Registro);
                    chave=4;
                         break;
                case 2:  AlteraTelefones(Registro);
                    chave=4;
                         break;
                case 3:  AlteraEnderecos(Registro);
                    chave=4;
                         break;
                case 4: 
                    break;
                default: 
                    System.out.println("Numero Invalido");
                    break;
            }
        } while(chave!=4);
    }
    
    public void AlterarRegistros(Agenda Agenda){
        int chave=0;
        Scanner reader = new Scanner(System.in);
        clearBuffer(reader);
        do{
            Agenda.imprimeAgenda();
            System.out.println("|---------------------------------------|");
            System.out.println("|-Digite CPF/CNPJ de qual deseja alterar|");
            
            try{
                AlterarRegistro(Agenda.registros.get(Agenda.acharRegistro(reader.nextLine())));
                
                chave=2;
                clearBuffer(reader);
            }catch(Exception e){
                clearBuffer(reader);
                System.out.println("|---------------------------------------|");
                System.out.println("|-----Esse número não está na Agenda----|");
                do{
                    System.out.println("|-DIGITE O NÚMERO PARA ESCOLHER A OPÇÃO-|");
                    System.out.println("|-1----Escrever um Número Novamente-----|");
                    System.out.println("|-2-------Voltar ao Menu Inicial--------|");
                    clearBuffer(reader);
                    System.out.println("|---------------------------------------|");
                    chave=reader.nextInt();
                    clearBuffer(reader);
                    if(chave!=1 && chave !=2){
                        System.out.println("|-----------Opção Inválida----------|");
                        chave=3;
                    }                
            }while(chave==3);
            }
        }while(chave!=2);    
    }
    
    public void menu (Agenda Agenda){
        int chave=0;
        Scanner reader = new Scanner(System.in);
        clearBuffer(reader);
        do{
            System.out.println("|---------------------------------------|");
            System.out.println("|----------BEM VINDO À AGENDA-----------|");
            System.out.println("|-DIGITE O NÚMERO PARA ESCOLHER A OPÇÃO-|");
            System.out.println("|-1-Ver Lista de Registros na Agenda----|");
            System.out.println("|-2-Adcionar Registro à Agenda----------|");
            System.out.println("|-3-Deletar Registro da Agenda----------|");
            System.out.println("|-4-Alterar Registro da Agenda----------|");
            System.out.println("|-5-Sair--------------------------------|");
            System.out.println("|---------------------------------------|");
            chave=reader.nextInt();
            clearBuffer(reader);
            switch (chave) {
                case 1:  Agenda.imprimeAgenda();
                         break;
                case 2:  Agenda.addRegistro(AdcionarRegistro());
                         break;
                case 3:  DeletaRegistro(Agenda);
                         break;
                case 4:  AlterarRegistros(Agenda);
                         break;
                case 5: System.out.println("BYE BYE não sei arquivo então tudo que vc fez acabou");
                         break;
                default: System.out.println("Numero Invalido");
                         break;
            }
        }while(chave!=5);
    }
}
