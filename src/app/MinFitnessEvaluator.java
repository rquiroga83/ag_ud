/**
 *Funcion de avaluacion especial sirve para determinar si un que cromosoma es el mejo
 *en este caso el mejor es el de menor numero ...
 **/

package app;

import org.jgap.*;
import org.jgap.impl.*;
import org.jgap.event.*;
import java.util.*;



public class MinFitnessEvaluator
    implements FitnessEvaluator {
  /** String containing the CVS revision. Read out via reflection!*/
  private final static String CVS_REVISION = "$Revision: 1.10 $";


  
  public boolean isFitter(final double a_fitness_value1,
                          final double a_fitness_value2) {
    return a_fitness_value1 < a_fitness_value2;
  }

  public boolean isFitter(IChromosome a_chrom1, IChromosome a_chrom2) {
    return isFitter(a_chrom1.getFitnessValue(), a_chrom2.getFitnessValue());
  }
}
