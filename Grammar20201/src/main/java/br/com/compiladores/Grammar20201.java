/* Generated By:JavaCC: Do not edit this line. Grammar20201.java */
package br.com.compiladores;

public class Grammar20201 implements Grammar20201Constants {
  public static void main(String args []) throws ParseException
  {
//    Grammar20201 parser = new Grammar20201(System.in);
//    while (true)
//    {
//      System.out.println("Reading from standard input...");
//      System.out.print("Entre com o c\u00f3digo: ");
//      try
//      {
//        switch (Grammar20201.one_line())
//        {
//          case 0 :
//          System.out.println("OK.");
//          break;
//          case 1 :
//          System.out.println("Goodbye.");
//          break;
//          default :
//          break;
//        }
//      }
//      catch (Exception e)
//      {
//        System.out.println("NOK.");
//        System.out.println(e.getMessage());
//        Grammar20201.ReInit(System.in);
//      }
//      catch (Error e)
//      {
//        System.out.println("Oops.");
//        System.out.println(e.getMessage());
//        break;
//      }
//    }
	  Interface tela = new Interface();
	  tela.setVisible(true);
  }

  static final public int one_line() throws ParseException {
    Programa();
    {if (true) return 0;}
    {if (true) return 1;}
    throw new Error("Missing return statement in function");
  }

//declaracao do corpo do programa
  static final public void Programa() throws ParseException {
    jj_consume_token(DO);
    jj_consume_token(THIS);
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(COLCH_ESQ);
    jj_consume_token(COLCH_DIR);
    DecTpEnum();
    DeclarationConstantAndVariable();
    jj_consume_token(BODY);
    jj_consume_token(COLCH_ESQ);
    ListaDeComandos();
    jj_consume_token(COLCH_DIR);
    Description();
  }

// dec lista de comandos
  static final public void ListaDeComandos() throws ParseException {
    Comandos();
    ListaDeComandosl();
  }

  static final public void ListaDeComandosl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DESIGNATE:
    case READ:
    case WRITE:
    case REPEAT:
    case AVALIATE:
      Comandos();
      ListaDeComandosl();
      break;
    default:
      jj_la1[0] = jj_gen;

    }
  }

  static final public void Comandos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DESIGNATE:
      ComandoAtribuicao();
      break;
    case READ:
      ComandoEntradaDados();
      break;
    case WRITE:
      ComandoSaidaDados();
      break;
    case AVALIATE:
      ComandoSelecao();
      break;
    case REPEAT:
      ComandoRepeticao();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

//dec de comandos de repeticao
  static final public void ComandoRepeticao() throws ParseException {
    jj_consume_token(REPEAT);
    jj_consume_token(THIS);
    Expressao();
    jj_consume_token(COLCH_ESQ);
    ListaDeComandos();
    jj_consume_token(COLCH_DIR);
  }

//dec de comandos de comandos de sele��o
  static final public void ComandoSelecao() throws ParseException {
    jj_consume_token(AVALIATE);
    jj_consume_token(THIS);
    Expressao();
    AlternanciaResultado();
    jj_consume_token(PONTO);
  }

  static final public void AlternanciaResultado() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      LinhaTrue();
      LinhaUntruel();
      break;
    case UNTRUE:
      LinhaUntrue();
      LinhaTruel();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void LinhaUntruel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case UNTRUE:
      LinhaUntrue();
      break;
    default:
      jj_la1[3] = jj_gen;

    }
  }

  static final public void LinhaTruel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      LinhaTrue();
      break;
    default:
      jj_la1[4] = jj_gen;

    }
  }

  static final public void LinhaTrue() throws ParseException {
    jj_consume_token(TRUE);
    jj_consume_token(RESULT);
    jj_consume_token(COLCH_ESQ);
    ListaDeComandos();
    jj_consume_token(COLCH_DIR);
  }

  static final public void LinhaUntrue() throws ParseException {
    jj_consume_token(UNTRUE);
    jj_consume_token(RESULT);
    jj_consume_token(COLCH_ESQ);
    ListaDeComandos();
    jj_consume_token(COLCH_DIR);
  }

