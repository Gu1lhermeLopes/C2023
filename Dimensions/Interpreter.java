import java.util.HashMap;
@SuppressWarnings("CheckReturnValue")
public class Interpreter extends DimensionsBaseVisitor<String> {

   /*@Override public String visitProgram(DimensionsParser.ProgramContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   } */
   HashMap<String,Double> prefixos;
   Interpreter(){
      prefixos= new HashMap<String,Double>();
   }
   

   @Override public String visitInstruction(DimensionsParser.InstructionContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitDimensionSi(DimensionsParser.DimensionSiContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitDimensionDependant(DimensionsParser.DimensionDependantContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitPrefix(DimensionsParser.PrefixContext ctx) {
      String name = ctx.ID.getText();
      String nota= visit(ctx.notacao());
      Double valor=10.0;
      String cienc=nota;
      if (nota == "10")
         prefixos.put(name, 10.0);
      else{
         cienc.replace("e", "");
         prefixos.put(name, Double.parseDouble(cienc));
      }
      return "name: "+name+": "+nota;
      //return res;
   }

   @Override public String visitUnit(DimensionsParser.UnitContext ctx) {
      String classe = ctx.classe.getText();
      String unit = ctx.ID(0).getText();
      String valor = ctx.REAL().getText();
      String newclasse = ctx.newclass.getText();
      if (  length(ctx.ID())==2 ) {
         String unit2 = ctx.ID(1).getText();
      }


      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitNotacaodez(DimensionsParser.NotacaodezContext ctx) {
      
      return "10";
      //return res;
   }

   @Override public String visitNotacaocienfitica(DimensionsParser.NotacaocienfiticaContext ctx) {
      String mul = ctx.INT().getText();
      
      return "e"+mul;
      //return res;
   }
}
