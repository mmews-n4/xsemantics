package it.xsemantics.dsl.tests.generator;

import com.google.inject.Inject;
import it.xsemantics.dsl.XsemanticsInjectorProvider;
import it.xsemantics.dsl.generator.XsemanticsGeneratorExtensions;
import it.xsemantics.dsl.tests.generator.XsemanticsGeneratorBaseTest;
import it.xsemantics.dsl.xsemantics.ErrorSpecification;
import it.xsemantics.dsl.xsemantics.JudgmentDescription;
import it.xsemantics.dsl.xsemantics.XsemanticsSystem;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(value = XsemanticsInjectorProvider.class)
@RunWith(value = XtextRunner.class)
@SuppressWarnings("all")
public class XsemanticsSystemGeneratorTest extends XsemanticsGeneratorBaseTest {
  @Inject
  private XsemanticsGeneratorExtensions _xsemanticsGeneratorExtensions;
  
  @Test
  public void testCompileOfErrorSpecification() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecification = this.testFiles.testJudgmentDescriptionsWithErrorSpecification();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void typeThrowException(String _issue, Exception _ex, final EObject c) ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throws RuleFailedException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _plus = (\"this \" + c);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _plus_1 = (_plus + \" made an error!\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String error = _plus_1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EObject source = c;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EClass _eClass = c.eClass();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EStructuralFeature feature = _eContainingFeature;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throwRuleFailedException(error,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("_issue, _ex,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new ErrorInformation(source, feature));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    this.checkErrorSpecification(_testJudgmentDescriptionsWithErrorSpecification, _builder);
  }
  
  @Test
  public void testCompileOfErrorSpecificationWithoutSourceAndFeature() {
    CharSequence _testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature = this.testFiles.testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void typeThrowException(String _issue, Exception _ex, final EObject c) ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throws RuleFailedException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _plus = (\"this \" + c);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _plus_1 = (_plus + \" made an error!\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String error = _plus_1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throwRuleFailedException(error,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("_issue, _ex,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new ErrorInformation(null, null));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    this.checkErrorSpecification(_testJudgmentDescriptionsWithErrorSpecificationWithoutSourceAndFeature, _builder);
  }
  
  @Test
  public void testCompileOfErrorSpecificationWithStringRep() {
    CharSequence _testStringRep = this.testFiles.testStringRep();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void typeThrowException(String _issue, Exception _ex, final EObject c) ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throws RuleFailedException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _stringRep = this.stringRep(c);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _plus = (\"this \" + _stringRep);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _plus_1 = (_plus + \" made an error!\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String error = _plus_1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EObject source = c;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EClass _eClass = c.eClass();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EStructuralFeature _eContainingFeature = _eClass.eContainingFeature();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EStructuralFeature feature = _eContainingFeature;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throwRuleFailedException(error,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("_issue, _ex,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new ErrorInformation(source, feature));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    this.checkErrorSpecification(_testStringRep, _builder);
  }
  
  @Test
  public void testCompileOfErrorWithReferenceToThis() {
    CharSequence _testForScopeOfThisInJudgmentDescription = this.testFiles.testForScopeOfThisInJudgmentDescription();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void typeThrowException(String _issue, Exception _ex, final EObject c) ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("throws RuleFailedException {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EClass _eClass = c.eClass();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EClass _clone = this.<EClass>clone(_eClass);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _plus = (\"this \" + _clone);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String _plus_1 = (_plus + \" made an error!\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String error = _plus_1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EObject _clone_1 = this.<EObject>clone(c);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EObject source = _clone_1;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EClass _eClass_1 = c.eClass();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EClass _clone_2 = this.<EClass>clone(_eClass_1);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EStructuralFeature _eContainingFeature = _clone_2.eContainingFeature();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("EStructuralFeature feature = _eContainingFeature;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("throwRuleFailedException(error,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("_issue, _ex,");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("new ErrorInformation(source, feature));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    this.checkErrorSpecification(_testForScopeOfThisInJudgmentDescription, _builder);
  }
  
  public void checkErrorSpecification(final CharSequence inputProgram, final CharSequence expected) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(inputProgram);
    final JudgmentDescription jDesc = this.firstJudgmentDescription(_parseAndAssertNoError);
    ImportManager _importManager = new ImportManager(true);
    final CharSequence result = this.tsGenerator.compileErrorSpecification(jDesc, _importManager);
    this.assertEqualsStrings(expected, result);
  }
  
  public void checkCompilationOfErrorSpecification(final CharSequence inputProgram, final Function2<? super ErrorSpecification,? super IAppendable,? extends String> compilation, final CharSequence expected, final CharSequence expectedVar) {
    XsemanticsSystem _parseAndAssertNoError = this.parseAndAssertNoError(inputProgram);
    final JudgmentDescription jDesc = this.firstJudgmentDescription(_parseAndAssertNoError);
    final ErrorSpecification errSpec = this.firstErrorSpecification(jDesc);
    ImportManager _importManager = new ImportManager(true);
    final TreeAppendable appendable = this._xsemanticsGeneratorExtensions.createAndConfigureAppendable(jDesc, _importManager);
    final String variable = compilation.apply(errSpec, appendable);
    this.assertEqualsStrings(expected, appendable);
    this.assertEqualsStrings(expectedVar, variable);
  }
}
