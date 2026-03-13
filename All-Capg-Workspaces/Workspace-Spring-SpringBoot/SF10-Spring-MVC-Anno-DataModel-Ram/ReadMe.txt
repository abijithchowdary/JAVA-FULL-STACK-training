

@Controller 	  Marks class as MVC Controller
@RequestMapping   Maps URL to method
@ModelAttribute	  Binds form → POJO
@Autowired	      Dependency Injection

What is @ModelAttribute?
Automatically binds form data to Java object.

Why no request.getParameter()?
Spring MVC handles it internally.

What is DispatcherServlet?
Front Controller of Spring MVC.

Application flow

JSP Form
 ↓
DispatcherServlet (Front Controller)
 ↓
@Controller
 ↓
@ModelAttribute → POJO
 ↓
@Service
 ↓
@Repository (DB)
 ↓
ModelAndView
 ↓
Success.jsp



-------
