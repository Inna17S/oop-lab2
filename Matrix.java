package main;
import java.util.Arrays;

public class Matrix {
    public double[][] mat;
    public  int row = 0;
    public  int column = 0;

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
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                mat[i][j] = 0;
    }

    //Копія іншої матриці
    public Matrix copyOfMatrix(){
        Matrix copyOfMatrix = new Matrix(row,column);
        for (int r=0;r<row;r++){
            for (int c=0;c<column;c++){
                copyOfMatrix.setElement( mat[r][c],r,c);
            }
        }
        return copyOfMatrix;
    }

    //виведення матриці
    public void print_matrix()
    {
        int i , j;
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
    //Заповнення випадковими значеннями
    public static Matrix random(int r, int c) {
        Matrix A = new Matrix(r, c);
        int i ;
        int j ;
        for (i = 0; i < r; i++)
            for (j = 0; j < c; j++)
                A.mat[i][j] = Math.round(Math.random() * 12 + 5);
        return A;
    }
    //Розмірність матриці
    public String size() {
        return ("Size of matrix:" + row + "x" + column);
    }
    //Встановлення елемента за індексом

    void setElement(double val,int i,int j){mat[i][j]= val;}


    //Отримання елемента за індексом
    public double getElement(int r, int c) {
        if (r >= row || c >= column)
            throw new RuntimeException("");
        else {
            return mat[r][c];
        }
    }
    //Отримання рядка
    public boolean getRow (int row){
        for(int i = 0; i<column; i++)
            System.out.print(this.mat[row][i] + " ");
        System.out.println();
        return true;
    }


    //Отримання стовпчика
    public boolean getColumn (int column){
        for(int i = 0; i<row; i++)
            System.out.printf(this.mat[i][column] + " ");
        System.out.println();
        return true;
    }

    //порівняння матриці
    public boolean equals(Matrix B) {
        Matrix A = this;
        if (B.column != A.column || B.row != A.row) throw new RuntimeException("");
        for (int i = 0; i < column; i++)
            for (int j = 0; j < row; j++)
                if (mat[i][j] != mat[i][j]) return false;
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
    public static Matrix randomise(int c) {
        Matrix A = new Matrix(1,c);
        int i ;
        for (i = 0; i < c; i++)
                A.mat[0][i] = Math.random();
        return A;
    }


    //Множення матриць
    public Matrix times(Matrix B) {
        Matrix A = this;
        if (A.column != B.row) throw new RuntimeException("Illegal matrix dimensions.");
        Matrix C = new Matrix(A.row, B.column);
        for (int i = 0; i < C.row; i++)
            for (int j = 0; j < C.column; j++)
                for (int k = 0; k < B.row; k++)
                    C.mat[i][j] += (A.mat[i][k] * B.mat[k][j]);
        return C;
    }







}
