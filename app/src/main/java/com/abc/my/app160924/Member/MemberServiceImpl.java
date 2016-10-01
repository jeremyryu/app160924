package com.abc.my.app160924.Member;

import android.util.Log;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemeberService {
    MemberDAO dao = new MemberDAO();

    @Override
    public MemberDTO login(MemberDTO param) {
        Log.i("====SERVICE에서 받은 ID :", param.getId());
        Log.i("====SERVICE에서 받은 PW :", param.getPw());
        MemberDTO member = new MemberDTO();
        member = dao.select(param);

        if (member == null) {
            member.setId("NONE");
            return member;
        }
        else if(member.getPw().equals(param.getPw())) {
            return member;
        }
        else {
            member.setId("NO_MATCH");
            return member;
        }
    }

    @Override
    public MemberDTO join(MemberDTO param) {
        return null;
    }
}
