package com.company;

import java.util.Random;

public class Main2
{
    public static void main(String[] args)throws Exception
    {
        PilhaVetor<Integer> p1 = new PilhaVetor<Integer>(10);
        PilhaVetor<Integer> p2 = new PilhaVetor<Integer>(10);
        PilhaVetor<Integer> p3 = new PilhaVetor<Integer>(10);
        PilhaVetor<Integer> p4 = new PilhaVetor<Integer>(10);
        PilhaVetor<Integer> p5 = new PilhaVetor<Integer>(10);
        PilhaVetor<Integer> p6 = new PilhaVetor<Integer>(10);
        PilhaVetor<Integer> p7 = new PilhaVetor<Integer>(10);
        PilhaVetor<Integer> p8 = new PilhaVetor<Integer>(10);
        PilhaVetor<Integer> p9 = new PilhaVetor<Integer>( 10);
        PilhaVetor<Integer> p10 = new PilhaVetor<Integer>(10);
        Random rnd = new Random(300);

        while (!p1.cheia())
        {
            p1.Empilhar(rnd.nextInt(300));
            p2.Empilhar(rnd.nextInt(300));
            p3.Empilhar(rnd.nextInt(300));
            p4.Empilhar(rnd.nextInt(300));
            p5.Empilhar(rnd.nextInt(300));
            p6.Empilhar(rnd.nextInt(300));
            p7.Empilhar(rnd.nextInt(300));
            p8.Empilhar(rnd.nextInt(300));
            p9.Empilhar(rnd.nextInt(300));
            p10.Empilhar(rnd.nextInt(300));
        }

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println(p9);
        System.out.println(p10);
    }
}
