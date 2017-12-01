package splp;

public class ASTCosNode extends SimpleNode {
  public ASTCosNode(int id) {
    super(id);
  }

  public void interpret()
  {
     String name;

     jjtGetChild(0).interpret();
     stack[top] = new Double(  Math.cos( ((Double)stack[top]).doubleValue() )  );
  }

}

