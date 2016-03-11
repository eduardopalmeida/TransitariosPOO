import static java.lang.System.out;
import java.io.*;
import java.util.*;

public class Empresa implements Serializable
{
    public static double percMinimaCargaOcupada = 0.6;
    public static double PBVan    = 30.0;
    public static double PBFurgao = 50.0;
    
    private HashMap<Integer, Cliente> clientes; // = new TreeMap<Integer,Cliente>();
    private HashMap<String,Veiculo> frota; // = new HashMap<String, Veiculo>();
    private ArrayList<Servico> servicos; // = new ArrayList<Servico>();
    
    // Constructores
    // Vazio
    public Empresa()
    {
        clientes = new HashMap<Integer, Cliente>();
        frota = new HashMap<String, Veiculo>();
        servicos = new ArrayList<Servico>();
    }
    
    // Parametrizado
    public Empresa(HashMap<Integer, Cliente> cClientes, HashMap<String, Veiculo> cFrota, ArrayList<Servico> cServicos)
    {
        clientes = new HashMap<Integer, Cliente>();
        frota = new HashMap<String, Veiculo>();
        servicos = new ArrayList<Servico>();
        
        // Copia Clientes
        for(Cliente c : cClientes.values())
        {
            clientes.put(c.getContribuinte(), c.clone());
        }
        
        // Copia Frota        
        for(String matr : cFrota.keySet()) 
        {
            frota.put(matr, ( cFrota.get(matr) ).clone() );
        }    
        
        // Copia Servicos
        for(Servico s : cServicos)
        {
            servicos.add(s);       
        }
    }
    
    // Cópia
    public Empresa(Empresa e)
    {
        HashMap<Integer, Cliente>  auxClientes = e.getClientes();
        HashMap<String,Veiculo>    auxFrota    = e.getFrota();
        ArrayList<Servico>         auxServicos = e.getServicos();
        
        Set<Integer> keys = clientes.keySet();
        
        for(Integer i : keys)
            auxClientes.put(i, clientes.get(i).clone() );
        
        for(String matr : frota.keySet())
            auxFrota.put(matr, ( frota.get(matr) ).clone() );
    
        for(Servico s : servicos)
            auxServicos.add(s.clone());
    }
    
    // Get's
    public HashMap<Integer, Cliente> getClientes()
    {
        HashMap<Integer, Cliente> aux = new HashMap<Integer, Cliente>();
        
        Set<Integer> keys = clientes.keySet();
        
        for(Integer i : keys)
            aux.put(i, clientes.get(i).clone() );
        
        return aux;
    }
    
    public HashMap<String, Veiculo> getFrota()
    {
        HashMap<String, Veiculo> aux = new HashMap<String, Veiculo>();
        
        for(String matr : frota.keySet())
            aux.put(matr, ( frota.get(matr) ).clone() );
        
        return aux;
    }
    
    public ArrayList<Servico> getServicos()
    {
        ArrayList<Servico> aux = new ArrayList<Servico>();
        
        for(Servico s : servicos)
            aux.add(s.clone());
        
        return aux;
    }
    
    // Adicionar Cliente
    public void addCliente(Cliente c)
    { 
        clientes.put(c.getContribuinte(), c.clone()); 
    }
    
    // Adicionar Cliente     
    public void addVeiculo(Veiculo v)
    {
        frota.put(v.getMatricula(), v.clone());
    }
    
    // Remover Veículo
    public void remVeiculo(String matricula)
    {
        if (frota.containsKey(matricula)) 
            frota.remove(matricula);
    }
    
    // Adicionar Serviço
    public void addServico(Servico s)
    {
        servicos.add(s);
    }
    
    // Verifica se já existe o cliente
    public boolean existeCliente(Integer contribuinte) 
    {
       return clientes.containsKey(contribuinte);
    }
    
    public Cliente getCliente(Integer contribuinte)
    {
       Cliente c;
       if(existeCliente(contribuinte))
            return c = clientes.get(contribuinte).clone();
       else return null;
    }
    
    public Veiculo getVeiculo(String matricula)
    {
       Veiculo v;
       if(frota.containsKey(matricula))
            return v = frota.get(matricula).clone();
       else return null;
    }
    
    // Retorna um veículo de um serviço
    public void retornaVeiculo(String matricula) 
    {
        Veiculo v;
        v = frota.get(matricula).clone();
        v.setEstado(false);
        v.setOcupado(0.0);
        addVeiculo(v);
    }
    
