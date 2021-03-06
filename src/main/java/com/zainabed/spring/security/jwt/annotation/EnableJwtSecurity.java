package com.zainabed.spring.security.jwt.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Configures Spring web security for authentication and authorization. It scans
 * application base package to load application {@link Bean @Bean}.
 * 
 * 
 * <p>
 * {@code @EnableJwtSecurity} class typically configure
 * {@code @EnableWebSecurity} and method level security. Application which
 * import it should annotated its security class and extends
 * {@code @JwtWebSecuriy} class.
 * </p>
 * 
 * <pre class="code">
 * &#064;EnableGlobalMethodSecurity
 * public class AppSecurity extends JwtWebSecuriy{
 *
 *  
 * }
 * </pre>
 * 
 * 
 * @author Zainul Shaikh
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ComponentScan(basePackages = { "com.zainabed.spring" })
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public @interface EnableJwtSecurity {

}
