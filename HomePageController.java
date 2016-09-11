package com.geekcap.geeknews.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.geekcap.geeknews.core.GeekNewsService;
import com.geekcap.geeknews.core.NewsArticle;

/**
 * The HomePageController is responsible for building the model of data to display
 * on the home page, which at this point contains a list of article overviews.
 * 
 * @author shaines
 *
 */
public class HomePageController extends AbstractController {
   /**
    * Provides access to GeekNews business methods
    */
   private GeekNewsService service;

   /**
    * Responsible for translating a web request into a ModelAndView object for presentation
    */
   @Override
   protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
      
      // Use the service to load the articles
      List<NewsArticle> articles = service.getArticleOverviews();
      
      // Send the articles to the "home" view
      return new ModelAndView( "home", "articles", articles );
   }
   
   /**
    * Injected by Spring
    * @param service
    */
   public void setGeekNewsService( GeekNewsService service ) {
      this.service = service;
   }
}
