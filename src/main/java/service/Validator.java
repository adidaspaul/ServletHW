package service;


import model.ErrorMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    public ErrorMessage validateAddDeveloper(HttpServletRequest request){
        ErrorMessage errorMessage = new ErrorMessage();
        List<String> errors = new ArrayList<>();

        try{
            Integer id = Integer.parseInt(request.getParameter("id"));
        }catch (NumberFormatException e){
            errors.add("Id must be a number");
        }

        String name = request.getParameter("devName");
            if(name.isEmpty()){
            errors.add("Name is required");
        }
            String sex = request.getParameter("devsSex");
            if(sex.isEmpty()){
                errors.add("Sex must be chosen");
            }

            Double salary = Double.parseDouble(request.getParameter("devSalary"));
            if(salary.isNaN()){
                errors.add("Type Salary");
            }
            errorMessage.setErrors(errors);

        return errorMessage;
    }

}
