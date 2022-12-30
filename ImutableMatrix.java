package main;

import java.util.Arrays;

public final class ImutableMatrix {
    private final Matrix a;

    //Конструктор
    public ImutableMatrix(Matrix b) {
        this.a = b.copyOfMatrix();}

    public ImutableMatrix(int r, int c, Matrix a) {

        this.a = a;
    }

    public ImutableMatrix(int row, int column) {
        this.a = null ;

    }


    //Розмірність
    public String size() {
        return (this.a.size());
    }
    //Копія іншої матриці
    public ImutableMatrix copyOfMatrix(){
        Matrix copyOfMatrix = new Matrix(this.a.row,this.a.column);
        for (int r=0;r<this.a.row;r++){
            for (int c=0;c<this.a.column;c++){
                copyOfMatrix.setElement( this.a.mat[r][c],r,c);
            }
        }
        return new ImutableMatrix(copyOfMatrix);
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
    //Отримання елемента за індексом
    public int getElement(int r,int c) {
        return (int) this.a.getElement(r,c);
    }
    //Отримання рядка
    public boolean getRow (int row){
        for(int i = 0; i<a.column; i++)
            System.out.print(this.a.mat[row][i] + " ");
        System.out.println();
        return true;
    }

    //Отримання стовпчика
    public boolean getColumn (int column){
        for(int i = 0; i<a.row; i++)
            System.out.printf(this.a.mat[i][column] + " ");
        System.out.println();
        return true;
    }
    //Метод equals
    public boolean equals(ImutableMatrix B) {
        ImutableMatrix A = this;
        if (B.a.column != A.a.column || B.a.row != A.a.row) throw new RuntimeException("False");
        for (int i = 0; i < a.column; i++)
            for (int j = 0; j < a.row; j++)
                if (A.a.mat[i][j] != B.a.mat[i][j]) return false;
        return true;
    }
    //Метод hashcode
    public int hashCode() {
        int h = 0;
        for (int i=0; i<this.a.mat.length; i++) {
            h =+ Arrays.hashCode(this.a.mat[i]);
        }
        return h;
    }
    //Множення матриць
    public ImutableMatrix times(ImutableMatrix B) {
        ImutableMatrix A = this;
        if (A.a.column != B.a.row) throw new RuntimeException("Illegal matrix dimensions.");
        ImutableMatrix C = new ImutableMatrix(A.a.row, B.a.column);
        for (int i = 0; i < C.a.row; i++)
            for (int j = 0; j < C.a.column; j++)
                for (int k = 0; k < B.a.row; k++)
                    C.a.mat[i][j] += (A.a.mat[i][k] * B.a.mat[k][j]);
        return C;
    }

}


