import java.util.HashMap;
@SuppressWarnings("CheckReturnValue")
public class Interpreter extends CalculatorBaseVisitor<Integer> {

   HashMap<String,Integer> variables;
   Interpreter(){
      variables= new HashMap<String,Integer>();
   }


   @Override public Integer visitStatExpr(CalculatorParser.StatExprContext ctx) {
      Integer e=visit(ctx.expr());
      if(e == null)
         return null;
      System.out.print(visit(ctx.expr()));
      return e;
   }

   @Override public Integer visitAssignment(CalculatorParser.AssignmentContext ctx) {
      
      Integer e=visit(ctx.expr());
      if(e == null)
         return null;
      variables.put(ctx.ID().getText() ,e);
      System.out.print(e);
      return e;
   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {

      Integer e1,e2;

      e1= visit(ctx.expr(0));
      e2= visit(ctx.expr(1));

      if(e1 == null || e2 == null)
         return null;

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

   @Override public Integer visitExprID(CalculatorParser.ExprIDContext ctx) {
      
      Integer e= variables.get(ctx.ID().getText());
      if(e == null){
         System.out.print("error");
      }
      return e;
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

      if(e1 == null || e2 == null)
         return null;

      switch (ctx.op.getText()) {
         case "*": return e1 * e2;
         case "/": return e1 / e2;
         case "%": return e1 % e2;
      }
      return null;
   }
}
