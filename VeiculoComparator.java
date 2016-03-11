import java.util.Comparator;

public class VeiculoComparator implements  Comparator<Veiculo> 
{
   public int compare(Veiculo v1, Veiculo v2) 
   {
     if(v1.getOcupado() == v2.getOcupado()) 
        return 0;
     if(v1.getOcupado() > v2.getOcupado()) 
        return -1;
     else 
        return 1;
   }  
}