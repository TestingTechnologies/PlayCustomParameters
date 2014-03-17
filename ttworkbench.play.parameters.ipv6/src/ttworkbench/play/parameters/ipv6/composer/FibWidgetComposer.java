package ttworkbench.play.parameters.ipv6.composer;

import ttworkbench.play.parameters.ipv6.ParameterMap;
import ttworkbench.play.parameters.ipv6.editors.integer.IntegerEditor;
import ttworkbench.play.parameters.ipv6.editors.ValidatingEditor;
import ttworkbench.play.parameters.ipv6.validators.FibValidator;
import ttworkbench.play.parameters.ipv6.validators.FibValidator_ERRORS;
import ttworkbench.play.parameters.ipv6.validators.FibValidator_NUMBER;
import ttworkbench.play.parameters.ipv6.validators.FibValidator_SEQ;
import ttworkbench.play.parameters.ipv6.validators.FibValidator_SUCC;
import ttworkbench.play.parameters.ipv6.widgets.FibWidget;
import ttworkbench.play.parameters.ipv6.widgets.NotifyingWidget;

import com.testingtech.muttcn.values.IntegerValue;
import com.testingtech.ttworkbench.ttman.parameters.api.IConfigurator;
import com.testingtech.ttworkbench.ttman.parameters.api.IParameter;

public class FibWidgetComposer extends WidgetComposer {
	
	// get relevant parameters
	final IParameter<IntegerValue> parameter_PX_N = getParametersMap().getParameterById( "PX_N");
	final IParameter<IntegerValue> parameter_PX_FIB_NUMBER = getParametersMap().getParameterById( "PX_FIB_NUMBER");
	final IParameter<IntegerValue> parameter_PX_FIB_SUCC_NUMBER = getParametersMap().getParameterById( "PX_FIB_SUCC_NUMBER");

	public FibWidgetComposer( IConfigurator theConfigurator, ParameterMap theParametersMap) {
		super( theConfigurator, theParametersMap);
	}

	@Override
	public void compose() {
		NotifyingWidget fibWidget = new FibWidget();
					
		getConfigurator().addWidget( fibWidget);

		FibValidator fibValidator_PX_FIB_NUMBER = new FibValidator_NUMBER();
		FibValidator fibSeqValidator = new FibValidator_SEQ();
		FibValidator fibSuccValidator = new FibValidator_SUCC();
		FibValidator fibWidgetLayerValidator = new FibValidator_ERRORS();
		

		// create an editor for each parameter
		ValidatingEditor<?> editor_PX_N = new IntegerEditor();
		ValidatingEditor<?> editor_PX_FIB_NUMBER = new IntegerEditor();
		ValidatingEditor<?> editor_PX_FIB_SUCC_NUMBER = new IntegerEditor();
		
		


		fibSeqValidator.addParameter( FibValidator.ParameterKey.PX_N, parameter_PX_N);
		fibSeqValidator.addParameter( FibValidator.ParameterKey.PX_FIB_NUMBER, parameter_PX_FIB_NUMBER);
		
		fibSuccValidator.addParameter( FibValidator.ParameterKey.PX_FIB_NUMBER, parameter_PX_FIB_NUMBER);
		fibSuccValidator.addParameter( FibValidator.ParameterKey.PX_FIB_SUCC_NUMBER, parameter_PX_FIB_SUCC_NUMBER);

		fibWidgetLayerValidator.addEditor( FibValidator.ParameterKey.PX_N, editor_PX_N);
		fibWidgetLayerValidator.addEditor( FibValidator.ParameterKey.PX_FIB_NUMBER, editor_PX_FIB_NUMBER);
		fibWidgetLayerValidator.addEditor( FibValidator.ParameterKey.PX_FIB_SUCC_NUMBER, editor_PX_FIB_SUCC_NUMBER);
		
		
		
		
		

		// assign each parameter to the corresponding editor in this widget
		getConfigurator().assign( editor_PX_N, fibWidget, parameter_PX_N);
		getConfigurator().assign( editor_PX_FIB_NUMBER, fibWidget, parameter_PX_FIB_NUMBER);
		getConfigurator().assign( editor_PX_FIB_SUCC_NUMBER, fibWidget, parameter_PX_FIB_SUCC_NUMBER);

		// register editors to corresponding validators
		fibValidator_PX_FIB_NUMBER.registerForMessages( editor_PX_FIB_NUMBER);
		fibValidator_PX_FIB_NUMBER.registerForMessages( fibWidget);
		fibValidator_PX_FIB_NUMBER.registerForMessages( editor_PX_FIB_SUCC_NUMBER);
		fibSeqValidator.registerForMessages( editor_PX_FIB_NUMBER);
		fibSuccValidator.registerForMessages( editor_PX_FIB_SUCC_NUMBER);
		fibSuccValidator.registerForActions( editor_PX_FIB_SUCC_NUMBER);
		
		
	  // register widgets to corresponding validators
		// fibWidgetLayerValidator.registerForMessages( fibWidget);

		// assign validators to the parameters they have to check
		getConfigurator().assign( fibValidator_PX_FIB_NUMBER, fibWidget, parameter_PX_FIB_NUMBER, parameter_PX_FIB_SUCC_NUMBER);
		getConfigurator().assign( fibSeqValidator, fibWidget, parameter_PX_N, parameter_PX_FIB_NUMBER);
		getConfigurator().assign( fibSuccValidator, fibWidget, parameter_PX_FIB_NUMBER, parameter_PX_FIB_SUCC_NUMBER);
		
	}
}