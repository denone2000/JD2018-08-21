package by.it.basumatarau.jd01_09;

public class TypeLister implements Dispatcher {
    public boolean wasAtInstanceOfScalar = false;
    public boolean wasAtInstanceOfVector = false;
    public boolean wasAtInstanceOfMatrix = false;

    @Override
    public void dispatch(Scalar scalar) {
        wasAtInstanceOfScalar = true;
    }

    @Override
    public void dispatch(Vector vector) {
        wasAtInstanceOfVector = true;
    }

    @Override
    public void dispatch(Matrix matrix) {
        wasAtInstanceOfMatrix = true;
    }

}
