package ttworkbench.play.parameters.settings;

import java.util.Map;

public interface Data {

	Widget[] getWidgets();
	
	
	public interface Widget extends WithAttributes {
		String getName();
		String getDescription();
		Image getImage();
		Parameter[] getParameters();
	}
	
	public interface Image {
		String getPath();
	}
	
	public interface Parameter extends WithAttributes {
		String getId();
		Object getDefaultValue();
		String getDescription();
		boolean isDescriptionVisible();

		Validator[] getValidators();
		Relation[] getRelations();
	}

	public interface Relation {
		Validator getValidator();
		RelationPartner[] getRelationPartners();
	}
	
	public interface RelationPartner {
		Parameter getParameter();
		boolean isRegisteredForMessages();
		boolean isRegisteredForActions();
	}
	
	public interface Validator extends WithAttributes {
		boolean isWidgetNotified();
		Class<?> getType();
	}
	
	public interface WithAttributes {
		Map<String, String> getAttributes();
	}
}