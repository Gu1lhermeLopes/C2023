import org.antlr.v4.runtime.tree.TerminalNode;
@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<Object> {

   @Override public Object visitTop(HelloParser.TopContext ctx) {
      Object res = null;
      visitChildren(ctx);
      return res;
   }

   @Override public Object visitName(HelloParser.NameContext ctx) {
      String res = "";
      for(TerminalNode id:ctx.ID()){
         res+=id.getText()+" ";
      }
      return res;
   }

   @Override public Object visitGreetings(HelloParser.GreetingsContext ctx) {
      Object res = null;
      System.out.print("Ola "+ visitName(ctx.name()));
      return res;
   }

   @Override public Object visitBye(HelloParser.ByeContext ctx) {
      Object res = null;
      System.out.print("Adeus "+ visitName(ctx.name()));
      return res;
   }
}
