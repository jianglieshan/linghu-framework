package linghu.busness;

import linghu.base.BaseActionRequest;
import linghu.base.BaseViewModel;

import java.util.List;

public interface IBusinessService {
    BaseViewModel addOrUpdate(BaseActionRequest request);
    List<BaseViewModel> query(BaseActionRequest request);
}
