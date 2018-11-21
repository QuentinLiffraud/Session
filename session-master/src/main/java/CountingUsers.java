
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CountingUsers implements HttpSessionListener {
    
    private int numberOfUsers=0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //On incrémente le nombre d'utilisateurs
        numberOfUsers++;
        //On stocke ce nombre dans le contexte d'application
        se.getSession().getServletContext().setAttribute("numberConnected", numberOfUsers);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        numberOfUsers--;
        se.getSession().getServletContext().setAttribute("numberConnected", numberOfUsers);
    }
    
    
}
