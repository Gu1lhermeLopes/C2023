@SuppressWarnings("CheckReturnValue")
public class Interpreter extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      if(ctx.expr() !=null){
         System.out.print(visit(ctx.expr()));
      }
      return null;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.getText());
      //return res;
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      Double res = null;
      Double e1,e2;

      e1= visit(ctx.expr(0));
      e2= visit(ctx.expr(1));

      switch (ctx.op.getText()) {
         case "*": return e1 * e2;
         case "/": return e1 / e2;
         case "+": return e1 + e2;
         case "-": return e1 - e2;
      }
      return null;
   }
}
