package io.github.epicvon2468.bunny.typeinfo

/**
 * This only exists because of a bug in the Kotlin compiler.
 *
 * https://github.com/JetBrains/kotlin/blob/master/compiler/frontend/src/org/jetbrains/kotlin/resolve/checkers/SealedInheritorInSameModuleChecker.kt
 *
 * The code in that file checks if the supertype of a class is sealed, and if it is not an expect class then it is considered an error???
 *
 * `!(superClass.isExpect || (superClass.module == currentModule && !superClass.isFromCommonSource))`
 *
 * ```kotlin
 * if (superClass.isSealed()) {
 *   if (descriptor.isFromCommonSource && superClass.module == currentModule) {
 *     return
 *   }
 *   if (!(superClass.isExpect || (superClass.module == currentModule && !superClass.isFromCommonSource))) {
 *     context.trace.report(Errors.SEALED_INHERITOR_IN_DIFFERENT_MODULE.on(typeReference))
 *   }
 * }
 * ```
 *
 * Making this class expect entirely resolves the issue.
 */
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect sealed interface NumberTypeInfo