import java.util.*;

public class QueridoMudeiACasa extends Servico
{
    // 10 cargas indiferenciadas para uma casa.

     // Variáveis de Instância
     private ArrayList<Carga> cargas;
     
     // Variáveis de Classe
     public static int MAXCARGAS = 10;
    
    // Contructores
    // Parametrizado
    public QueridoMudeiACasa(ArrayList<Carga> cCargas)
    {
        cargas = new ArrayList<Carga>();
        
        for(Carga c : cCargas)
        {
            cargas.add(c);
            c.setCategCarga(CategCarga.INDIFERENCIADA);
        }
    }
    
    // Cópia
    public QueridoMudeiACasa(QueridoMudeiACasa q)
    {
        ArrayList<Carga> auxCarga = q.getCarga();
        
        for(Carga c : cargas)
            auxCarga.add(c.clone());
    }
    
    // Vazio
    public QueridoMudeiACasa()
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
    
    public CategCarga getCategCarga()
    {
        return CategCarga.INDIFERENCIADA;
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
    public QueridoMudeiACasa clone() { return (new QueridoMudeiACasa(this));    }
    
    public double totalCarga()
    {
        double res = 0;
        for(Carga c : cargas)
            res = res + c.getPeso();
        
        return res;
    }
    
    
}
