package com.company;

interface IStack<Dado>
{
    void Empilhar(Dado dado);
    Dado OTopo() throws Exception;
    Dado Desempilhar() throws Exception;
    boolean EstaVazia();
    int Tamanho();
}
