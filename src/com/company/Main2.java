package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main2
{
    public static void main(String[] args)throws Exception
    {
        PilhaVetor<Integer> p1 = new PilhaVetor<Integer>(300);
        //Random rnd = new Random(300);
        //p1.Empilhar(600);

            try
            {
                System.out.println("Digite uma sequencia de operações:  ");
                String digito = Teclado.getUmString();
                balancear(digito);
            }
            catch (Exception err)
            {
                System.err.println(err.getMessage());
            }

            //System.out.println(p1);
    }

    public static boolean balancear(String balance)throws Exception
    {
        String[] d = new String[balance.length()];
        boolean balnco = true;
        PilhaVetor<String> p2 = new PilhaVetor<String>(balance.length());
        for(int i =0; i < balance.length(); i++)
        {
            d[i] = String.valueOf(balance.charAt(i));
        }
        for(int j = 0; j < balance.length() && balnco; j++)
        {
            if(EVerdade(d[j]))
            {
                p2.Empilhar(d[j] + "");
            }
            else
            {
                String caracterAbertura = p2.Desempilhar();
                if (!Combinam(caracterAbertura, d[j]+""))
                    balnco = false;
            }
        }
        System.out.println(p2);
        return balnco;
    }


    private static boolean TerPrecedencia(char valorLido, char simboloLido)
    {
        boolean temPrecedencia = false;
        switch(valorLido)
        {
            case '(':
                if(simboloLido == ')')
                    temPrecedencia = true;
                break;

            case '^':
                if (simboloLido == '(')
                    temPrecedencia = false;
                else
                    temPrecedencia = true;
                break;
            case '*':
                if(simboloLido == '(' || simboloLido == '^')
                    temPrecedencia = false;
                else
                    temPrecedencia = true;
                break;
            case '/':
                if(simboloLido == '(' || simboloLido == '^' || simboloLido == '*')
                    temPrecedencia = false;
                else
                    temPrecedencia = true;
                break;
            case '-':
                if(simboloLido == '(' || simboloLido == '^' || simboloLido == '*' || simboloLido == '/' )
                    temPrecedencia = false;
                else
                    temPrecedencia = true;
                break;
            case '+':
                if(simboloLido == '(' || simboloLido == '^' || simboloLido == '*' || simboloLido == '/' || simboloLido == '-' )
                    temPrecedencia = false;
                else
                    temPrecedencia = true;
                break;
            default:
        }

        return temPrecedencia;
    }

    public static boolean Ehoperador(char simbolo)
    {
        boolean simboloReal = false;
        if(simbolo == '(')
            simboloReal = true;
        else if(simbolo == ')')
            simboloReal = true;
        else if(simbolo == '[')
            simboloReal = true;
        else if(simbolo == ']')
            simboloReal = true;
        else if(simbolo == '{')
            simboloReal = true;
        else if(simbolo == '}')
            simboloReal = true;
        else if(simbolo == '+')
            simboloReal = true;
        else if(simbolo == '-')
            simboloReal = true;
        else if(simbolo == '*')
            simboloReal = true;
        else if(simbolo == '/')
            simboloReal = true;
        else if(simbolo == '^')
            simboloReal = true;

        return simboloReal;
    }
    public static boolean EVerdade(String caracter)
    {
        boolean ehVerdade = false;
        if(caracter.equals("("))
            ehVerdade = true;
        else if(caracter.equals("{"))
            ehVerdade = true;
        else if(caracter.equals("["))
            ehVerdade = true;

        return  ehVerdade;
    }

    private static boolean Combinam(String abre, String fecha)
    {
        return (abre == "{" && fecha == "}") || (abre == "[" && fecha == "]") || (abre == "(" && fecha == ")");
    }

    private static String converterInfixaParaPosfixa(String cadeiaLida) throws Exception
    {
        String[] cadeiasLidas = new String[cadeiaLida.length()];
        String resultado = "";
        PilhaVetor<Character> umaPilha = new PilhaVetor<Character>();   //Instância a Pilha
        for(int indice = 0; indice < cadeiaLida.length(); indice++)
        {
            char simboloLido = cadeiaLida.charAt(indice);
            if(!Ehoperador(simboloLido))
            {
                resultado += simboloLido;
            }
            else
            {
                boolean parou = false;
                while (!parou && !umaPilha.EstaVazia() && TerPrecedencia(umaPilha.OTopo(), simboloLido))
                {
                   char operandoMaior = umaPilha.Desempilhar();
                   if(operandoMaior != '(')
                   {
                       resultado += operandoMaior;
                   }
                   else
                       parou = true;
                }
            }
        }
        return resultado;
    }
}