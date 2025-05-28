com.utils/module-info.java

module com.utils {
    exports com.utils;
}


com.utils/src/com/utils/StringUtils.java

package com.utils;
public class StringUtils {
    public static String greet(String name) {
        return "Hello, " + name + "!";
    }
}


com.greetings/module-info.java

module com.greetings {
    requires com.utils;
}


com.greetings/src/com/greetings/Main.java

package com.greetings;
import com.utils.StringUtils;
public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.greet("User"));
    }
}


Compile and run commands

javac -d com.utils/out --module-source-path com.utils/src -m com.utils
javac -d com.greetings/out --module-path com.utils/out --module-source-path com.greetings/src -m com.greetings
java --module-path com.utils/out:com.greetings/out -m com.greetings/com.greetings.Main

Output:

Hello, User!
