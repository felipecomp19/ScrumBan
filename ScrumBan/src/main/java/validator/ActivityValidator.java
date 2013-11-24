package validator;

import model.ActivityModel;

import org.springframework.validation.Errors;
import org.springframework.util.StringUtils;

/**
 * <code>Validator</code> for <code>Activity</code> forms
 * 
 * @author Felipe Teixeira
 *
 */
public class ActivityValidator {

	public void validate(ActivityModel newActivity, Errors errors) {
		String name = newActivity.getName();
		if(!StringUtils.hasLength(name))
			errors.rejectValue("name", "required","required");
	}
}
