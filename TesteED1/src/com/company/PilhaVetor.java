package com.company;

public class PilhaVetor<Dado> implements IStack<Dado>
{
     Dado[] p;
     int topo;

     public PilhaVetor(int maximo)
     {
         p = (Dado[]) new Comparable[maximo];
         topo = -1;
     }

   public void Empilhar(Dado dado)
   {

      topo = topo + 1;
      p[topo] = dado;
   }

   public Dado OTopo() throws Exception
   {
      if(EstaVazia())
          throw new Exception("Pilha Vázia");

      Dado dadoAEmpilhar = p[topo];

      return dadoAEmpilhar;
   }

   public Dado Desempilhar() throws Exception
   {
       if(EstaVazia())
           throw new Exception("Pilha Vázia");

       Dado dadoAEmpilhar = p[topo];
       topo = topo -1;
       return dadoAEmpilhar;
   }

   public boolean EstaVazia ()
   {
      return (topo < 0);
   }

   public int Tamanho()
   {
       return topo + 1;
   }
    public boolean cheia()
    {
        return (topo == (p.length -1));
    }

    public String toString()
    {
        String ret = "Topo -->[ ";

        for(int i = topo; i > -1; i--)
        {
            ret = ret + p[i] + " ";
        }

        return ret+"]";
    }
}