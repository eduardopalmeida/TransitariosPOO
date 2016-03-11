import java.util.*;

public class Simples extends Servico
{
    // 1  carga  indiferenciada para qualquer destino.
    
    // Variáveis de Instância
    private ArrayList<Carga> cargas;
     
    // Variáveis de Classe
    public static int MAXCARGAS = 1;
    
    // Constructores
    // Parametrizado
    public Simples(ArrayList<Carga> cCargas)
    {
        cargas = new ArrayList<Carga>();
        
        for(Carga c : cCargas)
        {
            cargas.add(c);
            c.setCategCarga(CategCarga.INDIFERENCIADA);
        }
    }
    
    // Cópia
    public Simples(Simples s)
    {
        ArrayList<Carga> auxCarga = s.getCarga();
        
        for(Carga c : cargas)
            auxCarga.add(c.clone());
    }
    
    // Vazio
    public Simples()
    {
        cargas = new ArrayList<Carga>(MAXCARGAS);
    }

    // Get's
    public ArrayList<Carga> getCarga()
    {
        ArrayList<Carga> aux = new ArrayList<Carga>();
        
        for(Carga c : this.cargas)
            aux.add(c.clone());
        
        return aux;
    }
    
    // Set's
    
    public void setCarga(ArrayList<Carga> cCargas) 
    {
       for(Carga c : cCargas)
       {
           cargas.add(c.clone());
       }
    }
    
    public int getMaxCarga() { return this.MAXCARGAS; }
    
    public void setMaxCarga(int cMaxCarga) { MAXCARGAS = cMaxCarga; }
    
    public CategCarga getCategCarga()
    {
        return CategCarga.INDIFERENCIADA;
    }
        
    // toString
    public String toString()
    {
        StringBuilder s = new StringBuilder( super.toString() );

        s.append("Cargas: \n");
        
        for(Carga c : cargas)
           s.append( c.toString() );
        
        return s.toString();
    }
    
    // Clone
    public Simples clone() { return (new Simples(this)); }
    
    
    public double totalCarga()
    {
        double res = 0;
        for(Carga c : cargas)
            res = res + c.getPeso();
        
        return res;
    }
    
}
