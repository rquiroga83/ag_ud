/* Generated By:JJTree: Do not edit this line. ASTMaxNode.java */
package splp;
public class ASTMaxNode extends SimpleNode {
  public ASTMaxNode(int id) {
    super(id);
  }

  public void interpret()
  {
     jjtGetChild(0).interpret();
     jjtGetChild(1).interpret();

     stack[--top] = new Double( Math.max( ((Double)stack[top]).doubleValue() ,
                                 ((Double)stack[top + 1]).doubleValue() ) );
  }
}
