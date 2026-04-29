//------------PACKAGE A-------------//

package apack;

public class A {
    public int pubVar;
    protected int protVar;
    private int privVar;

    // Constructor
    public A(int pub, int prot, int priv) {
        pubVar = pub;
        protVar = prot;
        privVar = priv;
    }

    // Getter for private variable
    public int getPrivVar() {
        return privVar;
    }
}

//------------PACKAGE B-------------//

package bpack;

import apack.A;

public class B extends A {

    public B(int pub, int prot, int priv) {
        super(pub, prot, priv);
    }

    public void display() {
        System.out.println("Inside class B (Inheritance)");
        System.out.println("Public variable: " + pubVar);
        System.out.println("Protected variable: " + protVar);
        System.out.println("Private variable (via getter): " + getPrivVar());
    }
}

//------------PACKAGE C-------------//

package cpack;

import apack.A;

public class C {

    public void display(int pub, int prot, int priv) {
        A a = new A(pub, prot, priv);

        System.out.println("Inside class C (No inheritance)");
        System.out.println("Public variable: " + a.pubVar);

        // Cannot access protected directly (different package, no inheritance)
        // System.out.println(a.protVar); // Not allowed

        System.out.println("Private variable (via getter): " + a.getPrivVar());
    }
}

//------------MAIN CLASS-------------//

package dpack;

import java.util.Scanner;
import bpack.B;
import cpack.C;

public class ProtectedDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter values for B (pub, prot, priv):");
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int b3 = sc.nextInt();

        B b = new B(b1, b2, b3);

        System.out.println("Enter values for C (pub, prot, priv):");
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int c3 = sc.nextInt();

        C c = new C();

        System.out.println("\n--- Calling B ---");
        b.display();

        System.out.println("\n--- Calling C ---");
        c.display(c1, c2, c3);

        sc.close();
    }
}