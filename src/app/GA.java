package app;
import org.jgap.*;
import org.jgap.impl.*;
import org.jgap.event.*;


/**
 * Clase de algoritmos geneticos aqui es donde se iniciliza y se configura el algoritmo dependiendo 
 * de los datos que entren en el contructor 
**/
public class GA {
	
    private static final int MAX_ALLOWED_EVOLUTIONS = 200;
    int numPopulation;
    public static IChromosome Current_Chrom;
    Genotype genotype = null;
    int mutRate,mutType,CrossType,CrossRate,NatSel,NatSize;	
    double NatProb;
    static Configuration gaConf;
    Gene[] sampleGenes;
    boolean maxim;
    
    GA(String Population ,String mutationRate,int mutationType, 
       int CrossOver,String CrossOverRate, int NaturalSel,String NaturalSize,
       String NaturalProb,Gene[] a_Genes,boolean isRandomInit,boolean Maxim) {
        
            numPopulation = Integer.parseInt(Population);        
            mutRate = Integer.parseInt(mutationRate);
            mutType = mutationType;
            CrossType = CrossOver;
            CrossRate = Integer.parseInt(CrossOverRate);
            NatSel = NaturalSel;
            NatSize =  Integer.parseInt(NaturalSize);
            NatProb = Double.parseDouble(NaturalProb);
            sampleGenes = a_Genes;
            maxim = Maxim;
            
	    try {
                        
                        createConfiguration();  // genera configuracion de GAconf

                        gaConf.setPreservFittestIndividual(true);
                        gaConf.setKeepPopulationSizeConstant(false);                
                         
                                          
                        IChromosome sampleChromosome = new Chromosome(gaConf, sampleGenes);        
                                
                        gaConf.setSampleChromosome(sampleChromosome);
                        gaConf.setPopulationSize(numPopulation);
                        gaConf.setFitnessFunction(new FitFunction());
                        
                        if(isRandomInit == true){
                            genotype = Genotype.randomInitialGenotype(gaConf);
                        }
                        else{
                            // Crea una porblacioninicial leatoria.
                            // ------------------------------------------------

                            // No se puede usar el metodo normal de mutacion
                            // y se necesitan miltiples llamadad para crear .
                            // -----------------------------------------------------
                            IChromosome[] chromosomes =
                                new IChromosome[gaConf.getPopulationSize()];
                            Gene[] samplegenes = sampleChromosome.getGenes();
                            for (int i = 0; i < chromosomes.length; i++) {
                                  Gene[] genes = new Gene[samplegenes.length];
                                  for (int k = 0; k < genes.length; k++) {
                                        genes[k] = samplegenes[k].newGene();
                                        genes[k].setAllele(samplegenes[k].getAllele());
                                  }
                                  shuffle(genes);
                                  chromosomes[i] = new Chromosome(gaConf, genes);
                            }
                            genotype = new Genotype(gaConf, new Population(gaConf, chromosomes));                            
                        }
                      
	    }
            catch (InvalidConfigurationException e) {
		      e.printStackTrace();
		      System.exit( -2);
            }	    
	    
    }

  
    
      public void createConfiguration()  {
          // Copiado de DefaultConfiguration.
          // -----------------------------------------
              try{  

                  
                  switch(NatSel)    {
                      case 0:
                          BestChromosomesSelector bestChromsSelector =
                              new BestChromosomesSelector(gaConf, NatProb);
                          gaConf.addNaturalSelector(bestChromsSelector, true);
                          break;
                      case 1:     
                          TournamentSelector TournamentChromsSelector =
                              new TournamentSelector(gaConf, NatSize, NatProb);  
                          gaConf.addNaturalSelector(TournamentChromsSelector, true);
                          break;
                      case 2:
                           WeightedRouletteSelector WeightedRouletteChromsSelector =
                              new WeightedRouletteSelector(gaConf );  
                          gaConf.addNaturalSelector(WeightedRouletteChromsSelector, true);                         
                          break;
                  }

                  gaConf.setRandomGenerator(new StockRandomGenerator());
                  gaConf.setMinimumPopSizePercent(0);
                  gaConf.setEventManager(new EventManager());
                  
                  if(maxim){
                    gaConf.setFitnessEvaluator(new DefaultFitnessEvaluator());
                  }
                  else{
                    gaConf.setFitnessEvaluator(new MinFitnessEvaluator());
                   } 
                  
                 gaConf.setChromosomePool(new ChromosomePool());
                  // --------------------
                  // tipos de crosover
                  switch(CrossType) {
                      case 0:
                          gaConf.addGeneticOperator(new CrossoverOperator(gaConf,CrossRate));
                          break;
                      case 1:    
                          gaConf.addGeneticOperator(new AveragingCrossoverOperator(gaConf));
                          break;
                      case 2:
                          gaConf.addGeneticOperator(new CrossOverGenGen(gaConf,CrossRate));
                          break;
                      case 3:
                          break;  
                  }
                  //-----------------------
                  // Operadores de mutacion
                  switch(mutType){
                      case 0:
                          gaConf.addGeneticOperator(new MutationOperator(gaConf, mutRate));
                          break;
                      case 1:  
                          SwappingMutationOperator swappingMutation = 
                                                    new SwappingMutationOperator(gaConf, mutRate);
                          swappingMutation.setStartOffset(0);       // setea desde donde debe comenzar la mutacion
                          gaConf.addGeneticOperator( swappingMutation );
                          break;
                      case 2:    
                          gaConf.addGeneticOperator(new TwoWayMutationOperator(gaConf, mutRate));
                          break;
                  } 
              }
              catch( Exception e ) {
                    e.printStackTrace();
              } 
              
         }
      
        protected void shuffle(final Gene[] a_genes) {
        Gene t;
        // shuffle:
        for (int r = 0; r < 10 * a_genes.length; r++) {
          for (int i = m_startOffset; i < a_genes.length; i++) {
            int p = m_startOffset
                + gaConf.getRandomGenerator().
                nextInt(a_genes.length - m_startOffset);
            t = a_genes[i];
            a_genes[i] = a_genes[p];
            a_genes[p] = t;
          }
        }
      }
        
      
      private int m_startOffset = 1;

      /**
       * Coloca el numero de genes que seran excluidos del cambio
       * por probabilodad no debe cambiarse le promero de la lista
       * el valor por defecto es 1
       *
       */
      public void setStartOffset(final int a_offset) {
        m_startOffset = a_offset;
      }  
}   
