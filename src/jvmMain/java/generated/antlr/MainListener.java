// Generated from antlr/Main.g4 by ANTLR 4.13.2

package generated.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MainParser}.
 */
public interface MainListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MainParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MainParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MainParser.PrimaryContext ctx);
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
}