package LAB4.checker;

import java.util.Collections;
import java.util.List;

public class ListInclusionChecker<T> implements IListInclusionChecker<T> {
    @Override
    public boolean isSublist(List<T> L1, List<T> L2) {
        return Collections.indexOfSubList(L2, L1) != -1;
    }
}
