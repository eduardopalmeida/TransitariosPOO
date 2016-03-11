public class Van extends Veiculo
{
    // Variáveis de Classe
    public static double precoBase = 120.0;
    
    public void mudaPrecoBase(double cPrecoBase) { precoBase = cPrecoBase; }
    
    
    public Van(String cMarca, String cMatricula, double cCustoKm, double cCapacidade, double cOcupado, boolean cEstado, double cTotal)
    {
        super(cMarca, cMatricula, cCustoKm, cCapacidade, cOcupado, cEstado, cTotal);
    }

    public Van(Van v)
    {
        super( v.getMarca(), v.getMatricula(), v.getCustoKm(), v.getCapacidade(), v.getOcupado(), v.getEstado(), v.getTotal() );
    }
    
    
    

    
    public Van clone() { return (new Van(this)); }
    
    // toString
    public String toString()
    {
        return ( "\n---- Van ----\n" + super.toString());
    }
    
    public double preco(double cTotalCarga) { return precoBase; }
}
