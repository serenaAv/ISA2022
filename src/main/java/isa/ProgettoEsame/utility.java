//per generare un link da utilizzare per il reset della pw
package isa.ProgettoEsame;

import javax.servlet.http.HttpServletRequest;

public class utility {
    public static String getSiteURL(HttpServletRequest request)
    {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(),"");
    } 
    
}
