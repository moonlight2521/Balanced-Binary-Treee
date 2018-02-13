import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Zun Lin
 * CMSC 256 Spring 2017
 * Programming Project 5
 * Java Keyword Identifier
 * This program read in a keyword file and name of the source code file to be analyzed
 * the keyword file is then put in to a binary search tree. then the source code file is
 * then search through binary tree if the token is not in the dictionary then is show as identifiers
 * the word is counted and print out at the end.
 *
 */
public class project5 {
    public static void main(String args[]) {
        try {
            try {
                printHeading(5, "Java Keyword Identifier");
                // Check and read command line argument for file name
                String fileName;
                String keyWordFileName;
                if (args.length > 1) {
                    keyWordFileName = args[0];
                    fileName = args[1];
                } else                //when run the program. and there is there is no command line argument.
                {
                    keyWordFileName = promptForKeyWordFileName();    //Scan for keyword file
                    fileName = promptForFileName();                  //Scan for java file
                }
                //declare variables
                FrequencyCounter wordCount = new FrequencyCounter();
                AVLTree tree = new AVLTree();
                String symbol;
                String word;
                Scanner keyWordReader = openKeyWordFile(keyWordFileName); //Scanner for the keyword file.
                while(keyWordReader.hasNext()){
                    symbol = keyWordReader.next();
                    tree.insert(symbol);
                }
                Scanner fileReader = openFile(fileName);    //Scanner for the file.
                fileReader.useDelimiter("((['\"])(?:(?!\\2|\\\\).|\\\\.)*\\2)|\\/\\/[^\\n]*|[()]|[0-9,/.;{}]|\\[.*?\\]| |(^|\\s) ");   //use delimiter to remove some text
                while(fileReader.hasNext()){                    //while loop to check for none java keyword
                    word = fileReader.next().trim();
                    if (tree.find(word) == null){
                        wordCount.readWord(word);
                    }
                }

                tree.printLevelOrder();                 //print AVL tree in level order.
                System.out.println("");
                System.out.println("The following tokens are not Java keywords in the Java file" );
                System.out.println("");
                wordCount.display();                  //print words and counts their frequencies


            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println("No file was found.try again.");
        }
    }
    // ************************************************************************************************************
    // ************************************************************************************************************
    //file validation, make sure the user enter the right file or if there is a file.
    public static Scanner openKeyWordFile(String keyWordFileName) throws FileNotFoundException
    {
        File keyFile = new File(keyWordFileName);
        while(!keyFile.exists())
        {
            keyFile = new File(promptForKeyWordFileName());
        }
        return new Scanner(keyFile);
    }
    // ************************************************************************************************************
    // ************************************************************************************************************
    //file validation, make sure the user enter the right file or if there is a file.
    public static Scanner openFile(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        while(!file.exists())
        {
            file = new File(promptForFileName());
        }
        return new Scanner(file);
    }
    //************************************************************************************************************
    //Scanner to scan in the file.
    public static String promptForKeyWordFileName()
    {
        System.out.println("Enter Keyword file : ");
        Scanner keywordIn = new Scanner(System.in);
        return keywordIn.next();
    }
    //************************************************************************************************************
    //Scanner to scan in the file.
    public static String promptForFileName()
    {
        System.out.println("Enter the Java file name: ");
        Scanner keyIn = new Scanner(System.in);
        return keyIn.next();
    }

    //************************************************************************************************************
    public static void printHeading(int projectNum, String projectName)   //Header for this program.
    {
        System.out.println("Zun Lin");
        System.out.println("CMSC 256 Spring 2017");
        System.out.println("Programming Project " + projectNum);
        System.out.println(projectName);
        System.out.println();
    }
}
