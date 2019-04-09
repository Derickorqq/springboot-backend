package com.hospital.hospitalgd.common.interceptor;

import com.hospital.hospitalgd.common.ConstPool;
import com.hospital.hospitalgd.common.ResponseCode;
import com.hospital.hospitalgd.common.ServerResponse;
import com.hospital.hospitalgd.model.UserSessionModel;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: hospital-gd
 * @description:
 * @author: Art
 * @create: 2019-04-08 17:04
 **/
public class SessionInterceptor implements HandlerInterceptor {

    /**
     * preHandle中拦截所有ajax请求，排除所有非ajax请求，包括对页面和静态资源的访问
     * 统一校验session，session过期则统一返回session过期状态码，页面需要包装ajax方法统一处理这个状态码
     * 为什么不用重定向：重定向后页面引用路径问题非常蛋疼，而且针对ajax的氢气，重定向没反应，还是要ajax配合完成跳转
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session=request.getSession();
        //可以直接通过${preUrl}取值
        session.setAttribute("preUrl",request.getContextPath());
        UserSessionModel userSessionModel = (UserSessionModel)session.getAttribute(ConstPool.SESSION_USER_INFO_KEY_PRE);
        // 当请求不是请求静态资源，
        // 并且不是请求页面的时，
        // 统一校验session有效性
        if(
                !request.getRequestURI().matches("^"+request.getContextPath()+"(/login$|/page/.*)")
                &&!request.getRequestURI().matches(".*\\.(js|css|jpg|png|map)(\\?.*)?$")
                ){
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            if(userSessionModel==null||userSessionModel.getUserName()==null){
                response.getWriter().write(mapper.writeValueAsString(ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"登录失效")));
                return false;
            }
        }
        return true;
    }

    /**
     * 所有页面都写在一个路由类中
     * 过滤所有对页面的访问路径，校验session
     * session失效则返回到登录页面
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session=request.getSession();
        UserSessionModel ob=(UserSessionModel)session.getAttribute(ConstPool.SESSION_USER_INFO_KEY_PRE);
        if(request.getRequestURI().contains(request.getContextPath()+"/page/")
                &&!request.getRequestURI().contains(request.getContextPath()+"/page/login")){
            if (ob==null||ob.getUserName()==null) {
                modelAndView.setViewName("login");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
