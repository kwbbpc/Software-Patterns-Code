// $ANTLR 3.4 D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g 2012-04-30 21:14:16

  package broadway.kyle;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class PageFlowParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Identifier", "Letter", "MultiLineComment", "SingleLineComment", "Whitespace", "'goto'", "'on'", "'page'", "'stay'", "'when'"
    };

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

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public PageFlowParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public PageFlowParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return PageFlowParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g"; }


      @SuppressWarnings("unused")
      private Stack<?> dummyStack = null;
      @SuppressWarnings("unused")
      private List<?> dummyList = null;
      @SuppressWarnings("unused")
      private ArrayList<?> dummyArrayList = null;



    // $ANTLR start "onClause"
    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:34:1: onClause[Page current] : 'on' action= Identifier (w= whenClause[current, $action.text] )* ;
    public final void onClause(Page current) throws RecognitionException {
        Token action=null;

        try {
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:35:3: ( 'on' action= Identifier (w= whenClause[current, $action.text] )* )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:35:5: 'on' action= Identifier (w= whenClause[current, $action.text] )*
            {
            match(input,10,FOLLOW_10_in_onClause63); 

            action=(Token)match(input,Identifier,FOLLOW_Identifier_in_onClause67); 

            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:36:3: (w= whenClause[current, $action.text] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:36:4: w= whenClause[current, $action.text]
            	    {
            	    pushFollow(FOLLOW_whenClause_in_onClause75);
            	    whenClause(current, (action!=null?action.getText():null));

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "onClause"



    // $ANTLR start "whenClause"
    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:40:1: whenClause[Page current, String action] : 'when' status= Identifier (g= gotoClause[current] |s= stayClause[current] ) ;
    public final void whenClause(Page current, String action) throws RecognitionException {
        Token status=null;
        Page g =null;

        Page s =null;


        try {
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:41:3: ( 'when' status= Identifier (g= gotoClause[current] |s= stayClause[current] ) )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:41:5: 'when' status= Identifier (g= gotoClause[current] |s= stayClause[current] )
            {
            match(input,13,FOLLOW_13_in_whenClause98); 

            status=(Token)match(input,Identifier,FOLLOW_Identifier_in_whenClause102); 

            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:42:3: (g= gotoClause[current] |s= stayClause[current] )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==9) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:43:5: g= gotoClause[current]
                    {
                    pushFollow(FOLLOW_gotoClause_in_whenClause116);
                    g=gotoClause(current);

                    state._fsp--;



                          current.getTransition().getNextPageMap().put(action + (status!=null?status.getText():null), g);
                        

                    }
                    break;
                case 2 :
                    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:48:5: s= stayClause[current]
                    {
                    pushFollow(FOLLOW_stayClause_in_whenClause138);
                    s=stayClause(current);

                    state._fsp--;



                          current.getTransition().getNextPageMap().put(action + (status!=null?status.getText():null), s);
                        

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "whenClause"



    // $ANTLR start "gotoClause"
    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:55:1: gotoClause[Page current] returns [Page next] : 'goto' id= Identifier ;
    public final Page gotoClause(Page current) throws RecognitionException {
        Page next = null;


        Token id=null;

        try {
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:56:3: ( 'goto' id= Identifier )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:56:5: 'goto' id= Identifier
            {
            match(input,9,FOLLOW_9_in_gotoClause171); 

            id=(Token)match(input,Identifier,FOLLOW_Identifier_in_gotoClause175); 


                next = new PageBean();
                next.setPageName((id!=null?id.getText():null));
              

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return next;
    }
    // $ANTLR end "gotoClause"



    // $ANTLR start "stayClause"
    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:63:1: stayClause[Page current] returns [Page next] : 'stay' ;
    public final Page stayClause(Page current) throws RecognitionException {
        Page next = null;


        try {
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:64:3: ( 'stay' )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:64:5: 'stay'
            {
            match(input,12,FOLLOW_12_in_stayClause201); 

            next = current;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return next;
    }
    // $ANTLR end "stayClause"



    // $ANTLR start "pages"
    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:69:1: pages[Pages pageMap] : (p= page )* ;
    public final void pages(Pages pageMap) throws RecognitionException {
        Page p =null;


        try {
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:71:3: ( (p= page )* )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:71:5: (p= page )*
            {
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:71:5: (p= page )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:71:6: p= page
            	    {
            	    pushFollow(FOLLOW_page_in_pages232);
            	    p=page();

            	    state._fsp--;



            	        pageMap.getPageNameMap().put(p.getPageName(), p);  
            	      

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "pages"



    // $ANTLR start "page"
    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:79:1: page returns [Page result] : 'page' currentPage= Identifier (o= onClause[result] )* ;
    public final Page page() throws RecognitionException {
        Page result = null;


        Token currentPage=null;

        try {
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:81:3: ( 'page' currentPage= Identifier (o= onClause[result] )* )
            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:81:5: 'page' currentPage= Identifier (o= onClause[result] )*
            {
            match(input,11,FOLLOW_11_in_page263); 

            currentPage=(Token)match(input,Identifier,FOLLOW_Identifier_in_page267); 

             
                result = new PageBean();
                result.setPageName((currentPage!=null?currentPage.getText():null));
              

            // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:88:3: (o= onClause[result] )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==10) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\Code\\Software Patterns\\broadway.kyle.homework9\\src\\broadway\\kyle\\PageFlow.g:88:4: o= onClause[result]
            	    {
            	    pushFollow(FOLLOW_onClause_in_page285);
            	    onClause(result);

            	    state._fsp--;




            	      

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return result;
    }
    // $ANTLR end "page"

    // Delegated rules


 

    public static final BitSet FOLLOW_10_in_onClause63 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_onClause67 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_whenClause_in_onClause75 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_whenClause98 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_whenClause102 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_gotoClause_in_whenClause116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stayClause_in_whenClause138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_gotoClause171 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_gotoClause175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_stayClause201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_page_in_pages232 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_page263 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Identifier_in_page267 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_onClause_in_page285 = new BitSet(new long[]{0x0000000000000402L});

}