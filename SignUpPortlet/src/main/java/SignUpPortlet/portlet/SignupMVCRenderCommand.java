

package SignUpPortlet.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import SignUpPortlet.constants.SignUpPortletKeys;


@Component(
    immediate = true,
    property = {
        "javax.portlet.name="+ SignUpPortletKeys.SIGNUP,   // replace with your portlet name constant
        "mvc.command.name=/user/add_user"
    },
    service = MVCRenderCommand.class
)
public class SignupMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        // This will show signup.jsp from resources/META-INF/resources/
        return "/signUp.jsp";
    }
}









