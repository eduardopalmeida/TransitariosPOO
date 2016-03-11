import java.util.*;
import java.io.*;

public abstract class Veiculo implements Serializable
{
    // Variáveis de Instância
    private String marca;
    private String matricula;
    private double custoKm;
    private double capacidade;
    private double ocupado;
    private boolean estado; // True - veículo está em serviço
    private double total;
    
    // Contructores
    // Parametrizado
    public Veiculo(String cMarca, String cMatricula, double cCustoKm, double cCapacidade, double cOcupado, boolean cEstado, double cTotal)
    {
        marca = cMarca;
        matricula = cMatricula;
        custoKm = cCustoKm;
        capacidade = cCapacidade;
        ocupado = cOcupado;
        estado = cEstado;
        total = cTotal;
    }
    
    // Cópia
    public Veiculo(Veiculo v)
    {
        this.marca      = v.getMarca();
        this.matricula  = v.getMatricula();
        this.custoKm    = v.getCustoKm();
        this.capacidade = v.getCapacidade();
        this.ocupado    = v.getOcupado();
        this.estado     = v.getEstado();
        this.total      = v.getTotal();
    }
    
    // Vazio
    public Veiculo()
    {
        this.marca      = "";
        this.matricula  = "";
        this.custoKm    = 0.0;
        this.capacidade = 0.0;
        this.ocupado    = 0.0;
        this.total      = 0.0;
    }
    
    // Get's
    public String getMarca()        { return this.marca;        }
    public String getMatricula()    { return this.matricula;    }
    public double getCustoKm()      { return this.custoKm;      }
    public double getCapacidade()   { return this.capacidade;   }
    public double getOcupado()      { return this.ocupado;      }
    public boolean getEstado()      { return this.estado;       }
    public double getTotal()        { return this.total;        }
    
    // Set's
    public void setMarca(String cMarca)             { marca = cMarca;           }
    public void setMatricula(String cMatricula)     { matricula = cMatricula;   }
    public void setCustoKm(double cCustoKm)         { custoKm = cCustoKm;       }
    public void setCapacidade(double cCapacidade)   { capacidade = cCapacidade; }
    public void setOcupado(double cOcupado)         { ocupado = cOcupado;       }
    public void setEstado(boolean cEstado)          { estado = cEstado;         }
    public void setTotal(double cTotal)             { total = cTotal;           }
    
    // Incrementa
    public void incOcupado(double acrescento)       { ocupado += acrescento;    }
    public void incTotal(double acrescento)         { total += acrescento;      }
    
    // toString
    public String toString()
    {  
        StringBuilder s = new StringBuilder();
        s.append("Marca: "            + marca +                     "\n");
        s.append("Matrícula: "        + matricula +                 "\n");
        s.append("Custo por Km: "     + custoKm +                   "\n");
        s.append("Capacidade: "       + capacidade +                "\n");
        s.append("Ocupado: "          + ocupado +                   "\n");
        s.append("Activo: "           + estado +                    "\n");
        s.append("Histórico carga: "  + total +                     "\n");
        return s.toString();
    }
    public String shortToString()
    {
        StringBuilder s = new StringBuilder();
        s.append(matricula + "\t" + marca + "\t" + ( getClass().getName() ) + "\n" );
        
        return s.toString();
    }
    // Equals
    public boolean equals(Veiculo v)
    {
        return( 
                (v.marca == this.marca) && 
                (v.matricula == this.matricula) && 
                (v.custoKm == this.custoKm) &&
                (v.capacidade == this.capacidade) &&
                (v.ocupado == this.ocupado)
               );
    }
   
    // Métodos de Instância
    // Dada uma carga diz se pode ser transportada
    public boolean podeTransportar(double totalCarga) 
    { 
        return ( ( getCapacidade() - getOcupado() ) > totalCarga ); 
    }
    
    // 
    public boolean podeSair()
    {
        return ( getOcupado() >= 0.6*getCapacidade() );
    }

    public abstract Veiculo clone();
    public abstract double preco(double cTotalCarga);
    public abstract void mudaPrecoBase(double cPrecoBase);
}
