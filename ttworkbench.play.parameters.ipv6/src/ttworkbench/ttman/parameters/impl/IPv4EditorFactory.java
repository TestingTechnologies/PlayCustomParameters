package ttworkbench.ttman.parameters.impl;

import java.util.List;

import com.testingtech.ttworkbench.ttman.parameters.api.IAttribute;
import com.testingtech.ttworkbench.ttman.parameters.api.IParameter;
import com.testingtech.ttworkbench.ttman.parameters.api.IParameterEditor;
import com.testingtech.ttworkbench.ttman.parameters.api.IParameterEditorFactory;

public class IPv4EditorFactory implements IParameterEditorFactory {

	public IPv4EditorFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isApplicable(IParameter<? extends Object> parameter) {
		// TODO Auto-generated method stub
		parameter.getType(); //"Module1.Type2"
		parameter.getName(); //"Module1.Parameter2"
		return false;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IAttribute> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IParameterEditor create() {
		// TODO Auto-generated method stub
		return null;
	}

}

