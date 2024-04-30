public class Calling_java_methods_from_c {
    // Calling Java methods from C++ (callback)/Memanggil metode Java dari C++
    // (callback)

    /*
     * Memanggil metode Java dari kode asli adalah proses dua langkah :
     * 1. mendapatkan penunjuk metode dengan fungsi GetMethodID JNI, menggunakan
     * nama metode dan deskriptor;
     * 2. panggil salah satu fungsi Metode call* yang tercantum di sini.
     */

    /*
     * Java code
     * com.example.jni.JNIJavaCallback.java
     * 
     * package com.example.jni;
     * public class JNIJavaCallback {
     * static {
     * System.loadLibrary("libJNI_CPP");
     * }
     * 
     * public static void main(String[] args) {
     * new JNIJavaCallback().callback();
     * }
     * public native void callback();
     * public static void printNum(int i) {
     * System.out.println("Got int from C++: " + i);
     * }
     * 
     * public void printFloat(float i) {
     * System.out.println("Got float from C++: " + i);
     * }
     * }
     * C++ code
     * // com_example_jni_JNICppCallback.cpp
     * #include <iostream>
     * #include "com_example_jni_JNIJavaCallback.h"
     * using namespace std;
     * JNIEXPORT void JNICALL Java_com_example_jni_JNIJavaCallback_callback(JNIEnv
     * *env, jobject jthis) {
     * jclass thisClass = env->GetObjectClass(jthis);
     * jmethodID printFloat = env->GetMethodID(thisClass, "printFloat", "(F)V");
     * if (NULL == printFloat)
     * return;
     * env->CallVoidMethod(jthis, printFloat, 5.221);
     * jmethodID staticPrintInt = env->GetStaticMethodID(thisClass, "printNum",
     * "(I)V");
     * if (NULL == staticPrintInt)
     * return;
     * env->CallVoidMethod(jthis, staticPrintInt, 17);
     * }
     * Output
     * Got float from C++: 5.221
     * Got int from C++: 17
     * 
     */

    /*
     * Getting the descriptor
     * Deskriptor (atau tanda tangan tipe internal) diperoleh menggunakan program
     * javap pada file .class yang dikompilasi. Di sini adalah
     * keluaran dari javap -p -s com.example.jni.JNIJavaCallback :
     * 
     * Compiled from "JNIJavaCallback.java"
     * public class com.example.jni.JNIJavaCallback {
     * static {};
     * descriptor: ()V
     * public com.example.jni.JNIJavaCallback();
     * descriptor: ()V
     * public static void main(java.lang.String[]);
     * descriptor: ([Ljava/lang/String;)V
     * public native void callback();
     * descriptor: ()V
     * public static void printNum(int);
     * descriptor: (I)V // <---- Needed
     * public void printFloat(float);
     * descriptor: (F)V // <---- Needed
     * }
     */

    static {
        System.loadLibrary("libJNI_CPP");
    }

    public static void main(String[] args) throws Exception {
        new Calling_java_methods_from_c().callback();
    }

    public static void printNum(int i) {
        System.out.println("Got int from C++: " + i);
    }

    public void printFloat(float i) {
        System.out.println("Got float from C++: " + i);
    }

}