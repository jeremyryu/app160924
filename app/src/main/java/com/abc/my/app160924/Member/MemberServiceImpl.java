package com.abc.my.app160924.Member;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemeberService {
    MemberDAO dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDAO(context);
    }

    @Override
    public MemberDTO login(MemberDTO param) {
        Log.i("====SERVICE에서 받은 ID :", param.getId());
        Log.i("====SERVICE에서 받은 PW :", param.getPw());
        MemberDTO member = new MemberDTO();
        member = dao.selectOne(param);

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
    public ArrayList<MemberDTO> getList() {
        return dao.selectList();
    }

    @Override
    public ArrayList<MemberDTO> getListByName(MemberDTO member) {
        return dao.selectListByName(member);
    }

    @Override
    public MemberDTO getOne(MemberDTO member) {
        return dao.selectOne(member);
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public void update(MemberDTO member) {
        dao.update(member);
    }

    @Override
    public void unregist(String id) {
        dao.delete(id);
    }

    @Override
    public void regist(MemberDTO param) {

        Log.i("=SERVICE에서 받은 ID :", param.getId());
        Log.i("=SERVICE에서 받은 PW :", param.getPw());
        Log.i("=SERVICE에서 받은 NAME :", param.getName());
        Log.i("=SERVICE에서 받은 EMAIL :", param.getEmail());
        Log.i("=SERVICE에서 받은 ADDR :", param.getAddr());
        Log.i("=SERVICE에서 받은 PHONE :", param.getPhone());

        dao.insert(param);
    }
}
