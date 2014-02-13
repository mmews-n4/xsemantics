package it.xsemantics.test.validation.ecore;

import com.google.common.base.Objects;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class TypeSystem extends XsemanticsRuntimeSystem {
  public final static String ECLASSEOBJECT = "it.xsemantics.test.validation.ecore.EClassEObject";
  
  private PolymorphicDispatcher<Result<EObject>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<EObject>> type2Dispatcher;
  
  public TypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    type2Dispatcher = buildPolymorphicDispatcher1(
    	"type2Impl", 3, "||-", ":");
  }
  
  public Result<EObject> type(final EClass c) {
    return type(new RuleEnvironment(), null, c);
  }
  
  public Result<EObject> type(final RuleEnvironment _environment_, final EClass c) {
    return type(_environment_, null, c);
  }
  
  public Result<EObject> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return typeInternal(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Result<EObject> type2(final EClass c) {
    return type2(new RuleEnvironment(), null, c);
  }
  
  public Result<EObject> type2(final RuleEnvironment _environment_, final EClass c) {
    return type2(_environment_, null, c);
  }
  
  public Result<EObject> type2(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	return type2Internal(_environment_, _trace_, c);
    } catch (Exception _e_type2) {
    	return resultForFailure(_e_type2);
    }
  }
  
  public Result<Boolean> checkEClass(final EClass eClass) {
    return checkEClass(null, eClass);
  }
  
  public Result<Boolean> checkEClass(final RuleApplicationTrace _trace_, final EClass eClass) {
    try {
    	return checkEClassInternal(_trace_, eClass);
    } catch (Exception e) {
    	return resultForFailure(e);
    }
  }
  
  protected Result<Boolean> checkEClassInternal(final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    EObject result = null;
    /* empty |- eClass : result */
    Result<EObject> result_1 = typeInternal(emptyEnvironment(), _trace_, eClass);
    checkAssignableTo(result_1.getFirst(), EObject.class);
    result = (EObject) result_1.getFirst();
    
    return new Result<Boolean>(true);
  }
  
  protected Result<EObject> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	checkParamsNotNull(c);
    	return typeDispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EClass c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<EObject> type2Internal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EClass c) {
    try {
    	checkParamsNotNull(c);
    	return type2Dispatcher.invoke(_environment_, _trace_, c);
    } catch (Exception _e_type2) {
    	sneakyThrowRuleFailedException(_e_type2);
    	return null;
    }
  }
  
  protected void type2ThrowException(final String _error, final String _issue, final Exception _ex, final EClass c, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<EObject> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    try {
    	RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	Result<EObject> _result_ = applyRuleEClassEObject(G, _subtrace_, eClass);
    	addToTrace(_trace_, ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEClassEObject) {
    	typeThrowException(ruleName("EClassEObject") + stringRepForEnv(G) + " |- " + stringRep(eClass) + " : " + "EObject",
    		ECLASSEOBJECT,
    		e_applyRuleEClassEObject, eClass, new ErrorInformation[] {new ErrorInformation(eClass)});
    	return null;
    }
  }
  
  protected Result<EObject> applyRuleEClassEObject(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EClass eClass) throws RuleFailedException {
    EObject object = null; // output parameter
    boolean _or = false;
    String _string = new String();
    boolean _equals = Objects.equal("foo", _string);
    if (_equals) {
      _or = true;
    } else {
      String _string_1 = new String();
      boolean _equals_1 = Objects.equal("bar", _string_1);
      _or = _equals_1;
    }
    /* 'foo' == new String() || 'bar' == new String() */
    if (!_or) {
      sneakyThrowRuleFailedException("\'foo\' == new String() || \'bar\' == new String()");
    }
    boolean _and = false;
    String _string_2 = new String();
    boolean _equals_2 = Objects.equal("foo", _string_2);
    if (!_equals_2) {
      _and = false;
    } else {
      String _string_3 = new String();
      boolean _equals_3 = Objects.equal("bar", _string_3);
      _and = _equals_3;
    }
    /* 'foo' == new String() && 'bar' == new String() */
    if (!_and) {
      sneakyThrowRuleFailedException("\'foo\' == new String() && \'bar\' == new String()");
    }
    String _string_4 = new String();
    String _firstUpper = StringExtensions.toFirstUpper("bar");
    String _plus = (_string_4 + _firstUpper);
    boolean _equals_4 = Objects.equal("foo", _plus);
    /* 'foo' == new String() + 'bar'.toFirstUpper */
    if (!_equals_4) {
      sneakyThrowRuleFailedException("\'foo\' == new String() + \'bar\'.toFirstUpper");
    }
    String _string_5 = new String();
    String _firstUpper_1 = StringExtensions.toFirstUpper("bar");
    String _plus_1 = (_string_5 + _firstUpper_1);
    boolean _notEquals = (!Objects.equal("foo", _plus_1));
    /* 'foo' != new String() + 'bar'.toFirstUpper */
    if (!_notEquals) {
      sneakyThrowRuleFailedException("\'foo\' != new String() + \'bar\'.toFirstUpper");
    }
    String _string_6 = new String();
    String _firstUpper_2 = StringExtensions.toFirstUpper("bar");
    final String temp = (_string_6 + _firstUpper_2);
    boolean _contains = "foo".contains("f");
    /* 'foo'.contains('f') */
    if (!_contains) {
      sneakyThrowRuleFailedException("\'foo\'.contains(\'f\')");
    }
    "foo".concat("f");
    boolean _contains_1 = "foo".contains("f");
    /* !('foo'.contains('f')) */
    if (!(!_contains_1)) {
      sneakyThrowRuleFailedException("!(\'foo\'.contains(\'f\'))");
    }
    return new Result<EObject>(object);
  }
}
