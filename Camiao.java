public class Camiao extends Veiculo
{
    // Variáveis de Classe 
    private static double xCoeficiente = 0.4;
    private static double yCoeficiente = 0.5;
    

    public void mudaXCoeficiente(double cX)          { xCoeficiente = cX;      }
    public void mudaYCoeficiente(double cY)          { yCoeficiente = cY;      }

    // Variáveis de Instância
    private String condutor;
    private boolean atrelado;
    private double altura;
    private double precoBase;
    
    // Contructores
    // Parametrizado
    public Camiao(String cMarca, String cMatricula, double cCustoKm, double cCapacidade, double cOcupado, boolean cEstado, double cTotal, String cCondutor, boolean cAtrelado, double cAltura, 
                  double cPrecoBase)
    {
        super(cMarca, cMatricula, cCustoKm, cCapacidade, cOcupado, cEstado, cTotal);
        condutor = cCondutor;
        atrelado = cAtrelado;
        altura = cAltura;
        precoBase = cPrecoBase;
    }
    
    // Cópia
    public Camiao(Camiao c)
    {
        super(c.getMarca(), c.getMatricula(), c.getCustoKm(), c.getCapacidade(), c.getOcupado(), c.getEstado(), c.getTotal());
        this.condutor = c.getCondutor();
        this.atrelado = c.getAtrelado();
        this.altura = c.getAltura();
        this.precoBase = c.getPrecoBase();
    }
    
    // Vazio
    public Camiao()
    {
        condutor = "";
        altura = 0.0;
    }
    
    // Get's
    public String getCondutor()     { return this.condutor;     }
    public boolean getAtrelado()    { return this.atrelado;     }
    public double getAltura()       { return this.altura;       }
    public double getXCoeficiente() { return this.xCoeficiente; }
    public double getYCoeficiente() { return this.yCoeficiente; }
    public double getPrecoBase()    { return this.precoBase;    }
    
    // Set's
    public void setCondutor(String cCondutor)   { condutor = cCondutor;     }
    public void setAtrelado(boolean cAtrelado)  { atrelado = cAtrelado;     }
    public void setAltura(double cAltura)       { altura = cAltura;         }
    public void setXCoeficiente(double cX)      { xCoeficiente = cX;        }
    public void setYCoeficiente(double cY)      { yCoeficiente = cY;        }
    public void mudaPrecoBase(double cPrecoBase){ precoBase = cPrecoBase;   }
    
                    
    // toString
    public String toString()
    {  
        StringBuilder s = new StringBuilder("\n------ Camião ---------\n");
        s.append(super.toString());
        s.append("Condutor: "            + condutor +              "\n");
        s.append("Atrelado: "            + atrelado +              "\n");
        s.append("Altura: "              + altura +                "\n");
        return s.toString();
    }
    
    
    // Equals
    public boolean equals(Camiao c)
    {
        return( (super.equals(c)) &&
                (c.condutor == this.condutor) &&
                (c.atrelado == this.atrelado) &&
                (c.altura   == this. altura)
              );
    }
    
    // Clone
    public Camiao clone()
    {
        return (new  Camiao(this));
    }
    
    public double preco(double cTotalCarga)
    {
        return yCoeficiente*precoBase + xCoeficiente*(getCapacidade()-cTotalCarga);
    }
}
