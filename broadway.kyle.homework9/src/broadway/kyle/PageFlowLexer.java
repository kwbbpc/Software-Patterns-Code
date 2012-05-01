// $ANTLR 3.4 D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g 2012-04-30 21:14:16

  package broadway.kyle;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PageFlowLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int Identifier=4;
    public static final int Letter=5;
    public static final int MultiLineComment=6;
    public static final int SingleLineComment=7;
    public static final int Whitespace=8;

      @SuppressWarnings("unused")
      private Stack<?> dummyStack = null;
      @SuppressWarnings("unused")
      private List<?> dummyList = null;
      @SuppressWarnings("unused")
      private ArrayList<?> dummyArrayList = null;


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public PageFlowLexer() {} 
    public PageFlowLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public PageFlowLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g"; }

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:19:6: ( 'goto' )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:19:8: 'goto'
            {
            match("goto"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:20:7: ( 'on' )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:20:9: 'on'
            {
            match("on"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:21:7: ( 'page' )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:21:9: 'page'
            {
            match("page"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:22:7: ( 'stay' )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:22:9: 'stay'
            {
            match("stay"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:23:7: ( 'when' )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:23:9: 'when'
            {
            match("when"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:99:8: ( 'a' .. 'z' | 'A' .. 'Z' )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:102:12: ( Letter ( Letter )* )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:103:3: Letter ( Letter )*
            {
            mLetter(); 


            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:103:10: ( Letter )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Identifier"

    // $ANTLR start "Whitespace"
    public final void mWhitespace() throws RecognitionException {
        try {
            int _type = Whitespace;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:109:12: ( ( ' ' | '\\t' | '\\f' | '\\n' | '\\r' )+ )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:110:3: ( ' ' | '\\t' | '\\f' | '\\n' | '\\r' )+
            {
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:110:3: ( ' ' | '\\t' | '\\f' | '\\n' | '\\r' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||(LA2_0 >= '\f' && LA2_0 <= '\r')||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Whitespace"

    // $ANTLR start "MultiLineComment"
    public final void mMultiLineComment() throws RecognitionException {
        try {
            int _type = MultiLineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:113:18: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:114:3: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:114:8: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='*') ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1=='/') ) {
                        alt3=2;
                    }
                    else if ( ((LA3_1 >= '\u0000' && LA3_1 <= '.')||(LA3_1 >= '0' && LA3_1 <= '\uFFFF')) ) {
                        alt3=1;
                    }


                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= ')')||(LA3_0 >= '+' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:114:36: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match("*/"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MultiLineComment"

    // $ANTLR start "SingleLineComment"
    public final void mSingleLineComment() throws RecognitionException {
        try {
            int _type = SingleLineComment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:117:19: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\n' | '\\r' ( '\\n' )? )? )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:118:3: '//' (~ ( '\\n' | '\\r' ) )* ( '\\n' | '\\r' ( '\\n' )? )?
            {
            match("//"); 



            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:118:8: (~ ( '\\n' | '\\r' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:118:24: ( '\\n' | '\\r' ( '\\n' )? )?
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\n') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\r') ) {
                alt6=2;
            }
            switch (alt6) {
                case 1 :
                    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:118:25: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:118:30: '\\r' ( '\\n' )?
                    {
                    match('\r'); 

                    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:118:34: ( '\\n' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='\n') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:118:35: '\\n'
                            {
                            match('\n'); 

                            }
                            break;

                    }


                    }
                    break;

            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SingleLineComment"

    public void mTokens() throws RecognitionException {
        // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | Identifier | Whitespace | MultiLineComment | SingleLineComment )
        int alt7=9;
        switch ( input.LA(1) ) {
        case 'g':
            {
            int LA7_1 = input.LA(2);

            if ( (LA7_1=='o') ) {
                int LA7_9 = input.LA(3);

                if ( (LA7_9=='t') ) {
                    int LA7_16 = input.LA(4);

                    if ( (LA7_16=='o') ) {
                        int LA7_21 = input.LA(5);

                        if ( ((LA7_21 >= 'A' && LA7_21 <= 'Z')||(LA7_21 >= 'a' && LA7_21 <= 'z')) ) {
                            alt7=6;
                        }
                        else {
                            alt7=1;
                        }
                    }
                    else {
                        alt7=6;
                    }
                }
                else {
                    alt7=6;
                }
            }
            else {
                alt7=6;
            }
            }
            break;
        case 'o':
            {
            int LA7_2 = input.LA(2);

            if ( (LA7_2=='n') ) {
                int LA7_10 = input.LA(3);

                if ( ((LA7_10 >= 'A' && LA7_10 <= 'Z')||(LA7_10 >= 'a' && LA7_10 <= 'z')) ) {
                    alt7=6;
                }
                else {
                    alt7=2;
                }
            }
            else {
                alt7=6;
            }
            }
            break;
        case 'p':
            {
            int LA7_3 = input.LA(2);

            if ( (LA7_3=='a') ) {
                int LA7_11 = input.LA(3);

                if ( (LA7_11=='g') ) {
                    int LA7_18 = input.LA(4);

                    if ( (LA7_18=='e') ) {
                        int LA7_22 = input.LA(5);

                        if ( ((LA7_22 >= 'A' && LA7_22 <= 'Z')||(LA7_22 >= 'a' && LA7_22 <= 'z')) ) {
                            alt7=6;
                        }
                        else {
                            alt7=3;
                        }
                    }
                    else {
                        alt7=6;
                    }
                }
                else {
                    alt7=6;
                }
            }
            else {
                alt7=6;
            }
            }
            break;
        case 's':
            {
            int LA7_4 = input.LA(2);

            if ( (LA7_4=='t') ) {
                int LA7_12 = input.LA(3);

                if ( (LA7_12=='a') ) {
                    int LA7_19 = input.LA(4);

                    if ( (LA7_19=='y') ) {
                        int LA7_23 = input.LA(5);

                        if ( ((LA7_23 >= 'A' && LA7_23 <= 'Z')||(LA7_23 >= 'a' && LA7_23 <= 'z')) ) {
                            alt7=6;
                        }
                        else {
                            alt7=4;
                        }
                    }
                    else {
                        alt7=6;
                    }
                }
                else {
                    alt7=6;
                }
            }
            else {
                alt7=6;
            }
            }
            break;
        case 'w':
            {
            int LA7_5 = input.LA(2);

            if ( (LA7_5=='h') ) {
                int LA7_13 = input.LA(3);

                if ( (LA7_13=='e') ) {
                    int LA7_20 = input.LA(4);

                    if ( (LA7_20=='n') ) {
                        int LA7_24 = input.LA(5);

                        if ( ((LA7_24 >= 'A' && LA7_24 <= 'Z')||(LA7_24 >= 'a' && LA7_24 <= 'z')) ) {
                            alt7=6;
                        }
                        else {
                            alt7=5;
                        }
                    }
                    else {
                        alt7=6;
                    }
                }
                else {
                    alt7=6;
                }
            }
            else {
                alt7=6;
            }
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'q':
        case 'r':
        case 't':
        case 'u':
        case 'v':
        case 'x':
        case 'y':
        case 'z':
            {
            alt7=6;
            }
            break;
        case '\t':
        case '\n':
        case '\f':
        case '\r':
        case ' ':
            {
            alt7=7;
            }
            break;
        case '/':
            {
            int LA7_8 = input.LA(2);

            if ( (LA7_8=='*') ) {
                alt7=8;
            }
            else if ( (LA7_8=='/') ) {
                alt7=9;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 8, input);

                throw nvae;

            }
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 7, 0, input);

            throw nvae;

        }

        switch (alt7) {
            case 1 :
                // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:1:10: T__9
                {
                mT__9(); 


                }
                break;
            case 2 :
                // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:1:15: T__10
                {
                mT__10(); 


                }
                break;
            case 3 :
                // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:1:21: T__11
                {
                mT__11(); 


                }
                break;
            case 4 :
                // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:1:27: T__12
                {
                mT__12(); 


                }
                break;
            case 5 :
                // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:1:33: T__13
                {
                mT__13(); 


                }
                break;
            case 6 :
                // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:1:39: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 7 :
                // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:1:50: Whitespace
                {
                mWhitespace(); 


                }
                break;
            case 8 :
                // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:1:61: MultiLineComment
                {
                mMultiLineComment(); 


                }
                break;
            case 9 :
                // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:1:78: SingleLineComment
                {
                mSingleLineComment(); 


                }
                break;

        }

    }


 

}