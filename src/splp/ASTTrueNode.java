package splp;

public class ASTTrueNode extends SimpleNode {
  ASTTrueNode(int id) {
    super(id);
  }


  public void interpret()
  {
     stack[++top] = new Boolean(true);
  }

}
