package main;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public final class ImutableMatrix {
    private final Matrix a;
    //Конструктор Imutable-матриці
    public ImutableMatrix(Matrix b) {
        this.a = b.copy();}
    //Розмірність Imutable-матриці
    public String size() {
        return (this.a.size());
    }
    //Отримання елемента за індексом
    public int getElement(int r,int c) {
        return (int) this.a.getElement(r,c);
    }
    //Отримання рядка
    public Matrix getRow(int row) {
        Matrix oneRow = new Matrix (1,a.column);
        for (int i = 0; i < a.column; i++) {
            oneRow.setElement(a.mat[row][i],0,i);}
        return oneRow;
    }

    //Отримання стовпчика
    public Matrix getColumn(int column) {
        Matrix oneRow = new Matrix (a.row,1);
        for (int j = 0; j < a.row; j++) {
            oneRow.setElement(a.mat[j][column],j,0);}
        return oneRow;
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

}
