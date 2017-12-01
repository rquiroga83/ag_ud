package splp;

public class ASTWriteStatement extends SimpleNode {
  String name;
  double rev;
  
  ASTWriteStatement(int id) {
    super(id);
  }


  public void interpret()
  {
     Object o;
     byte[] b = new byte[64];

     if ((o = symtab.get(name)) == null)
        System.err.println("Undefined variable : " + name);
        
     rev = ((Double)o).doubleValue();
     SPL.putStack ( ((Double)o).doubleValue() );
     
     //System.out.println("Value of " + name + " : " + symtab.get(name));
  }

}
