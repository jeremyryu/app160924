package com.abc.my.app160924.Member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.abc.my.app160924.Util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO extends SQLiteOpenHelper {

    public MemberDAO(Context context) {
        super(context, "hanbitdb", null, 1);
        // 위치값, 만들려는 db의 이름, 팩토리, 버전
        this.getWritableDatabase(); // 입력가능한 db로 만들기
        Log.d("DB가 만들어지면 이 글이 보임", "성공");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public MemberDTO select(MemberDTO param) {
        Log.i("DAO 에서 받은 id :", param.getId());
        Log.i("DAO 에서 받은 pw :", param.getPw());
        MemberDTO member = new MemberDTO();
        member.setId("hong");
        member.setPw("1");
        member.setName("홍길동");
        return member;
    }
    public Retval insert(MemberDTO param){
        Retval val = new Retval();

        if(true) {
            val.setMessage("SUCCESS");
        } else {
            val.setMessage("FAIL");
        }

        return val;
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
