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

package it.xsemantics.example.lambda.xsemantics.validation;

import com.google.inject.Inject;
import it.xsemantics.example.lambda.lambda.Program;
import it.xsemantics.example.lambda.validation.AbstractLambdaJavaValidator;
import it.xsemantics.example.lambda.xsemantics.LambdaXsemanticsSystem;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.Check;

@SuppressWarnings("all")
public class LambdaXsemanticsSystemValidator extends AbstractLambdaJavaValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected LambdaXsemanticsSystem xsemanticsSystem;
  
  protected LambdaXsemanticsSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
  
  @Check
  public void checkProgram(final Program program) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkProgram(program),
    		program);
  }
}
