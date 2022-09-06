package com.company;

public interface IQueque<Dado>
{
    public void Enfileirar(Dado dado);
    Dado Retirar();
    Dado OInicio();
    Dado OFim();
    int Tamnho();
}
