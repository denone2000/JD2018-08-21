package by.it.basumatarau.jd01_09;

public interface Dispatcher {
    void dispatch(Scalar scalar);
    void dispatch(Vector vector);
    void dispatch(Matrix matrix);
}
