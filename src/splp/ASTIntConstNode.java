package splp;

public class ASTIntConstNode extends SimpleNode {

  int val;

  ASTIntConstNode(int id) {
    super(id);
  }


  public void interpret()
  {
     stack[++top] = new Integer(val);
  }

}
