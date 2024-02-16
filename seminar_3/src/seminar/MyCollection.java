package seminar;

import java.util.Arrays;
import java.util.Iterator;

public class MyCollection<T> implements Iterable {
    private int curInd;
    private Object[] lstObj;

    MyCollection() {
        this.curInd = 0;
        this.lstObj = new Object[10];
    }

    public void add(T obj) {
        if (curInd == lstObj.length - 1) {
            lstObj = Arrays.copyOf(lstObj, lstObj.length + 5);
        }
        lstObj[curInd] = obj;
        curInd++;
    }

    public Object get(Integer index) {
        return lstObj[index];
    }

    public void remove(Integer index) {
        Object[] tmpLst = new Object[lstObj.length];
        if (index >= 0 && index < curInd) {
            for (int i = 0; i < curInd; i++) {
                int iUp = i;
                if (i >= index) {
                    iUp++;
                }
                tmpLst[i] = lstObj[iUp];
            }
            curInd--;
            lstObj = tmpLst;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int curPos = 0;

            @Override
            public boolean hasNext() {
                if (curPos < lstObj.length && lstObj[curPos] != null) return true;
                return false;
            }

            @Override
            public T next() {
                curPos++;
                return (T) lstObj[curPos - 1];
            }
        };
    }

    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < curInd; i++) {
            msg.append(this.get(i) + "; ");
        }
        return msg.toString();
    }
}
