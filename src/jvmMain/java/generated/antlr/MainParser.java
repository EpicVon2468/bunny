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
		RULE_identifierWithType = 16, RULE_identifierWithVararg = 17, RULE_type = 18, 
		RULE_pointerType = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"top", "topLevel", "version", "functionDefinition", "structDefinition", 
			"variableDefinition", "assignmentExpression", "returnExpression", "expression", 
			"equalityExpression", "comparisonExpression", "termExpression", "factorExpression", 
			"unaryExpression", "primaryExpression", "parameterList", "identifierWithType", 
			"identifierWithVararg", "type", "pointerType"
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
			setState(40);
			version();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION || _la==STRUCT) {
				{
				{
				setState(41);
				topLevel();
				}
				}
				setState(46);
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
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				functionDefinition();
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
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
			setState(51);
			match(VERSION);
			setState(52);
			match(NUMBER);
			setState(53);
			match(NUMBER);
			setState(54);
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
		public TerminalNode TERMINATION() { return getToken(MainParser.TERMINATION, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(MainParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(MainParser.CLOSE_BRACE, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode TYPE_SPECIFIER() { return getToken(MainParser.TYPE_SPECIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
			setState(56);
			match(FUNCTION);
			setState(57);
			match(IDENTIFIER);
			setState(58);
			match(OPEN_PAREN);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(59);
				parameterList();
				}
			}

			setState(62);
			match(CLOSE_PAREN);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_SPECIFIER) {
				{
				setState(63);
				match(TYPE_SPECIFIER);
				setState(64);
				type();
				}
			}

			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERMINATION:
				{
				setState(67);
				match(TERMINATION);
				}
				break;
			case OPEN_BRACE:
				{
				setState(68);
				match(OPEN_BRACE);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1103940812800L) != 0)) {
					{
					setState(72);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case VARIABLE:
						{
						setState(69);
						variableDefinition();
						}
						break;
					case IDENTIFIER:
						{
						setState(70);
						assignmentExpression();
						}
						break;
					case RETURN:
						{
						setState(71);
						returnExpression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(77);
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
			setState(80);
			match(STRUCT);
			setState(81);
			match(IDENTIFIER);
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERMINATION:
				{
				setState(82);
				match(TERMINATION);
				}
				break;
			case OPEN_BRACE:
				{
				setState(83);
				match(OPEN_BRACE);
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FUNCTION || _la==VARIABLE) {
					{
					setState(86);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case VARIABLE:
						{
						setState(84);
						variableDefinition();
						}
						break;
					case FUNCTION:
						{
						setState(85);
						functionDefinition();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(91);
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
		public IdentifierWithTypeContext identifierWithType() {
			return getRuleContext(IdentifierWithTypeContext.class,0);
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
			setState(94);
			match(VARIABLE);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUTABLE) {
				{
				setState(95);
				match(MUTABLE);
				}
			}

			setState(98);
			identifierWithType();
			setState(99);
			match(ASSIGNMENT);
			setState(100);
			expression();
			setState(101);
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
			setState(103);
			match(IDENTIFIER);
			setState(104);
			match(ASSIGNMENT);
			setState(105);
			expression();
			setState(106);
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
			setState(108);
			match(RETURN);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1305704662530L) != 0)) {
				{
				setState(109);
				expression();
				}
			}

			setState(112);
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
			setState(114);
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
			setState(116);
			comparisonExpression();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMPARISON_EQUALS || _la==COMPARISON_NOT_EQUALS) {
				{
				{
				setState(117);
				_la = _input.LA(1);
				if ( !(_la==COMPARISON_EQUALS || _la==COMPARISON_NOT_EQUALS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(118);
				comparisonExpression();
				}
				}
				setState(123);
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
			setState(124);
			termExpression();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) {
				{
				{
				setState(125);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 983040L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(126);
				termExpression();
				}
				}
				setState(131);
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
			setState(132);
			factorExpression();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(133);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(134);
				factorExpression();
				}
				}
				setState(139);
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
			setState(140);
			unaryExpression();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIV || _la==ASTERISK) {
				{
				{
				setState(141);
				_la = _input.LA(1);
				if ( !(_la==DIV || _la==ASTERISK) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(142);
				unaryExpression();
				}
				}
				setState(147);
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
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUB:
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==NOT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(149);
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
				setState(150);
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
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(NUMBER);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(STRING_LITERAL);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(155);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(156);
				match(FALSE);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(157);
				match(IDENTIFIER);
				}
				break;
			case OPEN_PAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(158);
				match(OPEN_PAREN);
				setState(159);
				expression();
				setState(160);
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
		public List<IdentifierWithTypeContext> identifierWithType() {
			return getRuleContexts(IdentifierWithTypeContext.class);
		}
		public IdentifierWithTypeContext identifierWithType(int i) {
			return getRuleContext(IdentifierWithTypeContext.class,i);
		}
		public List<TerminalNode> ARGUMENT_SEPARATOR() { return getTokens(MainParser.ARGUMENT_SEPARATOR); }
		public TerminalNode ARGUMENT_SEPARATOR(int i) {
			return getToken(MainParser.ARGUMENT_SEPARATOR, i);
		}
		public IdentifierWithVarargContext identifierWithVararg() {
			return getRuleContext(IdentifierWithVarargContext.class,0);
		}
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
			setState(177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(164);
				identifierWithType();
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(165);
						match(ARGUMENT_SEPARATOR);
						setState(166);
						identifierWithType();
						}
						} 
					}
					setState(171);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ARGUMENT_SEPARATOR) {
					{
					setState(172);
					match(ARGUMENT_SEPARATOR);
					setState(173);
					identifierWithVararg();
					}
				}

				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				identifierWithVararg();
				}
				break;
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
	public static class IdentifierWithTypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MainParser.IDENTIFIER, 0); }
		public TerminalNode TYPE_SPECIFIER() { return getToken(MainParser.TYPE_SPECIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierWithTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierWithType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterIdentifierWithType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitIdentifierWithType(this);
		}
	}

	public final IdentifierWithTypeContext identifierWithType() throws RecognitionException {
		IdentifierWithTypeContext _localctx = new IdentifierWithTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_identifierWithType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(IDENTIFIER);
			setState(180);
			match(TYPE_SPECIFIER);
			setState(181);
			type();
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
	public static class IdentifierWithVarargContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MainParser.IDENTIFIER, 0); }
		public TerminalNode TYPE_SPECIFIER() { return getToken(MainParser.TYPE_SPECIFIER, 0); }
		public TerminalNode VARARG() { return getToken(MainParser.VARARG, 0); }
		public IdentifierWithVarargContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierWithVararg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterIdentifierWithVararg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitIdentifierWithVararg(this);
		}
	}

	public final IdentifierWithVarargContext identifierWithVararg() throws RecognitionException {
		IdentifierWithVarargContext _localctx = new IdentifierWithVarargContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_identifierWithVararg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(IDENTIFIER);
			setState(184);
			match(TYPE_SPECIFIER);
			setState(185);
			match(VARARG);
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
		enterRule(_localctx, 36, RULE_type);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(IDENTIFIER);
				}
				break;
			case ASTERISK:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
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
		enterRule(_localctx, 38, RULE_pointerType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(191);
				match(ASTERISK);
				}
				}
				setState(194); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ASTERISK );
			setState(196);
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
		"\u0004\u0001*\u00c7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0005\u0000+\b\u0000"+
		"\n\u0000\f\u0000.\t\u0000\u0001\u0001\u0001\u0001\u0003\u00012\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003=\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003B\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003I\b\u0003\n\u0003\f\u0003"+
		"L\t\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004W\b\u0004\n\u0004"+
		"\f\u0004Z\t\u0004\u0001\u0004\u0003\u0004]\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0003\u0005a\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0003\u0007o\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\tx\b\t\n\t\f\t{\t\t\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u0080\b\n\n\n\f\n\u0083\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u0088\b\u000b\n\u000b\f\u000b\u008b\t\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u0090\b\f\n\f\f\f\u0093\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u0098\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00a3\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00a8"+
		"\b\u000f\n\u000f\f\u000f\u00ab\t\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00af\b\u000f\u0001\u000f\u0003\u000f\u00b2\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u00be\b\u0012\u0001\u0013\u0004"+
		"\u0013\u00c1\b\u0013\u000b\u0013\f\u0013\u00c2\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000\u0005\u0001\u0000"+
		"\u000e\u000f\u0001\u0000\u0010\u0013\u0001\u0000\b\t\u0002\u0000\u0007"+
		"\u0007\u000b\u000b\u0001\u0000\t\n\u00ce\u0000(\u0001\u0000\u0000\u0000"+
		"\u00021\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u00068"+
		"\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\n^\u0001\u0000\u0000"+
		"\u0000\fg\u0001\u0000\u0000\u0000\u000el\u0001\u0000\u0000\u0000\u0010"+
		"r\u0001\u0000\u0000\u0000\u0012t\u0001\u0000\u0000\u0000\u0014|\u0001"+
		"\u0000\u0000\u0000\u0016\u0084\u0001\u0000\u0000\u0000\u0018\u008c\u0001"+
		"\u0000\u0000\u0000\u001a\u0097\u0001\u0000\u0000\u0000\u001c\u00a2\u0001"+
		"\u0000\u0000\u0000\u001e\u00b1\u0001\u0000\u0000\u0000 \u00b3\u0001\u0000"+
		"\u0000\u0000\"\u00b7\u0001\u0000\u0000\u0000$\u00bd\u0001\u0000\u0000"+
		"\u0000&\u00c0\u0001\u0000\u0000\u0000(,\u0003\u0004\u0002\u0000)+\u0003"+
		"\u0002\u0001\u0000*)\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000"+
		",*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-\u0001\u0001\u0000"+
		"\u0000\u0000.,\u0001\u0000\u0000\u0000/2\u0003\u0006\u0003\u000002\u0003"+
		"\b\u0004\u00001/\u0001\u0000\u0000\u000010\u0001\u0000\u0000\u00002\u0003"+
		"\u0001\u0000\u0000\u000034\u0005\'\u0000\u000045\u0005\u0019\u0000\u0000"+
		"56\u0005\u0019\u0000\u000067\u0005\u0019\u0000\u00007\u0005\u0001\u0000"+
		"\u0000\u000089\u0005\u001a\u0000\u00009:\u0005(\u0000\u0000:<\u0005\u0001"+
		"\u0000\u0000;=\u0003\u001e\u000f\u0000<;\u0001\u0000\u0000\u0000<=\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>A\u0005\u0002\u0000\u0000"+
		"?@\u0005&\u0000\u0000@B\u0003$\u0012\u0000A?\u0001\u0000\u0000\u0000A"+
		"B\u0001\u0000\u0000\u0000BN\u0001\u0000\u0000\u0000CO\u0005\u0018\u0000"+
		"\u0000DJ\u0005\u0003\u0000\u0000EI\u0003\n\u0005\u0000FI\u0003\f\u0006"+
		"\u0000GI\u0003\u000e\u0007\u0000HE\u0001\u0000\u0000\u0000HF\u0001\u0000"+
		"\u0000\u0000HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000"+
		"LJ\u0001\u0000\u0000\u0000MO\u0005\u0004\u0000\u0000NC\u0001\u0000\u0000"+
		"\u0000ND\u0001\u0000\u0000\u0000O\u0007\u0001\u0000\u0000\u0000PQ\u0005"+
		"\u001e\u0000\u0000Q\\\u0005(\u0000\u0000R]\u0005\u0018\u0000\u0000SX\u0005"+
		"\u0003\u0000\u0000TW\u0003\n\u0005\u0000UW\u0003\u0006\u0003\u0000VT\u0001"+
		"\u0000\u0000\u0000VU\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000"+
		"XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000[]\u0005\u0004\u0000\u0000\\R\u0001\u0000"+
		"\u0000\u0000\\S\u0001\u0000\u0000\u0000]\t\u0001\u0000\u0000\u0000^`\u0005"+
		"\u001b\u0000\u0000_a\u0005\u001c\u0000\u0000`_\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0003 \u0010\u0000"+
		"cd\u0005\r\u0000\u0000de\u0003\u0010\b\u0000ef\u0005\u0018\u0000\u0000"+
		"f\u000b\u0001\u0000\u0000\u0000gh\u0005(\u0000\u0000hi\u0005\r\u0000\u0000"+
		"ij\u0003\u0010\b\u0000jk\u0005\u0018\u0000\u0000k\r\u0001\u0000\u0000"+
		"\u0000ln\u0005 \u0000\u0000mo\u0003\u0010\b\u0000nm\u0001\u0000\u0000"+
		"\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0005\u0018"+
		"\u0000\u0000q\u000f\u0001\u0000\u0000\u0000rs\u0003\u0012\t\u0000s\u0011"+
		"\u0001\u0000\u0000\u0000ty\u0003\u0014\n\u0000uv\u0007\u0000\u0000\u0000"+
		"vx\u0003\u0014\n\u0000wu\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z\u0013\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000|\u0081\u0003\u0016\u000b\u0000"+
		"}~\u0007\u0001\u0000\u0000~\u0080\u0003\u0016\u000b\u0000\u007f}\u0001"+
		"\u0000\u0000\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0015\u0001"+
		"\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0089\u0003"+
		"\u0018\f\u0000\u0085\u0086\u0007\u0002\u0000\u0000\u0086\u0088\u0003\u0018"+
		"\f\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000"+
		"\u0000\u008a\u0017\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000"+
		"\u0000\u008c\u0091\u0003\u001a\r\u0000\u008d\u008e\u0007\u0003\u0000\u0000"+
		"\u008e\u0090\u0003\u001a\r\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090"+
		"\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u0019\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0007\u0004\u0000\u0000\u0095"+
		"\u0098\u0003\u001a\r\u0000\u0096\u0098\u0003\u001c\u000e\u0000\u0097\u0094"+
		"\u0001\u0000\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u001b"+
		"\u0001\u0000\u0000\u0000\u0099\u00a3\u0005\u0019\u0000\u0000\u009a\u00a3"+
		"\u0005\u0014\u0000\u0000\u009b\u00a3\u0005$\u0000\u0000\u009c\u00a3\u0005"+
		"%\u0000\u0000\u009d\u00a3\u0005(\u0000\u0000\u009e\u009f\u0005\u0001\u0000"+
		"\u0000\u009f\u00a0\u0003\u0010\b\u0000\u00a0\u00a1\u0005\u0002\u0000\u0000"+
		"\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2\u0099\u0001\u0000\u0000\u0000"+
		"\u00a2\u009a\u0001\u0000\u0000\u0000\u00a2\u009b\u0001\u0000\u0000\u0000"+
		"\u00a2\u009c\u0001\u0000\u0000\u0000\u00a2\u009d\u0001\u0000\u0000\u0000"+
		"\u00a2\u009e\u0001\u0000\u0000\u0000\u00a3\u001d\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a9\u0003 \u0010\u0000\u00a5\u00a6\u0005\u0005\u0000\u0000\u00a6"+
		"\u00a8\u0003 \u0010\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ae\u0001\u0000\u0000\u0000\u00ab\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\u0005\u0000\u0000\u00ad\u00af"+
		"\u0003\"\u0011\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001"+
		"\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00b2\u0003"+
		"\"\u0011\u0000\u00b1\u00a4\u0001\u0000\u0000\u0000\u00b1\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b2\u001f\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005(\u0000"+
		"\u0000\u00b4\u00b5\u0005&\u0000\u0000\u00b5\u00b6\u0003$\u0012\u0000\u00b6"+
		"!\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005(\u0000\u0000\u00b8\u00b9\u0005"+
		"&\u0000\u0000\u00b9\u00ba\u0005\f\u0000\u0000\u00ba#\u0001\u0000\u0000"+
		"\u0000\u00bb\u00be\u0005(\u0000\u0000\u00bc\u00be\u0003&\u0013\u0000\u00bd"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be"+
		"%\u0001\u0000\u0000\u0000\u00bf\u00c1\u0005\u000b\u0000\u0000\u00c0\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005(\u0000\u0000\u00c5\'\u0001"+
		"\u0000\u0000\u0000\u0017,1<AHJNVX\\`ny\u0081\u0089\u0091\u0097\u00a2\u00a9"+
		"\u00ae\u00b1\u00bd\u00c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}