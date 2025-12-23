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
		ASSIGNMENT=1, COMPARISON=2, TERMINATION=3, NUMBER=4, FUNCTION=5, FUNCTION_PROTOTYPE=6, 
		IDENTIFIER=7, WHITESPACE=8, NEWLINE=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LOWERCASE", "UPPERCASE", "DIGIT", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_PAREN", 
			"CLOSE_PAREN", "EQU", "ASSIGNMENT", "COMPARISON", "TERMINATION", "NUMBER", 
			"FUNCTION", "FUNCTION_PROTOTYPE", "IDENTIFIER", "WHITESPACE", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "';'", null, "'fun'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ASSIGNMENT", "COMPARISON", "TERMINATION", "NUMBER", "FUNCTION", 
			"FUNCTION_PROTOTYPE", "IDENTIFIER", "WHITESPACE", "NEWLINE"
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
		"\u0004\u0000\tc\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
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
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0003\rO\b\r"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000eV\b\u000e"+
		"\u000b\u000e\f\u000eW\u0001\u000f\u0001\u000f\u0001\u0010\u0003\u0010"+
		"]\b\u0010\u0001\u0010\u0004\u0010`\b\u0010\u000b\u0010\f\u0010a\u0000"+
		"\u0000\u0011\u0001\u0000\u0003\u0000\u0005\u0000\u0007\u0000\t\u0000\u000b"+
		"\u0000\r\u0000\u000f\u0000\u0011\u0001\u0013\u0002\u0015\u0003\u0017\u0004"+
		"\u0019\u0005\u001b\u0006\u001d\u0007\u001f\b!\t\u0001\u0000\u0005\u0001"+
		"\u0000az\u0001\u0000AZ\u0001\u000009\u0002\u0000,,..\u0002\u0000\t\t "+
		" c\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0003%"+
		"\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000\u0007)\u0001"+
		"\u0000\u0000\u0000\t+\u0001\u0000\u0000\u0000\u000b-\u0001\u0000\u0000"+
		"\u0000\r/\u0001\u0000\u0000\u0000\u000f1\u0001\u0000\u0000\u0000\u0011"+
		"3\u0001\u0000\u0000\u0000\u00135\u0001\u0000\u0000\u0000\u00158\u0001"+
		"\u0000\u0000\u0000\u0017;\u0001\u0000\u0000\u0000\u0019G\u0001\u0000\u0000"+
		"\u0000\u001bK\u0001\u0000\u0000\u0000\u001dU\u0001\u0000\u0000\u0000\u001f"+
		"Y\u0001\u0000\u0000\u0000!_\u0001\u0000\u0000\u0000#$\u0007\u0000\u0000"+
		"\u0000$\u0002\u0001\u0000\u0000\u0000%&\u0007\u0001\u0000\u0000&\u0004"+
		"\u0001\u0000\u0000\u0000\'(\u0007\u0002\u0000\u0000(\u0006\u0001\u0000"+
		"\u0000\u0000)*\u0005{\u0000\u0000*\b\u0001\u0000\u0000\u0000+,\u0005}"+
		"\u0000\u0000,\n\u0001\u0000\u0000\u0000-.\u0005(\u0000\u0000.\f\u0001"+
		"\u0000\u0000\u0000/0\u0005)\u0000\u00000\u000e\u0001\u0000\u0000\u0000"+
		"12\u0005=\u0000\u00002\u0010\u0001\u0000\u0000\u000034\u0003\u000f\u0007"+
		"\u00004\u0012\u0001\u0000\u0000\u000056\u0003\u000f\u0007\u000067\u0003"+
		"\u000f\u0007\u00007\u0014\u0001\u0000\u0000\u000089\u0005;\u0000\u0000"+
		"9\u0016\u0001\u0000\u0000\u0000:<\u0003\u0005\u0002\u0000;:\u0001\u0000"+
		"\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>E\u0001\u0000\u0000\u0000?A\u0007\u0003\u0000\u0000"+
		"@B\u0003\u0005\u0002\u0000A@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000"+
		"\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0001\u0000"+
		"\u0000\u0000E?\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0018"+
		"\u0001\u0000\u0000\u0000GH\u0005f\u0000\u0000HI\u0005u\u0000\u0000IJ\u0005"+
		"n\u0000\u0000J\u001a\u0001\u0000\u0000\u0000KL\u0003\u001d\u000e\u0000"+
		"LN\u0003\u000b\u0005\u0000MO\u0003\u001d\u000e\u0000NM\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0003\r\u0006"+
		"\u0000Q\u001c\u0001\u0000\u0000\u0000RV\u0003\u0001\u0000\u0000SV\u0003"+
		"\u0003\u0001\u0000TV\u0005_\u0000\u0000UR\u0001\u0000\u0000\u0000US\u0001"+
		"\u0000\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X\u001e\u0001\u0000"+
		"\u0000\u0000YZ\u0007\u0004\u0000\u0000Z \u0001\u0000\u0000\u0000[]\u0005"+
		"\r\u0000\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]"+
		"^\u0001\u0000\u0000\u0000^`\u0005\n\u0000\u0000_\\\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000b\"\u0001\u0000\u0000\u0000\t\u0000=CENUW\\a\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}