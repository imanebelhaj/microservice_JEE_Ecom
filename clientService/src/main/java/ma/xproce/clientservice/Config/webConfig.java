//package ma.xproce.clientservice.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class webConfig {
//
//    @Bean
//    public CorsWebFilter corsWebFilter() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.addAllowedOriginPattern("*"); // Allow all origins
//        corsConfig.addAllowedMethod("*");       // Allow all HTTP methods
//        corsConfig.addAllowedHeader("*");       // Allow all headers
//        corsConfig.setAllowCredentials(true);   // Allow credentials (e.g., cookies)
//
//        org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig); // Apply to all paths
//
//        return new CorsWebFilter(source);
//    }
//
//
//    // implements WebMvcConfigurer
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**")
////                .allowedOrigins("http://localhost:4200")
////                .allowedMethods("*")
////                .allowedHeaders("*");
////    }
//
//
//
//
////    @Bean
////    public WebMvcConfigurer corsConfig() {
////        return new WebMvcConfigurer() {
////            @Override
////            public void addCorsMappings(CorsRegistry registry) {
////                registry.addMapping("/**")
////                        .allowedOrigins("http://localhost:4200")
////                        .allowedMethods("*")
////                        .allowedHeaders("*");
////            }
////        };
////    }
//
//
//
////    @Bean
////    public CorsConfigurationSource corsConfigurationSource() {
////        CorsConfiguration config = new CorsConfiguration();
////        config.addAllowedOrigin("http://localhost:4200");  // Add your frontend URL
////        config.addAllowedMethod("*");  // Allow all methods
////        config.addAllowedHeader("*");  // Allow all headers
////        config.setAllowCredentials(true);  // Allow credentials (cookies, auth headers)
////
////        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////        source.registerCorsConfiguration("/**", config);
////
////        return source;
////    }
//
//
//}