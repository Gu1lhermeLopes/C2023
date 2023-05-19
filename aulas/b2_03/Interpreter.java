@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Integer> {

   @Override public Integer visitProgram(CalculatorParser.ProgramContext ctx) {
      Integer res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
      if(ctx.expr() !=null){
         System.out.print(visit(ctx.expr()));
      }
      return null;
   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {

      Integer e1,e2;

      e1= visit(ctx.expr(0));
      e2= visit(ctx.expr(1));

      switch (ctx.op.getText()) {
         case "+": return e1 + e2;
         case "-": return e1 - e2;
      }
      return null;
   }

   //visitExprUnitary

   @Override public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit( ctx.expr() );
      //return res;
   }

   @Override public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      Integer res = null;
      return Integer.parseInt(ctx.INTEGER().getText());
      //return res;
   }

   @Override public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Integer e1,e2;

      e1= visit(ctx.expr(0));
      e2= visit(ctx.expr(1));

      switch (ctx.op.getText()) {
         case "*": return e1 * e2;
         case "/": return e1 / e2;
         case "%": return e1 % e2;
      }
      return null;
   }
}
