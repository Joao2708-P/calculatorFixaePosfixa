package com.company;

import java.util.EventListener;
import java.util.Random;
import java.util.Scanner;

public class Main2
{
    static double[] ValorDe = new double[30];
    //FilaVetor<Double> valorDe = new FilaVetor<Double>(30);

    public static void main(String[] args) throws Exception
    {
        for(;;)
        {
            try
            {
                System.out.println("Olá! Seja bem-vindo a calculadora infixa e Pós fixa!");
                System.out.println("Deseja fazer uma operação? S - Sim - N - Não");
                char opcao = Teclado.getUmChar();
                switch (opcao)
                {
                    case 'n':
                    {
                        System.exit(0);
                        break;
                    }

                    case 's':
                    {
                        try
                        {
                            System.out.println("Digite a expressão a ser calculada:  ");
                            String digito = Teclado.getUmString();
                            int parent1 = 0;
                            int parent2 = 0;

                            for(int j = 0; j < digito.length(); j++)
                            {
                                if(digito.charAt(j) == '(')
                                    parent1++;
                                else if(digito.charAt(j) == ')')
                                    parent2++;
                            }

                            if(parent1 > parent2)
                                throw new  Exception("Cadeia em formato errado! Faltou isso: ( ");
                            else if(parent1 < parent2)
                                throw new Exception("Cadeia em formato errado! Faltou isso: ) ");

                            else
                            {
                                String valor = "";
                                String infixa = "";
                                int cnt = 0;

                                for(int i = 0; i < digito.length(); i++)
                                {
                                    if(!Ehoperador(digito.charAt(i)) && digito.charAt(i) != '.')
                                    {
                                        valor += digito.charAt(i);
                                    }

                                    else if(digito.charAt(i) == '.')
                                    {
                                        valor += '.';
                                    }

                                    else {
                                        if (!valor.equals("")) {
                                            ValorDe[cnt] = Double.parseDouble(valor);
                                            char letrinha = (char) (cnt + 'A');
                                            cnt++;
                                            valor = "";
                                            infixa += letrinha;
                                        }
                                        infixa += digito.charAt(i);
                                    }
                                }

                                if(!valor.equals(""))
                                {
                                    ValorDe[cnt] = Double.parseDouble(valor);
                                    char letrinha = (char)(cnt + 'A');
                                    cnt++;
                                    valor = "";
                                    infixa += letrinha;
                                }

                                String posFixa = converterInfixaParaPosfixa(infixa);

                                System.out.println(posFixa);

                                double resultado = ValorExpressaoPosFixa(posFixa);

                                System.out.println(resultado);
                            }
                        }
                        catch (Exception e)
                        {
                            System.err.println(e.getMessage());
                        }

                    }
                }
            }

            catch (Exception err)
            {
                System.err.println(err.getMessage());
            }
        }
    }

    //static char[] validos = {'+', '-', '*', '/', '^', '{', '[', '('};

    /*
    public static boolean balancear(String balance) throws Exception
    {
        String[] d = new String[balance.length()];
        boolean balnco = true;
        PilhaVetor<String> p2 = new PilhaVetor<String>(balance.length());
        for (int i = 0; i < balance.length(); i++)
        {
            d[i] = String.valueOf(balance.charAt(i));
        }
        for (int j = 0; j < balance.length() && balnco; j++)
        {
            if (EVerdade(d[j])) {
                p2.Empilhar(d[j] + "");
            } else {
                String caracterAbertura = p2.Desempilhar();
                if (!Combinam(caracterAbertura, d[j] + ""))
                    balnco = false;
            }
        }
        System.out.println(p2);
        return balnco;
    }
  */

    //Olha quais operações veem primeiro!
    private static boolean TerPrecedencia(char valorLido, char simboloLido)
    {
        boolean temPrecedencia = false;
        switch (valorLido) {
            case '(':
                if (simboloLido == ')')
                    temPrecedencia = true;
                break;

            case '^':
                if (simboloLido == '(')
                    temPrecedencia = false;
                else
                    temPrecedencia = true;
                break;

            case '*':
                if (simboloLido == '('  || simboloLido == '^')
                    temPrecedencia = false;
                else
                    temPrecedencia = true;
                break;

            case '/':
                if (simboloLido == '(' || simboloLido == '^' || simboloLido == '*')
                    temPrecedencia = false;
                else
                    temPrecedencia = true;
                break;

            case '-':
                if (simboloLido == '(' || simboloLido == '^' || simboloLido == '*' || simboloLido == '/')
                    temPrecedencia = false;
                else
                    temPrecedencia = true;
                break;

            case '+':
                if (simboloLido == '(' || simboloLido == '^' || simboloLido == '*' || simboloLido == '/' || simboloLido == '-')
                    temPrecedencia = false;
                else
                    temPrecedencia = true;
                break;
        }

        return temPrecedencia;
    }

