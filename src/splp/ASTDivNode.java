package splp;

public class ASTDivNode extends SimpleNode {
  ASTDivNode(int id) {
    super(id);
  }


  public void interpret()
  {
     jjtGetChild(0).interpret();
     jjtGetChild(1).interpret();

     stack[--top] = new Double(((Double)stack[top]).doubleValue() /
                                ((Double)stack[top + 1]).doubleValue());
  }

}
