package com.kyrutech.kylefyle;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;;

public class Main {
    public static void main(String[] args) {
        if(args.length < 1) {
            get("/", (req, res) -> {
                Map<String, Object> model = new HashMap<>();
                model.put("error", "No file argument to display");
                return new MustacheTemplateEngine().render(
                        new ModelAndView(model, "/templates/index.html")
                );
            });
        } else {

        }
        get("/hello", (req, res) -> "Hello World");
    }
}
