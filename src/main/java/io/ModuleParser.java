package io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import data.Item;
import data.SingleModule;


/**
 * This class contains parseFile() which is specifically used to read in contents from courselist text file.
 * DO NOT ALTER THE parseFILE() list under any circumstance.
 */
public class ModuleParser {
    /**
     * The Module name.
     */
    static String moduleName;
    /**
     * The Module code.
     */
    static String moduleCode;
    /**
     * The Module description.
     */
    static String moduleDescription;
    /**
     * The Module mc.
     */
    static String moduleMC;
    /**
     * The Module prerequisite.
     */
    static String modulePrerequisite;


    /**
     * Constructor of ModuleParser.
     */
    public ModuleParser() {

    }

    /**
     * The St.
     */
    static StringTokenizer st;
    /**
     * The Temp string.
     */
    static String tempString;

    /**
     * New modules are being created here.
     * Master list of modules are being created here.
     * New modules are being added here to the masterList.
     */
    public ArrayList<Item> load() throws IOException {
        InputStream is = getClass().getResourceAsStream("courselist11.txt");
        ArrayList<Item> masterList = new ArrayList<>();
        Scanner s = new Scanner(is);

        while (s.hasNext()) {
            tempString = s.nextLine();
            parseFile(tempString);
            SingleModule m = new SingleModule(moduleCode,moduleName,moduleDescription,moduleMC,modulePrerequisite);
            if (moduleCode != null) {
                masterList.add(m);
            }
            moduleCode = null;
        }
        return masterList;
    }

    /**
     * DO NOT ALTER THIS FUNCTION UNDER ANY CIRCUMSTANCES.
     * Processes the data of course list into its module code, name, description, mc and prerequisite.
     *
     * @param tempString A single line of data read from the content list text file.
     */
    private void parseFile(String tempString) {
        if (tempString.indexOf("EE") == 0 || tempString.indexOf("CG") == 0
                || tempString.indexOf("MA") == 0 || tempString.indexOf("CS") == 0 || tempString.indexOf("EG") == 0) {
            st = new StringTokenizer(tempString,"_");
            moduleCode = st.nextToken();
            moduleName = st.nextToken(); //moduleName;
            if (moduleName.contains("\t")) {
                moduleName = moduleName.replace("\t","");
            }
            moduleDescription = st.nextToken(); //moduleDescription;
            moduleMC = st.nextToken(); //moduleMC;
            if (moduleMC.contains("\"")) {
                moduleMC = moduleMC.replace("\"","");
                moduleMC = moduleMC.trim();
            }
            modulePrerequisite = st.nextToken().trim(); //modulePrerequisite;
        }
    }
}