// dec comando de saida de dados
  static final public void ComandoSaidaDados() throws ParseException {
    jj_consume_token(WRITE);
    LinhasWriters();
  }

  static final public void LinhasWriters() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ALL:
      LinhaWriteAll();
      break;
    case THIS:
      LinhaWrite();
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void LinhaWriteAll() throws ParseException {
    jj_consume_token(ALL);
    jj_consume_token(THIS);
    jj_consume_token(COLCH_ESQ);
    ListaDeIdentificadoresVet();
    jj_consume_token(COLCH_DIR);
    jj_consume_token(PONTO);
  }

  static final public void LinhaWrite() throws ParseException {
    jj_consume_token(THIS);
    jj_consume_token(COLCH_ESQ);
    ListaDeIdentificadoresVet();
    jj_consume_token(COLCH_DIR);
    jj_consume_token(PONTO);
  }

// dec comando de entrada de dados
  static final public void ComandoEntradaDados() throws ParseException {
    jj_consume_token(READ);
    jj_consume_token(THIS);
    jj_consume_token(COLCH_ESQ);
    ListaDeIdentificadoresVet();
    jj_consume_token(COLCH_DIR);
  }

// dec comando de atribuicao
  static final public void ComandoAtribuicao() throws ParseException {
    jj_consume_token(DESIGNATE);
    jj_consume_token(THIS);
    ListaDeIdentificadoresVet();
    jj_consume_token(AS);
    Expressao();
  }

// declaracao de variaiveis e constantes
  static final public void DeclarationConstantAndVariable() throws ParseException {
    jj_consume_token(DECLARATION);
    jj_consume_token(CONSTANT);
    jj_consume_token(AND);
    jj_consume_token(VARIABLE);
    jj_consume_token(COLCH_ESQ);
    DecConstEVar();
    jj_consume_token(COLCH_DIR);
  }

  static final public void DecConstEVar() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AS:
      jj_consume_token(AS);
      DecConstEVarl();
      break;
    default:
      jj_la1[6] = jj_gen;

    }
  }

  static final public void DecConstEVarl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CONSTANT:
      jj_consume_token(CONSTANT);
      ListaDecAsConstant();
      DecAsVariable();
      break;
    case VARIABLE:
      jj_consume_token(VARIABLE);
      ListaDecAsVariable();
      DecAsConstant();
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void DecAsConstant() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AS:
      jj_consume_token(AS);
      jj_consume_token(CONSTANT);
      ListaDecAsConstant();
      break;
    default:
      jj_la1[8] = jj_gen;

    }
  }

  static final public void DecAsVariable() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case AS:
      jj_consume_token(AS);
      jj_consume_token(VARIABLE);
      ListaDecAsVariable();
      break;
    default:
      jj_la1[9] = jj_gen;

    }
  }

  static final public void ListaDecAsConstant() throws ParseException {
    ListaDeIdentificadores();
    jj_consume_token(IS);
    TipoConst();
    jj_consume_token(IGUAL_DEC);
    Valor();
    jj_consume_token(PONTO);
    ListaDecAsConstantl();
  }

  static final public void ListaDecAsConstantl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      ListaDeIdentificadores();
      jj_consume_token(IS);
      TipoConst();
      jj_consume_token(IGUAL_DEC);
      Valor();
      jj_consume_token(PONTO);
      ListaDecAsConstantl();
      break;
    default:
      jj_la1[10] = jj_gen;

    }
  }

  static final public void TipoConst() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
      jj_consume_token(INTEGER);
      break;
    case REAL:
      jj_consume_token(REAL);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    case LOGIC:
      jj_consume_token(LOGIC);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ListaDecAsVariable() throws ParseException {
    ListaDeIdentificadoresVet();
    jj_consume_token(IS);
    TipoVar();
    jj_consume_token(PONTO);
    ListaDecAsVariablel();
  }

  static final public void ListaDecAsVariablel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      ListaDeIdentificadoresVet();
      jj_consume_token(IS);
      TipoVar();
      jj_consume_token(PONTO);
      ListaDecAsVariablel();
      break;
    default:
      jj_la1[12] = jj_gen;

    }
  }

  static final public void TipoVar() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER:
      jj_consume_token(INTEGER);
      break;
    case REAL:
      jj_consume_token(REAL);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    case LOGIC:
      jj_consume_token(LOGIC);

      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Valor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CINTEIRO:
      jj_consume_token(CINTEIRO);
      break;
    case CREAL:
      jj_consume_token(CREAL);
      break;
    case CLITERAL:
      jj_consume_token(CLITERAL);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void IsVetor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COLCH_ESQ:
      jj_consume_token(COLCH_ESQ);
      jj_consume_token(CINTEIRO);
      jj_consume_token(COLCH_DIR);
      break;
    default:
      jj_la1[15] = jj_gen;

    }
  }