    //Validação de operadores
    public static boolean Ehoperador(char simbolo)
    {
        boolean simboloReal = false;
        if (simbolo == '(')
            simboloReal = true;
        else if (simbolo == ')')
            simboloReal = true;
        else if (simbolo == '+')
            simboloReal = true;
        else if (simbolo == '-')
            simboloReal = true;
        else if (simbolo == '*')
            simboloReal = true;
        else if (simbolo == '/')
            simboloReal = true;
        else if (simbolo == '^')
            simboloReal = true;

        return simboloReal;
    }

    /*
        public static boolean EVerdade(String caracter)
        {
            boolean ehVerdade = false;
            if (caracter.equals("("))
                ehVerdade = true;
            else if (caracter.equals("{"))
                ehVerdade = true;
            else if (caracter.equals("["))
                ehVerdade = true;

            return ehVerdade;
        }

        private static boolean Combinam(String abre, String fecha)
        {
            return (abre == "{" && fecha == "}") || (abre == "[" && fecha == "]") || (abre == "(" && fecha == ")");
        }
    */


    private static String converterInfixaParaPosfixa(String cadeiaLida) throws Exception
    {
        //String[] cadeiasLidas = new String[cadeiaLida.length()];
        String resultado = "";
        PIlhaLista<Character> umaPilha = new PIlhaLista<Character>();   //Instância a Pilha

        for (int indice = 0; indice < cadeiaLida.length(); indice++)
        {
            char simboloLido = cadeiaLida.charAt(indice);

            if (!Ehoperador(simboloLido))
            {
                resultado += simboloLido;
            }

            else
            {
                while (!umaPilha.EstaVazia() && TerPrecedencia(umaPilha.OTopo(), simboloLido) && umaPilha.OTopo() != '(')
                    resultado += umaPilha.Desempilhar();

                if(simboloLido != ')')
                    umaPilha.Empilhar(simboloLido);

                else if (umaPilha.OTopo() != '(')
                    resultado += umaPilha.Desempilhar();
            }
        }

        while (!umaPilha.EstaVazia())
        {
            if (umaPilha.OTopo() == '(')
                umaPilha.Desempilhar();

            else
                resultado += umaPilha.Desempilhar();
        }

        return resultado;
    }

    private static double ValorDaSubExpressao(double valor1, char simbolo, double valor2)
    {
        double resultado = 0;
        switch (simbolo)
        {
            case '+':
                resultado = valor1 + valor2;
                break;
            case '-':
                resultado = valor1 - valor2;
                break;
            case '^':
                resultado = Math.pow(valor1, valor2);
                break;
            case '*':
                resultado = valor1 * valor2;
                break;

            case '/':
            {
                if(valor2 == 0 || valor1 == 0)
                {
                    System.err.println("Não é possivél dividir por zero!");
                }
                else
                {
                    resultado = valor1 / valor2;
                }
                break;
            }
        }

        return resultado;
    }

    private static double ValorExpressaoPosFixa(String cadeiaPosfixa) throws Exception
    {

       PIlhaLista<Double> umaPilha = new PIlhaLista<Double>();

       for (int i = 0; i < cadeiaPosfixa.length(); i++)
       {
           char simboloLido = cadeiaPosfixa.charAt(i);
           if(!Ehoperador(simboloLido))
           {
               umaPilha.Empilhar(ValorDe[simboloLido - 'A']);
           }
           else
           {
               double operando2 = umaPilha.Desempilhar();
               double operando1 = umaPilha.Desempilhar();
               double valor = ValorDaSubExpressao(operando1, simboloLido, operando2);
               umaPilha.Empilhar(valor);
           }
       }

       return umaPilha.Desempilhar();
    }
}