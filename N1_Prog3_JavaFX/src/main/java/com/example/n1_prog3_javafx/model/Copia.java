package com.example.n1_prog3_javafx.model;

import java.util.Objects;

public class Copia {
    private Integer codigo;
    private boolean fixo;
    private static Integer proxCodigo = 1;
    private Livros lOriginal;

    public Copia(){
        codigo = proxCodigo;
        proxCodigo++;
    }

    public Copia(Integer codigo, boolean fixo,Livros lOriginal) {
        this.codigo = codigo;
        this.fixo = fixo;
        this.lOriginal = lOriginal;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setFixo(boolean fixo) {
        this.fixo = fixo;
    }

    public void setlOriginal(Livros lOriginal) {
        this.lOriginal = lOriginal;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public boolean isFixo() {
        return fixo;
    }

    public Livros getlOriginal() {
        return lOriginal;
    }

    @Override
    public String toString() {
        return lOriginal + "-" + codigo;
    }

    //---//

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Copia copia = (Copia) o;
        return codigo.equals(copia.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}