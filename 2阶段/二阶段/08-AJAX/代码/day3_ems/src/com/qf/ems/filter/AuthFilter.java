package com.qf.ems.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    // 过滤
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 转换成带有http的类型
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 将不需要登录就可以访问的页面排除
        final String uri = request.getRequestURI();
        System.out.println(uri);
        final StringBuffer url = request.getRequestURL();
        System.out.println(url);
        if (uri.endsWith(".css") || uri.endsWith(".gif")
                || uri.endsWith("/ems/") || uri.endsWith("index.jsp") ||
                uri.endsWith("login.do") || uri.endsWith("logout.do") || uri.endsWith("code.do")){
        }else {
            // 判断是否登录，如果登录就放行，未登录就跳转到登录界面
            if(request.getSession().getAttribute("user") == null){
                // 未登录
                request.setAttribute("msg", "请先登录");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
        }
        // 交给过滤器链上其他过滤器处置
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
