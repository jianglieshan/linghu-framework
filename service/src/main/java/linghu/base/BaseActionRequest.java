package linghu.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className", visible = true)
//@JsonSubTypes({@JsonSubTypes.Type(value = ProductViewModel.class, name = "product")
//        , @JsonSubTypes.Type(value = StoreViewModel.class, name = "store")})

public class BaseActionRequest extends CommonRequest {
    private BaseViewModel viewModel;
    private String action;
    private String className;

    @JsonIgnore
    public BaseViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(BaseViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public int hashCode() {
        return (action+className).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BaseActionRequest){
            BaseActionRequest r = (BaseActionRequest)obj;
            return (action+className).equals(r.action+r.className);
        }
        else{
            return false;
        }

//        return super.equals(obj);
    }
}
