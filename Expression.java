import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.Stack;

public class Expression {
  /*****************************************************************
   * Converts an infix expression to a postfix expression and returns
   * a pointer to the buffer containing the postfix expression
   *****************************************************************/
  public static String Infix2Postfix(String infixExpr) {
    // Fill this in
    java.util.Stack<Character> stack=new Stack<>();

    String postfix="";
    for(int i=0;i<infixExpr.length();i++){
      char current=infixExpr.charAt(i);
      if(Character.isDigit(current)){
        postfix+=current;
      }
      else{
        if(current=='+'||current=='-'){
          if(!stack.isEmpty()){
            while(stack.peek()!='('&&stack.peek()!=')'){
              postfix+=" ";
              postfix+=stack.pop();
              if(stack.isEmpty()){
                break;
              }
            }
          }
          postfix+=" ";
          stack.push(current);
        }
        else if(current==')'){
             while(!stack.peek().equals('(')){
               postfix+=" ";
               postfix+=stack.pop();
             }
             if(stack.peek()=='('){
               stack.pop();

             }
        }
        else if(current==' '){
          continue;
        }
        else if(current =='('){
          stack.push(current);
        }
        else{
          postfix+=" ";
          stack.push(current);
        }
      }
    }
    while(!stack.isEmpty()){
      postfix+=" ";
      postfix+=stack.pop();
    }
    return postfix;
  } // end-Infix2Postfix

  /*****************************************************************
   * Given an expression in postfix form, evaluates the expression and returns the result
   *****************************************************************/
  public static int EvaluatePostfixExpression(String postfixExpr){
    // Fill this in
    Stack<Integer> stack = new Stack<>();
    String[] exp=postfixExpr.split(" ");
    for(int i=0;i<exp.length;i++){
      String current=exp[i];
      if(!current.equals("+")&&!current.equals("-")&&!current.equals("*")&&!current.equals("/")){
        stack.push(Integer.valueOf(current));
      }

      if(current.equals("+")){
        int c=stack.pop()+stack.pop();
        stack.push(c);
      }
      if(current.equals("-")){
        int tmp=stack.pop();
        int c=stack.pop()-tmp;
        stack.push(c);
      }
      if(current.equals("/")){
        int tmp=stack.pop();
        int c=stack.pop()/tmp;
        stack.push(c);
      }
      if(current.equals("*")){
        int c=stack.pop()*stack.pop();
        stack.push(c);
      }
    }
    return stack.peek();

  } //end-EvaluatePostfixExpression

  /*****************************************************************
   * Given a postfix expression, converts this to an expression tree
   * and returns a pointer to the root of the tree
   *****************************************************************/
  public static ExpressionTreeNode Postfix2ExpressionTree(String postfixExpr){
    // Fill this in
    Stack<ExpressionTreeNode> stack = new Stack<>();
    String[] exp=postfixExpr.split(" ");
    ExpressionTreeNode node;
    for(int i=0;i<exp.length;i++){
      String current=exp[i];

      if(!current.equals("+")&&!current.equals("-")&&!current.equals("*")&&!current.equals("/")){
        node= new ExpressionTreeNode((byte)1);
        node.operand=Integer.valueOf(current);
        stack.push(node);
      }
      else{
        node=new ExpressionTreeNode((byte)0);
        node.operator=current.charAt(0);
        node.right=stack.pop();
        node.left=stack.pop();
        stack.push(node);
      }

    }
    return stack.peek();
  } //end-Postfix2ExpressionTree
  
  /*****************************************************************
   * Given a pointer to the root of an expression tree, evaluates
   * the expression tree, and returns the result
   *****************************************************************/
  public static int EvaluateExpressionTree(ExpressionTreeNode root){
    // Fill this in

      if (root == null) return -1;
      Stack<Integer> stack = new Stack<>();
      PostorderTraversal(root,stack);

      return stack.peek();
  } //end-EvaluateExpressionTree
  public static void PostorderTraversal(ExpressionTreeNode root, Stack<Integer> stack){
    if (root == null) return;

    PostorderTraversal(root.left,stack);
    PostorderTraversal(root.right,stack);
    if(root.type==1){
          stack.push(root.operand);
    }
    else {
      if(root.operator=='+'){
        int c=stack.pop()+stack.pop();
        stack.push(c);
      }
      if(root.operator=='-'){
        int tmp=stack.pop();
        int c=stack.pop()-tmp;
        stack.push(c);
      }
      if(root.operator=='/'){
        int tmp=stack.pop();
        int c=stack.pop()/tmp;
        stack.push(c);
      }
      if(root.operator=='*'){
        int c=stack.pop()*stack.pop();
        stack.push(c);
      }
    }

  }
}
