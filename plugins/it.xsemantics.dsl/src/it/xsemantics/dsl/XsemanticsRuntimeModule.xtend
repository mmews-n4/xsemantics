/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

/*
 * generated by Xtext
 */
package it.xsemantics.dsl

import it.xsemantics.dsl.generator.XsemanticsOutputConfigurationProvider
import it.xsemantics.dsl.generator.XsemanticsXbaseCompiler
import it.xsemantics.dsl.typing.XsemanticsTypeComputer
import it.xsemantics.dsl.validation.XsemanticsXExpressionHelper
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfigurationProvider
import org.eclipse.xtext.xbase.compiler.XbaseCompiler
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer
import org.eclipse.xtext.xbase.util.XExpressionHelper
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator

/** 
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class XsemanticsRuntimeModule extends it.xsemantics.dsl.AbstractXsemanticsRuntimeModule {
	override Class<? extends ITypeComputer> bindITypeComputer() {
		return XsemanticsTypeComputer
	}

	def Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider() {
		return XsemanticsOutputConfigurationProvider
	}

	def Class<? extends OutputConfigurationProvider> bindOutputConfigurationProvider() {
		return XsemanticsOutputConfigurationProvider
	}

	def Class<? extends XExpressionHelper> bindXExpressionHelper() {
		return XsemanticsXExpressionHelper
	}

	def Class<? extends XbaseCompiler> bindXbaseCompiler() {
		return XsemanticsXbaseCompiler
	}

	def Class<? extends JvmModelGenerator> bindJvmModelGenerator() {
		return XsemanticsModelGenerator
	}
}
