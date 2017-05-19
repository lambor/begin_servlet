package controller.app20a;

import app20a.domain.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lambor on 17-5-19.
 */

@Controller
public class EmployeeController {
    private static final Log logger = LogFactory.getLog(EmployeeController.class);

    @RequestMapping("/app20a/employee_input")
    public String inputEmployee(Model model) {
        model.addAttribute(new Employee());
        return "EmployeeForm";
    }

    @RequestMapping("/app20a/employee_save")
    public String saveEmployee(Employee employee, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            logger.info("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
            return "EmployeeForm";
        }

        model.addAttribute("employee",employee);
        return "EmployeeDetails";
    }
}
