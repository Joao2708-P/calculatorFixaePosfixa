package com.company;


import java.util.List;

public class FilaVetor<Dado> implements IQueque<Dado>, Comparable<Dado>
{
    Dado[] f;
    int inicio, fim, tamanhoMaximo;  // N
    public FilaVetor()
    {}
    public FilaVetor(int tamanho)
    {
        f = (Dado[]) new Comparable[tamanho];
        inicio = fim = 0;
        tamanhoMaximo = tamanho;
    }
    public boolean EstaVazia()
    {
        return inicio == fim;
    }
    public void Enfileirar(Dado dado) throws Exception
    {
        if (Tamanho() == tamanhoMaximo - 1)
            throw new Exception("Overflow/Transbordamento: Fila cheia!");

        f[fim] = dado;
        fim = (fim + 1) % tamanhoMaximo;
    }
    public Dado Retirar() throws Exception
    {
        if (EstaVazia())
            throw new Exception("Underflow/Esvaziamento: Fila vazia!");

        Dado elementoRetirado = f[inicio];
        // f[inicio] = null;
        inicio = (inicio + 1) % tamanhoMaximo;
        return elementoRetirado;
    }
    public Dado OFim() throws Exception
    {
        if (EstaVazia())
            throw new Exception("Underflow/Esvaziamento: Fila vazia!");

        if (fim == 0)
            return f[tamanhoMaximo - 1];

        return f[fim - 1];
    }

    @Override
    public int Tamanho() {
        return (tamanhoMaximo - inicio + fim) % tamanhoMaximo;
    }

    public Dado OInicio()throws Exception
    {
        if (EstaVazia())
            throw new Exception("Underflow/Esvaziamento: Fila vazia!");
        return f[inicio];
    }

   /* public List<Dado> Lista()
    {
        var lista = new List<Dado>();
        for (int indice = inicio; indice != fim; indice = (indice+1)%tamanhoMaximo)
            lista.add(f[indice]);
        return lista;
    }*/

    @Override
    public int compareTo(Dado o) {
        return 0;
    }
}
