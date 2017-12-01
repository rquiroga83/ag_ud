package app;
import app.*;
import org.jgap.*;
import org.jgap.impl.*;
import splp.SPL;
/**
 *Funcion que da puntaje a cada cromosoma evaluado aqui es donde se inicia la interpretacion del texto
 *a parcear.
 **/
public class FitFunction 
		extends FitnessFunction{
    
	
	// Metodo eval abstracto derivado de la clase padre
	// para evaluar cromosoma a cromosoma
	// en este caso los cromosomas son binarios
	public double evaluate(IChromosome individuo)	{
		double Value = 0;
               
               GA.Current_Chrom = individuo; 
                
               CompositeGene Comp = (CompositeGene)individuo.getGene(0);
               //IntegerGene color = (IntegerGene)comp.geneAt(0);
               //Integer GenValue  = (Integer) color.getAllele();
                SPL spl = new SPL();   
                
                spl.putStack( (double)individuo.size() );   // entra con dos argumentos
                spl.putStack( (double)Comp.size() );
                
                spl.interpret();
                Value = spl.getStack().doubleValue();
                        
		return Value + 1000;
	}
}
