package com.abc.my.app160924.Member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemeberService {

    public MemberDTO login(MemberDTO member);

    public ArrayList<MemberDTO> getList();
    public ArrayList<MemberDTO> getListByName(MemberDTO member);
    public MemberDTO getOne(MemberDTO member);
    public int count();
    public void update(MemberDTO member);
    public void unregist(String id);

    public void regist(MemberDTO member);

}
