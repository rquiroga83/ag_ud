package splp;


public class ASTPowNode extends SimpleNode {
  ASTPowNode(int id) {
    super(id);
  }


  public void interpret()
  {
     jjtGetChild(0).interpret();
     jjtGetChild(1).interpret();

     stack[--top] = new Double( Math.pow( ((Double)stack[top]).doubleValue() , 
                                        ((Double)stack[top + 1]).doubleValue()  ));
  }
}
