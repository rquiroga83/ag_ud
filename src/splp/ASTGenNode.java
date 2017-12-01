/* Generated By:JJTree: Do not edit this line. ASTGenNode.java */
package splp;
import app.*;
import org.jgap.*;
import org.jgap.impl.*;
import org.jgap.event.*;


public class ASTGenNode extends SimpleNode {
  public ASTGenNode(int id) {
    super(id);
  }

  public void interpret()
  {
     int gen,aleta;
     
     jjtGetChild(0).interpret();
     jjtGetChild(1).interpret();
     
     top--;
     gen = (int)(((Double)stack[top]).doubleValue());
     aleta = (int)(((Double)stack[top + 1]).doubleValue()); 
     
     
     CompositeGene Gen = (CompositeGene)GA.Current_Chrom.getGene(gen);
     IntegerGene Aleta = (IntegerGene)Gen.geneAt(aleta);
     Integer GenValue  = (Integer) Aleta.getAllele();
     
     stack[top] = new Double( (double)(GenValue.intValue()) );
  }

}