// dec description do corpo do programa
  static final public void Description() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DESCRIPTION:
      jj_consume_token(DESCRIPTION);
      jj_consume_token(CLITERAL);
      break;
    default:
      jj_la1[16] = jj_gen;

    }
  }

// declaracao tipo enumerado
  static final public void DecTpEnum() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case DECLARATION:
      jj_consume_token(DECLARATION);
      jj_consume_token(TYPE);
      jj_consume_token(COLCH_ESQ);
      LinhasDeclarationType();
      jj_consume_token(COLCH_DIR);
      break;
    default:
      jj_la1[17] = jj_gen;

    }
  }

  static final public void LinhaDeclarationType() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(IS);
    ListaDeIdentificadores();
    jj_consume_token(PONTO);
  }

  static final public void LinhasDeclarationType() throws ParseException {
    LinhaDeclarationType();
    LinhasDeclarationTypel();
  }

  static final public void LinhasDeclarationTypel() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      LinhaDeclarationType();
      ListaDeIdentificadoresl();
      break;
    default:
      jj_la1[18] = jj_gen;

    }
  }

// decalaracao lista de identificadores
  static final public void ListaDeIdentificadores() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    ListaDeIdentificadoresl();
  }

  static final public void ListaDeIdentificadoresl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VIRG:
      jj_consume_token(VIRG);
      jj_consume_token(IDENTIFICADOR);
      ListaDeIdentificadoresl();
      break;
    default:
      jj_la1[19] = jj_gen;

    }
  }

// dec lista de identificadores com vetor
  static final public void ListaDeIdentificadoresVet() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    IsVector();
    ListaDeIdentificadoresVetl();
  }

  static final public void ListaDeIdentificadoresVetl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VIRG:
      jj_consume_token(VIRG);
      jj_consume_token(IDENTIFICADOR);
      IsVector();
      ListaDeIdentificadoresVetl();
      break;
    default:
      jj_la1[20] = jj_gen;

    }
  }

  static final public void IsVector() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case COLCH_ESQ:
      jj_consume_token(COLCH_ESQ);
      jj_consume_token(CINTEIRO);
      jj_consume_token(COLCH_DIR);
      break;
    default:
      jj_la1[21] = jj_gen;

    }
  }

