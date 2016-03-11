import java.util.Comparator;

public class ClienteComparator implements  Comparator<Cliente> {
   // método de comparação
   public int compare(Cliente c1, Cliente c2) {
     if(c1.getValorContratado() == c2.getValorContratado()) return 0;
     if(c1.getValorContratado() > c2.getValorContratado()) return -1;
           else return 1;
   }  
}