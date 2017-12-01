package splp;


/* JJT: 0.2.2 */




public class ASTReadStatement extends SimpleNode {
  String name;

  ASTReadStatement(int id) {
    super(id);
  }


  public void interpret()
  {
     Object o;
     byte[] b = new byte[64];
     double i;

     if ((o = symtab.get(name)) == null)
        System.err.println("Undefined variable : " + name);

     else if (o instanceof Double)
     {
        try
        {
           symtab.put( name, new Double( SPL.getStack().doubleValue() ) );
        } catch(Exception e) {
           System.exit(1);
        }
     }
  }
}
