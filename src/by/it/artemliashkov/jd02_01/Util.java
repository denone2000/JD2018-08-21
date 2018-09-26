package by.it.artemliashkov.jd02_01;

class Util {
    static int random()
    {
        return random(0, 2);
    }

    public static int random(int from,int to)
    {
        return (int)(from+Math.random()*(to-from+1));
    }

}
