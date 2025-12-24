// Generated from antlr/PrimaryLexer.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PrimaryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPEN_PAREN=1, CLOSE_PAREN=2, OPEN_BRACE=3, CLOSE_BRACE=4, ASSIGNMENT=5, 
		COMPARISON=6, STRING_LITERAL=7, NORMAL_COMMENT=8, DOCUMENTATION_COMMENT=9, 
		SECTION_COMMENT=10, TERMINATION=11, NUMBER=12, FUNCTION=13, TYPE_SPECIFIER=14, 
		IDENTIFIER=15, WHITESPACE=16, NEWLINE=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LOWERCASE", "UPPERCASE", "DIGIT", "EQUALS", "OPEN_PAREN", "CLOSE_PAREN", 
			"OPEN_BRACE", "CLOSE_BRACE", "ASSIGNMENT", "COMPARISON", "STRING_LITERAL", 
			"NORMAL_COMMENT", "DOCUMENTATION_COMMENT", "SECTION_COMMENT", "TERMINATION", 
			"NUMBER", "FUNCTION", "TYPE_SPECIFIER", "IDENTIFIER", "WHITESPACE", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", null, null, null, null, null, null, 
			"';'", null, "'fun'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "ASSIGNMENT", 
			"COMPARISON", "STRING_LITERAL", "NORMAL_COMMENT", "DOCUMENTATION_COMMENT", 
			"SECTION_COMMENT", "TERMINATION", "NUMBER", "FUNCTION", "TYPE_SPECIFIER", 
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


	public PrimaryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PrimaryLexer.g4"; }

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
		"\u0004\u0000\u0011\u0097\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\nE\b\n\n\n\f"+
		"\nH\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000bP\b\u000b\n\u000b\f\u000bS\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\\\b\f\n\f\f\f_\t\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0005\re\b\r\n\r\f\rh\t\r\u0001\r\u0003\rk"+
		"\b\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0004"+
		"\u000fs\b\u000f\u000b\u000f\f\u000ft\u0001\u000f\u0001\u000f\u0004\u000f"+
		"y\b\u000f\u000b\u000f\f\u000fz\u0003\u000f}\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u0085"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0004\u0012\u008a\b\u0012"+
		"\u000b\u0012\f\u0012\u008b\u0001\u0013\u0001\u0013\u0001\u0014\u0003\u0014"+
		"\u0091\b\u0014\u0001\u0014\u0004\u0014\u0094\b\u0014\u000b\u0014\f\u0014"+
		"\u0095\u0003FQ]\u0000\u0015\u0001\u0000\u0003\u0000\u0005\u0000\u0007"+
		"\u0000\t\u0001\u000b\u0002\r\u0003\u000f\u0004\u0011\u0005\u0013\u0006"+
		"\u0015\u0007\u0017\b\u0019\t\u001b\n\u001d\u000b\u001f\f!\r#\u000e%\u000f"+
		"\'\u0010)\u0011\u0001\u0000\u0005\u0001\u0000az\u0001\u0000AZ\u0001\u0000"+
		"09\u0002\u0000,,..\u0002\u0000\t\t  \u00a1\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000"+
		"\u0003-\u0001\u0000\u0000\u0000\u0005/\u0001\u0000\u0000\u0000\u00071"+
		"\u0001\u0000\u0000\u0000\t3\u0001\u0000\u0000\u0000\u000b5\u0001\u0000"+
		"\u0000\u0000\r7\u0001\u0000\u0000\u0000\u000f9\u0001\u0000\u0000\u0000"+
		"\u0011;\u0001\u0000\u0000\u0000\u0013=\u0001\u0000\u0000\u0000\u0015@"+
		"\u0001\u0000\u0000\u0000\u0017K\u0001\u0000\u0000\u0000\u0019V\u0001\u0000"+
		"\u0000\u0000\u001bf\u0001\u0000\u0000\u0000\u001do\u0001\u0000\u0000\u0000"+
		"\u001fr\u0001\u0000\u0000\u0000!~\u0001\u0000\u0000\u0000#\u0082\u0001"+
		"\u0000\u0000\u0000%\u0089\u0001\u0000\u0000\u0000\'\u008d\u0001\u0000"+
		"\u0000\u0000)\u0093\u0001\u0000\u0000\u0000+,\u0007\u0000\u0000\u0000"+
		",\u0002\u0001\u0000\u0000\u0000-.\u0007\u0001\u0000\u0000.\u0004\u0001"+
		"\u0000\u0000\u0000/0\u0007\u0002\u0000\u00000\u0006\u0001\u0000\u0000"+
		"\u000012\u0005=\u0000\u00002\b\u0001\u0000\u0000\u000034\u0005(\u0000"+
		"\u00004\n\u0001\u0000\u0000\u000056\u0005)\u0000\u00006\f\u0001\u0000"+
		"\u0000\u000078\u0005{\u0000\u00008\u000e\u0001\u0000\u0000\u00009:\u0005"+
		"}\u0000\u0000:\u0010\u0001\u0000\u0000\u0000;<\u0003\u0007\u0003\u0000"+
		"<\u0012\u0001\u0000\u0000\u0000=>\u0003\u0007\u0003\u0000>?\u0003\u0007"+
		"\u0003\u0000?\u0014\u0001\u0000\u0000\u0000@F\u0005\"\u0000\u0000AB\u0005"+
		"\\\u0000\u0000BE\u0005\"\u0000\u0000CE\t\u0000\u0000\u0000DA\u0001\u0000"+
		"\u0000\u0000DC\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FG\u0001"+
		"\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000GI\u0001\u0000\u0000\u0000"+
		"HF\u0001\u0000\u0000\u0000IJ\u0005\"\u0000\u0000J\u0016\u0001\u0000\u0000"+
		"\u0000KL\u0005/\u0000\u0000LM\u0005/\u0000\u0000MQ\u0001\u0000\u0000\u0000"+
		"NP\t\u0000\u0000\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000TU\u0003)\u0014\u0000U\u0018\u0001\u0000"+
		"\u0000\u0000VW\u0005/\u0000\u0000WX\u0005/\u0000\u0000XY\u0005/\u0000"+
		"\u0000Y]\u0001\u0000\u0000\u0000Z\\\t\u0000\u0000\u0000[Z\u0001\u0000"+
		"\u0000\u0000\\_\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000][\u0001"+
		"\u0000\u0000\u0000^`\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000"+
		"`a\u0003)\u0014\u0000a\u001a\u0001\u0000\u0000\u0000bc\u0005/\u0000\u0000"+
		"ce\u0005*\u0000\u0000db\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000"+
		"fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000ik\t\u0000\u0000\u0000ji\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0005*\u0000"+
		"\u0000mn\u0005/\u0000\u0000n\u001c\u0001\u0000\u0000\u0000op\u0005;\u0000"+
		"\u0000p\u001e\u0001\u0000\u0000\u0000qs\u0003\u0005\u0002\u0000rq\u0001"+
		"\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000u|\u0001\u0000\u0000\u0000vx\u0007\u0003\u0000"+
		"\u0000wy\u0003\u0005\u0002\u0000xw\u0001\u0000\u0000\u0000yz\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0001"+
		"\u0000\u0000\u0000|v\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"} \u0001\u0000\u0000\u0000~\u007f\u0005f\u0000\u0000\u007f\u0080\u0005"+
		"u\u0000\u0000\u0080\u0081\u0005n\u0000\u0000\u0081\"\u0001\u0000\u0000"+
		"\u0000\u0082\u0084\u0005:\u0000\u0000\u0083\u0085\u0005 \u0000\u0000\u0084"+
		"\u0083\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"$\u0001\u0000\u0000\u0000\u0086\u008a\u0003\u0001\u0000\u0000\u0087\u008a"+
		"\u0003\u0003\u0001\u0000\u0088\u008a\u0005_\u0000\u0000\u0089\u0086\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c&\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0007\u0004\u0000\u0000\u008e(\u0001\u0000\u0000"+
		"\u0000\u008f\u0091\u0005\r\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0094\u0005\n\u0000\u0000\u0093\u0090\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0001\u0000\u0000\u0000\u0096*\u0001\u0000\u0000\u0000\u000f\u0000"+
		"DFQ]fjtz|\u0084\u0089\u008b\u0090\u0095\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}