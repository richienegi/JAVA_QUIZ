package negi.ritikachaaras.java_quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import negi.ritikachaaras.java_quiz.QuizContract.QuestionTable;

public class QuizDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    public static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " + QuizContract.QuestionTable.TABLE_NAME + " ( " + QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " VARCHAR(255) ," +
                QuestionTable.COLUMN_OPTION1 + " VARCHAR(30) ," +
                QuestionTable.COLUMN_OPTION2 + " VARCHAR(40) ," +
                QuestionTable.COLUMN_OPTION3 + " VARCHAR(40) ," +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionTable.COLUMN_DIFICULTY + " TEXT, " +
                QuestionTable.COLUMN_ANS + " VARCHAR(500)" +
                ")";
        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillQuestionTable();

    }

    private void fillQuestionTable() {
        Question b1 = new Question("Java Programming was designed by _________________.",
                "Microsoft",
                "Sun Microsystems", "Google", 2, Question.Basic,
                "Java is a set of computer software and specifications developed at Sun Microsystems, which was later acquired by the Oracle Corporation.\n");
        addQuestion(b1);
        Question b2 = new Question("Which of the following personality is called as father of Java Programming language",
                "Bjarne Stroustrup", "James Gosling", "Charle Bebege", 2, Question.Basic,
                "Java is developed by James Gosling at Sun Microsystems.");
        addQuestion(b2);


        Question b3 = new Question("Java was publicly released with it’s First Version in _______________ .",
                "May 27, 1993", "Feb 27, 1995", "Jan  23, 1996", 3, Question.Basic, "The first version was released on January 23, 1996. Although it was first known  publicly in 1995.");
        addQuestion(b3);


        Question b4 = new Question("The first public implementation was _____________.",
                "Java 1.1", "1.0", "0.1", 2, Question.Basic, "First Version was 1.0,and first stable version, JDK 1.0.2, is called Java 1.");
        addQuestion(b4);

        Question b5 = new Question("Java Source Code is compiled into ______________.",
                "Source Code", ".Exe", "Bytecode", 3, Question.Basic, "Java Compiler first convert the source code into bytecode ,and  then bytecode is read by Interpreter to convert it into machine code.\n");
        addQuestion(b5);


        Question b6 = new Question("Which of the tool is used to compile java code ?",
                " jar", " javac", "java", 2, Question.Basic,
                "Javac is the tool present inside jdk->bin folder  used to compile java code\n");
        addQuestion(b6);

        Question b7 = new Question("Which of the following tool used to execute java code.",
                "java", "javadoc", "javac", 1, Question.Basic, "Java is the interpreter tool use to execute java  code");
        addQuestion(b7);

        Question b8 = new Question("Java is called as platform independent language. Do you agree with this statement ?",
                "No", "Yes", "Null", 2, Question.Basic, "Java comes with it’s tag line WORA ie. Write Once Run Anywhere, as it is Platform independent language.");
        addQuestion(b8);

        Question b9 = new Question("We can run same java program on different environment with same JDK Version",
                "Yes", "No", "", 2, Question.Basic, "JVM understands the compiled code. We need different JVM because JVM is different" +
                " for different OS as it is Machine Dependent.Therefore, JDK must be different for different O.S.\n");
        addQuestion(b9);

        Question b10 = new Question("JVM is a _____________ .",
                "Debugger", "Compiler", "Interpreter", 3, Question.Basic, "JVM is a interpreter which take bytecode as input and convert that code into machine code.\n");
        addQuestion(b10);

        Question b11 = new Question("Which of the following is smallest integer data type ?",
                "long", "short", "byte", 3, Question.Basic, "Byte is the smallest integer type in java having size in bytes =1 and range=-128 to 127.");
        addQuestion(b11);

        Question b12 = new Question("Which of the following is not a primitive data type ?",
                "short", "byte", "enum", 3, Question.Basic, "A Java Enum is a special Java type used to define collections of constants. More precisely, a Java enum type is a special kind of Java class.");
        addQuestion(b12);

        Question b13 = new Question("Integer Data type does not include following primitive data type ____________.",
                "double", "long", "Short", 1, Question.Basic, "double stores decimal values");
        addQuestion(b13);

        Question b14 = new Question("Range of Byte Data Type is ____________.",
                "-128 to 256", "-127 to 128", "-128 to 127", 3, Question.Basic, "byte range is 128 to 127");
        addQuestion(b14);

        Question b15 = new Question("In order to fetch stream of data from network or file , following data type is used ___________.\n",
                "byte", "int", "char", 1, Question.Basic, "in order to " +
                "fetch stream of data from file or network we use byte as it is the smallest data type we have.");
        addQuestion(b15);

        Question b16 = new Question("Default value of variable having boolean data type is ___________.",
                "0", "false", "1", 2, Question.Basic, "default value for  boolean data type is false");
        addQuestion(b16);

        Question b17 = new Question("What is Literal in Java Programming ?",
                "special type of class", "source code representation of a fixed value", "special type of data type", 2, Question.Basic,
                "source code representation of a fixed value\n" +
                        "Any constant value which can be assign to a variable is known as Literal\n" +
                        "Eg. int a=10  // here 10 is literal\n" +
                        "float  f=19.0f    //here 19.0 is literal\n");
        addQuestion(b17);

        Question b18 = new Question("Which type of literal is written in pair of single quote ?",
                "boolean", "float", "character", 3, Question.Basic, "Ans character \n" +
                "eg . char value=’c’;");
        addQuestion(b18);

        Question b19 = new Question("What is identifier in java programming ?.\n",
                "Names of method and variable and class.", "Names of variables, methods, classes, packages and interfaces. ",
                "Name of user defined variables methods, classes, packages.", 2, Question.Basic,
                "names of variables, methods, classes, packages and interfaces are known as identifiers. eg. int a=10;   // here a is an identifier");
        addQuestion(b19);

        Question b20 = new Question("Which characters are allowed in java identifiers",
                "A to Z , a to z, 0-9 ,$ and -", "A to Z , a to z, 0-9 ", "A to Z , a to z, 0-9 and -", 1, Question.Basic,
                "A to Z , a to z, 0-9 ,$ and - are allowed as java identifiers");
        addQuestion(b20);


        Question c1 = new Question("The Java if statement:",
                "Evaluates whether an expression is equal or not", "Evaluates whether an expression is true or false",
                "Evaluates whether an expression is less than or more than a number", 2, Question.Control,
                "if statement checks the condition is true of false with the help of comparison operators.\n");
        addQuestion(c1);

        Question c2 = new Question("Which of these are selection statements in Java?",
                "if()", "for()", "break", 1, Question.Control,
                "if() is known as the selection statement ,as it will select the statement to be execute based on condition.\n");
        addQuestion(c2);

        Question c3 = new Question(" Which of the following loops will execute the body of" +
                " loop even when condition controlling the loop is initially false?",
                " do-while",
                "while", "for ", 1, Question.Control,
                "do_while execute statement for once either condition is true or not\n");
        addQuestion(c3);

        Question c4 = new Question("Which of these jump statements can skip processing remainder of code in its body for a particular iteration?",
                "return ", "continue", " break ", 2, Question.Control,
                "continue skip processing remainder of code in its body for a particular iteration\n");
        addQuestion(c4);

        Question c5 = new Question("What is the output of this program?\n" +
                "\n" +
                " class ifDemo \n" +
                "{\n" +
                " public static void main(String args[])\n" +
                "  {\n" +
                "   int var1 = 5; \n" +
                "   int var2 = 6;\n" +
                "    if ((var2 = 1) == var1)\n" +
                "     System.out.print(var2);\n" +
                "       else \n" +
                "      System.out.print(++var2);\n" +
                "     } \n" +
                "    }\n",
                "1", "2 ", "3", 2, Question.Control,
                "\n" +
                        " var2 is initialised to 1. The conditional statement returns false and the else part gets executed.\n");
        addQuestion(c5);

        Question c6 = new Question("What is the output of this program?\n" +
                "\n" +
                " class DemoOp\n" +
                " {\n" +
                " public static void main(String args[]) \n" +
                "  {    \n" +
                "  int val = 0;\n" +
                " for (int i = 0, j = 0; i < 5 & j < 5; ++i, j = i + 1)\n" +
                "    val += i;\n" +
                " System.out.println(val);\n" +
                "  } \n" +
                "    }\n",
                "5", "6 ", "error", 2, Question.Basic,
                "Using comma operator , we can include more than one statement in the initialization and iteration portion of the for loop. " +
                        "Therefore both ++i and j = i + 1 is executed i gets the value – 0,1,2,3,4 & j gets the values -0,1,2,3,4,5.\n");
        addQuestion(c6);

        Question c7 = new Question("__________ statement provides an easy way to dispatch" +
                " execution to different parts of your code based on the value of an expression.\n",
                "if()-else()", "switch()", "If()", 2, Question.Control,
                "switch");
        addQuestion(c7);

        Question c8 = new Question("The conditional statement," +
                " _______ can only test for equality, whereas _________ can evaluate any type of Boolean expression.\n",
                " if, switch", "switch,if", "while, if", 2, Question.Control,
                "As switch is a condition Statement , if can evaluate any type of Boolean expression.\n");
        addQuestion(c8);

        Question c9 = new Question("Which of the following is not a valid flow control statement?",
                "exit()", "break", "return", 1, Question.Control,
                "exit() is not a flow control statement in Java. exit() terminates the currently running JVM.\n");
        addQuestion(c9);

        Question c10 = new Question("Output of program  \n" +
                "char a='1';\n" +
                "switch(a)\n" +
                "{\n" +
                "case 1:\n" +
                "System.out.println(\"M One\");\n" +
                " default:\n" +
                " System.out.println(\"Hello World\");\n" +
                "}\n",
                "Compile time error", "Run time error", "Hello world", 3, Question.Control,
                "it will print Hello world, as there is no case like(case : ‘1’) ,so  default will execute it’s statement.\n");
        addQuestion(c10);

        Question c11 = new Question("What would be the output of the following  if variable a=-10?\n" +
                "\n" +
                "if(a<=0)\n" +
                "{\n" +
                "  if(a==0)\n" +
                "  {\n" +
                "    System.out.println(\"1 \");\n" +
                "   }\n" +
                "   else \n" +
                "   { \n" +
                "    System.out.println(\"2 \");\n" +
                "   }\n" +
                "}\n" +
                "System.out.println(\"3 \");\n",
                "1,2", "2,3", "1,3", 2, Question.Control,
                "Since the first if condition is met, control would  go inside if statement and  the second if condition is not met, control would  go inside else statement and hence " +
                        "statement in else part and statement after the entire if block will be executed.\n");
        addQuestion(c11);

        Question c12 = new Question(" What is true about break?",
                " Break stops the execution of entire program", "Break halts the execution and forces the control out of the loop",
                " Break forces the control out of the loop and starts the execution of next iteration.", 2, Question.Control,
                "Break halts the execution and forces the control out of the loop\n");
        addQuestion(c12);

        Question c13 = new Question("output of following code\n" +
                "class Test {\n" +
                "public static void main(String[] args) {\n" +
                "for(int i = 0; 1; i++) {\n" +
                "System.out.println(“Hello”);\n" +
                "break;\n" +
                "} }  }",
                "Hello", "Compile time error", "Run time Error", 2, Question.Control,
                " As there is no condition provided it will generate  compile time error\n");
        addQuestion(c13);
        Question c14 = new Question("class IfDemo\n" +
                "{\n" +
                "public static void main(String args[])\n" +
                "{\n" +
                "int i = 10;\n" +
                "if (i >15)\n" +
                "System.out.println(“10 is less than 15”);\n" +
                "System.out.println(“I am Not in if”);\n" +
                "}\n" +
                "}\n",
                "I am Not in if", "10 is less than 15", "10 is less than 15, I am Not in if", 1,
                Question.Control,
                "As condition is not true so it will exclude  the first statement\n");
        addQuestion(c14);

        Question c15 = new Question("output of following code   \n" +
                "class NestedIfDemo\n" +
                "{\n" +
                "public static void main(String args[])\n" +
                "{\n" +
                "int i = 10;\n" +
                "if (i == 10)\n" +
                "{\n" +
                "if (i<15)\n" +
                "System.out.println(\"i is smaller than 15\");\n" +
                "\n" +
                "if (i<12)\n" +
                "System.out.println(\"i is smaller than 12\");\n" +
                "}\n" +
                "else\n" +
                "System.out.println(\"Value of I\");\n" +
                "}\n" +
                "\n" +
                "}\n" +
                "}\n",
                "i is smaller than 15", "i is smaller than 15, i is smaller than 12",
                "i is smaller than 15,Value of I", 2,
                Question.Control,
                "As first condition is true it will go inside and check both if conditions , as both the conditions are true, " +
                        "it will print both if statements.\n");
        addQuestion(c15);


        Question a1 = new Question("Which of the following declaration of the array contains error?",
                "int x[ ]= int[10]", "float d[ ]= {1,2,3}", "int b[]={5} " +
                "int a[]={1, 2,3,b[0]}", 1, Question.Array, "We always need new keyword for memory allocation;\n");
        addQuestion(a1);

        Question a2 = new Question("Which of these operators is used to allocate memory to array variable in Java?",
                "malloc", "alloc", "new", 3,
                Question.Array, "in java new keyword is used for memory allocation\n");
        addQuestion(a2);

        Question a3 = new Question("Which of these is an incorrect Statement?\n",
                "It is necessary to use new operator to initialize an array.", " Array can be initialized using comma " +
                "separated expressions surrounded by curly braces",
                "Array can be initialized when they are declared.\n", 1, Question.Array,
                "Array can be initialized using both new and comma separated expressions surrounded by curly" +
                        " braces example : int arr[5] = new int[5]; and int arr[] = { 0, 1, 2, 3, 4}\n");
        addQuestion(a3);

        Question a4 = new Question(" What is the output of this program?\n" +
                "   class array_output\n" +
                "  {\n" +
                "   public static void main(String args[])\n" +
                "   {\n" +
                "     int array_variable [] = new int[10];\n" +
                "\t    for (int i = 0; i < 10; ++i)\n" +
                "      {\n" +
                "       array_variable[i] = i;\n" +
                "       System.out.print(array_variable[i] + \" \");\n" +
                "         i++;\n" +
                "        }\n" +
                "     }\n" +
                "   }\n",
                " 0 2 4 6 8", "1 3 5 7 9", " 0 1 2 3 4 5 6 7 8 9",
                1, Question.Array, "When an array is declared using new operator then all of its elements are initialized" +
                " to 0 automatically. for loop body is executed 5 times as whenever controls comes in the loop " +
                "i value is incremented twice, first by i++ in body of loop then by ++i in increment condition of for loop.");
        addQuestion(a4);
        Question a5 = new Question("What is the output of this program?\n" +
                "\n" +
                "   class array_output\n" +
                "   {\n" +
                "    public static void main(String args[])\n" +
                "    {\n" +
                "   char array_variable [] = new char[10];\n" +
                "\t  for (int i = 0; i < 10; ++i)\n" +
                "   {\n" +
                "   array_variable[i] = 'i';\n" +
                "   System.out.print(array_variable[i] + \"\");\n" +
                "      }\n" +
                "    }\n" +
                "   }\n",
                "1 2 3 4 5 6 7 8 9 10",
                " i j k l m n o p q r",
                "i i i i i i i i i i", 3, Question.Array, "array will hold the character i at different index position");
        addQuestion(a5);
        Question a6 = new Question("In Java, each array object has a final field named . . . . that stores the size of the array",
                "width", "size", "length\n", 3, Question.Array, "arrname.length will return the size of array\n");
        addQuestion(a6);
        Question a7 = new Question("The ith element in the array has an index . . . .\n",
                " i", "i-1", "i+1", 2, Question.Array,
                " as index value starts from 0, therefore 4rth element in array has index 3");
        addQuestion(a7);
        Question a8 = new Question("What will this code print?\n" +
                "\n" +
                "int arr[] = new int [5];\n" +
                "System.out.print(arr);\n",
                "0", "00000", "Garbage value", 3, Question.Array,
                " arr is an array variable, it is pointing to array if integers. " +
                        "Printing arr will print garbage value. It is not same as printing arr[0].\n");
        addQuestion(a8);
        Question a9 = new Question("What is the output of this program?\n" +
                " class multidimention_array {\n" +
                " public static void main(String args[])\n" +
                " {\n" +
                " arr[][] = new int[3][];\n" +
                " arr[0] = new int[1];\n" +
                " arr[1] = new int[2];\n" +
                " arr[2] = new int[3];\n" +
                " int sum = 0;\n" +
                " for (int i = 0; i < 3; ++i)\n" +
                " for (int j = 0; j < i + 1; ++j)\n" +
                " arr[i][j] = j + 1;\n" +
                " for (int i = 0; i < 3; ++i)\n" +
                " for (int j = 0; j < i + 1; ++j)\n" +
                " sum + = arr[i][j];\n" +
                " System.out.print(sum);\n" +
                " }\n" +
                " }\n",
                "11", "10", "13", 2, Question.Array,
                "arr[][] is a 2D array, array has been allotted memory in parts. 1st row contains 1 element, 2nd row contains 2 elements and 3rd row contains 3 elements." +
                        " each element of array is given i + j value in loop. sum contains addition of all the elements of the array.");
        addQuestion(a9);
        Question a10 = new Question("What is the output of this program?\n" +
                " class evaluate {\n" +
                "   public static void main(String args[])\n" +
                "   {\n" +
                "   int arr[] = new int[] {0 , 1, 2, 3, 4, 5, 6, 7, 8, 9};\n" +
                "   int n = 6;\n" +
                "   n = arr[arr[n] / 2];\n" +
                "   System.out.println(arr[n] / 2);\n" +
                "   }\n" +
                "   }\n",
                "3", "1", "0", 2, Question.Array,
                "Array arr contains 10 elements. n contains 6 thus in next line n is given value 3 printing arr[3]/2 i:e 3/2 =1.5 i.e  1.\n");
        addQuestion(a10);
        Question a11 = new Question("What is the output of this program?\n" +
                " class array_output {\n" +
                "   public static void main(String args[])\n" +
                "   {\n" +
                "   int array_variable[][] = {{ 1, 2, 3}, { 4 , 5, 6}, { 7, 8, 9}};\n" +
                "   int sum = 0;\n" +
                "   for (int i = 0; i < 3; ++i)\n" +
                "   for (int j = 0; j < 3 ; ++j)\n" +
                "   sum = sum + array_variable[i][j];\n" +
                "   System.out.print(sum / 5);\n" +
                " }\n" +
                " }\n",
                "8", "9", "10", 2, Question.Array, "9\n");
        addQuestion(a11);


        Question o1 = new Question("Using encapsulation data security is ___________", "Not ensured", "Ensured to some extent",
                "Purely ensured", 2, Question.OOps_Concept, "The encapsulation can only ensure the data security to some extent. If pointer and addresses are misused, it may violate encapsulation. " +
                "Use of global variables also makes the program vulnerable, hence we can’t say that encapsulation gives pure security.");
        addQuestion(o1);


        Question o2 = new Question("Which of the following is a type of polymorphism in Java?",
                "Compile time polymorphism", " Execution time polymorphism",
                "Multiple polymorphism\n", 1, Question.OOps_Concept, "There are two type of polymorphism in Java. Compile time polymorphism (overloading) " +
                "and runtime polymorphism (overriding).\n");
        addQuestion(o2);

        Question o3 = new Question("When does method overloading is determined?", "At run time",
                "At compile time", "At execution time", 2, Question.OOps_Concept, " Overloading is determined at compile time." +
                " Hence, it is also known as compile time polymorphism\n");
        addQuestion(o3);

        Question o4 = new Question("Java does not support _______________?", "Multiple inheritance for classes",
                "multiple inheritance of interfaces", "compile time polymorphism", 1, Question.OOps_Concept,
                " Java does not support multiple inheritance for classes but" +
                        "in java multiple inheritance behavior is implemented using interfaces.");
        addQuestion(o4);

        Question o5 = new Question("In a class, encapsulating an object of another class is called", "Inheritance", "Composition",
                "Encapsulation", 2, Question.OOps_Concept, "None");
        addQuestion(o5);

        Question o6 = new Question("  IS-A relationship in java is related to", "Encapsulation",
                "Inheritance", "Composition", 2, Question.OOps_Concept, "None");
        addQuestion(o6);

        Question o7 = new Question("If you want to write multiple functions in a class with same name, then what Java feature will you use?",
                "Function overriding", "Encapsulation", "Function overloading", 3, Question.OOps_Concept, "None");
        addQuestion(o7);

        Question o8 = new Question("Loose coupling in java programs can be done by", "Using interface", "Encapsulating an object of another class",
                "Both", 1, Question.OOps_Concept, "None");
        addQuestion(o8);

        Question o9 = new Question("If class B is subclassed from class A then which is the correct syntax", "class B:A{}",
                "class B extends A{}", "class B implements A{}", 2, Question.OOps_Concept,
                "Below is the example\n" +
                        "class A\n" +
                        "{\n" +
                        "}\n" +
                        "class B extends A      \n" +
                        "{\n" +
                        "}\n");
        addQuestion(o9);

        Question o10 = new Question(" Which is/are false statements\n" +
                "final class cannot be inherited\n" +
                "final method can be inherited\n" +
                "final method can be overridden", "1 and 3",
                "2 and 3", "only 3", 3, Question.OOps_Concept, "Final class cannot be inherited.\n" +
                "If a non-final class contains final method then it can be inherited but cannot be overridden in child class.\n" +
                "final variable a of a class cannot be changed and it will be a constant.\n");
        addQuestion(o10);

        Question o11 = new Question("When Overloading does not occur?\n",
                "More than one method with same name but different method signature and different number or type of " +
                        "parameters\n", " More than one method with same name, same signature but different number of" +
                " signature\n",
                " More than one method with same name, same number of parameters and type " +
                        "but different signature", 3, Question.OOps_Concept, " Overloading occurs when more than one method with same name but " +
                "different constructor and also when same signature but different number of parameters and/or parameter type.\n");
        addQuestion(o11);

        Question o12 = new Question("If you do not have access to the source code for a class, but you want to change the way a method of that class works, then could you use subclassing to do " +
                "that that is to extend the \"bad\" class and override the method with your own better code?\n",
                "True", "false", "None", 1, Question.OOps_Concept, "None");
        addQuestion(o12);

        Question o13 = new Question("The most common reasons to use inheritance are",
                "To use interface, to promote code reuse",
                "to promote code reuse, to use polymorphism",
                "To use abstraction, to use encapsulation", 2, Question.OOps_Concept, "None");
        addQuestion(o13);

        Question o14 = new Question(" Given below the sample code :\n" +
                " \n" +
                "class Hotel {\n" +
                "public int bookings=2;\n" +
                "public void book() {\n" +
                "bookings++;\n" +
                "}\n" +
                "}\n" +
                " \n" +
                "public class SuperHotel extends Hotel {\n" +
                "public void book() {\n" +
                "bookings--;\n" +
                "}\n" +
                " \n" +
                "public void book(int size) {\n" +
                "book();\n" +
                "super.book();\n" +
                "bookings += size;\n" +
                "}\n" +
                " \n" +
                "public static void main(String args[]) {\n" +
                "SuperHotel Shotel = new SuperHotel();\n" +
                "Shotel.book(2);\n" +
                "System.out.print(Shotel.bookings);\n" +
                "}\n" +
                "}\n" +
                " \n" +
                "Find the output of the following code :" +
                "}", "2", "Copile Time Error", "4", 3, Question.OOps_Concept, "None");
        addQuestion(o14);

        Question o15 = new Question("An interface cannot have an inner class.", "true",
                "False", "None", 2, Question.OOps_Concept, "None");
        addQuestion(o15);

        Question o16 = new Question("Aggregation is a special form of association", "true", "false",
                "None", 1, Question.OOps_Concept, "Aggregation is a special form of association which is a unidirectional one way relationship between classes (or entities), for e.g. Wallet" +
                " and Money classes. Wallet has Money but money doesn’t need to have Wallet necessarily so its a one directional relationship.");
        addQuestion(o16);

        Question o17 = new Question("The ability to make changes in your implementation code without breaking the code of" +
                " others who use your code is a key benefit of _______________.\n",
                "Inheritance", "Polymorphism", "Encapsulation", 3, Question.OOps_Concept, "None");
        addQuestion(o17);

        Question o18 = new Question("Every class in Java is a subclass of class _____________.",
                "Object", "Ecapsulation", "Exception", 1, Question.OOps_Concept, "None");
        addQuestion(o18);

        Question o19 = new Question("The relation between Car and Owner or BankAccount and Customer is example for",
                "Composition",
                "Aggregation",
                "Association", 3, Question.OOps_Concept, "None");
        addQuestion(o19);

        Question o20 = new Question("Ad hoc polymorphism is ____________.", "Dynamic binding", "Method Overriding", "Method Overloading", 3, Question.OOps_Concept, "None");
        addQuestion(o20);


        Question ex1 = new Question("Predict the output of following Java program\n" +
                "   class Main {\n" +
                "       public static void main(String args[]) {\n" +
                "      try {\n" +
                "         throw 10;\n" +
                "      }\n" +
                "      catch(int e) {\n" +
                "         System.out.println(\"Got the  Exception \" + e);\n" +
                "      }} }\n", "Compile error", "Runtime error", "Got the Exception 10",
                1, Question.Exception_Handling, "it will generate Compile time error incompatible types: int cannot be converted to Throwable\n" +
                "\t\tthrow 10;\n" +
                "\t\t^\n" +
                " error: unexpected type\n" +
                "\tcatch(int e) {\n" +
                "\t      ^\n" +
                "  required: class\n" +
                "  found:    int\n" +
                "2 errors\n");
        addQuestion(ex1);


        Question ex2 = new Question(" class Test extends Exception { }\n" +
                "  class Main {\n" +
                "   public static void main(String args[]) {\n" +
                "      try {\n" +
                "         throw new Test();      }\n" +
                "      catch(Test t) {\n" +
                "         System.out.println(\"Got the Test Exception\");\n" +
                "}\n" +
                "      finally {\n" +
                "         System.out.println(\"Inside finally block \");\n" +
                "      }  } }\n",
                "Got the Test Exception Inside finally block\n", "Got the Test Exception",
                "Compiler Error\n", 1, Question.Exception_Handling, "In Java, the finally is always executed after the" +
                " try-catch block. This block can be used to do the common cleanup work\n");
        addQuestion(ex2);


        Question ex3 = new Question("Output of following Java program?\n" +
                "class Main {\n" +
                "   public static void main(String args[]) {\n" +
                "      int x = 0;\n" +
                "      int y = 10;\n" +
                "      int z = y/x;\n" +
                "  }\n" +
                "}\n",
                "Compile error",
                "Compiles and run fine",
                "Compiles fine but throws ArithmeticException exception"
                , 1, Question.Exception_Handling, "ArithmeticException is an unchecked exception, i.e.," +
                " not checked by the compiler. So the program compiles fine. See following for more details ");
        addQuestion(ex3);


        Question ex4 = new Question("When does Exceptions in Java arises in code sequence?\n",
                "Compilation Time",
                "Run Time",

                "Can Occur Any Time"
                , 2, Question.Exception_Handling, "Exceptions in java are run-time errors.\n");
        addQuestion(ex4);

        Question ex5 = new Question("Which of these keywords is not a part of exception handling?\n",
                "Try",
                "Finally",
                "Thrown"
                , 3, Question.Exception_Handling, "Exceptional handling is managed via 5 keywords – try, catch, throws, throw and finally.");
        addQuestion(ex5);

        Question ex6 = new Question(" Which of these keywords must be used to handle the exception thrown by try block in some rational manner?\n",
                "Try",
                "Throw",
                "Catch"
                , 3, Question.Exception_Handling, "If an exception occurs within the try block, it is thrown and" +
                " cached by catch block for processing.");
        addQuestion(ex6);

        Question ex7 = new Question("Which of these keywords is used to manually throw an exception?",
                "Try",
                "Catch",
                "Throw",
                3, Question.Exception_Handling, "Throw is used for custom exception");
        addQuestion(ex7);
        Question ex8 = new Question("The class at the top of the exception classes hierarchy is called?",
                "throwable", "catchable", "Exception", 1, Question.Exception_Handling, "throwable");
        addQuestion(ex8);
        Question ex9 = new Question("Java uses a keyword ………………… to preface a block of code that is likely to cause an error condition and ‘throw’ an exception.",
                "throw", "try", "catch", 2, Question.Exception_Handling, "try");
        addQuestion(ex9);

        Question ex10 = new Question("State whether the following statements are True or False.\n" +
                "i) A catch can have comma-separated multiple arguments.\n" +
                "ii) Throwing an Exception always causes program termination.\n",
                "False, False", "False, True", "True, True", 1, Question.Exception_Handling, "None");
        addQuestion(ex10);

        Question ex11 = new Question(" …………………….. exception is thrown when an attempt is made to access an array element beyond the index of the array.",
                "Throwable", "IndexNotFound", "ArrayIndexOutofBounds",
                3, Question.Exception_Handling, "None");
        addQuestion(ex11);
        Question ex12 = new Question("Which of the following are the most common run-time errors in Java programming.\n" +
                "i) Missing semicolons\n" +
                "ii) Dividing an integer by zero\n" +
                "iii) Converting invalid string to number\n" +
                "iv) Bad reference of objects\n", "i and ii only",
                "ii and iii only", " iii and iv only", 2, Question.Exception_Handling, "None");
        addQuestion(ex12);
        Question ex13 = new Question("What will be the output of the program?\n" +
                "try \n" +
                "{ \n" +
                "    int x = 0; \n" +
                "    int y = 5 / x; \n" +
                "} \n" +
                "catch (Exception e) \n" +
                "{\n" +
                "    System.out.println(\"Exception\"); \n" +
                "} \n" +
                "catch (ArithmeticException ae) \n" +
                "{\n" +
                "    System.out.println(\" Arithmetic Exception\"); \n" +
                "} \n" +
                "System.out.println(\"finished\");",
                "Finished",
                "Exception,finished",
                "Compilation fails", 3, Question.Exception_Handling,
                "Compilation fails because ArithmeticException has already been caught. ArithmeticException is a subclass of java." +
                        "lang.Exception, by time the ArithmeticException has been specified it has already been caught by the " +
                        "Exception class.\n" +
                        "If ArithmeticException appears before Exception, then the file will compile. When catching exceptions the more specific exceptions must be listed before the more general (the subclasses must be caught before the superclasses).\n");
        addQuestion(ex13);
        Question ex14 = new Question("Exception classes are available in the ……………………package.", "java.lang",
                "java.awt", "java.io", 1, Question.Exception_Handling, "java.lang");
        addQuestion(ex14);
        Question ex15 = new Question(" Every try statement should be followed by at least one catch statement; otherwise …………………. will occur.",
                "no execution", "Run time error", "compilation error", 3, Question.Exception_Handling, "Compilation time error");
        addQuestion(ex15);

        Question st1 = new Question("What will be the output of below statements?\n" +
                "\n" +
                "String s = \"Java\"+1+2+\"Quiz\"+\"\"+(3+4); \n" +
                "\t\t\n" +
                "System.out.println(s);\n", "Java12Quiz34", "Java3Quiz7", "Java12Quiz7", 3,
                Question.String_Wrapper, "None");
        addQuestion(st1);

        Question st2 = new Question("What will be output of below statements?\n" +
                "\n" +
                "String s1 = \"Cat\";\n" +
                "String s2 = \"Cat\";\n" +
                "String s3 = new String(\"Cat\");\n" +
                "        \n" +
                "System.out.println(s1==s2);\n" +
                "System.out.println(s1==s3);\n",
                "true false", "true true", "false true", 1, Question.String_Wrapper, "" +
                "Ans When we use double quotes to create a String, it first looks for String with same value in the String pool, if found it just returns the reference else it creates a new String in the pool and then returns the reference.\n" +
                "\n" +
                "However using new operator, we force String class to create a new String object in heap space.\n" +
                "\n" +
                "So s1 and s2 will have reference to same String in the pool whereas s3 will be a different object outside the pool, hence the output.\n");
        addQuestion(st2);

        Question st3 = new Question("What will be the output of below statements?\n" +
                "\n" +
                "String s1 = null;\n" +
                "System.out.println(s1); //line 2\n" +
                "System.out.println(s1.toString()); //line 3\n", "null null",
                " NullPointerException NullPointerException", "null NullPointerException", 3,
                Question.String_Wrapper, "Line 2 will print null because println method has null check like below.\n" +
                "\n" +
                "if (s == null) {\n" +
                "    s = \"null\";\n" +
                "}\n" +
                "Line 3 will throw NullPointerException because we are trying to invoke toString() function on null.\n");
        addQuestion(st3);
        Question st4 = new Question("What will be the output of below program?\n" +
                "\n" +
                "public class Test {\n" +
                "\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tString x = \"abc\";\n" +
                "\t\tString y = \"abc\";\n" +
                "\t\tx.concat(y);\n" +
                "\t\tSystem.out.print(x);\n" +
                "\t}\n" +
                "}\n",
                "null", "abcabc", "abc", 3, Question.String_Wrapper, "x.concat(y) will create a new string but " +
                "it’s not assigned to x, so value of x is not changed.\n");
        addQuestion(st4);

        Question st5 = new Question("What will be the output of below statements?\n" +
                "\n" +
                "String s1 = \"abc\";\n" +
                "String s2 = \"def\";\n" +
                "\t\t\n" +
                "System.out.println(s1.compareTo(s2));\n", "0", "-3", "false", 2,
                Question.String_Wrapper, "From String compareTo method documentation:\n" +
                "\n" +
                "compareTo method compares two strings lexicographically. The comparison is based on the Unicode value of each character \n" +
                "in the strings. The character sequence represented by this String object is compared lexicographically to the character \n" +
                "sequence represented by the argument string. The result is a negative integer if this String object lexicographically precedes \n" +
                "the argument string. The result is a positive integer if this String object lexicographically follows the argument string. The result is zero if the strings are equal;\n" +
                " compareTo returns 0 exactly when the equals(Object) method would return true.\n");
        addQuestion(st5);
        Question st6 = new Question(" What will be output of below statements?\n" +
                "\n" +
                "String s = \"Java String Quiz\";\n" +
                "System.out.println(s.substring(5,3));\n", "Compile time error",
                "Prints \"Str\"", "Runtime Exception StringIndexOutOfBoundsException",
                3, Question.String_Wrapper,
                "It will throw below runtime exception.\n" +
                        "\n" +
                        "Exception in thread \"main\" java.lang.StringIndexOutOfBoundsException: String index out of range: -1\n" +
                        "\tat java.lang.String.substring(String.java:1967)\n" +
                        "\tat com.journaldev.java.Test.main(Test.java:11)\n" +
                        "It’s because the end index is smaller than start index.\n");
        addQuestion(st6);

        Question st7 = new Question(" What will be output of below statements?\n" +
                "\n" +
                "String s = \"Java String Quiz\";\n" +
                "System.out.println(s.charAt(s.toUpperCase().length()));\n", "Runtime Exception",
                "Convert \"Z\" to int 90 and prints \"90\"", "Prints \"Z\"", 1,
                Question.String_Wrapper,
                "It will throw below runtime exception.\n" +
                        "\n" +
                        "Exception in thread \"main\" java.lang.StringIndexOutOfBoundsException: String index out of range: 16\n" +
                        "\tat java.lang.String.charAt(String.java:658)\n" +
                        "\tat com.journaldev.java.Test.main(Test.java:11)\n" +
                        "Note that index value starts from 0\n" +
                        "\n");
        addQuestion(st7);

        Question st8 = new Question(" String implementation follows which of the below design pattern?",
                "Singleton pattern", " Flyweight Design Pattern", " Factory pattern",
                2, Question.String_Wrapper, "String pool implementation follows flyweight design pattern.\n");
        addQuestion(st8);

        Question st9 = new Question(" How many String objects created in below statements?\n" +
                "\n" +
                "String s = \"abc\"; // line 1\n" +
                "String s1 = new String(\"abcd\"); // line 2\n", "1", "2", "3", 3,
                Question.String_Wrapper, "In line 1, “abc” created in String pool.\n" +
                "\n" +
                "In line 2, first “abcd” created in string pool, then passed as argument\n" +
                " to String new operator and another string gets created in heap memory.\n" +
                "\n");
        addQuestion(st9);

        Question st10 = new Question("What will be the output of below statements?\n" +
                "\n" +
                "String s1 = \"abc\";\n" +
                "StringBuffer s2 = new StringBuffer(s1);\n" +
                "System.out.println(s1.equals(s2));\n",
                "ClassCastException at runtime", "\n" +
                "  true", "false", 3, Question.String_Wrapper,
                "It will print false because s2 is not of type String. If you will look at the equals method implementation in the String class, you will find a check using instanceof \n" +
                        "operator to check if the type of passed object is String? If not, then return false.\n");
        addQuestion(st10);

        Question st11 = new Question(" What will be the output of below statements?\n" +
                "\n" +
                "String s1 = \"abc\";\n" +
                "String s2 = new String(\"abc\");\n" +
                "\t\t\n" +
                "System.out.print(s1==s2);\n" +
                "System.out.println(s1==s2.intern());\n",
                "true true",
                "false true",
                "true false"

                , 2, Question.String_Wrapper,
                "s1 is in the string pool whereas s2 is created in heap memory. Hence s1==s2 will return false.\n" +
                        "\n" +
                        "When s2.intern() method is called, it checks if there is any string with value “abc” in the pool. So it returns the reference of s1. So both s1 and s2 \n" +
                        "are pointing to same string instance now. Hence s1==s2.intern() will return true.\n");
        addQuestion(st11);

        Question st12 = new Question("Which method when implemented must return true while there are still more elements to extract, " +
                "and false when all the elements have been enumerated?\n",
                "Object nextElement( )", "boolean hasMoreElements( )", " Both A & B",
                1, Question.String_Wrapper, "boolean hasMoreElements( )");
        addQuestion(st12);

        Question st13 = new Question("  Which defines a method called nextElement that is used to get the next element in a data structure that contains multiple elements?",
                "Bitset", "Vector", "Enumeration", 3, Question.String_Wrapper, "Enumeration");
        addQuestion(st13);

        Question st14 = new Question("int x = 25;\n" +
                "Integer y = new Integer(33);\n" +
                "What is the difference between these two statements? \n",
                "Primitive data types", " primitive data type and an object of a wrapper class\n",
                "Wrapper class\n", 2, Question.String_Wrapper, "None");
        addQuestion(st14);

        Question st15 = new Question("Where does the primitive data type values be stored? ", " Heap Memory",
                "Stack Memory", "Both A & B", 2, Question.String_Wrapper, "Stack Memory\n");
        addQuestion(st15);

        Question st16 = new Question(" Wrapper classes are not used to convert any data type into an object.",
                "True", "false", "None", 2, Question.String_Wrapper, "Wrapper classes are used to convert any data type into an object");
        addQuestion(st16);

        Question st17 = new Question("Which of these is a wrapper for data type int?",
                "Integer", "Long", " Byte", 1, Question.String_Wrapper, "Integer");
        addQuestion(st17);

        Question st18 = new Question(" Which of the following methods is a method of wrapper Integer for obtaining hash code for the invoking object?\n",
                " int hash()\n", " int hashcode()", "int hashCode()", 3, Question.String_Wrapper, "None");
        addQuestion(st18);
        Question st19 = new Question("Which of these is a super class of wrappers Long, Character & Integer?\n",
                "Long", "Number", "Digits", 2, Question.String_Wrapper,
                "Number is an abstract class containing subclasses Double, Float, Byte, Short, Integer and Long.\n");
        addQuestion(st19);

        Question st20 = new Question("What is the output of this program?\n" +
                "\n" +
                "    class Output \n" +
                "    {\n" +
                "        public static void main(String args[]) \n" +
                "        {\n" +
                "            char a[] = {'a', '5', 'A', ' '};   \n" +
                "            System.out.print(Character.isDigit(a[0]) + \" \");\n" +
                "            System.out.print(Character.isWhitespace(a[3]) + \" \");\n" +
                "            System.out.print(Character.isUpperCase(a[2]));\n" +
                "        }\n" +
                "    }\n",
                "true false true", " false true true\n", " true true false", 2,
                Question.String_Wrapper, "Character.isDigit(a[0]) checks for a[0], whether it is a digit or not, since a[0] i:e ‘a’ is a character false is returned. a[3] is a whitespace hence Character.isWhitespace(a[3]) returns a true.\n" +
                " a[2] is an uppercase letter i:e ‘A’ hence Character.isUpperCase(a[2]) returns true.\n");
        addQuestion(st20);

        Question st21 = new Question(" Which of these is wrapper for simple data type char?\n", "Float",
                "Character", " String", 2, Question.String_Wrapper, "None");
        addQuestion(st21);

        Question st22 = new Question(" Which of these class is superclass of String and StringBuffer class?\n",
                "Java.util", "Java.lang", "ArrayList", 2, Question.String_Wrapper, "None");
        addQuestion(st22);

        Question st23 = new Question("String in Java is a___", "class", "object", "variable",
                1, Question.String_Wrapper, "None");
        addQuestion(st23);

        Question in = new Question("Which is true about an anonymous inner class?", "It can extend exactly one class and implement exactly one interface."
                , "It can extend exactly one class and can implement multiple interfaces.", "It can extend exactly one class or implement exactly one interface."
                , 3, Question.Inner_Classes, "The syntax of an anonymous inner class allows for only one named type after the new, and that type must be either a single interface (in which case " +
                "the anonymous class implements that one interface) or a single class (in which case the anonymous class extends that one class).");
        addQuestion(in);

        Question in1 = new Question("class Boo \n" +
                "{\n" +
                "    Boo(String s) { }\n" +
                "    Boo() { }\n" +
                "}\n" +
                "class Bar extends Boo \n" +
                "{\n" +
                "    Bar() { }\n" +
                "    Bar(String s) {super(s);}\n" +
                "    void zoo() \n" +
                "    {\n" +
                "    // insert code here\n" +
                "    }\n" +
                "}\n" +
                "which one create an anonymous inner class from within class Bar?", "Boo f = new Boo(24) { }",
                "Boo f = new Bar() { }", "Bar f = new Boo(String s) { }", 2, Question.Inner_Classes,
                "anonymous inner classes are no different from any other class when it comes to polymorphism. That means you are always allowed to declare a reference variable of the superclass type and have that reference variable refer to an " +
                        "instance of a subclass type, which in this case is an anonymous subclass of Bar. Since Bar is a" +
                        " subclass of Boo, it all works.");
        addQuestion(in1);

        Question in2 = new Question("Which is true about a method-local inner class?", "It must be marked final", "It can be marked abstract",
                "It can be marked public", 2, Question.Inner_Classes, "A method-local inner class can be abstract, although it means a subclass of the inner" +
                " class must be created if the abstract class is to be used (so an abstract method-local inner class is probably not useful");
        addQuestion(in2);

        Question in3 = new Question("Which statement is true about a static nested class?", "You must have a reference to an instance of the enclosing class in order to instantiate it.",
                "It's variables and methods must be static", "It does not have access to nonstatic members of the enclosing class", 3, Question.Inner_Classes,
                "a static nested class is not tied to an instance of the enclosing class, and thus can't access the nonstatic members of the class (just as a static method " +
                        "can't access nonstatic members of a class");
        addQuestion(in3);
        Question in4 = new Question("Which constructs an anonymous inner class instance?", "Runnable r = new Runnable() { }",
                "Runnable r = new Runnable(public void run() { })", "System.out.println(new Runnable() {public void run() { }})",
                3, Question.Inner_Classes, " It defines an anonymous inner class instance, which also means it creates an instance of that new anonymous class at the" +
                " same time. The anonymous class is an implementer of the Runnable interface, so it must override the run() method of Runnable");
        addQuestion(in4);

        Question in5 = new Question("class Foo \n" +
                "{\n" +
                "    class Bar{ }\n" +
                "}\n" +
                "class Test \n" +
                "{\n" +
                "    public static void main (String [] args) \n" +
                "    {\n" +
                "        Foo f = new Foo();\n" +
                "        /* Line 10: Missing statement ? */\n" +
                "    }\n" +
                "}\n" +
                "which statement, inserted at line 10, creates an instance of Bar?",
                "Foo.Bar b = f.new Bar();", "Foo.Bar b = new Foo.Bar()", "Bar b = f.new Bar();",
                1, Question.Inner_Classes, "Option 1 is correct because the syntax is correct-using both names (the enclosing class and the " +
                "inner class) in the reference declaration, then using a reference to the enclosing class to invoke new on the inner class.");
        addQuestion(in5);



       Question in6=new Question("public class MyOuter\n" +
               "{\n" +
               "public static class MyInner\n" +
               "{\n" +
               "public static void foo() { }\n" +
               "}\n" +
               "}\n" +
               "which statement, if placed in a class other than MyOuter or MyInner, instantiates an instance of the nested class?",
               "MyOuter.MyInner m = new MyOuter.MyInner()","MyOuter.MyInner mi = new MyInner()",
               "MyInner mi = new MyOuter.MyInner()",1,Question.Inner_Classes,
               "MyInner is a static nested class, so it must be instantiated using the fully-scoped name of MyOuter.MyInner.");
addQuestion(in6);

Question in7=new Question("Instance of inner class can exist only _______________ enclosing class.",
        "Within","Outside","Public to",1,Question.Inner_Classes," The class defined inside another class is local to the enclosing class. This means that the instance" +
        " of inner class will not be valid outside the enclosing class. There is no restriction for instance to be private or public always.");
addQuestion(in7);

Question in8=new Question(" A static nested class is _____________ class in behavior that is nested in another _________ class",
        "Top level, low level","Top level, top level","Low level, top level",
        2,Question.Inner_Classes,"Top level class encloses the other classes or have same preference as that of other top level " +
        "classes. Having a class inside the top level class is indirectly having a top level class which higher degree of encapsulation.");
addQuestion(in8);
Question in9=new Question("Which among the following is correct advantage/disadvantage of nested classes?","Makes the code more complex",
        "Makes the code unreadable"," Makes the code efficient and readable",3,Question.Inner_Classes,"The use of nested classes make the code more streamed towards a single concept. " +
        "This allows to group the most similar and related classes together and makes it even more efficient and readable.");
addQuestion(in9);
Question in10=new Question("Non-static nested classes have access to _____________ from enclosing class.",
        "Private members","Protected members","All the members",3,Question.Inner_Classes,
        "The non-static nested class can access all the members of the enclosing class. All the data members" +
                " and member functions can be accessed from the nested class. Even if the members are private, they can be accessed.");
addQuestion(in10);
Question in11=new Question("Which feature of OOP reduces the use of nested classes?","Encapsulation","Inheritance","Binding",2,
        Question.Inner_Classes," Using inheritance we can have the security of the class being inherited." +
        " The sub class can access the members of parent class. And have more feature than a nested class being used.");
addQuestion(in11);

Question in12=new Question("How many categories are nested classes divided into?","2","3",
        "4",1,Question.Inner_Classes,"The nested classes are divided into two main categories. Namely, Static and non-static. The categories define how the classes can be used inside another class.");
addQuestion(in12);

Question in13=new Question("Use of nested class ____________ encapsulation","Increases",
        "Decreases","Slightly decreases",1,Question.Inner_Classes," The use of nested class increases encapsulation as the inner class is getting even more grouped into the enclosing class." +
        " Firstly the class encapsulate the data, having nested classes can increase the encapsulation even further.");
addQuestion(in13);



Question mt1=new Question("What is multithreaded programming?",
        "It’s a process in which two different processes run simultaneously",
        "It’s a process in which two or more parts of same process run simultaneously",
        " It’s a process in which many different process are able to access same information",2,
        Question.Multi_Threading,"Multithreaded programming a process in which two or more parts of same process run simultaneously.");
addQuestion(mt1);

Question mt2=new Question("What is the name of the thread in output of this program?\n" +
        "\n" +
        "    class multithreaded_programing\n" +
        "    {\n" +
        "        public static void main(String args[])\n" +
        "        {\n" +
        "            Thread t = Thread.currentThread();\n" +
        "            System.out.println(t.isAlive());        \n" +
        "        }\n" +
        "    }","0","1","true",3,Question.Multi_Threading,"Thread t is seeded to" +
        " currently program, hence when you run the program the thread becomes active & code ‘t.isAlive’ returns true.");
addQuestion(mt2);

Question mt3=new Question("What is the priority of the thread in output of this program?\n" +
        "\n" +
        "    class multithreaded_programing \n" +
        "    {\n" +
        "        public static void main(String args[])\n" +
        "        {\n" +
        "            Thread t = Thread.currentThread();\n" +
        "            System.out.println(t);        \n" +
        "        }\n" +
        "    }","4","5","0",2,Question.Multi_Threading,"The output of program is Thread[main,5,main], in this priority assigned to the thread is 5. " +
        "It’s the default value. Since we have not named the thread they are named by the group to they belong i:e main method.");
addQuestion(mt3);
Question mt4=new Question("Which of these are types of multitasking?",
        "Process based","Thread based"," Process and Thread based",3,
        Question.Multi_Threading,"There are two types of multitasking: Process based multitasking and Thread based multitasking.");
addQuestion(mt4);

Question mt5=new Question("Which of these packages contain all the Java’s built in Thread Class?"," java.io"," java.util"," java.lang",
3,Question.Multi_Threading,"None");
addQuestion(mt5);

Question mt6=new Question("Thread priority in Java is?","Integer","Float","double",1,Question.Multi_Threading,
        "Java assigns to each thread a priority that determines hoe that thread should be treated with respect" +
                " to others. Thread priority are integers that specify relative priority of one thread to another.");
addQuestion(mt6);

Question mt7=new Question("What will happen if two thread of same priority are called to be processed simultaneously?",
        "Anyone will be executed first lexographically","Both of them will be executed simultaneously",
        "It is dependent on the operating system",3,Question.Multi_Threading,"In cases where two or more thread with same priority are competing for CPU cycles, different operating" +
        " system handle this situation differently. Some execute them in time sliced manner some depending on the thread they call.");
addQuestion(mt7);


Question mt8=new Question("Which of these statements is incorrect?","By multithreading CPU idle time is minimized, and we can take maximum use of it",
        "A thread can exist only in two states, running and blocked","Two thread in Java can have same priority",
        2,Question.Multi_Threading,"hread exist in several states, a thread can be running, " +
        "suspended, blocked, terminated & ready to run.");
addQuestion(mt8);
Question mt9=new Question(" What is the name of the thread in output of this program?\n" +
        "\n" +
        "    class multithreaded_programing\n" +
        "    {\n" +
        "        public static void main(String args[])\n" +
        "        {\n" +
        "            Thread t = Thread.currentThread();\n" +
        "            System.out.println(t);        \n" +
        "        }\n" +
        "    }"," main"," Thread","System",1,Question.Multi_Threading,
        "The output of program is Thread[main,5,main], Since we have not explicitly " +
                "named the thread they are named by the group to they belong i:e main method. Hence they are named ‘main’.");
addQuestion(mt9);

Question mt10=new Question("Which method is called internally by Thread start() method?","execute()","run()",
        "main()",2,Question.Multi_Threading,"Thread start() method internally calls run() method. All statements inside the run method is get executed by the thread.");
addQuestion(mt10);

Question mt11=new Question(" What is maximum thread priority in Java","1","10","5",2,Question.Multi_Threading,
        "10");
addQuestion(mt11);

Question mt12=new Question(" Number of threads in below java program is\n" +
        " \n" +
        "public class ThreadExtended extends Thread {\n" +
        " \n" +
        "\tpublic void run() {\n" +
        "\t\tSystem.out.println(\"\\nThread is running now\\n\");\n" +
        "\t}\n" +
        " \n" +
        "\tpublic static void main(String[] args) {\n" +
        " \n" +
        "\t\tThreadExtended threadE = new ThreadExtended();\n" +
        " \n" +
        "\t\tthreadE.start();\n" +
        "\t}\n" +
        "}","1","2","3",2,Question.Multi_Threading,"Main " +
        "program is also run as a thread. And, program has created one child thread. Hence, " +
        "total 2 threads are there in the program.");
addQuestion(mt12);

Question mt13=new Question(" Execution of a java thread begins on which method call?","start()","run()","Execute ()",1,Question.Multi_Threading,
        "On thread start method create a thread and execute it. Note that thread start() method calls run() method internally.");
addQuestion(mt13);
Question mt14=new Question("Which method is used to make main thread to wait for all child threads","Join ()","sleep()","wait()",
        1,Question.Multi_Threading,"join()");
addQuestion(mt14);
Question mt15=new Question("Which method is used to check if a thread is running?","isAlive()","run()","alive ()",1,Question.Inner_Classes,"isAlive()");
addQuestion(mt15);

Question mt16=new Question("Which method we implement from Runnable interface?","run ()","start ()","call ()",1,Question.Multi_Threading,"run");
   addQuestion(mt16);

   Question mt17=new Question("Daemon thread runs in","Background","Foreground","Both",1,Question.Multi_Threading,"threads that run-in background" +
           " within same process is called daemon thread. Read daemon thread with example in Java");
   addQuestion(mt17);

   Question mt18=new Question("Thread synchronization in a process will be required when","All threads sharing the same address space",
           "All threads sharing the same global variables","Both",3,Question.Multi_Threading,"Both");
    addQuestion(mt18);

    Question mt19=new Question("The life cycle of a thread in java is controlled by","JRE","JDK","JVM",3,Question.Multi_Threading,"None");
    addQuestion(mt19);

    Question mt20=new Question("Which method is used to get current running thread object?","runningThread()","currentThread()","runnableThread()",2,Question.Multi_Threading,"None");
    addQuestion(mt20);


    Question col1=new Question("Which of these packages contain all the collection classes?","java.lang","java.util",
            "java.awt",2,Question.Collection,"java.util");
    addQuestion(col1);

    Question col2=new Question("Which of these classes is not part of Java’s collection framework?","Maps","Array","Queue",
            3,Question.Collection,"Queue is not a part of collection framework.");
    addQuestion(col2);

    Question col3=new Question("Which of these interface is not a part of Java’s collection framework?",
            "List","SortedMap"," SortedList",3,Question.Collection,"SortedList is not a part of collection framework.");
    addQuestion(col3);

    Question col4=new Question("What is Collection in Java?","A group of objects","A group of classes","A group of interfaces",1,
            Question.Collection,"A collection is a group of objects, it is similar to String Template Library (STL) of C++ programming language");
    addQuestion(col4);

    Question col5=new Question("Which of these interface declares core method that all collections will have?","Set",
            "EventListner","Comparator",1,Question.Collection,"Collection interfaces defines" +
            " core methods that all the collections like set, map, arrays etc will have.");
    addQuestion(col5);

    Question col6=new Question("Which of these interface must contain a unique element?","Set","List","Array",1,Question.Collection,
            "Set interface extends collection interface to handle sets, which must contain unique elements.");
    addQuestion(col6);

    Question col7=new Question("Which of these methods deletes all the elements from invoking collection?","clear()","reset()","delete()",
            1,Question.Collection,"clear() method removes all the elements from invoking collection");
    addQuestion(col7);

    Question col8=new Question("What is the output of this program?\n" +
            "\n" +
            "    import java.util.*;\n" +
            "    class Array \n" +
            "    {\n" +
            "        public static void main(String args[]) \n" +
            "        {\n" +
            "            int array[] = new int [5];\n" +
            "            for (int i = 5; i > 0; i--)\n" +
            "                array[5-i] = i;\n" +
            "            Arrays.fill(array, 1, 4, 8);\n" +
            "            for (int i = 0; i < 5 ; i++)\n" +
            "                System.out.print(array[i]);\n" +
            "        }\n" +
            "    }","12885","12845","58881",3,Question.Collection,
            "array was containing 5,4,3,2,1 but when method Arrays.fill(array, 1, 4, 8) is called it fills the index location starting with 1 to 4 by value 8 hence array becomes 5,8,8,8,1.");

    addQuestion(col8);
    Question col9=new Question("What is the output of this program?\n" +
            "\n" +
            "    import java.util.*;\n" +
            "    class stack \n" +
            "    {\n" +
            "        public static void main(String args[]) \n" +
            "        {\n" +
            "            Stack obj = new Stack();\n" +
            "            obj.push(new Integer(3));\n" +
            "            obj.push(new Integer(2));\n" +
            "            obj.pop();\n" +
            "            obj.push(new Integer(5));\n" +
            "     \t    System.out.println(obj);\n" +
            "        }\n" +
            "    }","[3, 5]","[3, 2]"," [3, 2, 5].",1,Question.Collection,"push() and pop() are standard functions of the class stack, push() inserts in the stack and pop removes from the stack. 3 & 2 are inserted using push()" +
            " the pop() is used which removes 2 from the stack then again push is used to " +
            "insert 5 hence stack contains elements 3 & 5.");
    addQuestion(col9);

    Question col10=new Question("What is the output of this program?\n" +
            "\n" +
            "    import java.util.*;\n" +
            "    class hashtable \n" +
            "    {\n" +
            "        public static void main(String args[]) \n" +
            "        {\n" +
            "            Hashtable obj = new Hashtable();\n" +
            "            obj.put(\"A\", new Integer(3));\n" +
            "            obj.put(\"B\", new Integer(2));\n" +
            "            obj.put(\"C\", new Integer(8));\n" +
            "            obj.remove(new String(\"A\"));\n" +
            "            System.out.print(obj);\n" +
            "        }\n" +
            "    }"," {C=8, B=2}","[C=8, B=2]"," {A=3, C=8, B=2}",2,Question.Collection,
            "$ javac hashtable.java\n" +
                    "$ java hashtable\n" +
                    "{C=8, B=2}");
    addQuestion(col10);

    Question col11=new Question("What is the output of this program?\n" +
            "\n" +
            "    import java.util.*;\n" +
            "    class Bitset \n" +
            "    {\n" +
            "        public static void main(String args[]) \n" +
            "        {\n" +
            "            BitSet obj = new BitSet(5);\n" +
            "            for (int i = 0; i < 5; ++i)\n" +
            "                obj.set(i);\n" +
            "            obj.clear(2);\n" +
            "            System.out.print(obj);\n" +
            "        }\n" +
            "    }"," {0, 1, 3, 4}"," {0, 1, 2, 4}"," {0, 1, 2, 3, 4}",1,Question.Collection,
            "$ javac Bitset.java\n" +
                    "$ java Bitset\n" +
                    "{0, 1, 3, 4}");
    addQuestion(col11);



    Question jd1=new Question("Which of the following is not a component/class of JDBC API?",
            "DriverManager","Connection","Transaction",3,Question.JDBC,
            "Transaction is not a class of JDBC API. JDBC API consists of following interfaces " +
                    "and classes: DriverManager, Driver, Connection, Statement, ResultSet, SQLException.");
    addQuestion(jd1);


    Question jd2=new Question("In which of the following type of ResultSet, the cursor can only move forward in the result set?",
            "ResultSet.TYPE_FORWARD_ONLY","ResultSet.TYPE_SCROLL_INSENSITIVE","ResultSet.TYPE_SCROLL_SENSITIVE",
            1,Question.JDBC,
            "ResultSet.TYPE_FORWARD_ONLY: The cursor can only move forward in the result set.");
    addQuestion(jd2);

    Question jd3=new Question("Which of the following type of JDBC driver, is also called Type 3 JDBC driver?",
            "JDBC-ODBC Bridge plus ODBC driver",
            "Native-API, partly Java driver","JDBC-Net, pure Java driver",3,Question.JDBC,
            "JDBC-Net, pure Java driver, is also called Type 3 JDBC driver.");
    addQuestion(jd3);


    Question jd4=new Question("Which of the following is used to call stored procedures on the database?",
            " Statement","PreparedStatement","CallableStatement",3,Question.JDBC,
            "CallableStatement is used to call stored procedures on the database.");
    addQuestion(jd4);

Question jd5=new Question("Which of the following is correct about SQL Warning?","A warning can be reported on a Connection object, a Statement object (including PreparedStatement and CallableStatement objects), or a ResultSet object.",
        "Connection, Statement and ResultSet has a getWarnings method.","Both of the above.",3,Question.JDBC,
        "A warning can be reported on a Connection object, a Statement object (including PreparedStatement and CallableStatement objects)," +
                " or a ResultSet object. Each of these classes has a getWarnings method.");

    addQuestion(jd5);

    Question jd6=new Question("JDBC stands for","java database connectivity","java database components","java database control",1,Question.JDBC,"java database connectivity");
    addQuestion(jd6);

    Question jd7=new Question("Which of the following is advantage of using PreparedStatement in Java?","Slow performance","Encourages SQL injection",
            " Prevents SQL injection",3,Question.JDBC,"PreparedStatement in Java improves performance and also prevents from SQL injection.");
    addQuestion(jd7);

    Question jd8=new Question("What does setAutoCommit(false) do?","commits transaction after each query","does not commit transaction automatically after each query",
            "explicitly commits transaction",2,Question.JDBC,"setAutoCommit(false) does not commit transaction automatically after each query. That saves lot of time of the execution and hence improves performance.");
    addQuestion(jd8);

    Question jd9=new Question("Which of the following is method of JDBC batch process?","setBatch()","addBatch()","removeBatch()",2,Question.JDBC,
            "addBatch() is a method of JDBC batch process. It is faster in processing than executing one statement at a time.");
    addQuestion(jd9);

    Question jd10=new Question("Which one of the following contains date information?","java.sql.TimeStamp"," java.sql.Time",
            " java.io.Time",1,Question.JDBC,"java.sql.Time contains only time. Whereas, java.sql.TimeStamp contains both time and date.");
addQuestion(jd10);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, question.getQuestion1());
        cv.put(QuestionTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionTable.COLUMN_DIFICULTY, question.getDificulity());
        cv.put(QuestionTable.COLUMN_ANS, question.getAns());
        db.insert(QuestionTable.TABLE_NAME, null, cv);

    }

    /*    public ArrayList<Question> getAllQuestions() {
            ArrayList<Question> questionList = new ArrayList<>();
            db = this.getReadableDatabase();
            Cursor c = db.rawQuery("SELECT * FROM "+ QuestionTable.TABLE_NAME, null);
            if (c.moveToFirst()) {
                do {

                    Question question = new Question();
                    question.setQuestion1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                    question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                    question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                    question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                    question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                    question.setDificulity(c.getString(c.getColumnIndex(QuestionTable.COLUMN_DIFICULTY)));
                    question.setAns(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANS)));
                    questionList.add(question);

                } while (c.moveToNext());
            }
            c.close();
            return questionList;
        }*/
    public ArrayList<Question> getQuestions(String dificulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = this.getReadableDatabase();

        String[] selectionArgs = new String[]{dificulty};
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME +
                " WHERE " + QuestionTable.COLUMN_DIFICULTY + " = ?", selectionArgs);
        if (c.moveToFirst()) {
            do {

                Question question = new Question();
                question.setQuestion1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                question.setDificulity(c.getString(c.getColumnIndex(QuestionTable.COLUMN_DIFICULTY)));
                question.setAns(c.getString(c.getColumnIndex(QuestionTable.COLUMN_ANS)));
                questionList.add(question);

            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
