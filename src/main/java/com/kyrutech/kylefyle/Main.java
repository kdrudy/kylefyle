package com.kyrutech.kylefyle;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.io.File;
import java.util.*;

import static spark.Spark.*;;

public class Main {
    public static void main(String[] args) {
        port(8080);
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            if (args.length < 1) { //No file passed in
                model.put("hasError", true);
                model.put("error", "No file argument to display.");
            } else {
                File f = new File(args[0]);
                if (!f.exists() || f.isDirectory()) { //File doesn't exist or is a directory
                    model.put("hasError", true);
                    model.put("error", args[0] + " doesn't exist or is not a file.");
                } else { //Should be good
                    Scanner sc = new Scanner(f);
                    List<String> content = new ArrayList<>();
                    while(sc.hasNextLine()) {
                        content.add(sc.nextLine());
                    }
                    model.put("hasError", false);
                    model.put("fileName", f.getName());
                    model.put("content", content);
                }
            }
            return new MustacheTemplateEngine().render(
                    new ModelAndView(model, "index.html")
            );
        });
    }
}
