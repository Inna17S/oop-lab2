package main;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Matrix {
    public double[][] mat;
    public int row, column;
    // пустої матриці конструкція
    public Matrix(){
        row=0;
        column=0;
    }
    // конструкція матриці заданого розміру
    public Matrix(int r, int c)
    {
        row = r;
        column = c;
        mat = new double[row][column];
    }
    //Встановлення елемента за індексом

    public void setElement(double val,int i,int j){mat[i][j]= val;}
    //Копія іншої матриці
    public Matrix copy(){
        Matrix copy = new Matrix(row,column);
        for (int i=0;i<row;i++){
            for (int j=0;i<column;j++){
                copy.setElement( mat[i][j],i,j);
            }
        }
        return copy;
    }

    //функція для прийняття значень матриці від користувача
    public void get_input()
    {
        Scanner s = new Scanner(System.in);
        int i=0,j=0;

        System.out.println("Enter matrix elements (row by row)");
        for (i=0; i < row; i++)
        {
            for(j=0; j<column; j++)
            {
                mat[i][j] = s.nextDouble();
            }

        }
    }
    //виведення матриці
    public void print_matrix()
    {
        int i = 0, j = 0;
        System.out.println("The matrix is:>>");
        for (i = 0; i < row; i++)
        {
            System.out.println("");
            for (j = 0; j < column; j++)
            {
                System.out.printf("  " +mat[i][j]);
            }

        }
    }
    //Заповнення матриці випадковими значеннями
    public static Matrix random(int C, int R) {
        Matrix A = new Matrix(R, C);
        int i ;
        int j ;
        for (i = 0; i < C; i++)
            for (j = 0; j < R; j++)
                A.mat[i][j] = Math.round(Math.random() * 21 + 10);
        return A;
    }
    //Розмірність матриці
    public String size() {
        return ("Dimension of matrix:" + row + "x" + column);
    }


    //Отримання елемента за індексом
    public double getElement(int r, int c) {
        if (r >= row || c >= column)
            throw new RuntimeException("\n");
        else {
            return mat[r][c];
        }
    }
    //Отримання рядка
    public Matrix getRow(int row) {
        Matrix oneRow = new Matrix (1,column);
        for (int i = 0; i < column; i++) {
            oneRow.setElement(mat[row][i],0,i);}
        return oneRow;
    }

    //Отримання стовпчика
    public Matrix getColumn(int column) {
        Matrix oneRow = new Matrix (row,1);
        for (int j = 0; j < row; j++) {
            oneRow.setElement(mat[j][column],j,0);}
        return oneRow;
    }

    //порівняння матриці
    public boolean equals(Matrix B) {
        Matrix A = this;
        if (B.column != A.column || B.row != A.row) throw new RuntimeException("");
        for (int i = 0; i < column; i++)
            for (int j = 0; j < row; j++)
                if (A.mat[i][j] != B.mat[i][j]) return false;
        return true;
    }
    //Метод hashcode
    public int hashCode() {
        int h = 0;
        for (int i=0; i<this.mat.length; i++) {
            h =+ Arrays.hashCode(this.mat[i]);
        }
        return h;
    }
    //матриця-рядок
    public static Matrix randomise(int C) {
        Matrix A = new Matrix(1,C);
        int i ;
        for (i = 0; i < C; i++)
                A.mat[0][i] = Math.random();
        return A;
    }


    //Множення матриць
    public Matrix times(Matrix B) {
        Matrix A = this;
        if (A.row != B.column) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.column, B.row);
        for (int i = 0; i < C.column; i++)
            for (int j = 0; j < C.row; j++)
                for (int k = 0; k < A.row; k++)
                    C.mat[i][j] += (A.mat[i][k] * B.mat[k][j]);
        return C;
    }







}
