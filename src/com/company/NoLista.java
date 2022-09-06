package com.company;

public class NoLista<Dado>
{
    Dado info;
    NoLista<Dado> prox;

    public NoLista(Dado info, NoLista<Dado> prox)
    {
        this.info = info;
        this.prox = prox;
    }

    public Dado getInfo()
    {
        return info;
    }

    public void setInfo(Dado info)
    {
        this.info = info;
    }

    public NoLista<Dado> getProx()
    {
        return prox;
    }

    public void setProx(NoLista<Dado> prox)
    {
        this.prox = prox;
    }
}
