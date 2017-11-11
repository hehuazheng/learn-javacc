/* SqlParser.java */
/* Generated By:JavaCC: Do not edit this line. SqlParser.java */
package testsql;

import java.util.*;

public class SqlParser implements SqlParserConstants {
    private List<String> fromTables = new ArrayList<String>();

        public static void main( String[] args )throws ParseException, TokenMgrError, NumberFormatException {
                SqlParser parser = new SqlParser( System.in ) ;
                parser.start() ;
                parser.show();
        }

    public void addFromTable(String name, String alias) {
        if(alias != null) {
            fromTables.add(name + "." + alias);
        } else {
            fromTables.add(name);
        }
    }

    public void show() {
        System.out.println(fromTables);
    }

  final public void start() throws ParseException, NumberFormatException {Token t1=null, t2=null;
    jj_consume_token(SELECT);
    jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case DOT:{
      jj_consume_token(DOT);
      jj_consume_token(IDENTIFIER);
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case AS:{
      jj_consume_token(AS);
      jj_consume_token(IDENTIFIER);
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
      jj_consume_token(COMMA);
      jj_consume_token(IDENTIFIER);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case DOT:{
        jj_consume_token(DOT);
        jj_consume_token(IDENTIFIER);
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case AS:{
        jj_consume_token(AS);
        jj_consume_token(IDENTIFIER);
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        ;
      }
    }
    jj_consume_token(FROM);
    t1 = jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case AS:{
      jj_consume_token(AS);
      t2 = jj_consume_token(IDENTIFIER);
      break;
      }
    default:
      jj_la1[5] = jj_gen;
      ;
    }
if(t2 != null) {
           addFromTable(t1.image, t2.image);
       } else {
           addFromTable(t1.image, t1.image);
       }
       t1 = null;
       t2 = null;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INNER:
      case LEFT:
      case RIGHT:
      case JOIN:{
        ;
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case INNER:
      case LEFT:
      case RIGHT:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case INNER:{
          jj_consume_token(INNER);
          break;
          }
        case LEFT:{
          jj_consume_token(LEFT);
          break;
          }
        case RIGHT:{
          jj_consume_token(RIGHT);
          break;
          }
        default:
          jj_la1[7] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        ;
      }
      jj_consume_token(JOIN);
      t1 = jj_consume_token(IDENTIFIER);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case AS:{
        jj_consume_token(AS);
        t2 = jj_consume_token(IDENTIFIER);
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        ;
      }
if(t2 != null) {
          addFromTable(t1.image, t2.image);
      } else {
          addFromTable(t1.image, t1.image);
      }
       t1 = null;
       t2 = null;
      jj_consume_token(ON);
      jj_consume_token(IDENTIFIER);
      jj_consume_token(DOT);
      jj_consume_token(IDENTIFIER);
      jj_consume_token(EQ);
      jj_consume_token(IDENTIFIER);
      jj_consume_token(DOT);
      jj_consume_token(IDENTIFIER);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case AND:{
          ;
          break;
          }
        default:
          jj_la1[10] = jj_gen;
          break label_3;
        }
        jj_consume_token(AND);
        jj_consume_token(IDENTIFIER);
        jj_consume_token(DOT);
        jj_consume_token(IDENTIFIER);
        jj_consume_token(EQ);
        jj_consume_token(IDENTIFIER);
        jj_consume_token(DOT);
        jj_consume_token(IDENTIFIER);
      }
    }
    jj_consume_token(WHERE);
    jj_consume_token(IDENTIFIER);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case DOT:{
      jj_consume_token(DOT);
      jj_consume_token(IDENTIFIER);
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    jj_consume_token(EQ);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case SINGLE_QUOTE_STRING:{
      jj_consume_token(SINGLE_QUOTE_STRING);
      break;
      }
    case NUMBER:{
      jj_consume_token(NUMBER);
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(END);
}

  /** Generated Token Manager. */
  public SqlParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[13];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x100000,0x1000,0x80,0x100000,0x1000,0x1000,0x1e000,0xe000,0xe000,0x1000,0x40000,0x100000,0x40000000,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x20,};
	}

  /** Constructor with InputStream. */
  public SqlParser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public SqlParser(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new SqlParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public SqlParser(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new SqlParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new SqlParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public SqlParser(SqlParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(SqlParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 13; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[39];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 13; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 39; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private int trace_indent = 0;
  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
