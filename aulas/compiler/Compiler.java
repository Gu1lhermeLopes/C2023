import org.stringtemplate.v4.*;
import 

@SuppressWarnings("CheckReturnValue")
public class Compiler extends FractionBaseVisitor<String> {
   STGroup group= new STGroupFile("templates.stg");
   Map<Sting,Bool> vars = new HashMap<String,Bool>();

   @Override public String visitProgram(FractionParser.ProgramContext ctx) {
      ST st;
      String res;
      st = group.getInstanceOf("begin");
      res=st.render();
      visitChildren(ctx);

      st = group.getInstanceOf("end");
      res+=st.render();

      //return res;
   }

   @Override public String visitInstrutions(FractionParser.InstrutionsContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitPrint(FractionParser.PrintContext ctx) {
      String e= visit(ctx.expr());
      ST st = group.getInstanceOf("print");

      st.add("e",e);
      return st.render();
      //return res;
   }

   @Override public String visitAssignment(FractionParser.AssignmentContext ctx) {
      String name =ctx.ID().getText();
      Bool exits = vars.get(name);
      String res="";
      String e;
      e= visit(ctx.expr());
      ST st;
      if(exits == null){
         st = group.getInstanceOf("var_d");
         st.add("name",name);
         res+=st.render();
         vars.put(name,true);
      }else{

      }
      
      //return res;
   }

   @Override public String visitUnaryExpr(FractionParser.UnaryExprContext ctx) {
      String e1 = visit(ctx.expr());
      ST st;
      if  (ctx.op().getText().equals("*")){
         st = group.getInstanceOf("unary");
         st.add("e1",e1);
         return st.render();
      }
      return e1;
   }

   @Override public String visitAddExpr(FractionParser.AddExprContext ctx) {
      String e1 = visit(ctx.expr(0));
      String e2 = visit(ctx.expr(1));
      ST st;
      if (ctx.op().getText().equals("+"))
         st = group.getInstanceOf("sum");
      else
      st = group.getInstanceOf("sub");
      
      st.add("e1",e1);
      st.add("e2",e2);
      return st.render();
      //return res;
   }

   @Override public String visitLiteralExpr(FractionParser.LiteralExprContext ctx) {
      String literals[] = ctx.LITERAL().getText().split("/");
      ST st = group.getInstanceOf("literal");
      st.add("n",literals[0]);
      if(literals.length ==1){
         st.add("d",literals[1]);
      }
      return visit(ctx.expr());
      //return res;
   }

   @Override public String visitReduceExpr(FractionParser.ReduceExprContext ctx) {
      String e1 = visit(ctx.expr());
      ST st = group.getInstanceOf("reduce");
      st.add("e1",e1);
      return st.render();
   }

   @Override public String visitMulExpr(FractionParser.MulExprContext ctx) {
      String e1 = visit(ctx.expr(0));
      String e2 = visit(ctx.expr(1));

      if (ctx.op().getText().equals("*"))
         st = group.getInstanceOf("mul");
      else
      st = group.getInstanceOf("div");
      
      st.add("e1",e1);
      st.add("e2",e2);
      return st.render();
      //return res;
   }

   @Override public String visitPowExpr(FractionParser.PowExprContext ctx) {
      String b = visit(ctx.expr(0));
      String e = visit(ctx.expr(1));
      ST st = group.getInstanceOf("power");
      st.add("b",b);
      st.add("ee",e);
      return st.render();
      //return res;
   }

   @Override public String visitParentExpr(FractionParser.ParentExprContext ctx) {
      return visit(ctx.expr());
      //return res;
   }

   @Override public String visitIdExpr(FractionParser.IdExprContext ctx) {
      ST st = group.getInstanceOf("var_name");
      
      st.add(ctx.ID().getText());
      return st.render();
      //return res;
   }
}
