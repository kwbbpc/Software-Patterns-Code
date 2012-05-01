grammar PageFlow;

options {
  language = Java;
}

@header {
  package broadway.kyle;  
}

@lexer::header {
  package broadway.kyle;  
}  

@members {
  @SuppressWarnings("unused")
  private Stack<?> dummyStack = null;
  @SuppressWarnings("unused")
  private List<?> dummyList = null;
  @SuppressWarnings("unused")
  private ArrayList<?> dummyArrayList = null;
}
@lexer::members {
  @SuppressWarnings("unused")
  private Stack<?> dummyStack = null;
  @SuppressWarnings("unused")
  private List<?> dummyList = null;
  @SuppressWarnings("unused")
  private ArrayList<?> dummyArrayList = null;
}

// PARSER RULES 
  
onClause [Page current]
  : 'on' action=Identifier 
  (w=whenClause[current, $action.text])*
  
  ;
  
whenClause [Page current, String action]
  : 'when' status=Identifier 
  ( 
    g=gotoClause[current]
    {
      current.getTransition().getNextPageMap().put(action + $status.text, $g.next);
    }
    | 
    s=stayClause[current]
    {
      current.getTransition().getNextPageMap().put(action + $status.text, $s.next);
    }
   )
  ;
  
gotoClause [Page current] returns [Page next]
  : 'goto' id=Identifier 
  {
    next = new PageBean();
    next.setPageName($id.text);
  }
  ;
  
stayClause [Page current] returns [Page next]
  : 'stay'
    {next = current;}
  ;
  
  
pages[Pages pageMap]
  //add the resulting page to the page map
  : (p=page 
  {
    pageMap.getPageNameMap().put($p.result.getPageName(), $p.result);  
  })*
  ;
  
 //to add action code to the thing before the '*',
 // add parenths and action code after the thing.
page returns [Page result]
//setup the new page (name and transitions) and return it
  : 'page' currentPage=Identifier 
  { 
    result = new PageBean();
    result.setPageName($currentPage.text);
  }
  //the page is followed by an on clause which will add a certain transition
  // each on clause transition should be added to the transition object's map
  (o=onClause[result] 
  {

  })*
  ;

// LEXER RULES


fragment
Letter :
  'a'..'z' |
  'A'..'Z';

Identifier :
  Letter (Letter)*;




//whitespace rule: ignore these chars.
Whitespace :
  (' ' | '\t' | '\f' | '\n' | '\r')+ {$channel=HIDDEN;};  //channel hidden tells the parser to ignore
  
//comment rules - greedy = true: consume the rest of the input.
MultiLineComment :
  '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;};

//single line comments- nastier because of platform dependent line endings.
SingleLineComment :
  '//' (~('\n'|'\r'))* ('\n'|'\r'('\n')?)? {$channel=HIDDEN;};
