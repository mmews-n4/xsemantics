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

package it.xsemantics.dsl.tests.generator.fj;

import it.xsemantics.dsl.tests.generator.fj.common.FjAbstractGeneratedValidatorTests;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomRuntimeModuleForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.FjCustomStandaloneSetupForTesting;
import it.xsemantics.dsl.tests.generator.fj.common.FjExpectedTraces;
import it.xsemantics.test.fj.alt.validation.FjAltTypeSystemValidator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public class FjAltGeneratedValidatorTests extends
		FjAbstractGeneratedValidatorTests {

	public static class FjStandaloneSetupAlt extends
			FjCustomStandaloneSetupForTesting {

		public static class CustomFjTypeSystemValidator extends
				FjAltTypeSystemValidator {
			@Override
			protected List<EPackage> getEPackages() {
				List<EPackage> result = new ArrayList<EPackage>();
				result.add(it.xsemantics.example.fj.fj.FjPackage.eINSTANCE);
				return result;
			}
		}

		@Override
		protected FjCustomRuntimeModuleForTesting createFjCustomRuntimeModule() {
			return new FjCustomRuntimeModuleForTesting(fjTypeSystemClass()) {

				@Override
				public Class<? extends AbstractDeclarativeValidator> bindAbstractDeclarativeValidator() {
					return CustomFjTypeSystemValidator.class;
				}
				
				@SuppressWarnings("unused")
				public java.lang.Class<? extends FjExpectedTraces> bindFjExpectedTraces() {
					return FjAltExpectedTraces.class;
				}

			};
		}

		@Override
		protected Class<FjAltTypeSystemWrapper> fjTypeSystemClass() {
			return FjAltTypeSystemWrapper.class;
		}
	}

	protected Class<? extends FjCustomStandaloneSetupForTesting> fjCustomStandaloneSetupClass() {
		return FjStandaloneSetupAlt.class;
	}


}