// declaracao de expressao
  static final public void Expressao() throws ParseException {
    ExpressaoAtitmeticaOuLogica();
    Expressaol();
  }

  static final public void Expressaol() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
    case UNTRUE:
    case PAREN_ESQ:
    case NAO:
    case CLITERAL:
    case CINTEIRO:
    case CREAL:
    case IDENTIFICADOR:
      ExpressaoAtitmeticaOuLogica();
      break;
    case IGUAL:
      jj_consume_token(IGUAL);
      ExpressaoAtitmeticaOuLogica();
      break;
    case DIFERENTE:
      jj_consume_token(DIFERENTE);
      ExpressaoAtitmeticaOuLogica();
      break;
    case MENOR:
      jj_consume_token(MENOR);
      ExpressaoAtitmeticaOuLogica();
      break;
    case MAIOR:
      jj_consume_token(MAIOR);
      ExpressaoAtitmeticaOuLogica();
      break;
    case MENOR_IGUAL:
      jj_consume_token(MENOR_IGUAL);
      ExpressaoAtitmeticaOuLogica();
      break;
    case MAIOR_IGUAL:
      jj_consume_token(MAIOR_IGUAL);
      ExpressaoAtitmeticaOuLogica();
      break;
    default:
      jj_la1[22] = jj_gen;

    }
  }

  static final public void ExpressaoAtitmeticaOuLogica() throws ParseException {
    Termo2();
    MenorPrioridade();
  }

  static final public void MenorPrioridade() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SOMA:
      jj_consume_token(SOMA);
      Termo2();
      MenorPrioridade();
      break;
    case SUBTRACAO:
      jj_consume_token(SUBTRACAO);
      Termo2();
      MenorPrioridade();
      break;
    case OU:
      jj_consume_token(OU);
      Termo2();
      MenorPrioridade();
      jj_consume_token(OU);
      break;
    default:
      jj_la1[23] = jj_gen;

    }
  }

  static final public void Termo2() throws ParseException {
    Termo1();
    MediaPrioridade();
  }

  static final public void MediaPrioridade() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MULTIPLICACAO:
      jj_consume_token(MULTIPLICACAO);
      Termo1();
      MediaPrioridade();
      break;
    case DIVISAO:
      jj_consume_token(DIVISAO);
      Termo1();
      MediaPrioridade();
      break;
    case DIVISAO_INTEIRA:
      jj_consume_token(DIVISAO_INTEIRA);
      Termo1();
      MediaPrioridade();
      break;
    case DIVISAO_INTEIRA_RESTO:
      jj_consume_token(DIVISAO_INTEIRA_RESTO);
      Termo1();
      MediaPrioridade();
      break;
    case E:
      jj_consume_token(E);
      Termo1();
      MediaPrioridade();
      break;
    default:
      jj_la1[24] = jj_gen;

    }
  }

  static final public void Termo1() throws ParseException {
    Elemento();
    MaiorPrioridade();
  }

  static final public void MaiorPrioridade() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case POTENCIA:
      jj_consume_token(POTENCIA);
      Elemento();
      MaiorPrioridade();
      break;
    default:
      jj_la1[25] = jj_gen;

    }
  }

  static final public void Elemento() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      Indice();
      break;
    case CINTEIRO:
      jj_consume_token(CINTEIRO);
      break;
    case CREAL:
      jj_consume_token(CREAL);
      break;
    case CLITERAL:
      jj_consume_token(CLITERAL);
      break;
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case UNTRUE:
      jj_consume_token(UNTRUE);
      break;
    case PAREN_ESQ:
      jj_consume_token(PAREN_ESQ);
      Expressao();
      jj_consume_token(PAREN_DIR);
      break;
    case NAO:
      jj_consume_token(NAO);
      jj_consume_token(PAREN_ESQ);
      Expressao();
      jj_consume_token(PAREN_DIR);
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Indice() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CINTEIRO:
      jj_consume_token(CINTEIRO);
      break;
    default:
      jj_la1[27] = jj_gen;

    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public Grammar20201TokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[28];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x37000000,0x37000000,0x80000000,0x0,0x80000000,0x8000400,0x80000,0x50000,0x80000,0x80000,0x0,0xf00000,0x0,0xf00000,0x0,0x0,0x1000,0x2000,0x0,0x0,0x0,0x0,0x80000000,0x0,0x0,0x0,0x80000000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x1,0x1,0x0,0x0,0x0,0x0,0x0,0x0,0x20000000,0x0,0x20000000,0x0,0xd000000,0x2,0x0,0x0,0x20000000,0x10,0x10,0x2,0x2d801fa1,0x40c000,0x3b0000,0x40000,0x2d800021,0x4000000,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public Grammar20201(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Grammar20201(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new Grammar20201TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Grammar20201(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new Grammar20201TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Grammar20201(Grammar20201TokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(Grammar20201TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
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
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[65];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 28; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 65; i++) {
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

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
