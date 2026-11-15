# Journal
## Grammar
Grammar1 (TA1):
```
stmt  : assn ';'
assn  : id '=' expr
expr  : term addop expr
      | term
term  : fact mulop term
      | fact
fact  : id
      | num
      | '(' expr ')'
      | '-' fact
addop : '+'
      | '-'
mulop : '*'
      | '/'
```

Grammar2 (TA2):
```
prog     : block
block    : stmt ';' block
         | stmt
stmt     : assn
         | 'rd' id
         | 'wr' expr
         | 'if' boolexpr 'then' stmt
         | 'if' boolexpr 'then' stmt 'else' stmt
         | 'while' boolexpr 'do' stmt
         | 'begin' block 'end'
assn     : id '=' expr
expr     : term addop expr
         | term
term     : fact mulop term
         | fact
fact     : id
         | num
         | '(' expr ')'
         | '-' fact
boolexpr : expr relop expr
addop    : '+'
         | '-'
mulop    : '*'
         | '/'
relop    : '<'
         | '<='
         | '>'
         | '>='
         | '<>'
         | '=='
```

### What's new?
#### Additions:
- 4 new nonterminals: `prog`, `block`, `boolexpr`, `relop`
- New keywords: `rd`, `wr`, `if`, `then`, `else`, `while`, `do`, `begin`, `end`
- New relational operators: `<`, `<=`, `>`, `>=`, `<>`, `==`
#### Modifications:
- `stmt`'s definition has changed from `stmt: assn ';'`. Now incorporates the new keywords mentioned in [Additions](#additions) and no longer contains `';'` (moved to block as a separator).

### Notes
#### TODO:
- Write parsers for our four new non-terminals (match new terminals and update `stmt` as well)
- 