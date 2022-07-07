/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latex_assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.time.Clock.system;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mujtaba
 */
public class Latex_Assignment {

    private String latex;
    private int CurrentSection;

    private static Latex_Assignment instance = new Latex_Assignment();

    public static Latex_Assignment GetInstance() {
        return instance;
    }

    private Latex_Assignment() {
        CurrentSection = 0;
        latex = " \\documentclass[a4paper]{article}"
                + "\n\n\\usepackage[english]{babel}"
                + "\n\\usepackage[utf8]{inputenc}"
                + "\n\\usepackage{amsmath}"
                + "\n\\usepackage{graphicx}"
                + "\n\\usepackage[colorinlistoftodos]{todonotes}"
                + "\n\\usepackage[obeyspaces]{url}"
                + "\n%\\usepackage{hyperref}"
                + "\n\n\\usepackage{setspace}"
                + "\n\\usepackage{listings}"
                + "\n\\usepackage{xcolor}"
                + "\n\n\\definecolor{codegreen}{rgb}{0,0.6,0}"
                + "\n\\definecolor{codeblue}{rgb}{0,0,0.6}"
                + "\n\\definecolor{codegray}{rgb}{0.5,0.5,0.5}"
                + "\n\\definecolor{codepurple}{rgb}{0.58,0,0.82}"
                + "\n\\definecolor{backcolour}{rgb}{0.95,0.95,0.92}"
                + "\n\n\\lstset{language=Java, "
                + "  \nbackgroundcolor=\\color{backcolour},"
                + "  \nbackgroundcolor=\\color{backcolour},"
                + "  \ncommentstyle=\\color{codegreen},"
                + "  \nkeywordstyle=\\color{magenta},"
                + "  \nnumberstyle=\\tiny\\color{codegray},      "
                + "  \nstringstyle=\\color{codepurple},  "
                + "  \nbasicstyle=\\ttfamily\\footnotesize,"
                + "  \nbreakatwhitespace=false,"
                + "  \nbreaklines=true,  "
                + "  \ncaptionpos=b, "
                + "  \nkeepspaces=true,"
                + "  \nnumbers=left, "
                + "  \nnumbersep=5pt,"
                + "  \nshowspaces=false,"
                + "  \nshowstringspaces=false,"
                + "  \nshowtabs=false,"
                + "  \ntabsize=2 \n} \n";
    }

    public String GetLatex() {
        return latex;
    }

    public void SetLatex(String s) {
        latex = s;
    }

    public int GetSection() {
        return CurrentSection;
    }

    public void SetSection(int a) {
        CurrentSection = a;
    }

    public void SetTitle(String t) {
        latex = latex + "\\title{" + t + "\\\\ \\vspace{5mm}\n";
    }

    public void SetSubTitle(String t) {
        latex = latex + "\\large " + t + "}\n";
    }

    public void SetAuthor(String t) {
        latex = latex + "\\author{" + t + "}\n";
    }

    public void SetDate(String t) {
        latex = latex + "\\date{" + t + "}\n";
        Begin();
    }

    public void Begin() {
        latex = latex + "\\begin{document}\n\\maketitle\n\n";
    }

    public void StartSection(String s) {
        latex = latex + "\\section{" + s + "}\n";
    }

    public void StartSubSection(String s) {
        latex = latex + "\\subsection{" + s + "}\n";
    }

    public void AddText(String s, String space) {

        String LatexS = "\n \\vspace{" + space + "mm}\\\\ \n";
        s = s.replace("\n\n", LatexS);

        latex = latex + s;
    }

    public void AddPoint(String s) {

        latex = latex + "\\item " + s + "\n";
    }

    public void EndPoint() {
        latex = latex + "\n\\end{enumerate}\n";
    }

    public void StartPoint() {
        latex = latex + "\n\\begin{enumerate}\n";
    }

    public void EndDocument() {
        latex = latex + "\\end{document}";
        System.out.println(latex);
        File output = new File("LatexDocument.tex");
        FileWriter writer;
        try {
            writer = new FileWriter(output);
            writer.write(latex);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Latex_Assignment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        System.out.println("Type name:");
        String name = reader.readLine();
        System.out.println("Hello " + name);
    }

}
