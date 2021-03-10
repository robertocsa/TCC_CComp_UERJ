// Generated from .\lexrParsr\RecPyLexer.g4 by ANTLR 4.9.1
 // place this header action only in lexer, not the parser
	package lexrParsr;
	import java.util.*; 

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RecPyLexer extends Lexer {
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
		M_COND=1, M_DEF=2, M_FINAL_COLON=3, M_ARGS=4;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "M_COND", "M_DEF", "M_FINAL_COLON", "M_ARGS"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"START_WHILE_BLK", "END_WHILE_BLK", "LINE_ESCAPE", "DEF_BLK", "DEF_EXPR", 
			"DEF", "IF_", "WHILE_", "IF_EXPR", "WHILE_EXPR", "ELSE_", "RETURN_EXPR", 
			"RETURN_NTR", "RETURN_TR", "INTERM", "ATTRIBUTION", "COMMENT", "PRINT", 
			"WS", "AP", "FP", "COMPARISON", "OP", "NL", "PRINT_BLK", "PARAMETERS", 
			"SIMPL_BLK", "EMPTY_LINE", "EXPR", "PARAMET_COND", "COND", "DEF_NAME", 
			"FINAL_COLON", "ARGS"
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



		public enum TipoTrad {
			TAIL_RECURSIVE,
			NON_TAIL_RECURSIVE,
			ITERATIVE
		}
		// Antes de realizar testes na linha de comando (CMD), configurar a linha abaixo conforme o tipo de algoritmo a testar:
		// Fazer isso tanto no LEXER quanto no PARSER
		private TipoTrad tipoTraduc=TipoTrad.NON_TAIL_RECURSIVE;
		
		private boolean firstReturn=true;
		
		private int contParentsis=0;
		
		private void setFirstReturn(boolean logico){
			firstReturn=logico;
		}
		
		// Check if is it the first line in which 'return' appears
		private boolean isFirstReturn(){
			return firstReturn==true;
		}
		
		private boolean isReturnTR(){
			if (isTailRecursive() && ! isFirstReturn()){			
				return true;
			} else {
				return false;
			}
		}
		private boolean isReturnNTR(){
			if (isNonTailRecursive() && ! isFirstReturn()){			
				return true;
			} else {
				return false;
			}
		}
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


	public RecPyLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RecPyLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 5:
			DEF_action((RuleContext)_localctx, actionIndex);
			break;
		case 11:
			RETURN_EXPR_action((RuleContext)_localctx, actionIndex);
			break;
		case 33:
			ARGS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void DEF_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 setFirstReturn( true );
			break;
		}
	}
	private void RETURN_EXPR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 setFirstReturn(false);
			break;
		}
	}
	private void ARGS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			contParentsis=0;
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return RETURN_EXPR_sempred((RuleContext)_localctx, predIndex);
		case 12:
			return RETURN_NTR_sempred((RuleContext)_localctx, predIndex);
		case 13:
			return RETURN_TR_sempred((RuleContext)_localctx, predIndex);
		case 15:
			return ATTRIBUTION_sempred((RuleContext)_localctx, predIndex);
		case 25:
			return PARAMETERS_sempred((RuleContext)_localctx, predIndex);
		case 27:
			return EMPTY_LINE_sempred((RuleContext)_localctx, predIndex);
		case 31:
			return DEF_NAME_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean RETURN_EXPR_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return isFirstReturn();
		}
		return true;
	}
	private boolean RETURN_NTR_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return isReturnNTR() ;
		case 2:
			return isReturnNTR() ;
		case 3:
			return isReturnNTR() ;
		}
		return true;
	}
	private boolean RETURN_TR_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return isReturnTR() ;
		}
		return true;
	}
	private boolean ATTRIBUTION_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return isIterative();
		}
		return true;
	}
	private boolean PARAMETERS_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return  isIterative();
		}
		return true;
	}
	private boolean EMPTY_LINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return super.getCharPositionInLine() == 0;
		}
		return true;
	}
	private boolean DEF_NAME_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return  _input.LA(1)!='\u0028';
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u030a\b\1\b\1"+
		"\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\3\3\4\3\4\5\4S"+
		"\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\7\6_\n\6\f\6\16\6b\13\6\3"+
		"\6\3\6\3\7\7\7g\n\7\f\7\16\7j\13\7\3\7\3\7\3\7\3\7\3\7\7\7q\n\7\f\7\16"+
		"\7t\13\7\3\7\3\7\3\7\3\7\3\b\7\b{\n\b\f\b\16\b~\13\b\3\b\3\b\3\b\3\b\7"+
		"\b\u0084\n\b\f\b\16\b\u0087\13\b\3\b\3\b\3\t\7\t\u008c\n\t\f\t\16\t\u008f"+
		"\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u009d\n\t\f"+
		"\t\16\t\u00a0\13\t\3\t\7\t\u00a3\n\t\f\t\16\t\u00a6\13\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\7\t\u00af\n\t\f\t\16\t\u00b2\13\t\5\t\u00b4\n\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\7\f\u00c1\n\f\f\f\16\f\u00c4"+
		"\13\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\r\u00cf\n\r\f\r\16\r\u00d2"+
		"\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00dc\n\r\f\r\16\r\u00df\13"+
		"\r\3\r\6\r\u00e2\n\r\r\r\16\r\u00e3\3\r\3\r\3\r\3\r\3\16\3\16\7\16\u00ec"+
		"\n\16\f\16\16\16\u00ef\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\7\16\u00fa\n\16\f\16\16\16\u00fd\13\16\3\16\3\16\7\16\u0101\n\16\f"+
		"\16\16\16\u0104\13\16\3\16\3\16\7\16\u0108\n\16\f\16\16\16\u010b\13\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0114\n\16\f\16\16\16\u0117\13"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0122\n\16\f\16"+
		"\16\16\u0125\13\16\3\16\3\16\7\16\u0129\n\16\f\16\16\16\u012c\13\16\3"+
		"\16\3\16\7\16\u0130\n\16\f\16\16\16\u0133\13\16\3\16\3\16\3\16\3\16\7"+
		"\16\u0139\n\16\f\16\16\16\u013c\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\7\16\u0146\n\16\f\16\16\16\u0149\13\16\3\16\3\16\7\16\u014d\n"+
		"\16\f\16\16\16\u0150\13\16\3\16\3\16\7\16\u0154\n\16\f\16\16\16\u0157"+
		"\13\16\3\16\3\16\3\16\3\16\3\16\5\16\u015e\n\16\3\17\3\17\7\17\u0162\n"+
		"\17\f\17\16\17\u0165\13\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17"+
		"\u016f\n\17\f\17\16\17\u0172\13\17\3\17\3\17\3\17\7\17\u0177\n\17\f\17"+
		"\16\17\u017a\13\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u0182\n\20\3\21"+
		"\3\21\7\21\u0186\n\21\f\21\16\21\u0189\13\21\3\21\3\21\3\21\7\21\u018e"+
		"\n\21\f\21\16\21\u0191\13\21\3\21\3\21\6\21\u0195\n\21\r\21\16\21\u0196"+
		"\3\21\3\21\7\21\u019b\n\21\f\21\16\21\u019e\13\21\3\21\3\21\3\21\7\21"+
		"\u01a3\n\21\f\21\16\21\u01a6\13\21\3\21\3\21\6\21\u01aa\n\21\r\21\16\21"+
		"\u01ab\3\21\5\21\u01af\n\21\3\21\7\21\u01b2\n\21\f\21\16\21\u01b5\13\21"+
		"\3\21\3\21\3\21\3\21\7\21\u01bb\n\21\f\21\16\21\u01be\13\21\3\21\3\21"+
		"\3\21\5\21\u01c3\n\21\5\21\u01c5\n\21\3\22\7\22\u01c8\n\22\f\22\16\22"+
		"\u01cb\13\22\3\22\3\22\7\22\u01cf\n\22\f\22\16\22\u01d2\13\22\3\22\5\22"+
		"\u01d5\n\22\3\22\3\22\7\22\u01d9\n\22\f\22\16\22\u01dc\13\22\3\22\3\22"+
		"\3\22\3\22\7\22\u01e2\n\22\f\22\16\22\u01e5\13\22\3\22\3\22\3\22\3\22"+
		"\7\22\u01eb\n\22\f\22\16\22\u01ee\13\22\3\22\3\22\3\22\3\22\7\22\u01f4"+
		"\n\22\f\22\16\22\u01f7\13\22\3\22\3\22\3\22\3\22\7\22\u01fd\n\22\f\22"+
		"\16\22\u0200\13\22\5\22\u0202\n\22\3\23\7\23\u0205\n\23\f\23\16\23\u0208"+
		"\13\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0211\n\23\f\23\16\23\u0214"+
		"\13\23\3\23\3\23\3\24\6\24\u0219\n\24\r\24\16\24\u021a\3\25\7\25\u021e"+
		"\n\25\f\25\16\25\u0221\13\25\3\25\3\25\7\25\u0225\n\25\f\25\16\25\u0228"+
		"\13\25\3\25\6\25\u022b\n\25\r\25\16\25\u022c\5\25\u022f\n\25\3\26\7\26"+
		"\u0232\n\26\f\26\16\26\u0235\13\26\3\26\3\26\7\26\u0239\n\26\f\26\16\26"+
		"\u023c\13\26\3\26\6\26\u023f\n\26\r\26\16\26\u0240\5\26\u0243\n\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0252"+
		"\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u027e\n\30\3\31\5\31\u0281\n\31\3\31\3\31\3\32\6\32\u0286\n"+
		"\32\r\32\16\32\u0287\3\32\3\32\3\33\3\33\6\33\u028e\n\33\r\33\16\33\u028f"+
		"\3\34\6\34\u0293\n\34\r\34\16\34\u0294\3\34\5\34\u0298\n\34\3\35\3\35"+
		"\7\35\u029c\n\35\f\35\16\35\u029f\13\35\3\35\5\35\u02a2\n\35\3\35\3\35"+
		"\3\36\7\36\u02a7\n\36\f\36\16\36\u02aa\13\36\3\36\6\36\u02ad\n\36\r\36"+
		"\16\36\u02ae\3\36\7\36\u02b2\n\36\f\36\16\36\u02b5\13\36\6\36\u02b7\n"+
		"\36\r\36\16\36\u02b8\3\37\6\37\u02bc\n\37\r\37\16\37\u02bd\3 \7 \u02c1"+
		"\n \f \16 \u02c4\13 \3 \3 \7 \u02c8\n \f \16 \u02cb\13 \3 \3 \7 \u02cf"+
		"\n \f \16 \u02d2\13 \3 \3 \7 \u02d6\n \f \16 \u02d9\13 \3 \3 \3!\3!\5"+
		"!\u02df\n!\3!\7!\u02e2\n!\f!\16!\u02e5\13!\6!\u02e7\n!\r!\16!\u02e8\3"+
		"!\3!\3\"\7\"\u02ee\n\"\f\"\16\"\u02f1\13\"\3\"\3\"\7\"\u02f5\n\"\f\"\16"+
		"\"\u02f8\13\"\3\"\7\"\u02fb\n\"\f\"\16\"\u02fe\13\"\3\"\3\"\3#\6#\u0303"+
		"\n#\r#\16#\u0304\3#\3#\3#\3#\t\u00e3\u01d0\u01da\u01e3\u01ec\u01f5\u01fe"+
		"\2$\7\3\t\4\13\5\r\6\17\7\21\b\23\t\25\n\27\13\31\f\33\r\35\16\37\17!"+
		"\20#\21%\22\'\23)\24+\2-\2/\2\61\2\63\2\65\2\67\29\25;\26=\27?\2A\30C"+
		"\31E\32G\33I\34\7\2\3\4\5\6\16\3\2\f\f\4\2\f\f\17\17\3\2))\3\2$$\4\2\13"+
		"\13\"\"\4\2>>@@\5\2,-//\61\61\5\2((``~~\5\2\f\f\17\17??\t\2\"\"*+\62;"+
		"C]__aac|\6\2\60\60C\\aac|\3\2\62;\2\u0370\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\3A\3\2\2\2\3C\3\2\2\2\4E\3\2\2\2\5G\3\2\2\2\6I\3\2\2"+
		"\2\7K\3\2\2\2\tM\3\2\2\2\13P\3\2\2\2\rX\3\2\2\2\17Z\3\2\2\2\21h\3\2\2"+
		"\2\23|\3\2\2\2\25\u00b3\3\2\2\2\27\u00b7\3\2\2\2\31\u00bb\3\2\2\2\33\u00c2"+
		"\3\2\2\2\35\u00cc\3\2\2\2\37\u015d\3\2\2\2!\u015f\3\2\2\2#\u0181\3\2\2"+
		"\2%\u01c4\3\2\2\2\'\u0201\3\2\2\2)\u0206\3\2\2\2+\u0218\3\2\2\2-\u022e"+
		"\3\2\2\2/\u0242\3\2\2\2\61\u0251\3\2\2\2\63\u027d\3\2\2\2\65\u0280\3\2"+
		"\2\2\67\u0285\3\2\2\29\u028b\3\2\2\2;\u0292\3\2\2\2=\u0299\3\2\2\2?\u02b6"+
		"\3\2\2\2A\u02bb\3\2\2\2C\u02c2\3\2\2\2E\u02dc\3\2\2\2G\u02ef\3\2\2\2I"+
		"\u0302\3\2\2\2KL\5\31\13\2L\b\3\2\2\2MN\5%\21\2NO\5\35\r\2O\n\3\2\2\2"+
		"PR\7^\2\2QS\7\17\2\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\f\2\2UV\3\2\2\2"+
		"VW\b\4\2\2W\f\3\2\2\2XY\5\17\6\2Y\16\3\2\2\2Z[\5\21\7\2[\\\5E!\2\\`\5"+
		"I#\2]_\5/\26\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ac\3\2\2\2b`\3\2"+
		"\2\2cd\5G\"\2d\20\3\2\2\2eg\5+\24\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3"+
		"\2\2\2ik\3\2\2\2jh\3\2\2\2kl\7f\2\2lm\7g\2\2mn\7h\2\2nr\3\2\2\2oq\5+\24"+
		"\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\b\7\3"+
		"\2vw\3\2\2\2wx\b\7\4\2x\22\3\2\2\2y{\5+\24\2zy\3\2\2\2{~\3\2\2\2|z\3\2"+
		"\2\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\7k\2\2\u0080\u0081\7h"+
		"\2\2\u0081\u0085\3\2\2\2\u0082\u0084\5+\24\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0088\u0089\b\b\5\2\u0089\24\3\2\2\2\u008a\u008c"+
		"\5+\24\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7y"+
		"\2\2\u0091\u0092\7j\2\2\u0092\u0093\7k\2\2\u0093\u0094\7n\2\2\u0094\u0095"+
		"\7g\2\2\u0095\u0096\3\2\2\2\u0096\u0097\5+\24\2\u0097\u0098\7p\2\2\u0098"+
		"\u0099\7q\2\2\u0099\u009a\7v\2\2\u009a\u009e\3\2\2\2\u009b\u009d\5+\24"+
		"\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\u00b4\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a3\5+\24\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7y\2\2\u00a8"+
		"\u00a9\7j\2\2\u00a9\u00aa\7k\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7g\2\2"+
		"\u00ac\u00b0\3\2\2\2\u00ad\u00af\5+\24\2\u00ae\u00ad\3\2\2\2\u00af\u00b2"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b3\u008d\3\2\2\2\u00b3\u00a4\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\u00b6\b\t\5\2\u00b6\26\3\2\2\2\u00b7\u00b8\5\23\b\2\u00b8\u00b9"+
		"\5C \2\u00b9\u00ba\5G\"\2\u00ba\30\3\2\2\2\u00bb\u00bc\5\25\t\2\u00bc"+
		"\u00bd\5C \2\u00bd\u00be\5G\"\2\u00be\32\3\2\2\2\u00bf\u00c1\5+\24\2\u00c0"+
		"\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c6\7g\2\2\u00c6"+
		"\u00c7\7n\2\2\u00c7\u00c8\7u\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\3\2\2"+
		"\2\u00ca\u00cb\5G\"\2\u00cb\34\3\2\2\2\u00cc\u00d0\6\r\2\2\u00cd\u00cf"+
		"\5+\24\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7t"+
		"\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7w\2\2\u00d7\u00d8"+
		"\7t\2\2\u00d8\u00d9\7p\2\2\u00d9\u00dd\3\2\2\2\u00da\u00dc\5+\24\2\u00db"+
		"\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e2\n\2\2\2\u00e1"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\5\65\31\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00e8\b\r\6\2\u00e8\36\3\2\2\2\u00e9\u00ed\6\16\3\2\u00ea\u00ec\5+\24"+
		"\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f1\7t\2\2\u00f1"+
		"\u00f2\7g\2\2\u00f2\u00f3\7v\2\2\u00f3\u00f4\7w\2\2\u00f4\u00f5\7t\2\2"+
		"\u00f5\u00f6\7p\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00fb\5?\36\2\u00f8\u00fa"+
		"\5-\25\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0102\5E"+
		"!\2\u00ff\u0101\5-\25\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u0102\3\2"+
		"\2\2\u0105\u0109\5I#\2\u0106\u0108\5/\26\2\u0107\u0106\3\2\2\2\u0108\u010b"+
		"\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010c\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010c\u010d\5\63\30\2\u010d\u010e\5-\25\2\u010e\u010f\5"+
		"?\36\2\u010f\u0110\5\65\31\2\u0110\u015e\3\2\2\2\u0111\u0115\6\16\4\2"+
		"\u0112\u0114\5+\24\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113"+
		"\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117\u0115\3\2\2\2\u0118"+
		"\u0119\7t\2\2\u0119\u011a\7g\2\2\u011a\u011b\7v\2\2\u011b\u011c\7w\2\2"+
		"\u011c\u011d\7t\2\2\u011d\u011e\7p\2\2\u011e\u011f\3\2\2\2\u011f\u0123"+
		"\5?\36\2\u0120\u0122\5-\25\2\u0121\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0126\3\2\2\2\u0125\u0123\3\2"+
		"\2\2\u0126\u012a\5E!\2\u0127\u0129\5-\25\2\u0128\u0127\3\2\2\2\u0129\u012c"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012d\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012d\u0131\5I#\2\u012e\u0130\5/\26\2\u012f\u012e\3\2\2"+
		"\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\5\65\31\2\u0135\u015e\3\2\2\2"+
		"\u0136\u013a\6\16\5\2\u0137\u0139\5+\24\2\u0138\u0137\3\2\2\2\u0139\u013c"+
		"\3\2\2\2\u013a\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c"+
		"\u013a\3\2\2\2\u013d\u013e\7t\2\2\u013e\u013f\7g\2\2\u013f\u0140\7v\2"+
		"\2\u0140\u0141\7w\2\2\u0141\u0142\7t\2\2\u0142\u0143\7p\2\2\u0143\u0147"+
		"\3\2\2\2\u0144\u0146\5-\25\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u014a\u014e\5E!\2\u014b\u014d\5-\25\2\u014c\u014b\3\2\2\2\u014d\u0150"+
		"\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0151\3\2\2\2\u0150"+
		"\u014e\3\2\2\2\u0151\u0155\5I#\2\u0152\u0154\5/\26\2\u0153\u0152\3\2\2"+
		"\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0158"+
		"\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0159\5\63\30\2\u0159\u015a\5-\25\2"+
		"\u015a\u015b\5?\36\2\u015b\u015c\5\65\31\2\u015c\u015e\3\2\2\2\u015d\u00e9"+
		"\3\2\2\2\u015d\u0111\3\2\2\2\u015d\u0136\3\2\2\2\u015e \3\2\2\2\u015f"+
		"\u0163\6\17\6\2\u0160\u0162\5+\24\2\u0161\u0160\3\2\2\2\u0162\u0165\3"+
		"\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164\3\2\2\2\u0164\u0166\3\2\2\2\u0165"+
		"\u0163\3\2\2\2\u0166\u0167\7t\2\2\u0167\u0168\7g\2\2\u0168\u0169\7v\2"+
		"\2\u0169\u016a\7w\2\2\u016a\u016b\7t\2\2\u016b\u016c\7p\2\2\u016c\u0170"+
		"\3\2\2\2\u016d\u016f\5+\24\2\u016e\u016d\3\2\2\2\u016f\u0172\3\2\2\2\u0170"+
		"\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173\3\2\2\2\u0172\u0170\3\2"+
		"\2\2\u0173\u0174\5E!\2\u0174\u0178\5I#\2\u0175\u0177\5/\26\2\u0176\u0175"+
		"\3\2\2\2\u0177\u017a\3\2\2\2\u0178\u0176\3\2\2\2\u0178\u0179\3\2\2\2\u0179"+
		"\u017b\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u017c\5\65\31\2\u017c\"\3\2\2"+
		"\2\u017d\u0182\5=\35\2\u017e\u0182\5\'\22\2\u017f\u0182\5)\23\2\u0180"+
		"\u0182\5;\34\2\u0181\u017d\3\2\2\2\u0181\u017e\3\2\2\2\u0181\u017f\3\2"+
		"\2\2\u0181\u0180\3\2\2\2\u0182$\3\2\2\2\u0183\u0187\6\21\7\2\u0184\u0186"+
		"\5+\24\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018b\59"+
		"\33\2\u018b\u0194\3\2\2\2\u018c\u018e\5+\24\2\u018d\u018c\3\2\2\2\u018e"+
		"\u0191\3\2\2\2\u018f\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0192\3\2"+
		"\2\2\u0191\u018f\3\2\2\2\u0192\u0193\7.\2\2\u0193\u0195\59\33\2\u0194"+
		"\u018f\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0197\3\2"+
		"\2\2\u0197\u0198\3\2\2\2\u0198\u019c\7?\2\2\u0199\u019b\5+\24\2\u019a"+
		"\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2"+
		"\2\2\u019d\u019f\3\2\2\2\u019e\u019c\3\2\2\2\u019f\u01a0\59\33\2\u01a0"+
		"\u01a9\3\2\2\2\u01a1\u01a3\5+\24\2\u01a2\u01a1\3\2\2\2\u01a3\u01a6\3\2"+
		"\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a7\3\2\2\2\u01a6"+
		"\u01a4\3\2\2\2\u01a7\u01a8\7.\2\2\u01a8\u01aa\59\33\2\u01a9\u01a4\3\2"+
		"\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac"+
		"\u01ae\3\2\2\2\u01ad\u01af\5\65\31\2\u01ae\u01ad\3\2\2\2\u01ae\u01af\3"+
		"\2\2\2\u01af\u01c5\3\2\2\2\u01b0\u01b2\5+\24\2\u01b1\u01b0\3\2\2\2\u01b2"+
		"\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3\2"+
		"\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b7\59\33\2\u01b7\u01b8\3\2\2\2\u01b8"+
		"\u01bc\7?\2\2\u01b9\u01bb\5+\24\2\u01ba\u01b9\3\2\2\2\u01bb\u01be\3\2"+
		"\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01bf\3\2\2\2\u01be"+
		"\u01bc\3\2\2\2\u01bf\u01c0\59\33\2\u01c0\u01c2\3\2\2\2\u01c1\u01c3\5\65"+
		"\31\2\u01c2\u01c1\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4"+
		"\u0183\3\2\2\2\u01c4\u01b3\3\2\2\2\u01c5&\3\2\2\2\u01c6\u01c8\5+\24\2"+
		"\u01c7\u01c6\3\2\2\2\u01c8\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca"+
		"\3\2\2\2\u01ca\u01cc\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01d0\7%\2\2\u01cd"+
		"\u01cf\n\3\2\2\u01ce\u01cd\3\2\2\2\u01cf\u01d2\3\2\2\2\u01d0\u01d1\3\2"+
		"\2\2\u01d0\u01ce\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d3"+
		"\u01d5\7\17\2\2\u01d4\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\3"+
		"\2\2\2\u01d6\u01da\7\f\2\2\u01d7\u01d9\5\65\31\2\u01d8\u01d7\3\2\2\2\u01d9"+
		"\u01dc\3\2\2\2\u01da\u01db\3\2\2\2\u01da\u01d8\3\2\2\2\u01db\u0202\3\2"+
		"\2\2\u01dc\u01da\3\2\2\2\u01dd\u01de\t\4\2\2\u01de\u01df\t\4\2\2\u01df"+
		"\u01e3\t\4\2\2\u01e0\u01e2\13\2\2\2\u01e1\u01e0\3\2\2\2\u01e2\u01e5\3"+
		"\2\2\2\u01e3\u01e4\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e4\u01e6\3\2\2\2\u01e5"+
		"\u01e3\3\2\2\2\u01e6\u01e7\t\4\2\2\u01e7\u01e8\t\4\2\2\u01e8\u01ec\t\4"+
		"\2\2\u01e9\u01eb\5\65\31\2\u01ea\u01e9\3\2\2\2\u01eb\u01ee\3\2\2\2\u01ec"+
		"\u01ed\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ed\u0202\3\2\2\2\u01ee\u01ec\3\2"+
		"\2\2\u01ef\u01f0\t\5\2\2\u01f0\u01f1\t\5\2\2\u01f1\u01f5\t\5\2\2\u01f2"+
		"\u01f4\13\2\2\2\u01f3\u01f2\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f6\3"+
		"\2\2\2\u01f5\u01f3\3\2\2\2\u01f6\u01f8\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8"+
		"\u01f9\t\5\2\2\u01f9\u01fa\t\5\2\2\u01fa\u01fe\t\5\2\2\u01fb\u01fd\5\65"+
		"\31\2\u01fc\u01fb\3\2\2\2\u01fd\u0200\3\2\2\2\u01fe\u01ff\3\2\2\2\u01fe"+
		"\u01fc\3\2\2\2\u01ff\u0202\3\2\2\2\u0200\u01fe\3\2\2\2\u0201\u01c9\3\2"+
		"\2\2\u0201\u01dd\3\2\2\2\u0201\u01ef\3\2\2\2\u0202(\3\2\2\2\u0203\u0205"+
		"\5+\24\2\u0204\u0203\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0206"+
		"\u0207\3\2\2\2\u0207\u0209\3\2\2\2\u0208\u0206\3\2\2\2\u0209\u020a\7r"+
		"\2\2\u020a\u020b\7t\2\2\u020b\u020c\7k\2\2\u020c\u020d\7p\2\2\u020d\u020e"+
		"\7v\2\2\u020e\u0212\3\2\2\2\u020f\u0211\5+\24\2\u0210\u020f\3\2\2\2\u0211"+
		"\u0214\3\2\2\2\u0212\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0215\3\2"+
		"\2\2\u0214\u0212\3\2\2\2\u0215\u0216\5\67\32\2\u0216*\3\2\2\2\u0217\u0219"+
		"\t\6\2\2\u0218\u0217\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u0218\3\2\2\2\u021a"+
		"\u021b\3\2\2\2\u021b,\3\2\2\2\u021c\u021e\5+\24\2\u021d\u021c\3\2\2\2"+
		"\u021e\u0221\3\2\2\2\u021f\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0222"+
		"\3\2\2\2\u0221\u021f\3\2\2\2\u0222\u0226\7*\2\2\u0223\u0225\5+\24\2\u0224"+
		"\u0223\3\2\2\2\u0225\u0228\3\2\2\2\u0226\u0224\3\2\2\2\u0226\u0227\3\2"+
		"\2\2\u0227\u022f\3\2\2\2\u0228\u0226\3\2\2\2\u0229\u022b\5+\24\2\u022a"+
		"\u0229\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2"+
		"\2\2\u022d\u022f\3\2\2\2\u022e\u021f\3\2\2\2\u022e\u022a\3\2\2\2\u022f"+
		".\3\2\2\2\u0230\u0232\5+\24\2\u0231\u0230\3\2\2\2\u0232\u0235\3\2\2\2"+
		"\u0233\u0231\3\2\2\2\u0233\u0234\3\2\2\2\u0234\u0236\3\2\2\2\u0235\u0233"+
		"\3\2\2\2\u0236\u023a\7+\2\2\u0237\u0239\5+\24\2\u0238\u0237\3\2\2\2\u0239"+
		"\u023c\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u0243\3\2"+
		"\2\2\u023c\u023a\3\2\2\2\u023d\u023f\5+\24\2\u023e\u023d\3\2\2\2\u023f"+
		"\u0240\3\2\2\2\u0240\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0243\3\2"+
		"\2\2\u0242\u0233\3\2\2\2\u0242\u023e\3\2\2\2\u0243\60\3\2\2\2\u0244\u0245"+
		"\7k\2\2\u0245\u0252\7p\2\2\u0246\u0247\7?\2\2\u0247\u0252\7?\2\2\u0248"+
		"\u0252\t\7\2\2\u0249\u024a\7@\2\2\u024a\u0252\7?\2\2\u024b\u024c\7>\2"+
		"\2\u024c\u0252\7?\2\2\u024d\u024e\7>\2\2\u024e\u0252\7@\2\2\u024f\u0250"+
		"\7#\2\2\u0250\u0252\7?\2\2\u0251\u0244\3\2\2\2\u0251\u0246\3\2\2\2\u0251"+
		"\u0248\3\2\2\2\u0251\u0249\3\2\2\2\u0251\u024b\3\2\2\2\u0251\u024d\3\2"+
		"\2\2\u0251\u024f\3\2\2\2\u0252\62\3\2\2\2\u0253\u027e\t\b\2\2\u0254\u0255"+
		"\7\61\2\2\u0255\u027e\7\61\2\2\u0256\u027e\7\'\2\2\u0257\u0258\7,\2\2"+
		"\u0258\u027e\7,\2\2\u0259\u027e\t\t\2\2\u025a\u025b\7>\2\2\u025b\u027e"+
		"\7>\2\2\u025c\u025d\7@\2\2\u025d\u027e\7@\2\2\u025e\u027e\7\u0080\2\2"+
		"\u025f\u0260\7-\2\2\u0260\u027e\7?\2\2\u0261\u0262\7/\2\2\u0262\u027e"+
		"\7?\2\2\u0263\u0264\7,\2\2\u0264\u027e\7?\2\2\u0265\u0266\7\61\2\2\u0266"+
		"\u027e\7?\2\2\u0267\u0268\7\'\2\2\u0268\u027e\7?\2\2\u0269\u026a\7(\2"+
		"\2\u026a\u027e\7?\2\2\u026b\u026c\7~\2\2\u026c\u027e\7?\2\2\u026d\u026e"+
		"\7`\2\2\u026e\u027e\7?\2\2\u026f\u0270\7>\2\2\u0270\u0271\7>\2\2\u0271"+
		"\u027e\7?\2\2\u0272\u0273\7@\2\2\u0273\u0274\7@\2\2\u0274\u027e\7?\2\2"+
		"\u0275\u0276\7,\2\2\u0276\u0277\7,\2\2\u0277\u027e\7?\2\2\u0278\u0279"+
		"\7\61\2\2\u0279\u027a\7\61\2\2\u027a\u027e\7?\2\2\u027b\u027c\7<\2\2\u027c"+
		"\u027e\7?\2\2\u027d\u0253\3\2\2\2\u027d\u0254\3\2\2\2\u027d\u0256\3\2"+
		"\2\2\u027d\u0257\3\2\2\2\u027d\u0259\3\2\2\2\u027d\u025a\3\2\2\2\u027d"+
		"\u025c\3\2\2\2\u027d\u025e\3\2\2\2\u027d\u025f\3\2\2\2\u027d\u0261\3\2"+
		"\2\2\u027d\u0263\3\2\2\2\u027d\u0265\3\2\2\2\u027d\u0267\3\2\2\2\u027d"+
		"\u0269\3\2\2\2\u027d\u026b\3\2\2\2\u027d\u026d\3\2\2\2\u027d\u026f\3\2"+
		"\2\2\u027d\u0272\3\2\2\2\u027d\u0275\3\2\2\2\u027d\u0278\3\2\2\2\u027d"+
		"\u027b\3\2\2\2\u027e\64\3\2\2\2\u027f\u0281\7\17\2\2\u0280\u027f\3\2\2"+
		"\2\u0280\u0281\3\2\2\2\u0281\u0282\3\2\2\2\u0282\u0283\7\f\2\2\u0283\66"+
		"\3\2\2\2\u0284\u0286\n\3\2\2\u0285\u0284\3\2\2\2\u0286\u0287\3\2\2\2\u0287"+
		"\u0285\3\2\2\2\u0287\u0288\3\2\2\2\u0288\u0289\3\2\2\2\u0289\u028a\5\65"+
		"\31\2\u028a8\3\2\2\2\u028b\u028d\6\33\b\2\u028c\u028e\n\n\2\2\u028d\u028c"+
		"\3\2\2\2\u028e\u028f\3\2\2\2\u028f\u028d\3\2\2\2\u028f\u0290\3\2\2\2\u0290"+
		":\3\2\2\2\u0291\u0293\n\3\2\2\u0292\u0291\3\2\2\2\u0293\u0294\3\2\2\2"+
		"\u0294\u0292\3\2\2\2\u0294\u0295\3\2\2\2\u0295\u0297\3\2\2\2\u0296\u0298"+
		"\5\65\31\2\u0297\u0296\3\2\2\2\u0297\u0298\3\2\2\2\u0298<\3\2\2\2\u0299"+
		"\u029d\6\35\t\2\u029a\u029c\t\6\2\2\u029b\u029a\3\2\2\2\u029c\u029f\3"+
		"\2\2\2\u029d\u029b\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u02a1\3\2\2\2\u029f"+
		"\u029d\3\2\2\2\u02a0\u02a2\7\17\2\2\u02a1\u02a0\3\2\2\2\u02a1\u02a2\3"+
		"\2\2\2\u02a2\u02a3\3\2\2\2\u02a3\u02a4\7\f\2\2\u02a4>\3\2\2\2\u02a5\u02a7"+
		"\5+\24\2\u02a6\u02a5\3\2\2\2\u02a7\u02aa\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8"+
		"\u02a9\3\2\2\2\u02a9\u02ac\3\2\2\2\u02aa\u02a8\3\2\2\2\u02ab\u02ad\t\13"+
		"\2\2\u02ac\u02ab\3\2\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02ac\3\2\2\2\u02ae"+
		"\u02af\3\2\2\2\u02af\u02b3\3\2\2\2\u02b0\u02b2\5\63\30\2\u02b1\u02b0\3"+
		"\2\2\2\u02b2\u02b5\3\2\2\2\u02b3\u02b1\3\2\2\2\u02b3\u02b4\3\2\2\2\u02b4"+
		"\u02b7\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b6\u02a8\3\2\2\2\u02b7\u02b8\3\2"+
		"\2\2\u02b8\u02b6\3\2\2\2\u02b8\u02b9\3\2\2\2\u02b9@\3\2\2\2\u02ba\u02bc"+
		"\n\n\2\2\u02bb\u02ba\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bd\u02bb\3\2\2\2\u02bd"+
		"\u02be\3\2\2\2\u02beB\3\2\2\2\u02bf\u02c1\5-\25\2\u02c0\u02bf\3\2\2\2"+
		"\u02c1\u02c4\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c5"+
		"\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c5\u02c9\5A\37\2\u02c6\u02c8\5+\24\2\u02c7"+
		"\u02c6\3\2\2\2\u02c8\u02cb\3\2\2\2\u02c9\u02c7\3\2\2\2\u02c9\u02ca\3\2"+
		"\2\2\u02ca\u02cc\3\2\2\2\u02cb\u02c9\3\2\2\2\u02cc\u02d0\5\61\27\2\u02cd"+
		"\u02cf\5+\24\2\u02ce\u02cd\3\2\2\2\u02cf\u02d2\3\2\2\2\u02d0\u02ce\3\2"+
		"\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02d3\3\2\2\2\u02d2\u02d0\3\2\2\2\u02d3"+
		"\u02d7\5A\37\2\u02d4\u02d6\5/\26\2\u02d5\u02d4\3\2\2\2\u02d6\u02d9\3\2"+
		"\2\2\u02d7\u02d5\3\2\2\2\u02d7\u02d8\3\2\2\2\u02d8\u02da\3\2\2\2\u02d9"+
		"\u02d7\3\2\2\2\u02da\u02db\b \7\2\u02dbD\3\2\2\2\u02dc\u02e6\6!\n\2\u02dd"+
		"\u02df\t\f\2\2\u02de\u02dd\3\2\2\2\u02df\u02e3\3\2\2\2\u02e0\u02e2\t\r"+
		"\2\2\u02e1\u02e0\3\2\2\2\u02e2\u02e5\3\2\2\2\u02e3\u02e1\3\2\2\2\u02e3"+
		"\u02e4\3\2\2\2\u02e4\u02e7\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e6\u02de\3\2"+
		"\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02e6\3\2\2\2\u02e8\u02e9\3\2\2\2\u02e9"+
		"\u02ea\3\2\2\2\u02ea\u02eb\b!\b\2\u02ebF\3\2\2\2\u02ec\u02ee\5+\24\2\u02ed"+
		"\u02ec\3\2\2\2\u02ee\u02f1\3\2\2\2\u02ef\u02ed\3\2\2\2\u02ef\u02f0\3\2"+
		"\2\2\u02f0\u02f2\3\2\2\2\u02f1\u02ef\3\2\2\2\u02f2\u02f6\7<\2\2\u02f3"+
		"\u02f5\5+\24\2\u02f4\u02f3\3\2\2\2\u02f5\u02f8\3\2\2\2\u02f6\u02f4\3\2"+
		"\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02fc\3\2\2\2\u02f8\u02f6\3\2\2\2\u02f9"+
		"\u02fb\5\65\31\2\u02fa\u02f9\3\2\2\2\u02fb\u02fe\3\2\2\2\u02fc\u02fa\3"+
		"\2\2\2\u02fc\u02fd\3\2\2\2\u02fd\u02ff\3\2\2\2\u02fe\u02fc\3\2\2\2\u02ff"+
		"\u0300\b\"\t\2\u0300H\3\2\2\2\u0301\u0303\n\3\2\2\u0302\u0301\3\2\2\2"+
		"\u0303\u0304\3\2\2\2\u0304\u0302\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0306"+
		"\3\2\2\2\u0306\u0307\b#\n\2\u0307\u0308\3\2\2\2\u0308\u0309\b#\t\2\u0309"+
		"J\3\2\2\2`\2\3\4\5\6R`hr|\u0085\u008d\u009e\u00a4\u00b0\u00b3\u00c2\u00d0"+
		"\u00dd\u00e3\u00ed\u00fb\u0102\u0109\u0115\u0123\u012a\u0131\u013a\u0147"+
		"\u014e\u0155\u015d\u0163\u0170\u0178\u0181\u0187\u018f\u0196\u019c\u01a4"+
		"\u01ab\u01ae\u01b3\u01bc\u01c2\u01c4\u01c9\u01d0\u01d4\u01da\u01e3\u01ec"+
		"\u01f5\u01fe\u0201\u0206\u0212\u021a\u021f\u0226\u022c\u022e\u0233\u023a"+
		"\u0240\u0242\u0251\u027d\u0280\u0287\u028f\u0294\u0297\u029d\u02a1\u02a8"+
		"\u02ac\u02ae\u02b3\u02b8\u02bd\u02c2\u02c9\u02d0\u02d7\u02de\u02e3\u02e8"+
		"\u02ef\u02f6\u02fc\u0304\13\b\2\2\3\7\2\7\4\2\7\3\2\3\r\3\7\5\2\7\6\2"+
		"\4\2\2\3#\4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}