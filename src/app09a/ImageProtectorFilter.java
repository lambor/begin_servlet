package app09a;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by lambor on 17-5-9.
 */
@WebFilter(filterName = "ImageProtectorFilter", urlPatterns = {"*.png","*.jpg","*.gif"}, asyncSupported = true)
public class ImageProtectorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ImageProtectorFilter init.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ImageProtectorFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String referrer = httpServletRequest.getHeader("referer"); //referer为制定http协议时拼写错误
        System.out.println("referer:"+referrer);
        if(referrer != null) { //防止盗链 下载时请求request的header不带referer?
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            throw new ServletException("Image not available");
        }
    }

    @Override
    public void destroy() {

    }
}
