package TicketMgmtHeadlessSystemPortlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "javax.portlet.display-name=TicketMgmtHeadlessSystem",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.name=TicketMgmtHeadlessSystem",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class TicketMgmtHeadlessSystemPortlet extends MVCPortlet {

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws IOException, PortletException {

        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
        String csrfToken = AuthTokenUtil.getToken(httpRequest);

        String method = resourceRequest.getMethod(); // GET or POST
        String baseUrl = PortalUtil.getPortalURL(resourceRequest) + "/o/TicketMgmtHeadlessAPI/v1.0";

        String apiUrl = baseUrl + (method.equals("GET") ? "/get-tickets" : "/add-ticket");

        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("x-csrf-token", csrfToken);
        con.setRequestProperty("Cookie", httpRequest.getHeader("Cookie"));
        con.setRequestProperty("Authorization", "Basic " +
                Base64.encode("test@liferay.com:test1".getBytes()));

        con.setRequestMethod(method);

        if ("POST".equals(method)) {
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");

            // Read body from AJAX
            StringBuilder body = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(resourceRequest.getPortletInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    body.append(line);
                }
            }

            try (OutputStream os = con.getOutputStream()) {
                os.write(body.toString().getBytes());
                os.flush();
            }
        }

        int responseCode = con.getResponseCode();
        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                responseCode < 400 ? con.getInputStream() : con.getErrorStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
        }

        resourceResponse.setContentType("application/json");
        resourceResponse.getWriter().write(response.toString());
    }
}
