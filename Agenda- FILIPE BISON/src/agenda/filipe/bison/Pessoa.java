/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.filipe.bison;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author Fbiso
 */
abstract public class Pessoa {
    protected String numero; //cpf ou cnpj
    
    public String getNumero(){
        return this.numero;
    }
    
    abstract public void setNumero(String numero);
}

class PessoaFisica extends Pessoa{
    
    private static final Pattern PATTERN_GENERIC = Pattern.compile("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}");
    private static final Pattern PATTERN_NUMBERS = Pattern.compile("(?=^((?!((([0]{11})|([1]{11})|([2]{11})|([3]{11})|([4]{11})|([5]{11})|([6]{11})|([7]{11})|([8]{11})|([9]{11})))).)*$)([0-9]{11})");
    
    PessoaFisica(){
        
    };
    
    PessoaFisica (String numero){
        if(isValid(numero)==true){
            this.numero=numero;
        } 
    }
    
    @Override 
    public void setNumero (String numero){
        if(isValid(numero)==true){
            this.numero=numero;
        } 
    }
  /**
    * Método para validar CPF
    *
    * @author github.com/ademar111190/
    */
    //&& PATTERN_GENERIC.matcher(cpf).matches()
    public static boolean isValid(String cpf) {
        if (cpf != null ) {
            cpf = cpf.replaceAll("-", "");
            cpf = cpf.replaceAll("|", "");
            cpf = cpf.replaceAll("/", "");
            cpf = cpf.replaceAll("\\.", "");
            cpf = cpf.replaceAll("\\ ", "");
            if(cpf != null && PATTERN_NUMBERS.matcher(cpf).matches()) {
                int[] numbers = new int[11];
                for (int i = 0; i < 11; i++) numbers[i] = Character.getNumericValue(cpf.charAt(i));
                int i;
                int sum = 0;
                int factor = 100;
                for (i = 0; i < 9; i++) {
                    sum += numbers[i] * factor;
                    factor -= 10;
                }
                int leftover = sum % 11;
                leftover = leftover == 10 ? 0 : leftover;
                if (leftover == numbers[9]) {
                    sum = 0;
                    factor = 110;
                    for (i = 0; i < 10; i++) {
                        sum += numbers[i] * factor;
                        factor -= 10;
                    }
                    leftover = sum % 11;
                    leftover = leftover == 10 ? 0 : leftover;
                    return leftover == numbers[10];
                }
            }
        }
        return false;
    }
}

class PessoaJuridica extends Pessoa{
    PessoaJuridica(){
        
    };
    
    PessoaJuridica (String Numero){
        if(validacnpj(Numero)==true){
            this.numero=Numero;
        }
    }
    
    @Override
    public void setNumero(String Numero){
        if(validacnpj(Numero)==true){
            this.numero=Numero;
        }
    }
    
    private boolean validacnpj(String cnpj){
        //codigo baseado em um codigo de js encontrado em 
        //<https://www.geradorcnpj.com/javascript-validar-cnpj.htm>
        
        cnpj = cnpj.replaceAll("-", "");
        cnpj = cnpj.replaceAll("|", "");
        cnpj = cnpj.replaceAll("/", "");
        cnpj = cnpj.replaceAll("\\.", "");
        cnpj = cnpj.replaceAll("\\ ", "");
        if (cnpj.length() != 14)
        return false;
 
        // Elimina CNPJs invalidos conhecidos
        if (Objects.equals(cnpj, "00000000000000")  || 
            Objects.equals(cnpj, "11111111111111")  || 
            Objects.equals(cnpj, "22222222222222")  || 
            Objects.equals(cnpj, "33333333333333")  || 
            Objects.equals(cnpj, "44444444444444")  || 
            Objects.equals(cnpj, "55555555555555")  || 
            Objects.equals(cnpj, "66666666666666")  || 
            Objects.equals(cnpj, "77777777777777")  || 
            Objects.equals(cnpj, "88888888888888")  || 
            Objects.equals(cnpj, "99999999999999"))
            return false;
        
        // Valida DVs
        /**int tamanho = cnpj.length() - 2;
        String numeros = cnpj.substring(0,tamanho);
        String digitos = cnpj.substring(tamanho);
        int soma = 0;
        int pos = tamanho - 7;
        for (int i = tamanho; i >= 1; i--) {
            soma += (int)numeros.charAt(tamanho - i) * pos--;
            if (pos < 2) pos = 9;
        }
        int resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (resultado != (int)digitos.charAt(0)) return false;
         
        tamanho = tamanho + 1;
        numeros = cnpj.substring(0,tamanho);
        soma = 0;
        pos = tamanho - 7;
        for (int i = tamanho; i >= 1; i--) {
          soma += numeros.charAt(tamanho - i) * pos--;
          if (pos < 2) pos = 9;
        }
        resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
        if (resultado != (int)digitos.charAt(1)) return false;
        **/   
    return true;
    }
}