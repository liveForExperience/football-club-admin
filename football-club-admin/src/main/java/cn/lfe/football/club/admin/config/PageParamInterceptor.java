package cn.lfe.football.club.admin.config;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author ChenYue
 * @date 2021/6/30 17:55
 */
public class PageParamInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(@NonNull HttpServletRequest httpServletRequest, @NonNull HttpServletResponse httpServletResponse, @NonNull Object o, Exception e) {
        PageParamHolder.remove();
    }
}
