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
public class Main {

    /**
     * @param args the command line arguments
     */
    //leandro eu fiz o metodo menu, identico ao que está na main, mas quando usava ele, o compilador não compilava
    //fazendo na main funciona normalmente então deixei assim
    //outra coisa: tive muito problemas com buffer, e não encontrei a melhor maneira de eliminar o problema
    //então, usei uma maneira que algumas vezes vc vai precisar clicar enter para o proximo output sair
    //de resto está tudo okay
    public static void main(String[] args) {
        Agenda agenda= new Agenda();
        Interaction Interacao=new Interaction();
        
        int chave=0;
        Scanner reader = new Scanner(System.in);
        
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
            
            switch (chave) {
                case 1:  agenda.imprimeAgenda();
                         break;
                case 2:  agenda.addRegistro(Interacao.AdcionarRegistro());
                         break;
                case 3:  Interacao.DeletaRegistro(agenda);
                         break;
                case 4:  Interacao.AlterarRegistros(agenda);
                         break;
                case 5: System.out.println("BYE BYE não sei arquivo então tudo que vc fez acabou");
                         break;
                default: System.out.println("Numero Invalido");
                         break;
            }
        }while(chave!=5);
    }
}
