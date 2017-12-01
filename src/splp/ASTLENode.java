package splp;

public class ASTLENode extends SimpleNode {
  ASTLENode(int id) {
    super(id);
  }


  public void interpret()
  {
     jjtGetChild(0).interpret();
     jjtGetChild(1).interpret();

     stack[--top] = new Boolean(((Double)stack[top]).doubleValue() <=
                                ((Double)stack[top + 1]).doubleValue());
  }

}
