/**
 */
package org.modelexecution.fumltesting.uml.umlTestLang;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>UML Temporal Quantifier</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.modelexecution.fumltesting.uml.umlTestLang.UmlTestLangPackage#getUMLTemporalQuantifier()
 * @model
 * @generated
 */
public enum UMLTemporalQuantifier implements Enumerator
{
  /**
   * The '<em><b>Always</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ALWAYS_VALUE
   * @generated
   * @ordered
   */
  ALWAYS(0, "always", "always"),

  /**
   * The '<em><b>Sometimes</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #SOMETIMES_VALUE
   * @generated
   * @ordered
   */
  SOMETIMES(1, "sometimes", "sometimes"),

  /**
   * The '<em><b>Eventually</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EVENTUALLY_VALUE
   * @generated
   * @ordered
   */
  EVENTUALLY(2, "eventually", "eventually"),

  /**
   * The '<em><b>Immediately</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #IMMEDIATELY_VALUE
   * @generated
   * @ordered
   */
  IMMEDIATELY(3, "immediately", "immediately");

  /**
   * The '<em><b>Always</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Always</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ALWAYS
   * @model name="always"
   * @generated
   * @ordered
   */
  public static final int ALWAYS_VALUE = 0;

  /**
   * The '<em><b>Sometimes</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Sometimes</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #SOMETIMES
   * @model name="sometimes"
   * @generated
   * @ordered
   */
  public static final int SOMETIMES_VALUE = 1;

  /**
   * The '<em><b>Eventually</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Eventually</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #EVENTUALLY
   * @model name="eventually"
   * @generated
   * @ordered
   */
  public static final int EVENTUALLY_VALUE = 2;

  /**
   * The '<em><b>Immediately</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Immediately</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #IMMEDIATELY
   * @model name="immediately"
   * @generated
   * @ordered
   */
  public static final int IMMEDIATELY_VALUE = 3;

  /**
   * An array of all the '<em><b>UML Temporal Quantifier</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final UMLTemporalQuantifier[] VALUES_ARRAY =
    new UMLTemporalQuantifier[]
    {
      ALWAYS,
      SOMETIMES,
      EVENTUALLY,
      IMMEDIATELY,
    };

  /**
   * A public read-only list of all the '<em><b>UML Temporal Quantifier</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<UMLTemporalQuantifier> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>UML Temporal Quantifier</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UMLTemporalQuantifier get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      UMLTemporalQuantifier result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>UML Temporal Quantifier</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UMLTemporalQuantifier getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      UMLTemporalQuantifier result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>UML Temporal Quantifier</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UMLTemporalQuantifier get(int value)
  {
    switch (value)
    {
      case ALWAYS_VALUE: return ALWAYS;
      case SOMETIMES_VALUE: return SOMETIMES;
      case EVENTUALLY_VALUE: return EVENTUALLY;
      case IMMEDIATELY_VALUE: return IMMEDIATELY;
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
  private UMLTemporalQuantifier(int value, String name, String literal)
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
  
} //UMLTemporalQuantifier
