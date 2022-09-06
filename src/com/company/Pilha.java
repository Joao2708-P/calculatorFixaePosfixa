package com.company;

 class Pilha
 {
     private int[]   v;
     private int     topo;


    // public Pilha(int[] p)
     //{
      //   v  = p;
   //  }

     public Pilha(){  // construtor
         v = new int[10];
         topo = -1;
     }

     public void empilhar(int e) throws Exception{
         if (cheia()) throw new Exception("Erro de Overflow");;

         topo++;
         v[topo] = e;
     }


     public int  desempilhar() throws Exception{
         if (vazia()) throw new Exception("Erro de Underflow");

         int retorno = v[topo];
         topo--;
         return retorno;

     }

     public Pilha (Pilha modelo)throws Exception
     {
         if(modelo == null)
             throw new Exception("Modelo inessistente");

         this.topo = modelo.topo;
         this.v = modelo.v;

     }

     public Pilha Clone() throws Exception
     {
         Pilha ret = new Pilha();
         int[] uNova = new int[10];
         int i = 0;
         while (!this.vazia())
         {
             uNova[i] = this.desempilhar();
             i++;
         }
         for(int j = uNova.length - 1; j >= 0; j--)
         {
             int k = uNova[j];

             this.empilhar((int) k);

             ret.empilhar(k);
             ret.topo = this.topo;
         }
         return ret;
     }

     public void inverter () throws Exception
     {
         Pilha ret = new Pilha();
         int[] uNova = new int[10];
         int i = 0;
         while (!this.vazia())
         {
             uNova[i] = this.desempilhar();
             i++;
         }
         for(int j = 0; j < uNova.length ; j++)
         {
             int k = uNova[j];

             this.empilhar((int) k);

             ret.empilhar(k);
         }
     }

     public int  consulta() throws Exception
     {
         if (vazia()) throw new Exception("Pilha Vazia");

         return v[topo];
     }

     public boolean cheia(){
         return (topo == (v.length -1));
     }

     public boolean vazia(){
         return (topo == -1);
     }

     public String toString(){
         String ret="Topo --> [";

         for (int i=topo; i>-1 ; i--){
             ret = ret + v[i] + " ";
         }

         return ret+"]";
     }
 }