import java.util.*;
import java.io.*;

public class Cliente implements Serializable
{
   // Variáveis de instância
   private String nome;
   private int numero;
   private TipoCliente tipo;
   private String morada;
   private int contribuinte;
   private double valorContratado;
   private ArrayList<Servico> servicos;
   
   // Variáveis de Classe
   private static int numCliente = 0;
    
   // Construtores
   public Cliente(String cNome, TipoCliente cTipo, String cMorada, int cContribuinte, double cValorContratado)
   {
       nome            = cNome;
       numero          = numCliente + 1;
       tipo            = cTipo;
       morada          = cMorada;
       contribuinte    = cContribuinte;
       valorContratado = cValorContratado;
       servicos        = new ArrayList<Servico>();
       
       numCliente++;
   }
    
   public Cliente(Cliente c)
   {
       nome            = c.getNome();
       numero          = c.getNumero();
       tipo            = c.getTipo();
       morada          = c.getMorada();
       contribuinte    = c.getContribuinte();
       valorContratado = c.getValorContratado();
       servicos        = c.getServicos();
   }
    
   // Get's
   public String getNome()              { return this.nome;                 }
   public int getNumero()               { return this.numero;               }
   public TipoCliente getTipo()         { return this.tipo;                 }
   public String getMorada()            { return this.morada;               }
   public int getContribuinte()         { return this.contribuinte;         }
   public double getValorContratado()   { return this.valorContratado;      }
   
   
   public ArrayList<Servico> getServicos()  
   {
       ArrayList<Servico> aux = new ArrayList<Servico>();
       
       for(Servico s: this.servicos)
            aux.add(s);
       
       return aux;
   }

   // Set's
   public void setNome(String cNome)                       { nome = cNome;                          }
   public void setNumero(int cNumero)                      { numero = cNumero;                      }
   public void setTipo(TipoCliente cTipo)                  { tipo = cTipo;                          }
   public void setMorada(String cMorada)                   { morada = cMorada;                      }
   public void setContribuinte(int cContribuinte)          { contribuinte = cContribuinte;          }
   public void setValorContratado(double cValorContratado) { valorContratado = cValorContratado;    }
   public void setServicos(ArrayList<Servico> cServicos)
   {
       this.servicos.clear();
       
       for(Servico s: cServicos)
            this.servicos.add(s);
   }
   
    // Incrementa
    public void incValorContratado(double acrescento)       { valorContratado += acrescento;    }

   
   // Clone
   public Cliente clone() { return new Cliente(this); }
   
   // To String
   public String toString() 
   {
       StringBuilder s = new StringBuilder("------ CLIENTE ---------\n");
       s.append("Nome: "                + nome +                    "\n");
       s.append("Número: "              + numero +                  "\n");
       s.append("Tipo: "                + tipo +                    "\n");
       s.append("Morada: "              + morada +                  "\n");
       s.append("Contribuinte: "        + contribuinte +            "\n");
       s.append("Valor contratado: "    + valorContratado +         "\n");
       if (ultimoServico() != null) 
            s.append("Último serviço: "      + ultimoServico().listarUltimo() +"\n");
       return s.toString();
   } 
    
   // Equals
   public boolean equals(Object o) 
   {
        if (this == o) 
            return true;
            
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
            
        Cliente umCliente = (Cliente)o;
        
        return (
                       this.nome.equals(umCliente.getNome()) 
                    && this.numero == umCliente.getNumero()
                    && this.tipo.equals(umCliente.getTipo()) 
                    && this.morada.equals(umCliente.getMorada())
                    && this.contribuinte == umCliente.getContribuinte()
                    && this.valorContratado == umCliente.getValorContratado()
                    && this.servicos.equals(umCliente.getServicos())
               );
   }
      
   // Add Servico
   public void addServico(Servico s) { this.servicos.add(s); }
   
   // Último serviço
   public Servico ultimoServico()   
   {
       if (this.servicos.size() > 0) 
            return this.servicos.get(this.servicos.size() -1);
       else 
            return null;
   }
   
   // Lista Serviços
   public String listaServicos()
   {
       StringBuilder str = new StringBuilder("\n---- Lista de Serviços -----\n");

       for(Servico s : this.servicos)
            str.append( s.toString());
       
       return str.toString();
   }
}

