package splp;

import javax.swing.*;
import org.jgap.impl.*; 


public class SPL {
/**
 *Funcion que contiene los metodos para inicializar el parser que analiza el codigo escrito en la funcion 
 *fitness ...
 */
  protected static Object[] VarStack = new Object[64];
  public static int top = -1;  
  
  public static void putStack(double Val ) {
      
      VarStack[++top] = new Double(Val);
  }
  
  public static Double getStack( ) {
      
      Double Val;
      
      if(top >= 0 ) { 
          
          Val = new Double(((Double)VarStack[0]).doubleValue())  ;  // recupera el primer valor
          for(int i = 1;i<top + 1 ;i++ ){  // corre todos loa valores hacia abajo ....
              VarStack[ i - 1 ] = new Double(((Double)VarStack[i]).doubleValue()) ;
          }
          top--;
          return Val;
      }
      else  {
          return null;
      }
      
  }
  
  static SPLParser parser;
  static String File;  
  
  public SPL(){
      
  }
  
  public static void init(String file) {
        
        File = file;
        if (file.length() > 0) {
          JOptionPane.showMessageDialog(null,"Leyendo del archivo " + file + " . . .", "Atecion",JOptionPane.PLAIN_MESSAGE);
          try {
            //parser.ReInit(new java.io.FileInputStream(file));  
            parser = new SPLParser(new java.io.FileInputStream(file));
          } catch (java.io.FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo " + file + " no encontrado." , "Error",JOptionPane.ERROR_MESSAGE);
            return;
          }
        } else {
          JOptionPane.showMessageDialog(null, "Es necesario un fichero SPL" , "Error",JOptionPane.ERROR_MESSAGE);
          return;
        }
  }
  
    public static void reinit(String file) {
        File = file;
        if (file.length() > 0) {
          JOptionPane.showMessageDialog(null,"Leyendo del archivo " + file + " . . .", "Atencion",JOptionPane.PLAIN_MESSAGE);
          try {
            parser.ReInit(new java.io.FileInputStream(file));  
            //parser = new SPLParser(new java.io.FileInputStream(file));
          } catch (java.io.FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo " + file + " no encontrado." , "Error",JOptionPane.ERROR_MESSAGE);
            return;
          }
        } else {
          JOptionPane.showMessageDialog(null, "Es necesario un fichero SPL" , "Error",JOptionPane.ERROR_MESSAGE);
          return;
        }
  }
  
  
  public void interpret()   {
        try {
          parser.CompilationUnit();
          parser.jjtree.rootNode().interpret();


        } catch (ParseException e) {
          JOptionPane.showMessageDialog(null,"Se encontraron errores de sintaxis en funcion fittest", "Error",JOptionPane.ERROR_MESSAGE);
          JOptionPane.showMessageDialog(null, e.getMessage() , "Error",JOptionPane.ERROR_MESSAGE);
          parser.jjtree.rootNode().jjtClose();
          System.gc();
        } catch (Exception e1) {
          JOptionPane.showMessageDialog(null, "Errores encontrados durante la interpretacion. " +
                                              " \n * Revisar si el numero de alelos del gen corresponden..." +
                                              " \n * Revisar los nombres de las variables..." , "Error",JOptionPane.ERROR_MESSAGE);
          e1.printStackTrace();
          parser.jjtree.rootNode().jjtClose();
          System.gc();
          return;
        }

  }
  
}
