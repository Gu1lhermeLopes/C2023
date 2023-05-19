import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.HashMap;
@SuppressWarnings("CheckReturnValue")

public class NDict extends NumbersBaseListener {


   private HashMap<String,Integer> mappings;
   public NDict(){
      mappings=new HashMap<String,Integer>();
   }
   @Override public void enterMapping(NumbersParser.MappingContext ctx) {
      mappings.put(ctx.WORD().getText(), Integer.parseInt(ctx.NUMBER().getText()) );

   
   }

   public HashMap<String,Integer> map(){
      return mappings;
   }

}
