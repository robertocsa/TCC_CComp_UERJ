// Generated from .\lexrParsr\RecPyParser.g4 by ANTLR 4.9.1

	// import javax.swing.JOptionPane;
	package lexrParsr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RecPyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		START_WHILE_BLK=1, END_WHILE_BLK=2, LINE_ESCAPE=3, DEF_BLK=4, DEF_EXPR=5, 
		DEF=6, IF_=7, WHILE_=8, IF_EXPR=9, WHILE_EXPR=10, ELSE_=11, RETURN_EXPR=12, 
		RETURN_NTR=13, RETURN_TR=14, INTERM=15, ATTRIBUTION=16, COMMENT=17, PRINT=18, 
		PARAMETERS=19, SIMPL_BLK=20, EMPTY_LINE=21, PARAMET_COND=22, COND=23, 
		DEF_NAME=24, FINAL_COLON=25, ARGS=26;
	public static final int
		RULE_start = 0, RULE_defTailRecursive = 1, RULE_defNonTailRecursive = 2, 
		RULE_defIterative = 3, RULE_def_blk = 4, RULE_start_while_blk = 5, RULE_end_while_blk = 6, 
		RULE_if_expr = 7, RULE_else_ = 8, RULE_return_expr = 9, RULE_return_tr = 10, 
		RULE_return_ntr = 11, RULE_print = 12, RULE_comment = 13, RULE_attribution = 14, 
		RULE_simpl_blk = 15, RULE_empty_line = 16, RULE_interm = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "defTailRecursive", "defNonTailRecursive", "defIterative", "def_blk", 
			"start_while_blk", "end_while_blk", "if_expr", "else_", "return_expr", 
			"return_tr", "return_ntr", "print", "comment", "attribution", "simpl_blk", 
			"empty_line", "interm"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "START_WHILE_BLK", "END_WHILE_BLK", "LINE_ESCAPE", "DEF_BLK", "DEF_EXPR", 
			"DEF", "IF_", "WHILE_", "IF_EXPR", "WHILE_EXPR", "ELSE_", "RETURN_EXPR", 
			"RETURN_NTR", "RETURN_TR", "INTERM", "ATTRIBUTION", "COMMENT", "PRINT", 
			"PARAMETERS", "SIMPL_BLK", "EMPTY_LINE", "PARAMET_COND", "COND", "DEF_NAME", 
			"FINAL_COLON", "ARGS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "RecPyParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



		//public boolean isDef_LT(){
		//JOptionPane.showMessageDialog(null,"Debug: entrou na linha 17");
		//	return (_input.LT(1).getText().toUpperCase().equals("DEF")); 
		//}
		
		public enum TipoTrad {
			TAIL_RECURSIVE,
			NON_TAIL_RECURSIVE,
			ITERATIVE
		}
		// Antes de realizar testes na linha de comando (CMD), configurar a linha abaixo conforme o tipo de algoritmo a testar:
		// Fazer isso tanto no LEXER quanto no PARSER
		private TipoTrad tipoTraduc=TipoTrad.NON_TAIL_RECURSIVE;
		
		public void setTipoTraduc(TipoTrad tipoTrd_){
			tipoTraduc=tipoTrd_;
		}
		public boolean isTailRecursive(){
			return tipoTraduc==TipoTrad.TAIL_RECURSIVE;
		}
		public boolean isNonTailRecursive(){
			return tipoTraduc==TipoTrad.NON_TAIL_RECURSIVE;
		}
		public boolean isIterative(){
			return tipoTraduc==TipoTrad.ITERATIVE;
		}

	public RecPyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(RecPyParser.EOF, 0); }
		public DefTailRecursiveContext defTailRecursive() {
			return getRuleContext(DefTailRecursiveContext.class,0);
		}
		public DefNonTailRecursiveContext defNonTailRecursive() {
			return getRuleContext(DefNonTailRecursiveContext.class,0);
		}
		public DefIterativeContext defIterative() {
			return getRuleContext(DefIterativeContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				{
				setState(36);
				defTailRecursive();
				}
				}
				break;
			case 2:
				{
				{
				setState(37);
				defNonTailRecursive();
				}
				}
				break;
			case 3:
				{
				{
				setState(38);
				defIterative();
				}
				}
				break;
			}
			setState(41);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefTailRecursiveContext extends ParserRuleContext {
		public Def_blkContext def_blk() {
			return getRuleContext(Def_blkContext.class,0);
		}
		public List<Empty_lineContext> empty_line() {
			return getRuleContexts(Empty_lineContext.class);
		}
		public Empty_lineContext empty_line(int i) {
			return getRuleContext(Empty_lineContext.class,i);
		}
		public Return_exprContext return_expr() {
			return getRuleContext(Return_exprContext.class,0);
		}
		public Return_trContext return_tr() {
			return getRuleContext(Return_trContext.class,0);
		}
		public List<Else_Context> else_() {
			return getRuleContexts(Else_Context.class);
		}
		public Else_Context else_(int i) {
			return getRuleContext(Else_Context.class,i);
		}
		public List<IntermContext> interm() {
			return getRuleContexts(IntermContext.class);
		}
		public IntermContext interm(int i) {
			return getRuleContext(IntermContext.class,i);
		}
		public If_exprContext if_expr() {
			return getRuleContext(If_exprContext.class,0);
		}
		public DefTailRecursiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defTailRecursive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterDefTailRecursive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitDefTailRecursive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitDefTailRecursive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefTailRecursiveContext defTailRecursive() throws RecognitionException {
		DefTailRecursiveContext _localctx = new DefTailRecursiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_defTailRecursive);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(43);
			if (!(isTailRecursive())) throw new FailedPredicateException(this, "isTailRecursive()");
			{
			setState(44);
			def_blk();
			}
			{
			{
			{
			setState(45);
			if_expr();
			}
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(46);
					interm();
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
			{
			setState(52);
			return_expr();
			}
			}
			{
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(54);
					else_();
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(60);
					interm();
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
			{
			{
			setState(66);
			return_tr();
			}
			setState(70);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(67);
					interm();
					}
					} 
				}
				setState(72);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EMPTY_LINE) {
				{
				{
				setState(73);
				empty_line();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefNonTailRecursiveContext extends ParserRuleContext {
		public Def_blkContext def_blk() {
			return getRuleContext(Def_blkContext.class,0);
		}
		public List<Empty_lineContext> empty_line() {
			return getRuleContexts(Empty_lineContext.class);
		}
		public Empty_lineContext empty_line(int i) {
			return getRuleContext(Empty_lineContext.class,i);
		}
		public Return_exprContext return_expr() {
			return getRuleContext(Return_exprContext.class,0);
		}
		public Return_ntrContext return_ntr() {
			return getRuleContext(Return_ntrContext.class,0);
		}
		public List<Else_Context> else_() {
			return getRuleContexts(Else_Context.class);
		}
		public Else_Context else_(int i) {
			return getRuleContext(Else_Context.class,i);
		}
		public List<IntermContext> interm() {
			return getRuleContexts(IntermContext.class);
		}
		public IntermContext interm(int i) {
			return getRuleContext(IntermContext.class,i);
		}
		public If_exprContext if_expr() {
			return getRuleContext(If_exprContext.class,0);
		}
		public DefNonTailRecursiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defNonTailRecursive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterDefNonTailRecursive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitDefNonTailRecursive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitDefNonTailRecursive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefNonTailRecursiveContext defNonTailRecursive() throws RecognitionException {
		DefNonTailRecursiveContext _localctx = new DefNonTailRecursiveContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_defNonTailRecursive);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(79);
			if (!(isNonTailRecursive())) throw new FailedPredicateException(this, "isNonTailRecursive()");
			{
			setState(80);
			def_blk();
			}
			{
			{
			{
			setState(81);
			if_expr();
			}
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(82);
					interm();
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
			{
			setState(88);
			return_expr();
			}
			}
			{
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(90);
					else_();
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(96);
					interm();
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
			{
			{
			setState(102);
			return_ntr();
			}
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(103);
					interm();
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EMPTY_LINE) {
				{
				{
				setState(109);
				empty_line();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefIterativeContext extends ParserRuleContext {
		public Def_blkContext def_blk() {
			return getRuleContext(Def_blkContext.class,0);
		}
		public Start_while_blkContext start_while_blk() {
			return getRuleContext(Start_while_blkContext.class,0);
		}
		public End_while_blkContext end_while_blk() {
			return getRuleContext(End_while_blkContext.class,0);
		}
		public List<Empty_lineContext> empty_line() {
			return getRuleContexts(Empty_lineContext.class);
		}
		public Empty_lineContext empty_line(int i) {
			return getRuleContext(Empty_lineContext.class,i);
		}
		public DefIterativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defIterative; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterDefIterative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitDefIterative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitDefIterative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefIterativeContext defIterative() throws RecognitionException {
		DefIterativeContext _localctx = new DefIterativeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_defIterative);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(115);
			if (!(isIterative())) throw new FailedPredicateException(this, "isIterative()");
			{
			setState(116);
			def_blk();
			}
			{
			setState(117);
			start_while_blk();
			}
			{
			setState(118);
			end_while_blk();
			}
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EMPTY_LINE) {
				{
				{
				setState(119);
				empty_line();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Def_blkContext extends ParserRuleContext {
		public TerminalNode DEF_BLK() { return getToken(RecPyParser.DEF_BLK, 0); }
		public List<IntermContext> interm() {
			return getRuleContexts(IntermContext.class);
		}
		public IntermContext interm(int i) {
			return getRuleContext(IntermContext.class,i);
		}
		public Def_blkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_blk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterDef_blk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitDef_blk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitDef_blk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Def_blkContext def_blk() throws RecognitionException {
		Def_blkContext _localctx = new Def_blkContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_def_blk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(125);
			match(DEF_BLK);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERM) {
				{
				{
				setState(126);
				interm();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Start_while_blkContext extends ParserRuleContext {
		public TerminalNode START_WHILE_BLK() { return getToken(RecPyParser.START_WHILE_BLK, 0); }
		public List<IntermContext> interm() {
			return getRuleContexts(IntermContext.class);
		}
		public IntermContext interm(int i) {
			return getRuleContext(IntermContext.class,i);
		}
		public Start_while_blkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_while_blk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterStart_while_blk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitStart_while_blk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitStart_while_blk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Start_while_blkContext start_while_blk() throws RecognitionException {
		Start_while_blkContext _localctx = new Start_while_blkContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_start_while_blk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(132);
			match(START_WHILE_BLK);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERM) {
				{
				{
				setState(133);
				interm();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class End_while_blkContext extends ParserRuleContext {
		public TerminalNode END_WHILE_BLK() { return getToken(RecPyParser.END_WHILE_BLK, 0); }
		public List<IntermContext> interm() {
			return getRuleContexts(IntermContext.class);
		}
		public IntermContext interm(int i) {
			return getRuleContext(IntermContext.class,i);
		}
		public End_while_blkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_end_while_blk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterEnd_while_blk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitEnd_while_blk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitEnd_while_blk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final End_while_blkContext end_while_blk() throws RecognitionException {
		End_while_blkContext _localctx = new End_while_blkContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_end_while_blk);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(139);
			match(END_WHILE_BLK);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INTERM) {
				{
				{
				setState(140);
				interm();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_exprContext extends ParserRuleContext {
		public TerminalNode IF_EXPR() { return getToken(RecPyParser.IF_EXPR, 0); }
		public If_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterIf_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitIf_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitIf_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_exprContext if_expr() throws RecognitionException {
		If_exprContext _localctx = new If_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_if_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(IF_EXPR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_Context extends ParserRuleContext {
		public TerminalNode ELSE_() { return getToken(RecPyParser.ELSE_, 0); }
		public Else_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterElse_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitElse_(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitElse_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_Context else_() throws RecognitionException {
		Else_Context _localctx = new Else_Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_else_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(ELSE_);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_exprContext extends ParserRuleContext {
		public TerminalNode RETURN_EXPR() { return getToken(RecPyParser.RETURN_EXPR, 0); }
		public Return_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterReturn_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitReturn_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitReturn_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_exprContext return_expr() throws RecognitionException {
		Return_exprContext _localctx = new Return_exprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_return_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(RETURN_EXPR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_trContext extends ParserRuleContext {
		public TerminalNode RETURN_TR() { return getToken(RecPyParser.RETURN_TR, 0); }
		public Return_trContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_tr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterReturn_tr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitReturn_tr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitReturn_tr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_trContext return_tr() throws RecognitionException {
		Return_trContext _localctx = new Return_trContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_return_tr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(152);
			if (!(isTailRecursive())) throw new FailedPredicateException(this, "isTailRecursive()");
			setState(153);
			match(RETURN_TR);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_ntrContext extends ParserRuleContext {
		public TerminalNode RETURN_NTR() { return getToken(RecPyParser.RETURN_NTR, 0); }
		public Return_ntrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_ntr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterReturn_ntr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitReturn_ntr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitReturn_ntr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_ntrContext return_ntr() throws RecognitionException {
		Return_ntrContext _localctx = new Return_ntrContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_return_ntr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(155);
			if (!(isNonTailRecursive())) throw new FailedPredicateException(this, "isNonTailRecursive()");
			setState(156);
			match(RETURN_NTR);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(RecPyParser.PRINT, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(PRINT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(RecPyParser.COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(COMMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributionContext extends ParserRuleContext {
		public TerminalNode ATTRIBUTION() { return getToken(RecPyParser.ATTRIBUTION, 0); }
		public AttributionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterAttribution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitAttribution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitAttribution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributionContext attribution() throws RecognitionException {
		AttributionContext _localctx = new AttributionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_attribution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(162);
			match(ATTRIBUTION);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Simpl_blkContext extends ParserRuleContext {
		public TerminalNode SIMPL_BLK() { return getToken(RecPyParser.SIMPL_BLK, 0); }
		public Simpl_blkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpl_blk; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterSimpl_blk(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitSimpl_blk(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitSimpl_blk(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simpl_blkContext simpl_blk() throws RecognitionException {
		Simpl_blkContext _localctx = new Simpl_blkContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_simpl_blk);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(SIMPL_BLK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Empty_lineContext extends ParserRuleContext {
		public TerminalNode EMPTY_LINE() { return getToken(RecPyParser.EMPTY_LINE, 0); }
		public Empty_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterEmpty_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitEmpty_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitEmpty_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Empty_lineContext empty_line() throws RecognitionException {
		Empty_lineContext _localctx = new Empty_lineContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_empty_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(EMPTY_LINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntermContext extends ParserRuleContext {
		public TerminalNode INTERM() { return getToken(RecPyParser.INTERM, 0); }
		public IntermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).enterInterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RecPyParserListener ) ((RecPyParserListener)listener).exitInterm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RecPyParserVisitor ) return ((RecPyParserVisitor<? extends T>)visitor).visitInterm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntermContext interm() throws RecognitionException {
		IntermContext _localctx = new IntermContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_interm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(INTERM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return defTailRecursive_sempred((DefTailRecursiveContext)_localctx, predIndex);
		case 2:
			return defNonTailRecursive_sempred((DefNonTailRecursiveContext)_localctx, predIndex);
		case 3:
			return defIterative_sempred((DefIterativeContext)_localctx, predIndex);
		case 10:
			return return_tr_sempred((Return_trContext)_localctx, predIndex);
		case 11:
			return return_ntr_sempred((Return_ntrContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean defTailRecursive_sempred(DefTailRecursiveContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return isTailRecursive();
		}
		return true;
	}
	private boolean defNonTailRecursive_sempred(DefNonTailRecursiveContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return isNonTailRecursive();
		}
		return true;
	}
	private boolean defIterative_sempred(DefIterativeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return isIterative();
		}
		return true;
	}
	private boolean return_tr_sempred(Return_trContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return isTailRecursive();
		}
		return true;
	}
	private boolean return_ntr_sempred(Return_ntrContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return isNonTailRecursive();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34\u00ad\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\5\2*\n\2\3\2\3\2\3\3\3\3\3\3\3\3\7\3\62\n\3\f\3"+
		"\16\3\65\13\3\3\3\3\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\7\3@\n\3\f\3\16"+
		"\3C\13\3\3\3\3\3\7\3G\n\3\f\3\16\3J\13\3\3\3\7\3M\n\3\f\3\16\3P\13\3\3"+
		"\4\3\4\3\4\3\4\7\4V\n\4\f\4\16\4Y\13\4\3\4\3\4\3\4\7\4^\n\4\f\4\16\4a"+
		"\13\4\3\4\7\4d\n\4\f\4\16\4g\13\4\3\4\3\4\7\4k\n\4\f\4\16\4n\13\4\3\4"+
		"\7\4q\n\4\f\4\16\4t\13\4\3\5\3\5\3\5\3\5\3\5\7\5{\n\5\f\5\16\5~\13\5\3"+
		"\6\3\6\7\6\u0082\n\6\f\6\16\6\u0085\13\6\3\7\3\7\7\7\u0089\n\7\f\7\16"+
		"\7\u008c\13\7\3\b\3\b\7\b\u0090\n\b\f\b\16\b\u0093\13\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\23\b\63AHWel\2\24\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$\2\2\2\u00aa\2)\3\2\2\2\4-\3\2\2\2\6Q\3\2\2\2\bu\3"+
		"\2\2\2\n\177\3\2\2\2\f\u0086\3\2\2\2\16\u008d\3\2\2\2\20\u0094\3\2\2\2"+
		"\22\u0096\3\2\2\2\24\u0098\3\2\2\2\26\u009a\3\2\2\2\30\u009d\3\2\2\2\32"+
		"\u00a0\3\2\2\2\34\u00a2\3\2\2\2\36\u00a4\3\2\2\2 \u00a6\3\2\2\2\"\u00a8"+
		"\3\2\2\2$\u00aa\3\2\2\2&*\5\4\3\2\'*\5\6\4\2(*\5\b\5\2)&\3\2\2\2)\'\3"+
		"\2\2\2)(\3\2\2\2*+\3\2\2\2+,\7\2\2\3,\3\3\2\2\2-.\6\3\2\2./\5\n\6\2/\63"+
		"\5\20\t\2\60\62\5$\23\2\61\60\3\2\2\2\62\65\3\2\2\2\63\64\3\2\2\2\63\61"+
		"\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\5\24\13\2\67;\3\2\2\28:\5\22"+
		"\n\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<A\3\2\2\2=;\3\2\2\2>@\5$"+
		"\23\2?>\3\2\2\2@C\3\2\2\2AB\3\2\2\2A?\3\2\2\2BD\3\2\2\2CA\3\2\2\2DH\5"+
		"\26\f\2EG\5$\23\2FE\3\2\2\2GJ\3\2\2\2HI\3\2\2\2HF\3\2\2\2IN\3\2\2\2JH"+
		"\3\2\2\2KM\5\"\22\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\5\3\2\2\2"+
		"PN\3\2\2\2QR\6\4\3\2RS\5\n\6\2SW\5\20\t\2TV\5$\23\2UT\3\2\2\2VY\3\2\2"+
		"\2WX\3\2\2\2WU\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\5\24\13\2[_\3\2\2\2\\^\5"+
		"\22\n\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`e\3\2\2\2a_\3\2\2\2b"+
		"d\5$\23\2cb\3\2\2\2dg\3\2\2\2ef\3\2\2\2ec\3\2\2\2fh\3\2\2\2ge\3\2\2\2"+
		"hl\5\30\r\2ik\5$\23\2ji\3\2\2\2kn\3\2\2\2lm\3\2\2\2lj\3\2\2\2mr\3\2\2"+
		"\2nl\3\2\2\2oq\5\"\22\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\7\3\2"+
		"\2\2tr\3\2\2\2uv\6\5\4\2vw\5\n\6\2wx\5\f\7\2x|\5\16\b\2y{\5\"\22\2zy\3"+
		"\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\t\3\2\2\2~|\3\2\2\2\177\u0083\7"+
		"\6\2\2\u0080\u0082\5$\23\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\13\3\2\2\2\u0085\u0083\3\2\2"+
		"\2\u0086\u008a\7\3\2\2\u0087\u0089\5$\23\2\u0088\u0087\3\2\2\2\u0089\u008c"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\r\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008d\u0091\7\4\2\2\u008e\u0090\5$\23\2\u008f\u008e\3\2"+
		"\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\17\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7\13\2\2\u0095\21\3\2\2\2"+
		"\u0096\u0097\7\r\2\2\u0097\23\3\2\2\2\u0098\u0099\7\16\2\2\u0099\25\3"+
		"\2\2\2\u009a\u009b\6\f\5\2\u009b\u009c\7\20\2\2\u009c\27\3\2\2\2\u009d"+
		"\u009e\6\r\6\2\u009e\u009f\7\17\2\2\u009f\31\3\2\2\2\u00a0\u00a1\7\24"+
		"\2\2\u00a1\33\3\2\2\2\u00a2\u00a3\7\23\2\2\u00a3\35\3\2\2\2\u00a4\u00a5"+
		"\7\22\2\2\u00a5\37\3\2\2\2\u00a6\u00a7\7\26\2\2\u00a7!\3\2\2\2\u00a8\u00a9"+
		"\7\27\2\2\u00a9#\3\2\2\2\u00aa\u00ab\7\21\2\2\u00ab%\3\2\2\2\21)\63;A"+
		"HNW_elr|\u0083\u008a\u0091";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}