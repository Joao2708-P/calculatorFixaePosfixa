package com.company;

public interface IQueque<Dado>
{
    public void Enfileirar(Dado dado) throws Exception;
    Dado Retirar() throws Exception;
    Dado OInicio() throws Exception;
    Dado OFim() throws Exception;
    int Tamanho();
}
