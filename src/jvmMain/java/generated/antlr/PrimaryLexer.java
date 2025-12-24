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
		COMPARISON=6, STRING_LITERAL=7, COMMENT=8, DOCUMENTATION_COMMENT=9, SECTION_COMMENT=10, 
		TERMINATION=11, NUMBER=12, FUNCTION=13, VARIABLE=14, TYPE_SPECIFIER=15, 
		IDENTIFIER=16, WHITESPACE=17, NEWLINE=18;
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
			"COMMENT", "DOCUMENTATION_COMMENT", "SECTION_COMMENT", "TERMINATION", 
			"NUMBER", "FUNCTION", "VARIABLE", "TYPE_SPECIFIER", "IDENTIFIER", "WHITESPACE", 
			"NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", null, null, null, null, null, null, 
			"';'", null, "'funct'", "'define'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OPEN_PAREN", "CLOSE_PAREN", "OPEN_BRACE", "CLOSE_BRACE", "ASSIGNMENT", 
			"COMPARISON", "STRING_LITERAL", "COMMENT", "DOCUMENTATION_COMMENT", "SECTION_COMMENT", 
			"TERMINATION", "NUMBER", "FUNCTION", "VARIABLE", "TYPE_SPECIFIER", "IDENTIFIER", 
			"WHITESPACE", "NEWLINE"
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
		"\u0004\u0000\u0012\u00a0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\nG\b\n\n\n\f\nJ\t\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000bR\b\u000b\n\u000b\f\u000bU\t\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f^\b"+
		"\f\n\f\f\fa\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0005\rg\b\r\n\r\f\rj"+
		"\t\r\u0001\r\u0003\rm\b\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0004\u000fu\b\u000f\u000b\u000f\f\u000fv\u0001\u000f\u0001"+
		"\u000f\u0004\u000f{\b\u000f\u000b\u000f\f\u000f|\u0003\u000f\u007f\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0004\u0013\u0093\b\u0013\u000b\u0013\f\u0013\u0094\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0003\u0015\u009a\b\u0015\u0001\u0015\u0004\u0015\u009d"+
		"\b\u0015\u000b\u0015\f\u0015\u009e\u0003HS_\u0000\u0016\u0001\u0000\u0003"+
		"\u0000\u0005\u0000\u0007\u0000\t\u0001\u000b\u0002\r\u0003\u000f\u0004"+
		"\u0011\u0005\u0013\u0006\u0015\u0007\u0017\b\u0019\t\u001b\n\u001d\u000b"+
		"\u001f\f!\r#\u000e%\u000f\'\u0010)\u0011+\u0012\u0001\u0000\u0005\u0001"+
		"\u0000az\u0001\u0000AZ\u0001\u000009\u0002\u0000,,..\u0002\u0000\t\t "+
		" \u00a9\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0001-\u0001\u0000\u0000"+
		"\u0000\u0003/\u0001\u0000\u0000\u0000\u00051\u0001\u0000\u0000\u0000\u0007"+
		"3\u0001\u0000\u0000\u0000\t5\u0001\u0000\u0000\u0000\u000b7\u0001\u0000"+
		"\u0000\u0000\r9\u0001\u0000\u0000\u0000\u000f;\u0001\u0000\u0000\u0000"+
		"\u0011=\u0001\u0000\u0000\u0000\u0013?\u0001\u0000\u0000\u0000\u0015B"+
		"\u0001\u0000\u0000\u0000\u0017M\u0001\u0000\u0000\u0000\u0019X\u0001\u0000"+
		"\u0000\u0000\u001bh\u0001\u0000\u0000\u0000\u001dq\u0001\u0000\u0000\u0000"+
		"\u001ft\u0001\u0000\u0000\u0000!\u0080\u0001\u0000\u0000\u0000#\u0086"+
		"\u0001\u0000\u0000\u0000%\u008d\u0001\u0000\u0000\u0000\'\u0092\u0001"+
		"\u0000\u0000\u0000)\u0096\u0001\u0000\u0000\u0000+\u009c\u0001\u0000\u0000"+
		"\u0000-.\u0007\u0000\u0000\u0000.\u0002\u0001\u0000\u0000\u0000/0\u0007"+
		"\u0001\u0000\u00000\u0004\u0001\u0000\u0000\u000012\u0007\u0002\u0000"+
		"\u00002\u0006\u0001\u0000\u0000\u000034\u0005=\u0000\u00004\b\u0001\u0000"+
		"\u0000\u000056\u0005(\u0000\u00006\n\u0001\u0000\u0000\u000078\u0005)"+
		"\u0000\u00008\f\u0001\u0000\u0000\u00009:\u0005{\u0000\u0000:\u000e\u0001"+
		"\u0000\u0000\u0000;<\u0005}\u0000\u0000<\u0010\u0001\u0000\u0000\u0000"+
		"=>\u0003\u0007\u0003\u0000>\u0012\u0001\u0000\u0000\u0000?@\u0003\u0007"+
		"\u0003\u0000@A\u0003\u0007\u0003\u0000A\u0014\u0001\u0000\u0000\u0000"+
		"BH\u0005\"\u0000\u0000CD\u0005\\\u0000\u0000DG\u0005\"\u0000\u0000EG\t"+
		"\u0000\u0000\u0000FC\u0001\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000"+
		"GJ\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0005\"\u0000"+
		"\u0000L\u0016\u0001\u0000\u0000\u0000MN\u0005/\u0000\u0000NO\u0005/\u0000"+
		"\u0000OS\u0001\u0000\u0000\u0000PR\t\u0000\u0000\u0000QP\u0001\u0000\u0000"+
		"\u0000RU\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0003"+
		"+\u0015\u0000W\u0018\u0001\u0000\u0000\u0000XY\u0005/\u0000\u0000YZ\u0005"+
		"/\u0000\u0000Z[\u0005/\u0000\u0000[_\u0001\u0000\u0000\u0000\\^\t\u0000"+
		"\u0000\u0000]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000"+
		"a_\u0001\u0000\u0000\u0000bc\u0003+\u0015\u0000c\u001a\u0001\u0000\u0000"+
		"\u0000de\u0005/\u0000\u0000eg\u0005*\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000km\t\u0000\u0000"+
		"\u0000lk\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000no\u0005*\u0000\u0000op\u0005/\u0000\u0000p\u001c\u0001\u0000"+
		"\u0000\u0000qr\u0005;\u0000\u0000r\u001e\u0001\u0000\u0000\u0000su\u0003"+
		"\u0005\u0002\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000"+
		"vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w~\u0001\u0000\u0000"+
		"\u0000xz\u0007\u0003\u0000\u0000y{\u0003\u0005\u0002\u0000zy\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001"+
		"\u0000\u0000\u0000}\u007f\u0001\u0000\u0000\u0000~x\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f \u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0005f\u0000\u0000\u0081\u0082\u0005u\u0000\u0000\u0082\u0083\u0005"+
		"n\u0000\u0000\u0083\u0084\u0005c\u0000\u0000\u0084\u0085\u0005t\u0000"+
		"\u0000\u0085\"\u0001\u0000\u0000\u0000\u0086\u0087\u0005d\u0000\u0000"+
		"\u0087\u0088\u0005e\u0000\u0000\u0088\u0089\u0005f\u0000\u0000\u0089\u008a"+
		"\u0005i\u0000\u0000\u008a\u008b\u0005n\u0000\u0000\u008b\u008c\u0005e"+
		"\u0000\u0000\u008c$\u0001\u0000\u0000\u0000\u008d\u008e\u0005:\u0000\u0000"+
		"\u008e&\u0001\u0000\u0000\u0000\u008f\u0093\u0003\u0001\u0000\u0000\u0090"+
		"\u0093\u0003\u0003\u0001\u0000\u0091\u0093\u0005_\u0000\u0000\u0092\u008f"+
		"\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0091"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0092"+
		"\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095(\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0007\u0004\u0000\u0000\u0097*\u0001\u0000"+
		"\u0000\u0000\u0098\u009a\u0005\r\u0000\u0000\u0099\u0098\u0001\u0000\u0000"+
		"\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000"+
		"\u0000\u009b\u009d\u0005\n\u0000\u0000\u009c\u0099\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f,\u0001\u0000\u0000\u0000\u000e"+
		"\u0000FHS_hlv|~\u0092\u0094\u0099\u009e\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}