package splp;

public class ASTBitwiseComplNode extends SimpleNode {
  ASTBitwiseComplNode(int id) {
    super(id);
  }


  public void interpret()
  {
     jjtGetChild(0).interpret();

     stack[top] = new Double(~((Integer)stack[top]).intValue());
  }
}
