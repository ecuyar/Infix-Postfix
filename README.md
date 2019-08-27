# Infix-Prefix-Postfix

Infix, Postfix and Prefix notations are three different but equivalent ways of writing expressions. It is easiest to demonstrate the differences by looking at examples of operators that take two operands.

---

**Infix notation: X + Y**

Operators are written in-between their operands. This is the usual way we write expressions. An expression such as A * ( B + C ) / D is usually taken to mean something like: "First add B and C together, then multiply the result by A, then divide by D to give the final answer."

---

**Postfix notation: X Y +**
 
Operators are written after their operands. The infix expression given above is equivalent to A B C + * D / 
The order of evaluation of operators is always left-to-right, and brackets cannot be used to change this order. Because the "+" is to the left of the "*" in the example above, the addition must be performed before the multiplication.
Operators act on values immediately to the left of them. For example, the "+" above uses the "B" and "C". We can add (totally unnecessary) brackets to make this explicit: 
( (A (B C +) *) D /) 
Thus, the "*" uses the two values immediately preceding: "A", and the result of the addition. Similarly, the "/" uses the result of the multiplication and the "D".

---

**Prefix notation: + X Y**

Operators are written before their operands. The expressions given above are equivalent to / * A + B C D 
As for Postfix, operators are evaluated left-to-right and brackets are superfluous. Operators act on the two nearest values on the right. I have again added (totally unnecessary) brackets to make this clear: 
(/ (* A (+ B C) ) D)

---

Examples:

 Infix |	Postfix |	Prefix	| Notes 
 --- | --- | --- | --- 
A * B + C / D |	A B * C D / + |	+ * A B / C D	| multiply A and B, divide C by D, add the results
A * (B + C) / D |	A B C + * D / | / * A + B C D	| add B and C, multiply by A, divide by D
A * (B + C / D)	| A B C D / + *	| * A + B / C D	| divide C by D, add B, multiply by A



Examples are taken from: http://www.cs.man.ac.uk/~pjj/cs212/fix.html
