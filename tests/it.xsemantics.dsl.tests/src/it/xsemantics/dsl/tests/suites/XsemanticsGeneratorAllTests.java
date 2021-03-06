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

package it.xsemantics.dsl.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import it.xsemantics.dsl.tests.generator.UniqueNamesTest;
import it.xsemantics.dsl.tests.generator.XsemanticsCompilerTest;
import it.xsemantics.dsl.tests.generator.XsemanticsErrorSpecificationGeneratorTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratedFileHeaderTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratedJavaCodeTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorExtensionsTest;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorRunnerTests;
import it.xsemantics.dsl.tests.generator.XsemanticsJvmModelGeneratorTest;
import it.xsemantics.dsl.tests.generator.XsemanticsXbaseCompilerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	UniqueNamesTest.class,
	XsemanticsGeneratorExtensionsTest.class,
	XsemanticsXbaseCompilerTest.class,
	XsemanticsJvmModelGeneratorTest.class,
	XsemanticsCompilerTest.class,
	XsemanticsGeneratorRunnerTests.class,
	XsemanticsErrorSpecificationGeneratorTest.class,
	XsemanticsGeneratedJavaCodeTest.class,
	XsemanticsGeneratedFileHeaderTest.class
})
public class XsemanticsGeneratorAllTests {

}
