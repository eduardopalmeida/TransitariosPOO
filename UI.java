import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class UI
{    
    public static void menuServicos(Empresa e)
    {
           int mServicos = 200;
           while ( mServicos != 0)
           {
               out.println("\f");
               out.println("Serviços \n");
               out.println("1 - Simples ");
               out.println("2 - Aeroporto ");
               out.println("3 - Querido Mudei A Casa ");
               out.println("4 - Distribuição ");
               out.println("5 - Secret ");
               out.println("0 - Voltar \n");
               mServicos = Input.lerInt();
               
               switch (mServicos)
               {
                   case 1: 
                   {
                       int cont = Input.askInt("Insira o número de contribuinte do cliente: ");
                       if(!e.existeCliente(cont))
                       { 
                            out.println("Não existe o cliente \n");
                            Input.primaEnter();
                            break;
                       }
                       else
                       {
                            Cliente c = e.getCliente(cont);
                            Simples s = new Simples();

                            ArrayList<Carga> cargas = s.getCarga();
                            Carga cg = new Carga();
                            
                            for(int i=0; i<s.getMaxCarga(); i++)
                            {
                                double p = Input.askDouble("Introduza o peso da " + (i+1) + " carga " + (s.getCategCarga()));
                                cg.setPeso(p);
                                cg.setCategCarga(s.getCategCarga());
                                cargas.add(i,cg);
                            }                            
                            
                            s.setCarga(cargas);
                       
                            if(e.escolheVeiculo(s) != null)
                            {
                            
                                double valor = s.calcularPreco(); 
                       
                                c.incValorContratado(valor);
                                c.addServico(s);
                                e.addCliente(c);
                                out.println("O preço do serviço escolhido é:" + valor +"\n");
                                Input.primaEnter();
                            }
                            
                            else 
                            {
                                out.println("Não existe veículo disponível para a sua carga\n ");
                                Input.primaEnter();
                            }
                       }
                       
                       break;
                   }
                   
                   case 2:
                   {
                       int cont = Input.askInt("Insira o número de contribuinte do cliente: ");
                       if(!e.existeCliente(cont))
                       { 
                            out.println("Não existe o cliente \n");
                            Input.primaEnter();
                       }
                       else
                       {
                            Cliente c = e.getCliente(cont);                       
                       
                            Aeroporto a = new Aeroporto();

                            ArrayList<Carga> cargas = a.getCarga();
                            Carga cg = new Carga();
                            
                            for(int i=0; i<a.getMaxCarga(); i++)
                            {
                                double p = Input.askDouble("Introduza o peso da " + (i+1) + " carga " + (a.getCategCarga()));
                                cg.setPeso(p);
                                cg.setCategCarga(a.getCategCarga());
                                cargas.add(i,cg);
                            }                            
                                                      
                            
                            a.setCarga(cargas);
                            
                            if(e.escolheVeiculo(a) != null)
                            {
                            
                                double valor = a.calcularPreco(); 
                       
                                c.incValorContratado(valor);
                                c.addServico(a);
                                e.addCliente(c);
                                out.println("O preço do serviço escolhido é:" + valor +"\n");
                                Input.primaEnter();
                            }
                            
                            else 
                            {
                                out.println("Não existe veículo disponível para a sua carga\n ");
                                Input.primaEnter();
                            }
                       }
                       break;
                   }    
    
                   case 3:
                   {
                       int cont = Input.askInt("Insira o número de contribuinte do cliente: ");
                       if(!e.existeCliente(cont))
                       { 
                            out.println("Não existe o cliente \n");
                            Input.primaEnter();
                       }
                       
                       else
                       {
                
                            Cliente c = e.getCliente(cont);
                       
                            QueridoMudeiACasa q = new QueridoMudeiACasa();

                            ArrayList<Carga> cargas = q.getCarga();
                            Carga cg = new Carga();
                            
                            for(int i=0; i<q.getMaxCarga(); i++)
                            {
                                double p = Input.askDouble("Introduza o peso da " + (i+1) + " carga " + (q.getCategCarga()));
                                cg.setPeso(p);
                                cg.setCategCarga(q.getCategCarga());
                                cargas.add(i,cg);
                            }                            
                            
                            q.setCarga(cargas);
                            
                            if(e.escolheVeiculo(q) != null)
                            {
                            
                                double valor = q.calcularPreco(); 
                       
                                c.incValorContratado(valor);
                                c.addServico(q);
                                e.addCliente(c);
                                out.println("O preço do serviço escolhido é:" + valor +"\n");
                                Input.primaEnter();
                            }
                            
                            else 
                            {
                                out.println("Não existe veículo disponível para a sua carga\n ");
                                Input.primaEnter();
                            }
                       }
                       break;
                   }
                       
                   case 4:
                   {
                       int cont = Input.askInt("Insira o número de contribuinte do cliente: ");
                       if(!e.existeCliente(cont))
                       { 
                            out.println("Não existe o cliente \n");
                            Input.primaEnter();
                       }
                       
                       else
                       {
                            Cliente c = e.getCliente(cont);                       
                       
                            Distribuicao d = new Distribuicao();

                            ArrayList<Carga> cargas = d.getCarga();
                            Carga cg = new Carga();
                                                    
                            double numcargas = Input.askDouble("Introduza o número de cargas desejadas ");
                            if(numcargas <= d.getMaxCarga())
                            {
                                for(int i=0; i<numcargas; i++)
                                {
                                    double p = Input.askDouble("Introduza o peso da " + (i+1) + " carga " + (d.getCategCarga()));
                                    cg.setPeso(p);
                                    cg.setCategCarga(d.getCategCarga());
                                    cargas.add(i,cg);
                                }
                            }
                            else
                            {
                                out.println("Excedeu o número de cargas do serviço ");
                                Input.primaEnter();
                                break;
                            }
                                                    
                            
                            d.setCarga(cargas);
                            
                            if(e.escolheVeiculo(d) != null)
                            {
                            
                                double valor = d.calcularPreco(); 
                       
                                c.incValorContratado(valor);
                                c.addServico(d);
                                e.addCliente(c);
                                out.println("O preço do serviço escolhido é:" + valor +"\n");
                                Input.primaEnter();
                            }
                            
                            else 
                            {
                                out.println("Não existe veículo disponível para a sua carga\n ");
                                Input.primaEnter();
                            }
                       }
                       break;
                   }
                  
                   case 5:
                   {
                       int cont = Input.askInt("Insira o número de contribuinte do cliente: ");
                       if(!e.existeCliente(cont))
                       { 
                            out.println("Não existe o cliente \n");
                            Input.primaEnter();
                       }
                       
                       else
                       {
                            Cliente c = e.getCliente(cont);                       
                       
                            Secret s = new Secret();

                            ArrayList<Carga> cargas = s.getCarga();
                            Carga cg = new Carga();
                            
                            for(int i=0; i<s.getMaxCarga(); i++)
                            {
                                double p = Input.askDouble("Introduza o peso da " + (i+1) + " carga " + (s.getCategCarga()));
                                cg.setPeso(p);
                                cg.setCategCarga(s.getCategCarga());
                                cargas.add(i,cg);
                            }                            
                                                    
                            s.setCarga(cargas);
                            
                            if(e.escolheVeiculo(s) != null)
                            {
                            
                                double valor = s.calcularPreco(); 
                       
                                c.incValorContratado(valor);
                                c.addServico(s);
                                e.addCliente(c);
                                out.println("O preço do serviço escolhido é:" + valor +"\n");
                                Input.primaEnter();
                            }
                            
                            else 
                            {
                                out.println("Não existe veículo disponível para a sua carga\n ");
                                Input.primaEnter();
                            }
                       }
                       break;
                   }
                   
                   case 0: { break; }
                   
                   default: { out.println("Insira uma opção válida\n"); break; } 
               }
           }
    }
                   
    public static void menuListagem(Empresa e)
    {
           int mListagem = 200;
           while ( mListagem != 0)
           {
               out.println("\f");
               out.println("1 - Listar veículos");
               out.println("2 - Listar veículos pendentes");
               out.println("3 - Listar clientes");
               out.println("4 - Listar serviços");
               out.println("0 - Voltar\n");
               mListagem = Input.lerInt();
               
               switch (mListagem)
               {
                   case 1:  { out.println(e.listaVeiculos()); Input.primaEnter(); break;           }
                   case 2:  { out.println(e.listaVeiculosPendentes()); Input.primaEnter();break;   }
                   case 3:  { out.println(e.listaClientes()); Input.primaEnter(); break;           }
                   case 4:  { out.println(e.listaServicos()); Input.primaEnter(); break;           }
                   case 0:  { break;                                           }
                   default: { out.println("Insira uma opção válida"); break;   }
               }
           }
    }
    
    public static void menuCliente(Empresa e)
    {
           int mClientes = 200;
           while ( mClientes != 0) 
           {
               out.println("\f");
               out.println("\nGestão Clientes\n");
               out.println("1 - Adicionar Cliente");
               out.println("2 - Ficha Cliente");
               out.println("3 - Lista Serviços Cliente");
               out.println("0 - Voltar\n");
               mClientes = Input.lerInt();
                    
               switch (mClientes) 
               {
                   case 1: 
                   {     
                       String nome = Input.askString("Insira o nome do cliente: ");
                       String morada = Input.askString("Insira a morada do cliente: ");
                       int cont = Input.askInt("Insira o número de contribuinte do cliente: ");
                                    
                       out.println("Tipo de cliente:");
                       out.println("1 - Individual ");
                       out.println("2 - Empresa \n");
                                
                       int opc = 0;
                       while (opc !=1 && opc !=2) 
                       {
                            opc = Input.askInt("Opção: ");
                       }
                                  
                       TipoCliente tc;
                       if (opc == 1) 
                            tc = TipoCliente.INDIVIDUAL;
                       else 
                            tc = TipoCliente.EMPRESARIAL;
                                
                       Cliente cliente = new Cliente (nome,tc,morada,cont,0.0);
                       e.addCliente(cliente);
                                
                       out.println("Cliente inserido com sucesso ");
                       Input.primaEnter();
                       break;
                   }
                            
                   case 2:
                   { 
                        int cont = Input.askInt("Insira o número de contribuinte do cliente: ");
                        
                        if(!e.existeCliente(cont))
                        { 
                            out.println("Não existe o cliente \n");
                            Input.primaEnter();
                        }
                        
                        else
                        {
                            out.println(e.fichaCliente(cont));
                            Input.primaEnter();
                        }
                        
                        break;
                   }
                                
                   case 3:  
                   {
                        int cont = Input.askInt("Insira o número de contribuinte do cliente: ");
                                
                        if(!e.existeCliente(cont))
                        { 
                            out.println("Não existe o cliente \n");
                            Input.primaEnter();
                        }
                        else
                        {
                            Cliente c = e.getCliente(cont);
                            out.println(c.listaServicos());
                            Input.primaEnter();
                        }
                        
                        break;
                   }
                   
                   case 4:  {break; }
                            
                   default: { out.println("Insira uma opção válida"); break; }
               }
           }
       }
       
    public static void menuVeiculo(Empresa e)
    {
        int mVeiculos = 200;
        while ( mVeiculos != 0) 
       {
           out.println("\f");
           out.println("\nGestão Veículos\n");
           out.println("1 - Adicionar Veículo");
           out.println("2 - Remover Veículo");
           out.println("3 - Registar regresso de Veículo");
           out.println("4 - Ordenar saída de Veículo");
           out.println("5 - Alterar preço base de Veículo");
           out.println("6 - Alterar cálculo de preço de um Veículo");
           out.println("0 - Voltar\n");
           mVeiculos = Input.lerInt();
                
           switch (mVeiculos) 
           {
               case 1: 
               {     
                   String marca = Input.askString("Insira a marca do veículo: ");
                   String matricula = Input.askString("Insira a matrícula do veículo: ");
                   double custokm = Input.askDouble("Insira o custo por km do veículo: ");
                   double capacidade = Input.askDouble("Insira a capacidade do veículo: ");
                   Combustivel comb = null;
                                
                   out.println("Tipo de veículo:");
                   out.println("1 - Furgão Refrigerado ");
                   out.println("2 - Furgão Não Refrigerado ");
                   out.println("3 - Camião ");
                   out.println("4 - Van \n");
                            
                   int opc = 0;
                   while (opc <1 || opc>4) 
                   {
                        opc = Input.askInt("Opção: ");
                   }
                              
                   switch(opc)
                   {
                       case 1: 
                       {
                           double autonomia = Input.askDouble("Insira a autonomia do veículo: ");
                           out.println("Tipo de combústivel :");
                           out.println("1 - Gasolina ");
                           out.println("2 - Gasóleo ");
                           out.println("3 - GPL ");
                           
                           opc = 0;
                           while (opc <1 || opc>3) 
                           {
                               opc = Input.askInt("Opção: ");
                           }
                           
                           switch (opc)
                           {
                               
                               case 1:  { comb = Combustivel.GASOLINA; break;            }
                               case 2:  { comb = Combustivel.GASOLEO; break;             }
                               case 3:  { comb = Combustivel.GPL; break;                 }
                               default: { out.println("Insira uma opção válida"); break; }
                           }
                           
                           FurgaoR fr = new FurgaoR(marca,matricula,custokm,capacidade,0.0,false,0.0,comb,autonomia);
                           e.addVeiculo(fr);
                           out.println("Veículo inserido com sucesso ");
                           Input.primaEnter();
                       }
                        
                       case 2:  
                       {
                           double autonomia = Input.askDouble("Insira a autonomia do veículo: ");
                           out.println("Tipo de combústivel :");
                           out.println("1 - Gasolina ");
                           out.println("2 - Gasóleo ");
                           out.println("3 - GPL ");
                           
                           opc = 0;
                           while (opc <1 || opc>3) 
                           {
                               opc = Input.askInt("Opção: ");
                           }
                           
                           switch (opc)
                           {
                               
                               case 1:  { comb = Combustivel.GASOLINA; break;            }
                               case 2:  { comb = Combustivel.GASOLEO; break;             }
                               case 3:  { comb = Combustivel.GPL; break;                 }
                               default: { out.println("Insira uma opção válida"); break; }
                           }
                           
                           FurgaoNR nfr = new FurgaoNR(marca,matricula,custokm,capacidade,0.0,false,0.0,comb,autonomia);
                           e.addVeiculo(nfr);
                           out.println("Veículo inserido com sucesso ");
                           Input.primaEnter();
                       }
                       case 3:  
                       {
                           String condutor = Input.askString("Insira o nome do condutor: ");
                           out.println("Atrelado: ");
                           out.println("1 - Sim ");
                           out.println("2 - Não \n");
                    
                           opc = 0;
                           while (opc !=1 && opc !=2) 
                           {
                               opc = Input.askInt("Opção: ");
                           }
                           boolean atrelado;
                           if (opc == 1)
                                atrelado = true;
                           else
                                atrelado = false;
                    
                           double altura = Input.askDouble("Insira a altura do camião: ");
                           double precoBase = Input.askDouble("Insira o preço base do camião: ");
                           Camiao c = new Camiao(marca,matricula,custokm,capacidade,0.0,false,0.0,condutor,atrelado,altura,precoBase);
                           out.println("Veículo inserido com sucesso ");
                           Input.primaEnter();
                       }
                      
                       case 4:  
                       { 
                           Van v = new Van(marca,matricula,custokm,capacidade,0.0,false,0.0); e.addVeiculo(v);                            
                           out.println("Veículo inserido com sucesso ");
                           Input.primaEnter(); 
                       }
                           
                       default: { out.println("Insira uma opção válida"); break; }
                   }
                   break;
               }
               
               case 2 : 
               { 
                   out.println(e.listaVeiculosShort());
                   String matricula = Input.askString("Insira a matrícula do veículo que deseja remover ");
                   if(e.getVeiculo(matricula) != null)
                   {
                       e.remVeiculo(matricula);
                       out.println("Veículo removido com sucesso \n");
                       Input.primaEnter();
                   }
                   else
                   {
                       out.println("Não existe veículo com a matrícula dada \n");
                       Input.primaEnter();
                   }
                   break;
               }
               
               case 3 :
               {
                   
                   String matricula = Input.askString("Insira a matrícula do veículo que deseja que regresse ");
                   if(e.getVeiculo(matricula) != null)
                   {
                       if(e.getVeiculo(matricula).getEstado())
                       {
                           e.retornaVeiculo(matricula);
                           out.println("Veículo regressou do serviço com sucesso \n");
                           Input.primaEnter();
                       }
                       else
                       {
                           out.println("Não existe nenhum veículo em serviço \n");
                           Input.primaEnter();
                       }
                   }
                   else
                   {
                       out.println("Não existe veículo com a matrícula dada \n");
                       Input.primaEnter();
                   }
                   break;
               }
               
               case 4:
               {
                   out.println(e.listaVeiculosShort());       
                   String matricula = Input.askString("Insira a matrícula do veículo que deseja enviar em serviço ");
                   if(e.getVeiculo(matricula) != null)
                   {
                       if(!e.getVeiculo(matricula).getEstado() && e.getVeiculo(matricula).getOcupado() > 0)
                       {
                           e.enviaVeiculo(matricula);
                           out.println("Veículo enviado em serviço com sucesso \n");
                           Input.primaEnter();
                       }
                       else
                       {
                           out.println("Não existe nenhum veículo na frota com carga \n");
                           Input.primaEnter();
                       }                       
                   }
                   else
                   {
                       out.println("Não existe veículo com a matrícula dada \n");
                       Input.primaEnter();
                   }
                   break;
               }
               
               case 5:
               {
                   String matricula = Input.askString("Insira a matrícula do veículo que deseja alterar o preço base ");
                   if(e.getVeiculo(matricula) != null)
                   {
                        double preco = Input.askDouble("Insira o novo preço base ");
                        Veiculo v = e.getVeiculo(matricula);
                        v.mudaPrecoBase(preco);
                        out.println("Preço alterado com sucesso \n");
                        Input.primaEnter();
                   }
                   
                   else 
                   { 
                       out.println("Não existe veículo com a matrícula dada \n");
                       Input.primaEnter();
                   }
                   break;
               }
               case 6:
               {
                   out.println("Tipo de veículo:");
                   out.println("1 - Furgão Refrigerado ");
                   out.println("2 - Furgão Não Refrigerado ");
                   out.println("3 - Camião ");
                   out.println("4 - Van \n");
                            
                   int opc = 0;
                   while (opc <1 || opc>4) 
                   {
                        opc = Input.askInt("Opção: ");
                   }
                   
                   switch(opc)
                   {
                       case 1:
                       {
                           FurgaoR fr = new FurgaoR();
                           double xc = Input.askDouble("Insira o novo coeficiente x ");
                           fr.mudaXCoeficiente(xc);
                           out.println("Coeficiente alterado com sucesso");
                           Input.primaEnter();
                           break;
                       }
                       case 2:
                       {
                           FurgaoNR fn = new FurgaoNR();
                           double xc = Input.askDouble("Insira o novo coeficiente x ");
                           fn.mudaXCoeficiente(xc);
                           out.println("Coeficiente alterado com sucesso");
                           Input.primaEnter();
                           break;
                       }
                       case 3:
                       {
                           Camiao c = new Camiao();
                           double xc = Input.askDouble("Insira o novo coeficiente x ");
                           c.mudaXCoeficiente(xc);
                           double yc = Input.askDouble("Insira o novo coeficiente y ");
                           c.mudaYCoeficiente(yc);
                           out.println("Coeficientes alterados com sucesso");
                           Input.primaEnter();
                           break;
                       }
                       case 4:
                       {
                           out.println("A Van não possui fórmula de cálculo");
                           Input.primaEnter();
                           break;
                       }    
                       default: { break;}
                    }
                   break;
               } 
               case 0 : { break; }
           }  
       }
    }
   
    public static void main(String args[])
    {
        // Empresa
        Empresa emp = new Empresa(); 
      
       int rep = Integer.MAX_VALUE;
       
       while (rep != 0) 
       {
            out.println("\f");
            out.println("Transitários POO\n");
            out.println("1 - Gestão Clientes");
            out.println("2 - Gestão Veiculos");
            out.println("3 - Novo Serviço");
            out.println("4 - Listagem");
            out.println("\n");
            out.println("5 - Carregar de ficheiro...");
            out.println("6 - Guardar num ficheiro...");
            out.println("\n");
            out.println("0 - Sair\n");
            rep = Input.lerInt();
       
            switch (rep) 
            {
                case 1: { menuCliente(emp); break;         }
                case 2: { menuVeiculo(emp); break;         }
                case 3: { menuServicos(emp); break;        }
                case 4: { menuListagem(emp); break;        }
                case 5: {
                           try {
                                out.println("\f");
                                out.println("\nCarregar Ficheiro\n");
                                
                                String ficheiro = Input.askString("Insira o nome do ficheiro: ");
                                
                                ObjectInputStream ois = new ObjectInputStream( new FileInputStream(ficheiro) );
                                emp = (Empresa) ois.readObject();
                           }
                           catch(IOException e)            { out.println(e.getMessage()); }
                           catch(ClassNotFoundException e) { out.println(e.getMessage()); }
        
                           Input.primaEnter();
                    
                           break;
                        }
                case 6: { 
                            try {
                                    out.println("\f");
                                    out.println("\nGuardar Ficheiro\n");
                                    
                                    String ficheiro = Input.askString("Insira o nome do ficheiro: ");
                                    ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(ficheiro));
                                    oos.writeObject(emp);
                                    oos.flush(); oos.close(); 
                                }
                                catch(IOException e) { out.println(e.getMessage()); } 
                                
                                Input.primaEnter();
                            break;
                        }
                case 0: { break;                   }                
                default: { out.println("Insira uma opção válida"); break; }
            }
       }
    }
}