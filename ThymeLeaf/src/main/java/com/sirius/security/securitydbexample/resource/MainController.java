package com.sirius.security.securitydbexample.resource;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unbescape.html.HtmlEscape;

import com.sirius.security.securitydbexample.model.Resources;
import com.sirius.security.securitydbexample.repository.ResourcesRepository;

/**
 * Application home page and login.
 */
@Controller
public class MainController {

	@Autowired
	ResourcesRepository resourcesRepository;
	
    @RequestMapping("/")
    public String root(Locale locale) {
        return "redirect:/index.html";
    }

    /** Home page. */
    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }

    /** User zone index. */
    @RequestMapping("/user/index.html")
    public String userIndex(Authentication authentication) {
    	
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();

    	System.err.println(userDetails.getUsername());
    	System.err.println(userDetails.getAuthorities());
    	
    	
    		
        return "user/index";
    }

    /** Administration zone index. */
    @RequestMapping("/admin/index.html")
    public String adminIndex(Model model,Authentication authentication) {
    	
    	
    	// adding messages to the view
    	
    	
    	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    	
    	ArrayList<GrantedAuthority> temp = new ArrayList<GrantedAuthority>(
    			userDetails.getAuthorities().size());
        temp.addAll(userDetails.getAuthorities());
       
    String role = temp.get(0).toString().replace("ROLE_","");
     
    	try {
    Resources resource = resourcesRepository.findByRole(role);
    
	model.addAttribute("message"," Below is the data ");
	model.addAttribute("owner","Company Name : "+resource.getCompanyName());
	model.addAttribute("permission","Permission for the data : "+resource.getPermission());
	model.addAttribute("role","Role : "+userDetails.getAuthorities());

	System.err.println("Data id : "+resource.getData_id());
	System.err.println("Owner of the company data"+resource.getCompanyName());
	System.err.println("Permission for the role"+resource.getPermission());
	System.err.println(userDetails.getAuthorities());
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    
    	
        return "admin/index";
    }

    /** Shared zone index. */
    @RequestMapping("/shared/index.html")
    public String sharedIndex() {
        return "shared/index";
    }

    /** Login form. */
    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    /** Login form with error. */
    @RequestMapping("/login-error.html")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    /** Simulation of an exception. */
    @RequestMapping("/simulateError.html")
    public void simulateError() {
        throw new RuntimeException("This is a simulated error message");
    }

    /** Error page. */
    @RequestMapping("/error.html")
    public String error(HttpServletRequest request, Model model) {
        model.addAttribute("errorCode", "Error " + request.getAttribute("javax.servlet.error.status_code"));
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("<ul>");
        while (throwable != null) {
            errorMessage.append("<li>").append(HtmlEscape.escapeHtml5(throwable.getMessage())).append("</li>");
            throwable = throwable.getCause();
        }
        errorMessage.append("</ul>");
        model.addAttribute("errorMessage", errorMessage.toString());
        return "error";
    }

    /** Error page. */
    @RequestMapping("/403.html")
    public String forbidden() {
        return "403";
    }


}
