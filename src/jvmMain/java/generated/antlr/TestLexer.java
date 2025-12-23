// Generated from antlr/TestLexer.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TestLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPEN_BRACE=1, CLOSE_BRACE=2, ASSIGNMENT=3, COMPARISON=4, TERMINATION=5, 
		NUMBER=6, FUNCTION=7, FUNCTION_PROTOTYPE=8, IDENTIFIER=9, WHITESPACE=10, 
		NEWLINE=11;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LOWERCASE", "UPPERCASE", "DIGIT", "OPEN_PAREN", "CLOSE_PAREN", "EQUALS", 
			"OPEN_BRACE", "CLOSE_BRACE", "ASSIGNMENT", "COMPARISON", "TERMINATION", 
			"NUMBER", "FUNCTION", "FUNCTION_PROTOTYPE", "IDENTIFIER", "WHITESPACE", 
			"NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", null, null, "';'", null, "'fun'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OPEN_BRACE", "CLOSE_BRACE", "ASSIGNMENT", "COMPARISON", "TERMINATION", 
			"NUMBER", "FUNCTION", "FUNCTION_PROTOTYPE", "IDENTIFIER", "WHITESPACE", 
			"NEWLINE"
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


	public TestLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TestLexer.g4"; }

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

	public static final String _serializedATN =
		"\u0004\u0000\u000bf\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0004\u000b<\b\u000b\u000b\u000b\f\u000b=\u0001\u000b\u0001"+
		"\u000b\u0004\u000bB\b\u000b\u000b\u000b\f\u000bC\u0003\u000bF\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0005\rO\b\r"+
		"\n\r\f\rR\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0004"+
		"\u000eY\b\u000e\u000b\u000e\f\u000eZ\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0003\u0010`\b\u0010\u0001\u0010\u0004\u0010c\b\u0010\u000b\u0010\f\u0010"+
		"d\u0000\u0000\u0011\u0001\u0000\u0003\u0000\u0005\u0000\u0007\u0000\t"+
		"\u0000\u000b\u0000\r\u0001\u000f\u0002\u0011\u0003\u0013\u0004\u0015\u0005"+
		"\u0017\u0006\u0019\u0007\u001b\b\u001d\t\u001f\n!\u000b\u0001\u0000\u0005"+
		"\u0001\u0000az\u0001\u0000AZ\u0001\u000009\u0002\u0000,,..\u0002\u0000"+
		"\t\t  h\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0003"+
		"%\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000\u0007)\u0001"+
		"\u0000\u0000\u0000\t+\u0001\u0000\u0000\u0000\u000b-\u0001\u0000\u0000"+
		"\u0000\r/\u0001\u0000\u0000\u0000\u000f1\u0001\u0000\u0000\u0000\u0011"+
		"3\u0001\u0000\u0000\u0000\u00135\u0001\u0000\u0000\u0000\u00158\u0001"+
		"\u0000\u0000\u0000\u0017;\u0001\u0000\u0000\u0000\u0019G\u0001\u0000\u0000"+
		"\u0000\u001bK\u0001\u0000\u0000\u0000\u001dX\u0001\u0000\u0000\u0000\u001f"+
		"\\\u0001\u0000\u0000\u0000!b\u0001\u0000\u0000\u0000#$\u0007\u0000\u0000"+
		"\u0000$\u0002\u0001\u0000\u0000\u0000%&\u0007\u0001\u0000\u0000&\u0004"+
		"\u0001\u0000\u0000\u0000\'(\u0007\u0002\u0000\u0000(\u0006\u0001\u0000"+
		"\u0000\u0000)*\u0005(\u0000\u0000*\b\u0001\u0000\u0000\u0000+,\u0005)"+
		"\u0000\u0000,\n\u0001\u0000\u0000\u0000-.\u0005=\u0000\u0000.\f\u0001"+
		"\u0000\u0000\u0000/0\u0005{\u0000\u00000\u000e\u0001\u0000\u0000\u0000"+
		"12\u0005}\u0000\u00002\u0010\u0001\u0000\u0000\u000034\u0003\u000b\u0005"+
		"\u00004\u0012\u0001\u0000\u0000\u000056\u0003\u000b\u0005\u000067\u0003"+
		"\u000b\u0005\u00007\u0014\u0001\u0000\u0000\u000089\u0005;\u0000\u0000"+
		"9\u0016\u0001\u0000\u0000\u0000:<\u0003\u0005\u0002\u0000;:\u0001\u0000"+
		"\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>E\u0001\u0000\u0000\u0000?A\u0007\u0003\u0000\u0000"+
		"@B\u0003\u0005\u0002\u0000A@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000"+
		"\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0001\u0000"+
		"\u0000\u0000E?\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0018"+
		"\u0001\u0000\u0000\u0000GH\u0005f\u0000\u0000HI\u0005u\u0000\u0000IJ\u0005"+
		"n\u0000\u0000J\u001a\u0001\u0000\u0000\u0000KL\u0003\u001d\u000e\u0000"+
		"LP\u0003\u0007\u0003\u0000MO\u0003\u001d\u000e\u0000NM\u0001\u0000\u0000"+
		"\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000"+
		"\u0000\u0000QS\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000ST\u0003"+
		"\t\u0004\u0000T\u001c\u0001\u0000\u0000\u0000UY\u0003\u0001\u0000\u0000"+
		"VY\u0003\u0003\u0001\u0000WY\u0005_\u0000\u0000XU\u0001\u0000\u0000\u0000"+
		"XV\u0001\u0000\u0000\u0000XW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u001e\u0001"+
		"\u0000\u0000\u0000\\]\u0007\u0004\u0000\u0000] \u0001\u0000\u0000\u0000"+
		"^`\u0005\r\u0000\u0000_^\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000ac\u0005\n\u0000\u0000b_\u0001\u0000\u0000\u0000"+
		"cd\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000e\"\u0001\u0000\u0000\u0000\t\u0000=CEPXZ_d\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}