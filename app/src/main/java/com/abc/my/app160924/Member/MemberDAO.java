package com.abc.my.app160924.Member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.abc.my.app160924.Util.Retval;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDAO extends SQLiteOpenHelper {
    public static final String DB_NAME = "hanbit.db";
    public static final int DB_VERSION = 1;

    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String ADDR = "addr";
    public static final String PHONE = "phone";
    public static final String PHOTO = "profileimg";
    public static final String TABLE_NAME = "member";


    public MemberDAO(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        // 위치값, 만들려는 db의 이름, 팩토리, 버전
        this.getWritableDatabase(); // 입력가능한 db로 만들기
        Log.d("DB가 만들어지면 이 글이 보임", "성공");
        Log.d("DB가 만들어지면 이 글이 보임3", "성공");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB onCreate 이 글이 보임", "성공");

        db.execSQL(
        "create table if not exists member"
                +"("
                +"        id text primary key,"
                +"        pw text,"
                +"        name text,"
                +"        email text,"
                +"        addr text,"
                +"        phone text,"
                +"        profileimg text"
                +");");

        db.execSQL("insert into member"
        + "( "
        +"                id, pw,name, email,  addr,  phone,  profileimg"
        +"        )"
        +" values "
        +"        ('hong', '1', 'gildong', 'hong@naver.com', 'seoul', '01022163844','jpg'); "
        );

        db.execSQL("insert into member"
          +"      ( "
          +"              id, pw,name, email,  addr,  phone,  profileimg"
          +"      ) "
          +" values"
          +"      ('hong2', '2', 'gildong2', 'hong@naver.com', 'seoul', '01022163844', 'jpg'); "
        );

        db.execSQL("insert into member"
                +"      ( "
                +"              id, pw,name, email,  addr,  phone,  profileimg"
                +"      ) "
                +" values"
                +"      ('hong3', '3', 'gildong', 'hong@naver.com', 'seoul2', '01022163844','jpg'); "
        );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("insert into Android values (null, 'android_6.0.0', 1);");
        db.execSQL("insert into Android values (null, 'android_6.0.1', 2);");
        db.execSQL("drop table if exists member;");
        this.onCreate(db);
    }

    // 검색조건없이 전체목록 조회
    public ArrayList<MemberDTO> selectList() {
        Log.i("DAO 전체조회 :", "selectList() 진입");

        String sql = "select "
                + String.format("%s,%s,%s,%s,%s,%s,%s", ID, PW, NAME, EMAIL, ADDR, PHONE, PHOTO)
                + " from " + TABLE_NAME + ";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

        if(cursor != null){
            Log.i("DAO LIST조회결과 :", "SUCCESS");

            cursor.moveToFirst();
        }

        do{
            MemberDTO temp = new MemberDTO();

            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setAddr(cursor.getString(4));
            temp.setPhone(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6));

            list.add(temp);
        }
        while (cursor.moveToNext());

        return list;
    }

    // 검색조건이 있는 목록 조회
    public ArrayList<MemberDTO> selectListByName(MemberDTO param) {
        Log.i("DAO 검색조회 :", "selectListByName() 진입");

        String sql = "select "
                + String.format("%s,%s,%s,%s,%s,%s,%s", ID, PW, NAME, EMAIL, ADDR, PHONE, PHOTO)
                + " from member "
                + " where name = '" + param.getName() + "';"
                ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

        if(cursor != null){
            Log.i("DAO LIST조회결과 :", "SUCCESS");

            cursor.moveToFirst();
        }

        do{
            MemberDTO temp = new MemberDTO();

            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setAddr(cursor.getString(4));
            temp.setPhone(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6));

            list.add(temp);
        }
        while (cursor.moveToNext());

        return list;
    }

    public MemberDTO selectOne(MemberDTO param) {
        Log.i("DAO 에서 받은 id :", param.getId());
        Log.i("DAO 에서 받은 pw :", param.getPw());
        Log.i("DAO ID조회 :", "selectListOne() 진입");

        String sql = "select "
                + String.format("%s,%s,%s,%s,%s,%s,%s", ID, PW, NAME, EMAIL, ADDR, PHONE, PHOTO)
                + " from member "
                + " where id = '" + param.getId() + "';"
                ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        MemberDTO temp = null;

        if(cursor.moveToNext()){
            Log.i("DAO LIST조회결과 :", "SUCCESS");
            temp = new MemberDTO();

            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setEmail(cursor.getString(3));
            temp.setAddr(cursor.getString(4));
            temp.setPhone(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6));
        }

        return temp;
    }

    public int count() {
        Log.i("DAO COUNT 조회 :", "count() 진입");

        String sql = "select count(*) as count "
                + " from member ;"
                ;
        int count = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        MemberDTO temp = null;

        if(cursor.moveToNext()){
            Log.i("DAO LIST조회결과 :", "SUCCESS");
            temp = new MemberDTO();

            count = cursor.getInt(cursor.getColumnIndex("count"));
        }

        return count;
    }

    public void insert(MemberDTO param){
        Log.i("DAO Insert :", "insert() 진입");
        String sql = "insert into " + TABLE_NAME
                +"      ( "
                + String.format("%s,%s,%s,%s,%s,%s,%s", ID, PW, NAME, EMAIL, ADDR, PHONE, PHOTO)
                +"      ) "
                +" values"
                +"      ( "
                + String.format("'%s','%s','%s','%s','%s','%s','%s'",
                   param.getId(),param.getPw(),param.getName(),param.getEmail(), param.getAddr(),param.getPhone(),param.getProfileImg())
                + " ); "
                ;
        Retval val = new Retval();
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);

        db.close();

    }

    public void update(MemberDTO param){
        Log.i("DAO UPDATE :", "update() 진입");
        String sql = "update " + TABLE_NAME
                +" set pw = '"  + param.getPw() + "'"
                +" ,email  = '" + param.getEmail() + "'"
                +" ,addr = '"   + param.getEmail() + "'"
                +" ,profileimg = '" + param.getProfileImg() + "'"
                +"  where id = '" + param.getId() +"';"
                ;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);

        db.close();
    }

    public void delete(MemberDTO param){
        Log.i("DAO Delete :", "delete() 진입");
        String sql = "delete " + TABLE_NAME
                +"  where id = '" + param.getId() +"';"
                ;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);

        db.close();

    }

}
