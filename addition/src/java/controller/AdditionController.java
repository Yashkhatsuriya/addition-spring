/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.AdditionService;

/**
 *
 * @author yash
 */
public class AdditionController extends SimpleFormController {
    private AdditionService additionService;
    public void setAdditionService(AdditionService additionService)
    {
        this.additionService=additionService;
    }
    
    public AdditionController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Addition.class);
        setCommandName("addition");
        setSuccessView("resultView");
        setFormView("inputView");
    }
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
            Addition addition = (Addition) command;
        ModelAndView modelAndView = new ModelAndView(getSuccessView());
        modelAndView.addObject("answer",AdditionService.doAddition(addition.getNumber1(),addition.getNumber2()));
      
        return modelAndView;
    }
    
     
}
