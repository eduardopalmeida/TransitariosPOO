import java.util.*;

public class Aeroporto extends Servico
{
    // 3  cargas indiferenciadas para um Aeroporto.
     
    // Variáveis de Instância
    private ArrayList<Carga> cargas;
     
    // Variáveis de Classe
    public static int MAXCARGAS = 3;
     
    // Contructores
    // Parametrizado
    public Aeroporto(ArrayList<Carga> cCargas)
    {
        cargas = new ArrayList<Carga>();
        
        for(Carga c : cCargas)
        {
            cargas.add(c);
            c.setCategCarga(CategCarga.INDIFERENCIADA);
        }
    }
    
    // Cópia
    public Aeroporto(Aeroporto a)
    {
        ArrayList<Carga> auxCarga = a.getCarga();
        
        for(Carga c : cargas)
            auxCarga.add(c.clone());
    }
    
    // Vazio
    public Aeroporto()
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
    public Aeroporto clone() { return (new Aeroporto(this)); }
    
    public double totalCarga()
    {
        double res = 0;
        for(Carga c : cargas)
            res = res + c.getPeso();
        
        return res;
    }
}
