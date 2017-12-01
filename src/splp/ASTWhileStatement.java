package splp;

public class ASTWhileStatement extends SimpleNode {
  ASTWhileStatement(int id) {
    super(id);
  }


  public void interpret()
  {
     do {
       jjtGetChild(0).interpret();

       if (((Boolean)stack[top--]).booleanValue())
          jjtGetChild(1).interpret();
       else
          break;
    } while (true);
  }

}
