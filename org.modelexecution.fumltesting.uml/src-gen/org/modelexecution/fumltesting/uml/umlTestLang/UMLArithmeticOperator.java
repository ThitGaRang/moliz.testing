/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>UML Arithmetic Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLArithmeticOperator()
 * @model
 * @generated
 */
public enum UMLArithmeticOperator implements Enumerator
{
  /**
   * The '<em><b>Equal</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EQUAL_VALUE
   * @generated
   * @ordered
   */
  EQUAL(0, "equal", "="),

  /**
   * The '<em><b>Not equal</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NOT_EQUAL_VALUE
   * @generated
   * @ordered
   */
  NOT_EQUAL(1, "not_equal", "!="),

  /**
   * The '<em><b>Greater</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GREATER_VALUE
   * @generated
   * @ordered
   */
  GREATER(2, "greater", ">"),

  /**
   * The '<em><b>Smaller</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SMALLER_VALUE
   * @generated
   * @ordered
   */
  SMALLER(3, "smaller", "<"),

  /**
   * The '<em><b>Greater equal</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GREATER_EQUAL_VALUE
   * @generated
   * @ordered
   */
  GREATER_EQUAL(4, "greater_equal", ">="),

  /**
   * The '<em><b>Smaller equal</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SMALLER_EQUAL_VALUE
   * @generated
   * @ordered
   */
  SMALLER_EQUAL(5, "smaller_equal", "<="),

  /**
   * The '<em><b>Includes</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INCLUDES_VALUE
   * @generated
   * @ordered
   */
  INCLUDES(6, "includes", "includes"),

  /**
   * The '<em><b>Excludes</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXCLUDES_VALUE
   * @generated
   * @ordered
   */
  EXCLUDES(7, "excludes", "excludes");

  /**
   * The '<em><b>Equal</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Equal</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EQUAL
   * @model name="equal" literal="="
   * @generated
   * @ordered
   */
  public static final int EQUAL_VALUE = 0;

  /**
   * The '<em><b>Not equal</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Not equal</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NOT_EQUAL
   * @model name="not_equal" literal="!="
   * @generated
   * @ordered
   */
  public static final int NOT_EQUAL_VALUE = 1;

  /**
   * The '<em><b>Greater</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Greater</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GREATER
   * @model name="greater" literal=">"
   * @generated
   * @ordered
   */
  public static final int GREATER_VALUE = 2;

  /**
   * The '<em><b>Smaller</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Smaller</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SMALLER
   * @model name="smaller" literal="<"
   * @generated
   * @ordered
   */
  public static final int SMALLER_VALUE = 3;

  /**
   * The '<em><b>Greater equal</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Greater equal</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GREATER_EQUAL
   * @model name="greater_equal" literal=">="
   * @generated
   * @ordered
   */
  public static final int GREATER_EQUAL_VALUE = 4;

  /**
   * The '<em><b>Smaller equal</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Smaller equal</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SMALLER_EQUAL
   * @model name="smaller_equal" literal="<="
   * @generated
   * @ordered
   */
  public static final int SMALLER_EQUAL_VALUE = 5;

  /**
   * The '<em><b>Includes</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Includes</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INCLUDES
   * @model name="includes"
   * @generated
   * @ordered
   */
  public static final int INCLUDES_VALUE = 6;

  /**
   * The '<em><b>Excludes</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Excludes</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EXCLUDES
   * @model name="excludes"
   * @generated
   * @ordered
   */
  public static final int EXCLUDES_VALUE = 7;

  /**
   * An array of all the '<em><b>UML Arithmetic Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final UMLArithmeticOperator[] VALUES_ARRAY =
    new UMLArithmeticOperator[]
    {
      EQUAL,
      NOT_EQUAL,
      GREATER,
      SMALLER,
      GREATER_EQUAL,
      SMALLER_EQUAL,
      INCLUDES,
      EXCLUDES,
    };

  /**
   * A public read-only list of all the '<em><b>UML Arithmetic Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<UMLArithmeticOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>UML Arithmetic Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UMLArithmeticOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      UMLArithmeticOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>UML Arithmetic Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UMLArithmeticOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      UMLArithmeticOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>UML Arithmetic Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UMLArithmeticOperator get(int value)
  {
    switch (value)
    {
      case EQUAL_VALUE: return EQUAL;
      case NOT_EQUAL_VALUE: return NOT_EQUAL;
      case GREATER_VALUE: return GREATER;
      case SMALLER_VALUE: return SMALLER;
      case GREATER_EQUAL_VALUE: return GREATER_EQUAL;
      case SMALLER_EQUAL_VALUE: return SMALLER_EQUAL;
      case INCLUDES_VALUE: return INCLUDES;
      case EXCLUDES_VALUE: return EXCLUDES;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private UMLArithmeticOperator(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //UMLArithmeticOperator
