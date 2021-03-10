// Generated from .\lexrParsr\RecPyParser.g4 by ANTLR 4.9.1

	// import javax.swing.JOptionPane;
	package lexrParsr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RecPyParser}.
 */
public interface RecPyParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RecPyParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(RecPyParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(RecPyParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#defTailRecursive}.
	 * @param ctx the parse tree
	 */
	void enterDefTailRecursive(RecPyParser.DefTailRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#defTailRecursive}.
	 * @param ctx the parse tree
	 */
	void exitDefTailRecursive(RecPyParser.DefTailRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#defNonTailRecursive}.
	 * @param ctx the parse tree
	 */
	void enterDefNonTailRecursive(RecPyParser.DefNonTailRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#defNonTailRecursive}.
	 * @param ctx the parse tree
	 */
	void exitDefNonTailRecursive(RecPyParser.DefNonTailRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#defIterative}.
	 * @param ctx the parse tree
	 */
	void enterDefIterative(RecPyParser.DefIterativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#defIterative}.
	 * @param ctx the parse tree
	 */
	void exitDefIterative(RecPyParser.DefIterativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#def_blk}.
	 * @param ctx the parse tree
	 */
	void enterDef_blk(RecPyParser.Def_blkContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#def_blk}.
	 * @param ctx the parse tree
	 */
	void exitDef_blk(RecPyParser.Def_blkContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#start_while_blk}.
	 * @param ctx the parse tree
	 */
	void enterStart_while_blk(RecPyParser.Start_while_blkContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#start_while_blk}.
	 * @param ctx the parse tree
	 */
	void exitStart_while_blk(RecPyParser.Start_while_blkContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#end_while_blk}.
	 * @param ctx the parse tree
	 */
	void enterEnd_while_blk(RecPyParser.End_while_blkContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#end_while_blk}.
	 * @param ctx the parse tree
	 */
	void exitEnd_while_blk(RecPyParser.End_while_blkContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#if_expr}.
	 * @param ctx the parse tree
	 */
	void enterIf_expr(RecPyParser.If_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#if_expr}.
	 * @param ctx the parse tree
	 */
	void exitIf_expr(RecPyParser.If_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#else_}.
	 * @param ctx the parse tree
	 */
	void enterElse_(RecPyParser.Else_Context ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#else_}.
	 * @param ctx the parse tree
	 */
	void exitElse_(RecPyParser.Else_Context ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#return_expr}.
	 * @param ctx the parse tree
	 */
	void enterReturn_expr(RecPyParser.Return_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#return_expr}.
	 * @param ctx the parse tree
	 */
	void exitReturn_expr(RecPyParser.Return_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#return_tr}.
	 * @param ctx the parse tree
	 */
	void enterReturn_tr(RecPyParser.Return_trContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#return_tr}.
	 * @param ctx the parse tree
	 */
	void exitReturn_tr(RecPyParser.Return_trContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#return_ntr}.
	 * @param ctx the parse tree
	 */
	void enterReturn_ntr(RecPyParser.Return_ntrContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#return_ntr}.
	 * @param ctx the parse tree
	 */
	void exitReturn_ntr(RecPyParser.Return_ntrContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(RecPyParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(RecPyParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(RecPyParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(RecPyParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#attribution}.
	 * @param ctx the parse tree
	 */
	void enterAttribution(RecPyParser.AttributionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#attribution}.
	 * @param ctx the parse tree
	 */
	void exitAttribution(RecPyParser.AttributionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#simpl_blk}.
	 * @param ctx the parse tree
	 */
	void enterSimpl_blk(RecPyParser.Simpl_blkContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#simpl_blk}.
	 * @param ctx the parse tree
	 */
	void exitSimpl_blk(RecPyParser.Simpl_blkContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#empty_line}.
	 * @param ctx the parse tree
	 */
	void enterEmpty_line(RecPyParser.Empty_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#empty_line}.
	 * @param ctx the parse tree
	 */
	void exitEmpty_line(RecPyParser.Empty_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link RecPyParser#interm}.
	 * @param ctx the parse tree
	 */
	void enterInterm(RecPyParser.IntermContext ctx);
	/**
	 * Exit a parse tree produced by {@link RecPyParser#interm}.
	 * @param ctx the parse tree
	 */
	void exitInterm(RecPyParser.IntermContext ctx);
}