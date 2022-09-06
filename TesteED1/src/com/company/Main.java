package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {

            Pilha pl = new Pilha();
            Pilha p2 = new Pilha();
            Random rnd = new Random(100);

            while (!pl.cheia())
            {
                pl.empilhar(rnd.nextInt(100));
            }

            try
            {
                p2 = pl.Clone();
            }
            catch (Exception err)
            {
                System.err.println(err.getMessage());
            }

            //pl.inverter();
            System.out.println(p2);
            System.out.println(pl);
            somentePares(pl);
            Inverter(pl);
        }

        public static void somentePares (Pilha P) throws Exception {

            Pilha dePares = new Pilha();

            int elemento = 0;

            Pilha aux = new Pilha();

            while (!P.vazia()) {
                elemento = P.desempilhar();
                aux.empilhar(elemento);
            }

            while (!aux.vazia()) {
                elemento = aux.desempilhar();

                if ((elemento % 2) == 0)
                    dePares.empilhar(elemento);

                P.empilhar(elemento);
            }

            System.out.println(dePares);
        }
        public static void Inverter (Pilha p) throws Exception
        {
            Pilha ret = new Pilha();
            int[] uNova = new int[10];
            int i = 0;
            while (!p.vazia())
            {
                uNova[i] = p.desempilhar();
                i++;
            }

            for(int j = 0; j <= uNova.length - 1; j++)
            {
                int k = uNova[j];

                int h = (int) k;

                p.empilhar(h);

                ret.empilhar(k);
            }
            System.out.println(ret);
        }
    }