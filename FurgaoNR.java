public class FurgaoNR extends Veiculo
{
    // Variáveis de Classe
    private static double precoBase = 50.0;
    private static double xCoeficiente = 0.4;
    
    public void mudaPrecoBase(double cPrecoBase)     { precoBase = cPrecoBase;   }
    public void mudaXCoeficiente(double x)           { xCoeficiente = x;         }    
    
    // Variáveis de instância
    private Combustivel comb;
    private double autonomia; // Km's
    
    // Constructores
    // Parameterizado
    public FurgaoNR( String cMarca, String cMatricula, double cCustoKm, double cCapacidade, double cOcupado, boolean cEstado, double cTotal, Combustivel cComb, double cAutonomia)
    {
        super(cMarca, cMatricula, cCustoKm, cCapacidade, cOcupado, cEstado, cTotal);
        comb = cComb;
        autonomia = cAutonomia;
    }
    
    // Cópia
    public FurgaoNR(FurgaoNR f)
    {
        super(f.getMarca(), f.getMatricula(), f.getCustoKm(), f.getCapacidade(), f.getOcupado(), f.getEstado(), f.getTotal());
        this.comb = f.getCombustivel();
        this.autonomia = f.getAutonomia();
    }
    
    // Vazio
    public FurgaoNR()
    {
        comb = null;
        autonomia = 0.0;
    }
    
    // Get's
    public Combustivel getCombustivel()  { return this.comb;         }
    public double getAutonomia()         { return this.autonomia;    }
    
    // Set's
    public void setCombustivel(Combustivel cComb)    { comb = cComb;             }
    public void setAutonomia(double cAutonomia)      { autonomia = cAutonomia;   }
    
    // toString
    public String toString()
    {  
        StringBuilder s = new StringBuilder("\n------ Furgão Não-Refrigerado ---------\n");
        s.append(super.toString());
        s.append("Combustível: "            + comb +                               "\n");
        s.append("Autonomia: "              + autonomia +                          "\n");
        return s.toString();
    }
    // Equals
    public boolean equals(FurgaoNR f)
    {
        return (super.equals(f) &&
               (f.comb == this.comb) &&
               (f.autonomia == this.autonomia)
                );
    }
    
    // Clone
    public FurgaoNR clone()
    {
        return (new  FurgaoNR(this));
    }
    
    public double preco(double cTotalCarga)
    {
        return precoBase + xCoeficiente*(getCapacidade()-cTotalCarga);
    }
}