    // Envia um veículo em serviço sem cumprir os 60% de ocupação
    public void enviaVeiculo(String matricula)
    {
        Veiculo v;
        v = frota.get(matricula).clone();
        if (v.getOcupado() > 0)
            v.setEstado(true); 
        addVeiculo(v);
    }
    
    // Ficha cliente
    public String fichaCliente(Integer contribuinte)
    {
        if(existeCliente(contribuinte)) 
            return clientes.get(contribuinte).toString();
        else
            return null;
    }

    // Devolve uma STRING com a lista dos veiculos
    public String listaVeiculos()
    {
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        for(String str: frota.keySet())
            veiculos.add(frota.get(str).clone());
        Collections.sort(veiculos, new VeiculoComparator());
        
        StringBuilder s = new StringBuilder("---- Lista de Veiculos -----\n");
        
        for(Veiculo v : veiculos )
            s.append( v.toString());
            
        return s.toString();
    }
    
    public String listaVeiculosShort()
    {        
        StringBuilder s = new StringBuilder();
        
        for(Veiculo v : frota.values() )
            s.append( v.shortToString() );
            
        return s.toString();
    }    
    
    // Devolve uma STRING com a lista dos veiculos a aguardar autorização
    public String listaVeiculosPendentes()
    {
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        for(String str: frota.keySet())
            veiculos.add(frota.get(str).clone());
        Collections.sort(veiculos, new VeiculoComparator2());
        
        StringBuilder s = new StringBuilder("---- Lista de Veiculos -----\n");
        
        for(Veiculo v : veiculos )
        {
            if(v.getEstado() == false)
                s.append( v.toString());
        }
            
        return s.toString();
    }
    
    
    // Devolve uma String com a lista de clientes da Empresa
    public String listaClientes()
    {
        ArrayList<Cliente> cl = new ArrayList<Cliente>();
        for(Integer contribuinte : clientes.keySet())
            cl.add(clientes.get(contribuinte).clone());
        Collections.sort(cl, new ClienteComparator());
        
        StringBuilder s = new StringBuilder("---- Lista de Clientes -----\n");
        
        for(Cliente c : cl)
            s.append( c.toString());
            
        return s.toString();
        
    }
    
    // Lista Serviços
    public String listaServicos()
    {
        StringBuilder str = new StringBuilder("---- Lista de Serviços -----\n"); 
    
        for(Servico s : this.servicos)
             str.append( s.toString());
        
        return str.toString();
    }
    
    Veiculo existeVeiculo(CategCarga tipoCarga, double totalCarga)
    {
        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        for(String str: frota.keySet())
                veiculos.add(frota.get(str).clone());
        Collections.sort(veiculos, new VeiculoComparator());
        
        switch(tipoCarga)
        {
            case INDIFERENCIADA:
            {
                for(Veiculo v : veiculos)
                {
                    // 1ª prioridade
                    if( ( (v instanceof Camiao)  || (v instanceof FurgaoNR) ) && v.podeTransportar(totalCarga) && !v.getEstado() ) 
                        return (v.clone());
                }
                for(Veiculo v : veiculos)
                {
                    if( ((v instanceof Van) || (v instanceof FurgaoR)) && v.podeTransportar(totalCarga) && !v.getEstado() )
                        return (v.clone());
                }
                break;
            }
            case PERECIVEL:
            {
                for(Veiculo v : veiculos)
                {
                    if( ((v instanceof Van) || (v instanceof FurgaoR)) && v.podeTransportar(totalCarga) && !v.getEstado() )
                        return (v.clone());
                }
                break;
            }
            case TOXICA:
            {
                for(Veiculo v : veiculos)
                {
                    if( ((v instanceof Camiao) || (v instanceof FurgaoNR)) && v.podeTransportar(totalCarga) && !v.getEstado() )
                        return (v.clone());
                }
                break;
            }
        }
        return null;
        
    }
    
    Veiculo escolheVeiculo(Servico s)
    {
        Veiculo v;
        
        double totalCarga = s.totalCarga();
        CategCarga c = s.getCategCarga();
        
        v = existeVeiculo(c, totalCarga);
        if (v!= null)
        {
            v.incOcupado(totalCarga);
            v.incTotal(totalCarga);
        
            if(v.podeSair()) 
                v.setEstado(true);
           
                s.setVeiculo(v);
        
                addVeiculo(v);
        
                addServico(s);
        
                return v;
        }
        
        else return null;
    }
    
}
