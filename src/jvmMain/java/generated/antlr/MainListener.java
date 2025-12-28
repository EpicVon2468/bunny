// Generated from antlr/Main.g4 by ANTLR 4.13.2

package generated.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MainParser}.
 */
public interface MainListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MainParser#top}.
	 * @param ctx the parse tree
	 */
	void enterTop(MainParser.TopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#top}.
	 * @param ctx the parse tree
	 */
	void exitTop(MainParser.TopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#topLevel}.
	 * @param ctx the parse tree
	 */
	void enterTopLevel(MainParser.TopLevelContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#topLevel}.
	 * @param ctx the parse tree
	 */
	void exitTopLevel(MainParser.TopLevelContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#version}.
	 * @param ctx the parse tree
	 */
	void enterVersion(MainParser.VersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#version}.
	 * @param ctx the parse tree
	 */
	void exitVersion(MainParser.VersionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(MainParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(MainParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinition(MainParser.TypeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinition(MainParser.TypeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(MainParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(MainParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(MainParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(MainParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#returnExpression}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpression(MainParser.ReturnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#returnExpression}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpression(MainParser.ReturnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MainParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MainParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(MainParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(MainParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(MainParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(MainParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#termExpression}.
	 * @param ctx the parse tree
	 */
	void enterTermExpression(MainParser.TermExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#termExpression}.
	 * @param ctx the parse tree
	 */
	void exitTermExpression(MainParser.TermExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#factorExpression}.
	 * @param ctx the parse tree
	 */
	void enterFactorExpression(MainParser.FactorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#factorExpression}.
	 * @param ctx the parse tree
	 */
	void exitFactorExpression(MainParser.FactorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(MainParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(MainParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(MainParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(MainParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MainParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MainParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MainParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MainParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainParser#pointerType}.
	 * @param ctx the parse tree
	 */
	void enterPointerType(MainParser.PointerTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#pointerType}.
	 * @param ctx the parse tree
	 */
	void exitPointerType(MainParser.PointerTypeContext ctx);
}