package org.modelexecution.fumltesting.ocl.internal.modelinstance;

import org.eclipse.osgi.util.NLS;

/**
 * 
 * @author Stefan
 * 
 */
public class FUMLModelInstanceTypeMessages extends NLS {
	private static final String BUNDLE_NAME = "org.dresdenocl.modelinstancetype.ecore.internal.msg.messages";

	public static String FUMLModelInstanceProvider_InvalidURL;

	public static String FUMLModelInstance_CannotRetrieveElements;
	public static String FUMLModelInstance_ObjectDoesNoMatchToModel;
	public static String FUMLModelInstance_CannotCast;
	public static String FUMLModelInstance_NoSupportOfStaticProperties;
	public static String FUMLModelInstance_NoSupportOfStaticOperations;
	public static String FUMLModelInstance_EnumerationLiteralNotFound;
	public static String FUMLModelInstance_CannotCastTypeClassNotFound;
	public static String FUMLModelInstance_CannotRecreateArray;
	public static String FUMLModelInstance_CannotRecreateCollection;
	public static String FUMLModelInstance_ClassNotFound;

	public static String FUMLModelInstanceFactory_AdapteeIsNoEObjectInstance;
	public static String FUMLModelInstanceFactory_TypeNotFoundInModel;
	public static String FUMLModelInstanceFactory_CannotAdaptToType;

	public static String FUMLModelInstanceObject_PropertyNotFoundInModelInstanceElement;
	public static String FUMLModelInstanceObject_CannotCopyForAtPre;
	public static String FUMLModelInstanceObject_OperationAccessFailed;
	public static String FUMLModelInstanceObject_OperationNotFound;
	public static String FUMLModelInstanceObject_PropertyAccessFailed;

	static {
		NLS.initializeMessages(BUNDLE_NAME, FUMLModelInstanceTypeMessages.class);
	}

	private FUMLModelInstanceTypeMessages() {
		/** No implementation necessary. */
	}
}