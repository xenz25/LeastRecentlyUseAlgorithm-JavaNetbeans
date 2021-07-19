package errorpack;

import java.util.HashMap;

public class ErrorCode {
	public static final String[] ERR_PARAM_KEY = {"TIL", "DEF"};
	private HashMap<Integer, HashMap<String, String>> error_library = new HashMap<>();
	
	public ErrorCode() {
		// TODO Auto-generated constructor stub
		initLibrary();
	}
	
	private void initLibrary() {
		error_library.put(0, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "Reference String Length");
			put(ERR_PARAM_KEY[1], "The allowable length of reference string is 5-15.");
		}});
		error_library.put(1, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "Invalid Reference String");
			put(ERR_PARAM_KEY[1], "It looks like the inputted Reference String is Invalid.");
		}});
		error_library.put(2, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "Decimal Number on Reference String");
			put(ERR_PARAM_KEY[1], "The Reference String numbers must be a Whole Number.");
		}});
		error_library.put(3, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "Zero Page Frame");
			put(ERR_PARAM_KEY[1], "The Page Frame number cannot be Zero.");
		}});
		error_library.put(4, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "Decimal Number on Page Frame");
			put(ERR_PARAM_KEY[1], "The Page Frame number must be a Whole Number.");
		}});
		error_library.put(5, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "No Input Found");
			put(ERR_PARAM_KEY[1], "Required Inputs are not Found.\nCannot proceed.");
		}});
		error_library.put(6, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "Oops!");
			put(ERR_PARAM_KEY[1], "An unknown error had interrupted current task.");
		}});
		error_library.put(7, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "Negative Number on Reference String");
			put(ERR_PARAM_KEY[1], "Reference String number cannot be Negative.");
		}});
		error_library.put(8, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "Negative Number on Page Frame");
			put(ERR_PARAM_KEY[1], "Page Frame number cannot be Negative.");
		}});
		error_library.put(9, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "Multiple Errors Found");
			put(ERR_PARAM_KEY[1], "Please double check the inputted Reference String.");
		}});
		error_library.put(10, new HashMap<>() {{
			put(ERR_PARAM_KEY[0], "Multiple Errors Found");
			put(ERR_PARAM_KEY[1], "Please double check the inputted Page Frame.");
		}});
	}
	
	public HashMap<String, String> getErrorCodeParameter(int err_code_number){
		return error_library.get(err_code_number);
	}

}
 