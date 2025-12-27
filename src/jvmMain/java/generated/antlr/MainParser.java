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
		MEMBER_REFERENCE=6, DIV=7, ADD=8, SUB=9, ASTERISK=10, VARARG=11, ASSIGNMENT=12, 
		COMPARISON=13, STRING_LITERAL=14, COMMENT=15, DOCUMENTATION_COMMENT=16, 
		SECTION_COMMENT=17, TERMINATION=18, NUMBER=19, FUNCTION=20, VARIABLE=21, 
		MUTABLE=22, CONSTANT=23, STRUCT=24, SINGLETON=25, RETURN=26, STATIC_KEYWORD_NEW=27, 
		STATIC_KEYWORD_INSTANCE=28, STATIC_KEYWORD_DESTROY=29, TRUE=30, FALSE=31, 
		TYPE_SPECIFIER=32, IDENTIFIER=33, VERSION_DECLARATION=34, WHITESPACE=35, 
		NEWLINE=36;
	public static final int
		RULE_primary = 0, RULE_version = 1, RULE_functionDefinition = 2, RULE_typeDefinition = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"primary", "version", "functionDefinition", "typeDefinition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "','", "'.'", "'/'", "'+'", "'-'", 
			"'*'", "'...'", null, null, null, null, null, null, "';'", null, "'funct'", 
			"'define'", "'mutable'", "'constant'", "'type'", "'singleton'", "'return'", 
			"'::new'", "'::instance()'", "'::destroy()'", "'true'", "'false'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "ARGUMENT_SEPARATOR", 
			"MEMBER_REFERENCE", "DIV", "ADD", "SUB", "ASTERISK", "VARARG", "ASSIGNMENT", 
			"COMPARISON", "STRING_LITERAL", "COMMENT", "DOCUMENTATION_COMMENT", "SECTION_COMMENT", 
			"TERMINATION", "NUMBER", "FUNCTION", "VARIABLE", "MUTABLE", "CONSTANT", 
			"STRUCT", "SINGLETON", "RETURN", "STATIC_KEYWORD_NEW", "STATIC_KEYWORD_INSTANCE", 
			"STATIC_KEYWORD_DESTROY", "TRUE", "FALSE", "TYPE_SPECIFIER", "IDENTIFIER", 
			"VERSION_DECLARATION", "WHITESPACE", "NEWLINE"
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
	public static class PrimaryContext extends ParserRuleContext {
		public VersionContext version() {
			return getRuleContext(VersionContext.class,0);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public List<TypeDefinitionContext> typeDefinition() {
			return getRuleContexts(TypeDefinitionContext.class);
		}
		public TypeDefinitionContext typeDefinition(int i) {
			return getRuleContext(TypeDefinitionContext.class,i);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			version();
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION || _la==STRUCT) {
				{
				setState(11);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FUNCTION:
					{
					setState(9);
					functionDefinition();
					}
					break;
				case STRUCT:
					{
					setState(10);
					typeDefinition();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(15);
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
	public static class VersionContext extends ParserRuleContext {
		public TerminalNode VERSION_DECLARATION() { return getToken(MainParser.VERSION_DECLARATION, 0); }
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
		enterRule(_localctx, 2, RULE_version);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(VERSION_DECLARATION);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(MainParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(MainParser.IDENTIFIER, i);
		}
		public TerminalNode OPEN_PAREN() { return getToken(MainParser.OPEN_PAREN, 0); }
		public List<TerminalNode> TYPE_SPECIFIER() { return getTokens(MainParser.TYPE_SPECIFIER); }
		public TerminalNode TYPE_SPECIFIER(int i) {
			return getToken(MainParser.TYPE_SPECIFIER, i);
		}
		public TerminalNode CLOSE_PAREN() { return getToken(MainParser.CLOSE_PAREN, 0); }
		public TerminalNode TERMINATION() { return getToken(MainParser.TERMINATION, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(MainParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(MainParser.CLOSE_BRACE, 0); }
		public List<TerminalNode> ARGUMENT_SEPARATOR() { return getTokens(MainParser.ARGUMENT_SEPARATOR); }
		public TerminalNode ARGUMENT_SEPARATOR(int i) {
			return getToken(MainParser.ARGUMENT_SEPARATOR, i);
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
		enterRule(_localctx, 4, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(FUNCTION);
			setState(19);
			match(IDENTIFIER);
			setState(20);
			match(OPEN_PAREN);
			setState(21);
			match(IDENTIFIER);
			setState(22);
			match(TYPE_SPECIFIER);
			setState(23);
			match(IDENTIFIER);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ARGUMENT_SEPARATOR) {
				{
				{
				setState(24);
				match(ARGUMENT_SEPARATOR);
				setState(25);
				match(IDENTIFIER);
				setState(26);
				match(TYPE_SPECIFIER);
				setState(27);
				match(IDENTIFIER);
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(33);
			match(CLOSE_PAREN);
			setState(34);
			match(TYPE_SPECIFIER);
			setState(35);
			match(IDENTIFIER);
			setState(39);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TERMINATION:
				{
				setState(36);
				match(TERMINATION);
				}
				break;
			case OPEN_BRACE:
				{
				setState(37);
				match(OPEN_BRACE);
				setState(38);
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
	public static class TypeDefinitionContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(MainParser.STRUCT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MainParser.IDENTIFIER, 0); }
		public TerminalNode TERMINATION() { return getToken(MainParser.TERMINATION, 0); }
		public TypeDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).enterTypeDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MainListener ) ((MainListener)listener).exitTypeDefinition(this);
		}
	}

	public final TypeDefinitionContext typeDefinition() throws RecognitionException {
		TypeDefinitionContext _localctx = new TypeDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(STRUCT);
			setState(42);
			match(IDENTIFIER);
			setState(43);
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

	public static final String _serializedATN =
		"\u0004\u0001$.\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0005\u0000\f\b\u0000\n\u0000\f\u0000\u000f\t\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u001d"+
		"\b\u0002\n\u0002\f\u0002 \t\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002(\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0000\u0000\u0004\u0000"+
		"\u0002\u0004\u0006\u0000\u0000-\u0000\b\u0001\u0000\u0000\u0000\u0002"+
		"\u0010\u0001\u0000\u0000\u0000\u0004\u0012\u0001\u0000\u0000\u0000\u0006"+
		")\u0001\u0000\u0000\u0000\b\r\u0003\u0002\u0001\u0000\t\f\u0003\u0004"+
		"\u0002\u0000\n\f\u0003\u0006\u0003\u0000\u000b\t\u0001\u0000\u0000\u0000"+
		"\u000b\n\u0001\u0000\u0000\u0000\f\u000f\u0001\u0000\u0000\u0000\r\u000b"+
		"\u0001\u0000\u0000\u0000\r\u000e\u0001\u0000\u0000\u0000\u000e\u0001\u0001"+
		"\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u0010\u0011\u0005\""+
		"\u0000\u0000\u0011\u0003\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0014"+
		"\u0000\u0000\u0013\u0014\u0005!\u0000\u0000\u0014\u0015\u0005\u0001\u0000"+
		"\u0000\u0015\u0016\u0005!\u0000\u0000\u0016\u0017\u0005 \u0000\u0000\u0017"+
		"\u001e\u0005!\u0000\u0000\u0018\u0019\u0005\u0005\u0000\u0000\u0019\u001a"+
		"\u0005!\u0000\u0000\u001a\u001b\u0005 \u0000\u0000\u001b\u001d\u0005!"+
		"\u0000\u0000\u001c\u0018\u0001\u0000\u0000\u0000\u001d \u0001\u0000\u0000"+
		"\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000"+
		"\u0000\u001f!\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000!"+
		"\"\u0005\u0002\u0000\u0000\"#\u0005 \u0000\u0000#\'\u0005!\u0000\u0000"+
		"$(\u0005\u0012\u0000\u0000%&\u0005\u0003\u0000\u0000&(\u0005\u0004\u0000"+
		"\u0000\'$\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000(\u0005\u0001"+
		"\u0000\u0000\u0000)*\u0005\u0018\u0000\u0000*+\u0005!\u0000\u0000+,\u0005"+
		"\u0012\u0000\u0000,\u0007\u0001\u0000\u0000\u0000\u0004\u000b\r\u001e"+
		"\'";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}