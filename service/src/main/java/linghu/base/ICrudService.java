package linghu.base;

import java.util.List;

public interface ICrudService {
    BaseViewModel addOrUpdate(BaseActionRequest request);
    List<BaseViewModel> query(BaseActionRequest request);
}
