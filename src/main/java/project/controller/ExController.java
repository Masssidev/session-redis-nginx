package project.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpSession session, @RequestParam HashMap param){
    	String sUser = (String) session.getAttribute("user");

    	if (sUser == null) {
            sUser = (String)param.get("user");
            session.setAttribute("user", sUser);
            return "create " + sUser + " session.";
        } else {
            sUser = (String)session.getAttribute("user");
        }

    	logger.info("session id : {} ", request.getSession().getId());
        return "load " + sUser + " session.";
    }
}


