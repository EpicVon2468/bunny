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
		OPEN_PAREN=1, CLOSE_PAREN=2, OPEN_BRACE=3, CLOSE_BRACE=4, ARGUMENT_SEPARATOR=5, 
		ASSIGNMENT=6, COMPARISON=7, STRING_LITERAL=8, COMMENT=9, DOCUMENTATION_COMMENT=10, 
		SECTION_COMMENT=11, TERMINATION=12, NUMBER=13, FUNCTION=14, VARIABLE=15, 
		RETURN=16, STATIC_KEYWORD_REFERENCE=17, STATIC_KEYWORD__NEW=18, TYPE_SPECIFIER=19, 
		IDENTIFIER=20, WHITESPACE=21, NEWLINE=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LOWERCASE", "UPPERCASE", "DIGIT", "EQUALS", "OPEN_PAREN", "CLOSE_PAREN", 
			"OPEN_BRACE", "CLOSE_BRACE", "ARGUMENT_SEPARATOR", "ASSIGNMENT", "COMPARISON", 
			"STRING_LITERAL", "COMMENT", "DOCUMENTATION_COMMENT", "SECTION_COMMENT", 
			"TERMINATION", "NUMBER", "FUNCTION", "VARIABLE", "RETURN", "STATIC_KEYWORD_REFERENCE", 
			"STATIC_KEYWORD__NEW", "TYPE_SPECIFIER", "IDENTIFIER", "WHITESPACE", 
			"NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "','", null, null, null, null, null, 
			null, "';'", null, "'funct'", "'define'", "'return'", "'::'", "'new'", 
			"':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "ARGUMENT_SEPARATOR", 
			"ASSIGNMENT", "COMPARISON", "STRING_LITERAL", "COMMENT", "DOCUMENTATION_COMMENT", 
			"SECTION_COMMENT", "TERMINATION", "NUMBER", "FUNCTION", "VARIABLE", "RETURN", 
			"STATIC_KEYWORD_REFERENCE", "STATIC_KEYWORD__NEW", "TYPE_SPECIFIER", 
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
		"\u0004\u0000\u0016\u00b8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"Q\b\u000b\n\u000b\f\u000bT\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\\\b\f\n\f\f\f_\t\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0005\rh\b\r\n\r\f\rk\t\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0005\u000eq\b\u000e\n\u000e\f\u000et\t\u000e"+
		"\u0001\u000e\u0003\u000ew\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0004\u0010\u007f\b\u0010\u000b\u0010"+
		"\f\u0010\u0080\u0001\u0010\u0001\u0010\u0004\u0010\u0085\b\u0010\u000b"+
		"\u0010\f\u0010\u0086\u0003\u0010\u0089\b\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0004\u0017\u00ab\b\u0017\u000b\u0017\f\u0017\u00ac\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0003\u0019\u00b2\b\u0019\u0001\u0019\u0004\u0019\u00b5"+
		"\b\u0019\u000b\u0019\f\u0019\u00b6\u0003R]i\u0000\u001a\u0001\u0000\u0003"+
		"\u0000\u0005\u0000\u0007\u0000\t\u0001\u000b\u0002\r\u0003\u000f\u0004"+
		"\u0011\u0005\u0013\u0006\u0015\u0007\u0017\b\u0019\t\u001b\n\u001d\u000b"+
		"\u001f\f!\r#\u000e%\u000f\'\u0010)\u0011+\u0012-\u0013/\u00141\u00153"+
		"\u0016\u0001\u0000\u0005\u0001\u0000az\u0001\u0000AZ\u0001\u000009\u0002"+
		"\u0000,,..\u0002\u0000\t\t  \u00c1\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000"+
		"-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001"+
		"\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00015\u0001\u0000\u0000"+
		"\u0000\u00037\u0001\u0000\u0000\u0000\u00059\u0001\u0000\u0000\u0000\u0007"+
		";\u0001\u0000\u0000\u0000\t=\u0001\u0000\u0000\u0000\u000b?\u0001\u0000"+
		"\u0000\u0000\rA\u0001\u0000\u0000\u0000\u000fC\u0001\u0000\u0000\u0000"+
		"\u0011E\u0001\u0000\u0000\u0000\u0013G\u0001\u0000\u0000\u0000\u0015I"+
		"\u0001\u0000\u0000\u0000\u0017L\u0001\u0000\u0000\u0000\u0019W\u0001\u0000"+
		"\u0000\u0000\u001bb\u0001\u0000\u0000\u0000\u001dr\u0001\u0000\u0000\u0000"+
		"\u001f{\u0001\u0000\u0000\u0000!~\u0001\u0000\u0000\u0000#\u008a\u0001"+
		"\u0000\u0000\u0000%\u0090\u0001\u0000\u0000\u0000\'\u0097\u0001\u0000"+
		"\u0000\u0000)\u009e\u0001\u0000\u0000\u0000+\u00a1\u0001\u0000\u0000\u0000"+
		"-\u00a5\u0001\u0000\u0000\u0000/\u00aa\u0001\u0000\u0000\u00001\u00ae"+
		"\u0001\u0000\u0000\u00003\u00b4\u0001\u0000\u0000\u000056\u0007\u0000"+
		"\u0000\u00006\u0002\u0001\u0000\u0000\u000078\u0007\u0001\u0000\u0000"+
		"8\u0004\u0001\u0000\u0000\u00009:\u0007\u0002\u0000\u0000:\u0006\u0001"+
		"\u0000\u0000\u0000;<\u0005=\u0000\u0000<\b\u0001\u0000\u0000\u0000=>\u0005"+
		"(\u0000\u0000>\n\u0001\u0000\u0000\u0000?@\u0005)\u0000\u0000@\f\u0001"+
		"\u0000\u0000\u0000AB\u0005{\u0000\u0000B\u000e\u0001\u0000\u0000\u0000"+
		"CD\u0005}\u0000\u0000D\u0010\u0001\u0000\u0000\u0000EF\u0005,\u0000\u0000"+
		"F\u0012\u0001\u0000\u0000\u0000GH\u0003\u0007\u0003\u0000H\u0014\u0001"+
		"\u0000\u0000\u0000IJ\u0003\u0007\u0003\u0000JK\u0003\u0007\u0003\u0000"+
		"K\u0016\u0001\u0000\u0000\u0000LR\u0005\"\u0000\u0000MN\u0005\\\u0000"+
		"\u0000NQ\u0005\"\u0000\u0000OQ\t\u0000\u0000\u0000PM\u0001\u0000\u0000"+
		"\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000RP\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000UV\u0005\"\u0000\u0000V\u0018\u0001\u0000\u0000\u0000"+
		"WX\u0005/\u0000\u0000XY\u0005/\u0000\u0000Y]\u0001\u0000\u0000\u0000Z"+
		"\\\t\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^`\u0001\u0000"+
		"\u0000\u0000_]\u0001\u0000\u0000\u0000`a\u00033\u0019\u0000a\u001a\u0001"+
		"\u0000\u0000\u0000bc\u0005/\u0000\u0000cd\u0005/\u0000\u0000de\u0005/"+
		"\u0000\u0000ei\u0001\u0000\u0000\u0000fh\t\u0000\u0000\u0000gf\u0001\u0000"+
		"\u0000\u0000hk\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000"+
		"lm\u00033\u0019\u0000m\u001c\u0001\u0000\u0000\u0000no\u0005/\u0000\u0000"+
		"oq\u0005*\u0000\u0000pn\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000"+
		"\u0000tr\u0001\u0000\u0000\u0000uw\t\u0000\u0000\u0000vu\u0001\u0000\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0005*\u0000"+
		"\u0000yz\u0005/\u0000\u0000z\u001e\u0001\u0000\u0000\u0000{|\u0005;\u0000"+
		"\u0000| \u0001\u0000\u0000\u0000}\u007f\u0003\u0005\u0002\u0000~}\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080~\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0088\u0001\u0000"+
		"\u0000\u0000\u0082\u0084\u0007\u0003\u0000\u0000\u0083\u0085\u0003\u0005"+
		"\u0002\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"+
		"\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000"+
		"\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u0082\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\"\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0005f\u0000\u0000\u008b\u008c\u0005u\u0000\u0000\u008c"+
		"\u008d\u0005n\u0000\u0000\u008d\u008e\u0005c\u0000\u0000\u008e\u008f\u0005"+
		"t\u0000\u0000\u008f$\u0001\u0000\u0000\u0000\u0090\u0091\u0005d\u0000"+
		"\u0000\u0091\u0092\u0005e\u0000\u0000\u0092\u0093\u0005f\u0000\u0000\u0093"+
		"\u0094\u0005i\u0000\u0000\u0094\u0095\u0005n\u0000\u0000\u0095\u0096\u0005"+
		"e\u0000\u0000\u0096&\u0001\u0000\u0000\u0000\u0097\u0098\u0005r\u0000"+
		"\u0000\u0098\u0099\u0005e\u0000\u0000\u0099\u009a\u0005t\u0000\u0000\u009a"+
		"\u009b\u0005u\u0000\u0000\u009b\u009c\u0005r\u0000\u0000\u009c\u009d\u0005"+
		"n\u0000\u0000\u009d(\u0001\u0000\u0000\u0000\u009e\u009f\u0005:\u0000"+
		"\u0000\u009f\u00a0\u0005:\u0000\u0000\u00a0*\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0005n\u0000\u0000\u00a2\u00a3\u0005e\u0000\u0000\u00a3\u00a4\u0005"+
		"w\u0000\u0000\u00a4,\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005:\u0000"+
		"\u0000\u00a6.\u0001\u0000\u0000\u0000\u00a7\u00ab\u0003\u0001\u0000\u0000"+
		"\u00a8\u00ab\u0003\u0003\u0001\u0000\u00a9\u00ab\u0005_\u0000\u0000\u00aa"+
		"\u00a7\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac"+
		"\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad"+
		"0\u0001\u0000\u0000\u0000\u00ae\u00af\u0007\u0004\u0000\u0000\u00af2\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b2\u0005\r\u0000\u0000\u00b1\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b5\u0005\n\u0000\u0000\u00b4\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b74\u0001\u0000\u0000\u0000"+
		"\u000e\u0000PR]irv\u0080\u0086\u0088\u00aa\u00ac\u00b1\u00b6\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}