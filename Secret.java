import java.util.*;

public class Secret extends Servico
{
    // Variáveis de Instância
    private ArrayList<Carga> cargas;
     
    // Variáveis de Classe
    public static int MAXCARGAS = 1;
   
    // Contructores
    // Parametrizado
    public Secret(ArrayList<Carga> cCargas)
    {
        cargas = new ArrayList<Carga>();
        
        for(Carga c : cCargas)
        {
            cargas.add(c);
            c.setCategCarga(CategCarga.TOXICA);
        }
    }
    
    // Cópia
    public Secret(Secret a)
    {
        ArrayList<Carga> auxCarga = a.getCarga();
        
        for(Carga c : cargas)
            auxCarga.add(c.clone());
    }
    
    // Vazio
    public Secret()
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
    
    public CategCarga getCategCarga()
    {
        return CategCarga.TOXICA;
    }
    
    public int getMaxCarga() { return this.MAXCARGAS; }
    
    public void setMaxCarga(int cMaxCarga) { MAXCARGAS = cMaxCarga; }
    
    // toString
    public String toString()
    {
        StringBuilder s = new StringBuilder( super.toString() );
        
        s.append("Cargas: \n");
        
        for(Carga c : this.cargas)
           s.append( c.toString() );
        
        return s.toString();
    }

    // Clone
    public Secret clone() { return (new Secret(this)); } 
    
    public double totalCarga()
    {
        double res = 0;
        for(Carga c : this.cargas)
            res = res + c.getPeso();
        
        return res;
    }
}
