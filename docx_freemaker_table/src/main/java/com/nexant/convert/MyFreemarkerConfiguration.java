package com.nexant.convert;

import fr.opensagres.xdocreport.document.discovery.ITemplateEngineInitializerDiscovery;
import fr.opensagres.xdocreport.template.ITemplateEngine;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.freemarker.FreemarkerTemplateEngine;
import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;

public class MyFreemarkerConfiguration implements ITemplateEngineInitializerDiscovery {

    class MyTemplateExceptionHandler implements TemplateExceptionHandler {
        public void handleTemplateException(TemplateException te, Environment env, java.io.Writer out) throws TemplateException {
            try {
                out.write(String.format("${%s}", te.getBlamedExpressionString()));
            } catch (IOException e) {
                throw new TemplateException("Failed to print error message. Cause: " + e, env);
            }
        }
    }

    public String getId() {
        return MyFreemarkerConfiguration.class.getName();
    }

    public String getDescription() {
        return null;
    }

    public String getDocumentKind() {
        return null;
    }

    public void initialize(ITemplateEngine templateEngine) {
        if (TemplateEngineKind.Freemarker.name().equals(templateEngine.getKind())) {
            Configuration cfg = ((FreemarkerTemplateEngine) templateEngine).getFreemarkerConfiguration();
            cfg.setTemplateExceptionHandler(new MyTemplateExceptionHandler());
            cfg.setLogTemplateExceptions(false);
        }
    }
}
