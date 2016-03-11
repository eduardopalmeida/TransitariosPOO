import java.io.*;

public class Carga implements Serializable
{
    private CategCarga categ;
    private double peso;
    
    // Constructores
    // Parametrizado
    public Carga(double cPeso)
    {
        categ = null;
        peso  = cPeso;
    }
    // Cópia
    public Carga(Carga c)
    {
        categ = c.getCategCarga();
        peso  = c.getPeso();
    }
    // Vazio
    public Carga()
    {
        categ = null;
        peso  = 0.0;
    }
    
    // Get's
    public CategCarga getCategCarga()   { return categ; }
    public double getPeso()             { return peso;  }
    
    // Set's
    public void setCategCarga(CategCarga cCateg)    { categ = cCateg;       }
    public void setPeso(double cPeso)               { peso = cPeso;         }
    
    // Clone
    public Carga clone()  { return new Carga(this); }
    
    // toString
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append("Categoria: " + categ + "\n");
        s.append("Peso: " + peso + "\n");
        
        return s.toString();
    }
    
    //  Equals
    public boolean Equals(Object o)
    {
        if(this == o)
        return true;
        
        if( (o == null) || (this.getClass() != o.getClass()))
        return false;
        
        Carga auxCarga = (Carga) o;
     
        return ( this.categ.equals( auxCarga.getCategCarga() )  && ( peso == auxCarga.getPeso() ) ) ;
    }
    
}
