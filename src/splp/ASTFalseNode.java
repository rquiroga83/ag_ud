package splp;

public class ASTFalseNode extends SimpleNode {
  ASTFalseNode(int id) {
    super(id);
  }


  public void interpret()
  {
     stack[++top] = new Boolean(false);
  }

}
