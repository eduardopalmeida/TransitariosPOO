import java.util.Comparator;

public class VeiculoComparator2 implements  Comparator<Veiculo> 
{
   public int compare(Veiculo v1, Veiculo v2) 
   {
     if(v1.getTotal() == v2.getTotal()) 
        return 0;
     if(v1.getTotal() > v2.getTotal()) 
        return -1;
     else 
        return 1;
   }  
}