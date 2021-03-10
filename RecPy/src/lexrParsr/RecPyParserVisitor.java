// Generated from .\lexrParsr\RecPyParser.g4 by ANTLR 4.9.1

	// import javax.swing.JOptionPane;
	package lexrParsr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RecPyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RecPyParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RecPyParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(RecPyParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#defTailRecursive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefTailRecursive(RecPyParser.DefTailRecursiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#defNonTailRecursive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefNonTailRecursive(RecPyParser.DefNonTailRecursiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#defIterative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefIterative(RecPyParser.DefIterativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#def_blk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDef_blk(RecPyParser.Def_blkContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#start_while_blk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_while_blk(RecPyParser.Start_while_blkContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#end_while_blk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_while_blk(RecPyParser.End_while_blkContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#if_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_expr(RecPyParser.If_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#else_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_(RecPyParser.Else_Context ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#return_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_expr(RecPyParser.Return_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#return_tr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_tr(RecPyParser.Return_trContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#return_ntr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_ntr(RecPyParser.Return_ntrContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(RecPyParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(RecPyParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#attribution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribution(RecPyParser.AttributionContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#simpl_blk}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpl_blk(RecPyParser.Simpl_blkContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#empty_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty_line(RecPyParser.Empty_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link RecPyParser#interm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterm(RecPyParser.IntermContext ctx);
}