package com.ming.bz;

import com.ming.po.Items;
import com.ming.po.Orderdetail;
import com.ming.po.UserEx;

import java.util.List;

public class UserBz {

    private UserEx userEx;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public UserEx getUserEx() {
        return userEx;
    }

    public void setUserEx(UserEx userEx) {
        this.userEx = userEx;
    }
}
