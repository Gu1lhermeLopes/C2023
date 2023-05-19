// Generated from Fraction.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FractionParser}.
 */
public interface FractionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FractionParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FractionParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FractionParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FractionParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link FractionParser#instrutions}.
	 * @param ctx the parse tree
	 */
	void enterInstrutions(FractionParser.InstrutionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FractionParser#instrutions}.
	 * @param ctx the parse tree
	 */
	void exitInstrutions(FractionParser.InstrutionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FractionParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(FractionParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link FractionParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(FractionParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link FractionParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(FractionParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link FractionParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(FractionParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(FractionParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(FractionParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(FractionParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(FractionParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(FractionParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(FractionParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code reduceExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReduceExpr(FractionParser.ReduceExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code reduceExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReduceExpr(FractionParser.ReduceExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulExpr(FractionParser.MulExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulExpr(FractionParser.MulExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(FractionParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(FractionParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParentExpr(FractionParser.ParentExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParentExpr(FractionParser.ParentExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(FractionParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link FractionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(FractionParser.IdExprContext ctx);
}