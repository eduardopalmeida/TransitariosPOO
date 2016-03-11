import java.util.*;
import java.io.*;

public abstract class Servico implements Serializable
{
    private double preco;
    private Veiculo veiculo;
    
    // Constructores
    // Parametrizado
    
    public Servico()
    {
        this.preco = 0.0;
        this.veiculo = null;
    }
   
    // Cópia
    public Servico(Servico s)
    {        
        this.veiculo = s.getVeiculo();
        this.preco   = s.getPreco();
    }
    
    
    // Get's
    public Veiculo getVeiculo()         {   return this.veiculo.clone();    }
    public double getPreco()            {   return this.preco;              }        
    
    
    // Set's 
    public void setVeiculo(Veiculo cVeiculo)    { veiculo = cVeiculo;   }
    public void setPreco(double cPreco)         { preco = cPreco;       }
    
    
    // toString
    public String toString()
    {
        StringBuilder s = new StringBuilder("\n------ Serviço " + (getClass().getName()) + " ------");
        
        s.append("\nPreço: "   + preco);            
        if(this.veiculo != null)
            s.append("\nVeículo: " + veiculo.toString() + "\n");
        return s.toString();
    }
    
    public String listarUltimo()
    {
        return ("\nServiço " + (getClass().getName()) + "\nPreço: " + preco);
    }
    
    
    public double calcularPreco()
    {
        double i = this.getVeiculo().preco(this.totalCarga());
        setPreco(i);
        return i;
    }
    
    public abstract Servico clone();
    public abstract double totalCarga();
    public abstract CategCarga getCategCarga();
    public abstract int getMaxCarga();
    public abstract void setMaxCarga(int cMaxCarga);
    
    
    
    
    
}
