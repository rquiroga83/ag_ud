package splp;

public class ASTVarDeclaration extends SimpleNode
                               implements SPLParserConstants {

  int type;
  String name;

  ASTVarDeclaration(int id) {
    super(id);
  }


  public void interpret()
  {
     if (type == BOOL)
        symtab.put(name, new Boolean(false));
     else
        symtab.put(name, new Double(0));
  }
}
