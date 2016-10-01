package com.abc.my.app160924.Member;

import android.util.Log;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO {

    public MemberDTO select(MemberDTO param) {
        Log.i("DAO 에서 받은 id :", param.getId());
        Log.i("DAO 에서 받은 pw :", param.getPw());
        MemberDTO member = new MemberDTO();
        member.setId("hong");
        member.setPw("1");
        member.setName("홍길동");
        return member;
    }
    public MemberDTO insert(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }

    public MemberDTO update(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }

    public MemberDTO delete(MemberDTO param){
        MemberDTO member = new MemberDTO();
        return member;
    }

}
