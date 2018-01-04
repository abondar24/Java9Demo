package org.abondar.experimental.jshell.demo;

import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;

public class Main {

    public static void main(String[] args) {
        String [] snippets = {
                "int x=100;",
                "double x = 190.89;",
                "long multiply(int value) {return value * multiplier;}",
                "int multiplier = 2;",
                "multiply(200)",
                "mul(99)"
        };


        try (JShell shell = JShell.create()){
            shell.onSnippetEvent(Main::snippetHandler);
            for (String s: snippets){
                shell.eval(s);
                System.out.println("----------------");
            }
        }
    }


    private static void snippetHandler(SnippetEvent se){
        Snippet snippet = se.snippet();
        System.out.printf("Snippet: %s\n",snippet.source());
        Snippet causeSnippet = se.causeSnippet();
        if (causeSnippet!=null){
            System.out.printf("Cause snipped %s\n",causeSnippet.source());
        }

        System.out.printf("Kind %s\n",snippet.kind());
        System.out.printf("Sub-kind: %s\n",snippet.subKind());
        System.out.printf("Previous status: %s\n",se.previousStatus());
        System.out.printf("Current status: %s\n",se.status());
        System.out.printf("Value: %s\n",se.value());

        Exception e = se.exception();
        if (e!=null){
            System.out.printf("Exception: %s\n",se.exception().getMessage());
        }
    }
}
