# Journal
- currently struggling understanding purpose/usage of NodeRd
- NodeWr was extends Node, changed to extend NodeStmt
- NodeRd constructor must declare null initialized variables?
- Add newline char to NodeRd code() return? In general, most code conversions lack newline characters which result in kinda ugly code output. Probably make this more pretty when everything works.

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
1. Scanner
- Add new keywords to `initKeywords`.
- Add new relops to `initOperators`.

2. Parser
- Write parsers for new non-terminals (match new terminals, update `stmt` as well)
- `parseRelop`
- `parseBoolexpr`
- `parseBlock`
- Update `parseStmt` (one branch per statement)
- Update `parse`: parse `block` -> match EOF.

3. Nodes
- New nodes: `NodeBlock`, `NodeRd`, `NodeRelop`, `NodeBoolexpr`, `NodeIf`, `NodeWhile` (maybe `NodeBegin`/`NodeEnd`?)
- `NodeWr` already exists (idk if it works)

4. Test cases
- TA1 tests all use the old `stmt` definition ending with `;`. Fix this.
- TA1 tests use multiple prg files. Fix this.
- Add test cases for each new keyword (rd, wr, relops, if, if/else, while, multi-stmt blocks, begin/end, comments).

#### Currently working on/done:
- created Nodes for new grammar additions
- retyped NodeStmt to follow NodeFact since we now have different types of statements
- new Node's typed fully
- updated Scanner + Parser to parse/scan new operators + keywords
- Writing tests: `test-rd`, `test-wr`, `test-relop` (do for each relop), `test-ifelse`, `test-while`, `test-begin-end`
- Tests for `if` and `ifelse` are unnecessary since we test that in relop tests.