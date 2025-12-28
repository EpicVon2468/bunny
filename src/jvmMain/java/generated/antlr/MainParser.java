// Generated from antlr/Main.g4 by ANTLR 4.13.2

package generated.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MainParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPEN_PAREN=1, CLOSE_PAREN=2, OPEN_BRACE=3, CLOSE_BRACE=4, ARGUMENT_SEPARATOR=5, 
		MEMBER_REFERENCE=6, DIV=7, ADD=8, SUB=9, NOT=10, ASTERISK=11, VARARG=12, 
		ASSIGNMENT=13, COMPARISON_EQUALS=14, COMPARISON_NOT_EQUALS=15, COMPARISON_GREATER=16, 
		COMPARISON_GREATER_THAN=17, COMPARISON_LESS=18, COMPARISON_LESS_THAN=19, 
		STRING_LITERAL=20, COMMENT=21, DOCUMENTATION_COMMENT=22, SECTION_COMMENT=23, 
		TERMINATION=24, NUMBER=25, FUNCTION=26, VARIABLE=27, MUTABLE=28, CONSTANT=29, 
		STRUCT=30, SINGLETON=31, RETURN=32, STATIC_KEYWORD_NEW=33, STATIC_KEYWORD_INSTANCE=34, 
		STATIC_KEYWORD_DESTROY=35, TRUE=36, FALSE=37, TYPE_SPECIFIER=38, VERSION=39, 
		IDENTIFIER=40, WHITESPACE=41, NEWLINE=42;
	public static final int
		RULE_top = 0, RULE_topLevel = 1, RULE_version = 2, RULE_functionDefinition = 3, 
		RULE_structDefinition = 4, RULE_variableDefinition = 5, RULE_assignmentExpression = 6, 
		RULE_returnExpression = 7, RULE_expression = 8, RULE_equalityExpression = 9, 
		RULE_comparisonExpression = 10, RULE_termExpression = 11, RULE_factorExpression = 12, 
		RULE_unaryExpression = 13, RULE_primaryExpression = 14, RULE_parameterList = 15, 
		RULE_type = 16, RULE_pointerType = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"top", "topLevel", "version", "functionDefinition", "structDefinition", 
			"variableDefinition", "assignmentExpression", "returnExpression", "expression", 
			"equalityExpression", "comparisonExpression", "termExpression", "factorExpression", 
			"unaryExpression", "primaryExpression", "parameterList", "type", "pointerType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "','", "'.'", "'/'", "'+'", "'-'", 
			"'!'", "'*'", "'...'", null, null, null, null, null, null, null, null, 
			null, null, null, "';'", null, "'funct'", "'define'", "'mutable'", "'constant'", 
			"'type'", "'singleton'", "'return'", "'::new'", "'::instance()'", "'::destroy()'", 
			"'true'", "'false'", "':'", "'VERSION'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "ARGUMENT_SEPARATOR", 
			"MEMBER_REFERENCE", "DIV", "ADD", "SUB", "NOT", "ASTERISK", "VARARG", 
			"ASSIGNMENT", "COMPARISON_EQUALS", "COMPARISON_NOT_EQUALS", "COMPARISON_GREATER", 
			"COMPARISON_GREATER_THAN", "COMPARISON_LESS", "COMPARISON_LESS_THAN", 
			"STRING_LITERAL", "COMMENT", "DOCUMENTATION_COMMENT", "SECTION_COMMENT", 
			"TERMINATION", "NUMBER", "FUNCTION", "VARIABLE", "MUTABLE", "CONSTANT", 
			"STRUCT", "SINGLETON", "RETURN", "STATIC_KEYWORD_NEW", "STATIC_KEYWORD_INSTANCE", 
			"STATIC_KEYWORD_DESTROY", "TRUE", "FALSE", "TYPE_SPECIFIER", "VERSION", 
			"IDENTIFIER", "WHITESPACE", "NEWLINE"
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
	public String getGrammarFileName() { return "Main.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MainParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TopContext extends ParserRuleContext {
		public VersionContext version() {
			return getRuleContext(VersionContext.class,0);
		}
		public List<TopLevelContext> topLevel() {
			return getRuleContexts(TopLevelContext.class);
		}
		public TopLevelContext topLevel(int i) {
			return getRuleContext(TopLevelContext.class,i);
		}
		public TopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_top; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterTop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitTop(this);
		}
	}

	public final TopContext top() throws RecognitionException {
		TopContext _localctx = new TopContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_top);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			version();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION || _la==STRUCT) {
				{
				{
				setState(37);
				topLevel();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TopLevelContext extends ParserRuleContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public StructDefinitionContext structDefinition() {
			return getRuleContext(StructDefinitionContext.class,0);
		}
		public TopLevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterTopLevel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitTopLevel(this);
		}
	}

	public final TopLevelContext topLevel() throws RecognitionException {
		TopLevelContext _localctx = new TopLevelContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevel);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				functionDefinition();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				structDefinition();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VersionContext extends ParserRuleContext {
		public TerminalNode VERSION() { return getToken(MainParser.VERSION, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(MainParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(MainParser.NUMBER, i);
		}
		public VersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_version; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterVersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitVersion(this);
		}
	}

	public final VersionContext version() throws RecognitionException {
		VersionContext _localctx = new VersionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_version);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(VERSION);
			setState(48);
			match(NUMBER);
			setState(49);
			match(NUMBER);
			setState(50);
			match(NUMBER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MainParser.FUNCTION, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MainParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(MainParser.OPEN_PAREN, 0); }
		public TerminalNode CLOSE_PAREN() { return getToken(MainParser.CLOSE_PAREN, 0); }
		public TerminalNode TYPE_SPECIFIER() { return getToken(MainParser.TYPE_SPECIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode TERMINATION() { return getToken(MainParser.TERMINATION, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(MainParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(MainParser.CLOSE_BRACE, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<AssignmentExpressionContext> assignmentExpression() {
			return getRuleContexts(AssignmentExpressionContext.class);
		}
		public AssignmentExpressionContext assignmentExpression(int i) {
			return getRuleContext(AssignmentExpressionContext.class,i);
		}
		public List<ReturnExpressionContext> returnExpression() {
			return getRuleContexts(ReturnExpressionContext.class);
		}
		public ReturnExpressionContext returnExpression(int i) {
			return getRuleContext(ReturnExpressionContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitFunctionDefinition(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(FUNCTION);
			setState(53);
			match(IDENTIFIER);
			setState(54);
			match(OPEN_PAREN);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(55);
				parameterList();
				}
			}

			setState(58);
			match(CLOSE_PAREN);
			setState(59);
			match(TYPE_SPECIFIER);
			setState(60);
			type();
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERMINATION:
				{
				setState(61);
				match(TERMINATION);
				}
				break;
			case OPEN_BRACE:
				{
				setState(62);
				match(OPEN_BRACE);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1103940812800L) != 0)) {
					{
					setState(66);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case VARIABLE:
						{
						setState(63);
						variableDefinition();
						}
						break;
					case IDENTIFIER:
						{
						setState(64);
						assignmentExpression();
						}
						break;
					case RETURN:
						{
						setState(65);
						returnExpression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71);
				match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StructDefinitionContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(MainParser.STRUCT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MainParser.IDENTIFIER, 0); }
		public TerminalNode TERMINATION() { return getToken(MainParser.TERMINATION, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(MainParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(MainParser.CLOSE_BRACE, 0); }
		public List<VariableDefinitionContext> variableDefinition() {
			return getRuleContexts(VariableDefinitionContext.class);
		}
		public VariableDefinitionContext variableDefinition(int i) {
			return getRuleContext(VariableDefinitionContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public StructDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterStructDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitStructDefinition(this);
		}
	}

	public final StructDefinitionContext structDefinition() throws RecognitionException {
		StructDefinitionContext _localctx = new StructDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_structDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(STRUCT);
			setState(75);
			match(IDENTIFIER);
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERMINATION:
				{
				setState(76);
				match(TERMINATION);
				}
				break;
			case OPEN_BRACE:
				{
				setState(77);
				match(OPEN_BRACE);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FUNCTION || _la==VARIABLE) {
					{
					setState(80);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case VARIABLE:
						{
						setState(78);
						variableDefinition();
						}
						break;
					case FUNCTION:
						{
						setState(79);
						functionDefinition();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(85);
				match(CLOSE_BRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDefinitionContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(MainParser.VARIABLE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MainParser.IDENTIFIER, 0); }
		public TerminalNode TYPE_SPECIFIER() { return getToken(MainParser.TYPE_SPECIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(MainParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode TERMINATION() { return getToken(MainParser.TERMINATION, 0); }
		public TerminalNode MUTABLE() { return getToken(MainParser.MUTABLE, 0); }
		public VariableDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterVariableDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitVariableDefinition(this);
		}
	}

	public final VariableDefinitionContext variableDefinition() throws RecognitionException {
		VariableDefinitionContext _localctx = new VariableDefinitionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(VARIABLE);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUTABLE) {
				{
				setState(89);
				match(MUTABLE);
				}
			}

			setState(92);
			match(IDENTIFIER);
			setState(93);
			match(TYPE_SPECIFIER);
			setState(94);
			type();
			setState(95);
			match(ASSIGNMENT);
			setState(96);
			expression();
			setState(97);
			match(TERMINATION);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MainParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(MainParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode TERMINATION() { return getToken(MainParser.TERMINATION, 0); }
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitAssignmentExpression(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignmentExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(IDENTIFIER);
			setState(100);
			match(ASSIGNMENT);
			setState(101);
			expression();
			setState(102);
			match(TERMINATION);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnExpressionContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MainParser.RETURN, 0); }
		public TerminalNode TERMINATION() { return getToken(MainParser.TERMINATION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterReturnExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitReturnExpression(this);
		}
	}

	public final ReturnExpressionContext returnExpression() throws RecognitionException {
		ReturnExpressionContext _localctx = new ReturnExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(RETURN);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1305704662530L) != 0)) {
				{
				setState(105);
				expression();
				}
			}

			setState(108);
			match(TERMINATION);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			equalityExpression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ParserRuleContext {
		public List<ComparisonExpressionContext> comparisonExpression() {
			return getRuleContexts(ComparisonExpressionContext.class);
		}
		public ComparisonExpressionContext comparisonExpression(int i) {
			return getRuleContext(ComparisonExpressionContext.class,i);
		}
		public List<TerminalNode> COMPARISON_NOT_EQUALS() { return getTokens(MainParser.COMPARISON_NOT_EQUALS); }
		public TerminalNode COMPARISON_NOT_EQUALS(int i) {
			return getToken(MainParser.COMPARISON_NOT_EQUALS, i);
		}
		public List<TerminalNode> COMPARISON_EQUALS() { return getTokens(MainParser.COMPARISON_EQUALS); }
		public TerminalNode COMPARISON_EQUALS(int i) {
			return getToken(MainParser.COMPARISON_EQUALS, i);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitEqualityExpression(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_equalityExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			comparisonExpression();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPARISON_EQUALS || _la==COMPARISON_NOT_EQUALS) {
				{
				{
				setState(113);
				_la = _input.LA(1);
				if ( !(_la==COMPARISON_EQUALS || _la==COMPARISON_NOT_EQUALS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(114);
				comparisonExpression();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ParserRuleContext {
		public List<TermExpressionContext> termExpression() {
			return getRuleContexts(TermExpressionContext.class);
		}
		public TermExpressionContext termExpression(int i) {
			return getRuleContext(TermExpressionContext.class,i);
		}
		public List<TerminalNode> COMPARISON_GREATER() { return getTokens(MainParser.COMPARISON_GREATER); }
		public TerminalNode COMPARISON_GREATER(int i) {
			return getToken(MainParser.COMPARISON_GREATER, i);
		}
		public List<TerminalNode> COMPARISON_GREATER_THAN() { return getTokens(MainParser.COMPARISON_GREATER_THAN); }
		public TerminalNode COMPARISON_GREATER_THAN(int i) {
			return getToken(MainParser.COMPARISON_GREATER_THAN, i);
		}
		public List<TerminalNode> COMPARISON_LESS() { return getTokens(MainParser.COMPARISON_LESS); }
		public TerminalNode COMPARISON_LESS(int i) {
			return getToken(MainParser.COMPARISON_LESS, i);
		}
		public List<TerminalNode> COMPARISON_LESS_THAN() { return getTokens(MainParser.COMPARISON_LESS_THAN); }
		public TerminalNode COMPARISON_LESS_THAN(int i) {
			return getToken(MainParser.COMPARISON_LESS_THAN, i);
		}
		public ComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitComparisonExpression(this);
		}
	}

	public final ComparisonExpressionContext comparisonExpression() throws RecognitionException {
		ComparisonExpressionContext _localctx = new ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comparisonExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			termExpression();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) {
				{
				{
				setState(121);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(122);
				termExpression();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermExpressionContext extends ParserRuleContext {
		public List<FactorExpressionContext> factorExpression() {
			return getRuleContexts(FactorExpressionContext.class);
		}
		public FactorExpressionContext factorExpression(int i) {
			return getRuleContext(FactorExpressionContext.class,i);
		}
		public List<TerminalNode> SUB() { return getTokens(MainParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(MainParser.SUB, i);
		}
		public List<TerminalNode> ADD() { return getTokens(MainParser.ADD); }
		public TerminalNode ADD(int i) {
			return getToken(MainParser.ADD, i);
		}
		public TermExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterTermExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitTermExpression(this);
		}
	}

	public final TermExpressionContext termExpression() throws RecognitionException {
		TermExpressionContext _localctx = new TermExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			factorExpression();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(129);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(130);
				factorExpression();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FactorExpressionContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public List<TerminalNode> DIV() { return getTokens(MainParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(MainParser.DIV, i);
		}
		public List<TerminalNode> ASTERISK() { return getTokens(MainParser.ASTERISK); }
		public TerminalNode ASTERISK(int i) {
			return getToken(MainParser.ASTERISK, i);
		}
		public FactorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterFactorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitFactorExpression(this);
		}
	}

	public final FactorExpressionContext factorExpression() throws RecognitionException {
		FactorExpressionContext _localctx = new FactorExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_factorExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			unaryExpression();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIV || _la==ASTERISK) {
				{
				{
				setState(137);
				_la = _input.LA(1);
				if ( !(_la==DIV || _la==ASTERISK) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(138);
				unaryExpression();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(MainParser.NOT, 0); }
		public TerminalNode SUB() { return getToken(MainParser.SUB, 0); }
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unaryExpression);
		int _la;
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(145);
				unaryExpression();
				}
				break;
			case OPEN_PAREN:
			case STRING_LITERAL:
			case NUMBER:
			case TRUE:
			case FALSE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				primaryExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(MainParser.NUMBER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(MainParser.STRING_LITERAL, 0); }
		public TerminalNode TRUE() { return getToken(MainParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MainParser.FALSE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MainParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PAREN() { return getToken(MainParser.OPEN_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(MainParser.CLOSE_PAREN, 0); }
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitPrimaryExpression(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_primaryExpression);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(NUMBER);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(STRING_LITERAL);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(152);
				match(FALSE);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(153);
				match(IDENTIFIER);
				}
				break;
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(154);
				match(OPEN_PAREN);
				setState(155);
				expression();
				setState(156);
				match(CLOSE_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(MainParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MainParser.IDENTIFIER, i);
		}
		public List<TerminalNode> TYPE_SPECIFIER() { return getTokens(MainParser.TYPE_SPECIFIER); }
		public TerminalNode TYPE_SPECIFIER(int i) {
			return getToken(MainParser.TYPE_SPECIFIER, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ARGUMENT_SEPARATOR() { return getTokens(MainParser.ARGUMENT_SEPARATOR); }
		public TerminalNode ARGUMENT_SEPARATOR(int i) {
			return getToken(MainParser.ARGUMENT_SEPARATOR, i);
		}
		public TerminalNode VARARG() { return getToken(MainParser.VARARG, 0); }
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitParameterList(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parameterList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(IDENTIFIER);
			setState(161);
			match(TYPE_SPECIFIER);
			setState(162);
			type();
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(163);
					match(ARGUMENT_SEPARATOR);
					setState(164);
					match(IDENTIFIER);
					setState(165);
					match(TYPE_SPECIFIER);
					setState(166);
					type();
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARGUMENT_SEPARATOR) {
				{
				setState(172);
				match(ARGUMENT_SEPARATOR);
				setState(173);
				match(IDENTIFIER);
				setState(174);
				match(TYPE_SPECIFIER);
				setState(175);
				match(VARARG);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MainParser.IDENTIFIER, 0); }
		public PointerTypeContext pointerType() {
			return getRuleContext(PointerTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(IDENTIFIER);
				}
				break;
			case ASTERISK:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				pointerType();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PointerTypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MainParser.IDENTIFIER, 0); }
		public List<TerminalNode> ASTERISK() { return getTokens(MainParser.ASTERISK); }
		public TerminalNode ASTERISK(int i) {
			return getToken(MainParser.ASTERISK, i);
		}
		public PointerTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterPointerType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitPointerType(this);
		}
	}

	public final PointerTypeContext pointerType() throws RecognitionException {
		PointerTypeContext _localctx = new PointerTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_pointerType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(182);
				match(ASTERISK);
				}
				}
				setState(185); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ASTERISK );
			setState(187);
			match(IDENTIFIER);
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

	public static final String _serializedATN =
		"\u0004\u0001*\u00be\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\'\b\u0000\n\u0000\f\u0000*\t\u0000\u0001\u0001\u0001\u0001"+
		"\u0003\u0001.\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"9\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003C\b\u0003\n\u0003\f\u0003"+
		"F\t\u0003\u0001\u0003\u0003\u0003I\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004Q\b\u0004\n\u0004"+
		"\f\u0004T\t\u0004\u0001\u0004\u0003\u0004W\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0003\u0005[\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007k\b\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005"+
		"\tt\b\t\n\t\f\tw\t\t\u0001\n\u0001\n\u0001\n\u0005\n|\b\n\n\n\f\n\u007f"+
		"\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0084\b\u000b\n\u000b"+
		"\f\u000b\u0087\t\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u008c\b\f\n\f\f"+
		"\f\u008f\t\f\u0001\r\u0001\r\u0001\r\u0003\r\u0094\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u009f\b\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00a8"+
		"\b\u000f\n\u000f\f\u000f\u00ab\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00b1\b\u000f\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u00b5\b\u0010\u0001\u0011\u0004\u0011\u00b8\b\u0011\u000b\u0011\f\u0011"+
		"\u00b9\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"\u0000\u0005\u0001\u0000\u000e\u000f\u0001\u0000\u0010\u0013\u0001"+
		"\u0000\b\t\u0002\u0000\u0007\u0007\u000b\u000b\u0001\u0000\t\n\u00c5\u0000"+
		"$\u0001\u0000\u0000\u0000\u0002-\u0001\u0000\u0000\u0000\u0004/\u0001"+
		"\u0000\u0000\u0000\u00064\u0001\u0000\u0000\u0000\bJ\u0001\u0000\u0000"+
		"\u0000\nX\u0001\u0000\u0000\u0000\fc\u0001\u0000\u0000\u0000\u000eh\u0001"+
		"\u0000\u0000\u0000\u0010n\u0001\u0000\u0000\u0000\u0012p\u0001\u0000\u0000"+
		"\u0000\u0014x\u0001\u0000\u0000\u0000\u0016\u0080\u0001\u0000\u0000\u0000"+
		"\u0018\u0088\u0001\u0000\u0000\u0000\u001a\u0093\u0001\u0000\u0000\u0000"+
		"\u001c\u009e\u0001\u0000\u0000\u0000\u001e\u00a0\u0001\u0000\u0000\u0000"+
		" \u00b4\u0001\u0000\u0000\u0000\"\u00b7\u0001\u0000\u0000\u0000$(\u0003"+
		"\u0004\u0002\u0000%\'\u0003\u0002\u0001\u0000&%\u0001\u0000\u0000\u0000"+
		"\'*\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000"+
		"\u0000)\u0001\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000+.\u0003"+
		"\u0006\u0003\u0000,.\u0003\b\u0004\u0000-+\u0001\u0000\u0000\u0000-,\u0001"+
		"\u0000\u0000\u0000.\u0003\u0001\u0000\u0000\u0000/0\u0005\'\u0000\u0000"+
		"01\u0005\u0019\u0000\u000012\u0005\u0019\u0000\u000023\u0005\u0019\u0000"+
		"\u00003\u0005\u0001\u0000\u0000\u000045\u0005\u001a\u0000\u000056\u0005"+
		"(\u0000\u000068\u0005\u0001\u0000\u000079\u0003\u001e\u000f\u000087\u0001"+
		"\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000"+
		":;\u0005\u0002\u0000\u0000;<\u0005&\u0000\u0000<H\u0003 \u0010\u0000="+
		"I\u0005\u0018\u0000\u0000>D\u0005\u0003\u0000\u0000?C\u0003\n\u0005\u0000"+
		"@C\u0003\f\u0006\u0000AC\u0003\u000e\u0007\u0000B?\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000GI\u0005\u0004\u0000\u0000H=\u0001"+
		"\u0000\u0000\u0000H>\u0001\u0000\u0000\u0000I\u0007\u0001\u0000\u0000"+
		"\u0000JK\u0005\u001e\u0000\u0000KV\u0005(\u0000\u0000LW\u0005\u0018\u0000"+
		"\u0000MR\u0005\u0003\u0000\u0000NQ\u0003\n\u0005\u0000OQ\u0003\u0006\u0003"+
		"\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000"+
		"\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0001"+
		"\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UW\u0005\u0004\u0000\u0000"+
		"VL\u0001\u0000\u0000\u0000VM\u0001\u0000\u0000\u0000W\t\u0001\u0000\u0000"+
		"\u0000XZ\u0005\u001b\u0000\u0000Y[\u0005\u001c\u0000\u0000ZY\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0005"+
		"(\u0000\u0000]^\u0005&\u0000\u0000^_\u0003 \u0010\u0000_`\u0005\r\u0000"+
		"\u0000`a\u0003\u0010\b\u0000ab\u0005\u0018\u0000\u0000b\u000b\u0001\u0000"+
		"\u0000\u0000cd\u0005(\u0000\u0000de\u0005\r\u0000\u0000ef\u0003\u0010"+
		"\b\u0000fg\u0005\u0018\u0000\u0000g\r\u0001\u0000\u0000\u0000hj\u0005"+
		" \u0000\u0000ik\u0003\u0010\b\u0000ji\u0001\u0000\u0000\u0000jk\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0005\u0018\u0000\u0000"+
		"m\u000f\u0001\u0000\u0000\u0000no\u0003\u0012\t\u0000o\u0011\u0001\u0000"+
		"\u0000\u0000pu\u0003\u0014\n\u0000qr\u0007\u0000\u0000\u0000rt\u0003\u0014"+
		"\n\u0000sq\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000uv\u0001\u0000\u0000\u0000v\u0013\u0001\u0000\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000x}\u0003\u0016\u000b\u0000yz\u0007\u0001\u0000"+
		"\u0000z|\u0003\u0016\u000b\u0000{y\u0001\u0000\u0000\u0000|\u007f\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u0015\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0085"+
		"\u0003\u0018\f\u0000\u0081\u0082\u0007\u0002\u0000\u0000\u0082\u0084\u0003"+
		"\u0018\f\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000"+
		"\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0017\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000"+
		"\u0000\u0000\u0088\u008d\u0003\u001a\r\u0000\u0089\u008a\u0007\u0003\u0000"+
		"\u0000\u008a\u008c\u0003\u001a\r\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0019\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0007\u0004\u0000\u0000"+
		"\u0091\u0094\u0003\u001a\r\u0000\u0092\u0094\u0003\u001c\u000e\u0000\u0093"+
		"\u0090\u0001\u0000\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094"+
		"\u001b\u0001\u0000\u0000\u0000\u0095\u009f\u0005\u0019\u0000\u0000\u0096"+
		"\u009f\u0005\u0014\u0000\u0000\u0097\u009f\u0005$\u0000\u0000\u0098\u009f"+
		"\u0005%\u0000\u0000\u0099\u009f\u0005(\u0000\u0000\u009a\u009b\u0005\u0001"+
		"\u0000\u0000\u009b\u009c\u0003\u0010\b\u0000\u009c\u009d\u0005\u0002\u0000"+
		"\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e\u0095\u0001\u0000\u0000"+
		"\u0000\u009e\u0096\u0001\u0000\u0000\u0000\u009e\u0097\u0001\u0000\u0000"+
		"\u0000\u009e\u0098\u0001\u0000\u0000\u0000\u009e\u0099\u0001\u0000\u0000"+
		"\u0000\u009e\u009a\u0001\u0000\u0000\u0000\u009f\u001d\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0005(\u0000\u0000\u00a1\u00a2\u0005&\u0000\u0000\u00a2"+
		"\u00a9\u0003 \u0010\u0000\u00a3\u00a4\u0005\u0005\u0000\u0000\u00a4\u00a5"+
		"\u0005(\u0000\u0000\u00a5\u00a6\u0005&\u0000\u0000\u00a6\u00a8\u0003 "+
		"\u0010\u0000\u00a7\u00a3\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000"+
		"\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\u00b0\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0005\u0005\u0000\u0000\u00ad\u00ae\u0005(\u0000"+
		"\u0000\u00ae\u00af\u0005&\u0000\u0000\u00af\u00b1\u0005\f\u0000\u0000"+
		"\u00b0\u00ac\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u001f\u0001\u0000\u0000\u0000\u00b2\u00b5\u0005(\u0000\u0000\u00b3"+
		"\u00b5\u0003\"\u0011\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b5!\u0001\u0000\u0000\u0000\u00b6\u00b8\u0005"+
		"\u000b\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005"+
		"(\u0000\u0000\u00bc#\u0001\u0000\u0000\u0000\u0015(-8BDHPRVZju}\u0085"+
		"\u008d\u0093\u009e\u00a9\u00b0\u00b4\u00b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}