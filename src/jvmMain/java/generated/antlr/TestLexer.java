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
		NUMBER=1, FUNCTION=2, IDENTIFIER=3, WHITESPACE=4, NEWLINE=5;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LOWERCASE", "UPPERCASE", "DIGIT", "NUMBER", "FUNCTION", "IDENTIFIER", 
			"WHITESPACE", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'fun'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBER", "FUNCTION", "IDENTIFIER", "WHITESPACE", "NEWLINE"
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
		"\u0004\u0000\u00059\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0004\u0003\u0019\b\u0003\u000b\u0003\f\u0003"+
		"\u001a\u0001\u0003\u0001\u0003\u0004\u0003\u001f\b\u0003\u000b\u0003\f"+
		"\u0003 \u0003\u0003#\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005,\b\u0005\u000b"+
		"\u0005\f\u0005-\u0001\u0006\u0001\u0006\u0001\u0007\u0003\u00073\b\u0007"+
		"\u0001\u0007\u0004\u00076\b\u0007\u000b\u0007\f\u00077\u0000\u0000\b\u0001"+
		"\u0000\u0003\u0000\u0005\u0000\u0007\u0001\t\u0002\u000b\u0003\r\u0004"+
		"\u000f\u0005\u0001\u0000\u0005\u0001\u0000az\u0001\u0000AZ\u0001\u0000"+
		"09\u0002\u0000,,..\u0002\u0000\t\t  =\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0001\u0011"+
		"\u0001\u0000\u0000\u0000\u0003\u0013\u0001\u0000\u0000\u0000\u0005\u0015"+
		"\u0001\u0000\u0000\u0000\u0007\u0018\u0001\u0000\u0000\u0000\t$\u0001"+
		"\u0000\u0000\u0000\u000b+\u0001\u0000\u0000\u0000\r/\u0001\u0000\u0000"+
		"\u0000\u000f5\u0001\u0000\u0000\u0000\u0011\u0012\u0007\u0000\u0000\u0000"+
		"\u0012\u0002\u0001\u0000\u0000\u0000\u0013\u0014\u0007\u0001\u0000\u0000"+
		"\u0014\u0004\u0001\u0000\u0000\u0000\u0015\u0016\u0007\u0002\u0000\u0000"+
		"\u0016\u0006\u0001\u0000\u0000\u0000\u0017\u0019\u0003\u0005\u0002\u0000"+
		"\u0018\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000"+
		"\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000"+
		"\u001b\"\u0001\u0000\u0000\u0000\u001c\u001e\u0007\u0003\u0000\u0000\u001d"+
		"\u001f\u0003\u0005\u0002\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f"+
		" \u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000"+
		"\u0000\u0000!#\u0001\u0000\u0000\u0000\"\u001c\u0001\u0000\u0000\u0000"+
		"\"#\u0001\u0000\u0000\u0000#\b\u0001\u0000\u0000\u0000$%\u0005f\u0000"+
		"\u0000%&\u0005u\u0000\u0000&\'\u0005n\u0000\u0000\'\n\u0001\u0000\u0000"+
		"\u0000(,\u0003\u0001\u0000\u0000),\u0003\u0003\u0001\u0000*,\u0005_\u0000"+
		"\u0000+(\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+*\u0001\u0000"+
		"\u0000\u0000,-\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001"+
		"\u0000\u0000\u0000.\f\u0001\u0000\u0000\u0000/0\u0007\u0004\u0000\u0000"+
		"0\u000e\u0001\u0000\u0000\u000013\u0005\r\u0000\u000021\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0005\n\u0000"+
		"\u000052\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000078\u0001\u0000\u0000\u00008\u0010\u0001\u0000\u0000\u0000"+
		"\b\u0000\u001a \"+-27\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}