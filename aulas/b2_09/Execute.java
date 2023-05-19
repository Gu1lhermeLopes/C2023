import java.util.HashMap;
import java.util.Map;
@SuppressWarnings("CheckReturnValue")
public class Execute extends FractionBaseVisitor<Frac> {
/* 
   @Override public Frac visitProgram(FractionParser.ProgramContext ctx) {
      Frac res = null;
      return visitChildren(ctx);
      //return res;
   }*/
/* 
   @Override public Frac visitInstrutions(FractionParser.InstrutionsContext ctx) {
      Frac res = null;
      return visitChildren(ctx);
      //return res;
   }*/

   static Map<String,Frac> var = new HashMap<String,Frac>();

   @Override public Frac visitPrint(FractionParser.PrintContext ctx) {
      Frac value = visit( ctx.expr() );
      if(value.denominador==1)
         System.out.print(value.numerador);
      else
         System.out.print(value.numerador+"/"+ value.denominador);
      //return res;
   }

   @Override public Frac visitAssignment(FractionParser.AssignmentContext ctx) {
      Frac value = visit( ctx.expr() );
      var.put(ctx.ID().getText(),value);
      //return res;
   }

   @Override public Frac visitUnaryExpr(FractionParser.UnaryExprContext ctx) {
      Frac value = visit( ctx.expr() );
      return value.minus();
      //return res;
   }

   @Override public Frac visitAddExpr(FractionParser.AddExprContext ctx) {
      Frac a = visit(ctx.expr(0));
      Frac b = visit(ctx.expr(1));
      if(ctx.op().getText().equals("+"))
         return a.sum(b);
      return a.sub(b);
   }

   @Override public Frac visitLiteralExpr(FractionParser.LiteralExprContext ctx) {
      String[] numbers =ctx.LITERAL().getText().split("/");
      Integer n=Integer.parseInt( numbers[0]);
      Integer d=Integer.parseInt( numbers[1]);

      if(d==null)
         return new Frac(n,1);

      return new Frac(n,d);
      //return res;
   }

   @Override public Frac visitReduceExpr(FractionParser.ReduceExprContext ctx) {
      Frac value = visit( ctx.expr() );
      return value.reduce();
      //return res;
   }

   @Override public Frac visitMulExpr(FractionParser.MulExprContext ctx) {
      Frac a = visit(ctx.expr(0));
      Frac b = visit(ctx.expr(1));
      if(ctx.op().getText().equals("*"))
         return a.mul(b);
      return a.div(b);

   }

   @Override public Frac visitPowExpr(FractionParser.PowExprContext ctx) {
      Frac exp= visit(ctx.expr(1));
      Frac base;
      exp.reduce();
      if(exp.denominador != 1){
         System.exit(1);
      }
      base = visit(ctx.expr(0));
      return base.power(exp);
   }

   @Override public Frac visitParentExpr(FractionParser.ParentExprContext ctx) {
     return visit( ctx.expr() );
      //return res;
   }

   @Override public Frac visitIdExpr(FractionParser.IdExprContext ctx) {
      String varname=ctx.ID().getText();
      Frac value = var.get(varname);
      if(value==null)
         System.exit(1);
      else
         return value;
      //return res;
   }
}
