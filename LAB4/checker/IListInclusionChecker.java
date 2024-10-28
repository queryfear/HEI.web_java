package LAB4.checker;

import java.util.List;

public interface IListInclusionChecker<T> {
    boolean isSublist(List<T> L1, List<T> L2);
}

