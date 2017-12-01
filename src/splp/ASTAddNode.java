package splp;

public class ASTAddNode extends SimpleNode {
  ASTAddNode(int id) {
    super(id);
  }


  public void interpret()
  {
     jjtGetChild(0).interpret();
     jjtGetChild(1).interpret();

     stack[--top] = new Double(((Double)stack[top]).doubleValue() +
                                ((Double)stack[top + 1]).doubleValue());
     
  }
}
