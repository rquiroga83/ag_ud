package splp;

public class ASTNumberConstNode extends SimpleNode {

  double val;

  ASTNumberConstNode(int id) {
    super(id);
  }


  public void interpret()
  {
     stack[++top] = new Double(val);
  }

}
