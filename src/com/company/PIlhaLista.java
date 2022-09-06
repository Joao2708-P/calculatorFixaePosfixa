package com.company;

import java.awt.*;

public class PIlhaLista<Dado> implements Comparable<Dado>, IStack<Dado>
{
    NoLista<Dado> topo;
    int tamanho;

    public PIlhaLista()
    {
        this.topo = null;
        this.tamanho = 0;
    }

    public void PilhaLista() // construtor
    {
        topo = null;
        tamanho = 0;
    }


    public int Tamanho()
    {
        return tamanho;
    }

    public boolean EstaVazia ()
    {
        return  topo == null;
    }


    public void Empilhar(Dado o)
    {
        // Instancia um nó, coloca o Dado o nele e o liga ao antigo topo da pilha
        NoLista<Dado> novoNo = new NoLista<Dado>(o, topo);
        topo = novoNo; // topo passa a apontar o novo nó
        tamanho++; // atualiza número de elementos na pilha
    }


    public Dado OTopo() throws Exception
    {
        if (EstaVazia())
            throw new Exception("Underflow da pilha");
        return topo.info;
    }


    public Dado Desempilhar() throws Exception
    {
        if (EstaVazia())
            throw new Exception("Underflow da pilha");
        Dado o = topo.info; // obtém o objeto do topo
        topo = topo.prox; // avança topo para o nó seguinte
        tamanho--; // atualiza número de elementos na pilha
        return o; // devolve o objeto que estava no topo
    }


    @Override
    public int compareTo(Dado o)
    {
        return 0;
    }
}
