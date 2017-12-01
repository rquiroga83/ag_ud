package splp;

public class ASTNENode extends SimpleNode {
  ASTNENode(int id) {
    super(id);
  }


  public void interpret()
  {
     jjtGetChild(0).interpret();
     jjtGetChild(1).interpret();

     if (stack[top] instanceof Boolean)
        stack[--top] = new Boolean(((Boolean)stack[top]).booleanValue() !=
                                ((Boolean)stack[top + 1]).booleanValue());
     else
        stack[--top] = new Boolean(((Double)stack[top]).doubleValue() !=
                                ((Double)stack[top + 1]).doubleValue());
  }

}
