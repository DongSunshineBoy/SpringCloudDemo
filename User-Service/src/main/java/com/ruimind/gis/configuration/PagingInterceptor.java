//package com.ruimind.gis.configuration;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.ruimind.gis.dto.query.PageParamQueryDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.persistence.EntityManager;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.Objects;
//
//@Configuration
//public class PagingInterceptor implements HandlerInterceptor, WebMvcConfigurer {
//
//    @Autowired
//    private EntityManager entityManager;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    public PagingInterceptor(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    public PagingInterceptor() {
//    }
//
//
//    @Bean
//    public PagingInterceptor setPagingInterceptor() {
//        return new PagingInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(setPagingInterceptor());
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Class<?> controllerClass = handlerMethod.getBeanType();
//            Method method = handlerMethod.getMethod();
//            if (controllerClass.isAnnotationPresent(RestController.class) || controllerClass.isAnnotationPresent(Controller.class)) {
//                if (method.isAnnotationPresent(Paging.class)) {
//                    Paging paging = method.getAnnotation(Paging.class);
//                    if (paging == null) {
//                        return true;
//                    }
//                    Class<?> dtoClass = paging.dtoClass();
//
//                    if (Objects.isNull(dtoClass)) {
//                        return true;
//                    }
//
//                    PageParamQueryDTO paramQueryDTO = objectMapper.readValue(request.getInputStream(), PageParamQueryDTO.class);
//
//                    //此处可以默认采用前段单个请求方式传递参数
//                    int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
//                    int size = request.getParameter("size") == null ? paramQueryDTO.getSize() : Integer.parseInt(request.getParameter("size"));
//                    String sort = request.getParameter("sort") == null ? paramQueryDTO.getSort() : request.getParameter("sort");
//                    String direction = request.getParameter("direction") == null ? paramQueryDTO.getDirection() : request.getParameter("direction");
//                    Sort sortObject = Sort.by(Sort.Direction.fromString(direction), sort);
//                    Pageable pageable = PageRequest.of(page - 1, size, sortObject);
//                    PageableHolder.setPageable(pageable);
//                } else {
//                    PageableHolder.clear();
//                }
//            }
//        }
//        return true;
//    }
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        PageableHolder.clear();
//    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        if (modelAndView != null && !Objects.requireNonNull(modelAndView.getViewName()).startsWith("redirect:")) {
//            Pageable pageable = PageableHolder.getPageable();
//            if (pageable != null) {
//                CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//                CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
//                countQuery.select(builder.count(countQuery.from(getDomainClass(handler))));
//                Long count = entityManager.createQuery(countQuery).getSingleResult();
//                modelAndView.addObject("pageable", pageable);
//                modelAndView.addObject("totalElements", count);
//                modelAndView.addObject("totalPages", (count + pageable.getPageSize() - 1) / pageable.getPageSize());
//            }
//        }
//    }
//
//    private Class<?> getDomainClass(Object handler) {
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Class<?> controllerClass = handlerMethod.getBeanType();
//            Type[] types = controllerClass.getGenericInterfaces();
//            if (types.length > 0 && types[0] instanceof ParameterizedType) {
//                ParameterizedType parameterizedType = (ParameterizedType) types[0];
//                return (Class<?>) parameterizedType.getActualTypeArguments()[0];
//            }
//        }
//        throw new RuntimeException("Cannot determine domain class");
//    }
//}
